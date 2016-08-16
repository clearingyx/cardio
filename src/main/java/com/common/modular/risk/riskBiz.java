package com.common.modular.risk;

import com.common.component.resp.RspCodeMsg;
import com.common.model.auto.PersonQuestionEntity;
import com.common.model.biz.RiskReq;
import com.common.service.PersonQuestionService;
import com.exception.base.RspRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * Created by zhang.peng on 2016/8/10.
 */
@Controller
@RequestMapping("/risk")
public class RiskBiz {
    @Autowired
    PersonQuestionService personQuestionService;

    //基本的权重属性
    double ce_age;
    double ce_sbp;
    double ce_hyprx;
    double ce_dm;
    double ce_cigs;
    double ce_cvd;
    double ce_af;
    double ce_lvh;
    double ce_inter = 0.0;//女性特有，首先实例化

    //修正参数的其他因素
    double rr_bmi = 0.2;
    //double rr_race = 0.2;
    double rr_diet = 0.2;
    double rr_drink = 0.1;
    double rr_stress = 0.1;
    double rr_activity = 0.1;
    double rr_family = 0.05;

    //修正参数的权重属性
    double rr_cognitive = 1.8;
    double rr_poor_memory = 1.4;
    double rr_injury = 1.2;
    int rr_mini_stroke = 15;

    /**
     * 计算测评结果
     * @param personQuestionEntity
     */
    @RequestMapping(value = "risk",method = RequestMethod.POST)
    public RiskReq risk(PersonQuestionEntity personQuestionEntity
            //, Model model
                       ){
        //修正实体类参数，初始化权重
        PersonQuestionEntity question = initEntity(personQuestionEntity);

        //用户结果
        double risk;
        //基础结果，即最好结果
        double base_risk;
        //模型计算 得到男性基本模型
        if (question.getGender() == 1) {
            risk = getManRisk(question);
            base_risk = getBaseRiskForMan(question);
        } else {
            //得到女性基本模型
            risk = getWomanRisk(question);
            base_risk = getBaseRiskForWoman(question);
        }

        //得到风险修正测评参数，保留2位小数
        double risk_correct = getRiskCorrect(question, risk);

        //用户和基础的患病几率的倍数
        double multiple = risk_correct/base_risk;
        BigDecimal bd1 = new BigDecimal(multiple);
        multiple = bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        BigDecimal bd = new BigDecimal(risk_correct);
        risk_correct = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if(risk_correct > 92.99){
            risk_correct = 92.99;
        }

        //得到危险等级
        int risk_level = getRiskLevel(risk_correct);

        //返回页面类
        RiskReq riskReq = new RiskReq();
        riskReq.setRisk_level(risk_level);
        riskReq.setRisk_correct(risk_correct);

        riskReq.setMultiple(multiple);

        if(personQuestionEntity.getTc() >= 5.2){
            riskReq.setTc(1);
        }
        if(personQuestionEntity.getSbp() > 140){
            riskReq.setSbp(1);
        }
        if(personQuestionEntity.gethDiab() == 1 || personQuestionEntity.gethDiab() == 2){
            riskReq.sethDiab(1);
        }
        double bmi = ( question.getWeight() / (Math.pow( (double)question.getHeight()/100, 2 ) ) ) - 24;
        if (bmi > 24) {
            riskReq.setBmi(1);
        }
        if(personQuestionEntity.gethSmk() == 1){
            riskReq.sethSmk(1);
        }

        //得到测评等级结果，insert person_question 并且 update person，走事务，已经都抛出异常了，只有等于1才会return回这里
        personQuestionService.saveRisk(personQuestionEntity,risk_level);

        return riskReq;
        //返回页面，根据用户危险等级查看结果页面
//        model.addAttribute("question",personQuestionEntity);
//        model.addAttribute("risk_level",risk_level);
//        model.addAttribute("risk_correct",risk_correct);
//        return "weixin/result.jsp";
    }

    /**
     * 男性风险
     */
    public double getManRisk(PersonQuestionEntity question){
        double L = (question.getAge() * ce_age) + (question.getSbp() * ce_sbp) +
                (question.getHyprx() * ce_hyprx) + (question.gethDiab() * ce_dm) +
                (question.gethSmk() * ce_cigs) + (question.getCvd() * ce_cvd) +
                (question.getAf() * ce_af) + (question.getLvh() * ce_lvh);

        //得到初始测评参数
        return 100 * (1 - Math.pow( 0.9044, Math.exp( L - 5.6770 )));
    }

    /**
     * 女性风险
     */
    public double getWomanRisk(PersonQuestionEntity question){
        double L = (question.getAge() * ce_age) + (question.getSbp() * ce_sbp) +
                ( question.getHyprx() * ( ce_hyprx - ce_inter * question.getSbp() ) ) +
                (question.gethDiab() * ce_dm) + (question.gethSmk() * ce_cigs) +
                (question.getCvd() * ce_cvd) + (question.getAf() * ce_af) +
                (question.getLvh() * ce_lvh);

        //得到初始测评参数
        return 1 - Math.pow( 0.9353, Math.exp( L - 7.5766 ) );
    }

    /**
     * 男性基础风险
     * @param question
     * @return
     */
    public double getBaseRiskForMan(PersonQuestionEntity question){
        double L = (question.getAge()*ce_age)+(119*ce_sbp);
        return 100 * (1 - Math.pow( 0.9044, Math.exp( L - 5.6770 )));
    }

    /**
     * 女性基础风险
     * @param question
     * @return
     */
    public double getBaseRiskForWoman(PersonQuestionEntity question){
        double L = (question.getAge()*ce_age)+(119*ce_sbp);
        return 1 - Math.pow( 0.9353, Math.exp( L - 7.5766 ) );
    }

    /**
     * 根据测评结果计算危险等级
     */
    public int getRiskLevel(double risk){
        if (risk >= 0 && risk < 5){
            return 0;
        } else if (risk >= 5 && risk < 10) {
            return 1;
        } else if (risk >= 10 && risk < 15) {
            return 2;
        } else if (risk >= 15) {
            return 3;
        } else {
            throw new RspRuntimeException(RspCodeMsg.RISK_PARAMS_ERR,"测评结果参数出错");
        }
    }

    /**
     * 修正参数后风险
     */
    public double getRiskCorrect(PersonQuestionEntity question, double risk){
        //得到bmi，中国看模型是减去24，如果为负数，则为0
        // 体重/身高（米）平方，中国 -24
        double bmi = ( question.getWeight() / (Math.pow( (double)question.getHeight()/100, 2 ) ) ) - 24;
        if (bmi < 0) {
            bmi = 0;
        }

        //修正测评参数
        risk = risk + ( bmi * rr_bmi + //rr_race * d33 +  //d33来源： race == "white" d33 = 1；这里不用
                rr_diet * question.getDiet() + rr_drink * question.gethDrink() +
                rr_stress * question.getStress() + rr_activity * question.getActivity() +
                rr_family * question.getFamilys()
        );
        //认知障碍
        if (question.getCognitive() == 1) {
            risk = risk * rr_cognitive;
            //记忆力差
        } else if (question.getCognitive() == 0 && question.getPoorMemory() == 1) {
            risk = risk * rr_poor_memory;
        }
        //脑损伤
        if (question.getInjury() == 1) {
            risk = risk * rr_injury;
        }
        //小中风
        if (question.getMiniStroke() == 1) {
            risk = risk + rr_mini_stroke;
        }
        return risk;
    }

    /**
     * 一些选项需要修改值
     * @param question
     * @return
     */
    public PersonQuestionEntity initEntity(PersonQuestionEntity question){
        //初始化权重属性
        if(question.getGender() == 1) {
            ce_age = 0.0505;
            ce_sbp = 0.0140;
            ce_hyprx = 0.3263;
            ce_dm = 0.1060;
            ce_cigs = 0.5147;
            ce_cvd = 0.5195;
            ce_af = 0.6061;
            ce_lvh = 0.8415;
        } else {
            //女性的权重属性
            ce_age = 0.0657;
            ce_sbp = 0.0197;
            ce_hyprx = 2.5432;
            ce_inter = 0.0134;
            ce_dm = 0.5442;
            ce_cigs = 0.5294;
            ce_cvd = 0.4326;
            ce_af = 1.1497;
            ce_lvh = 0.8488;
        }
        if (question.getSbp() <= 119){
            question.setSbp(119);
        }
        if(question.gethDiab() == 2) {
            question.sethDiab(1);
        }
        if(question.getCvd() == 2) {
            question.setCvd(1);
        }
        if(question.getLvh() == 2) {
            question.setLvh(1);
        }
        if(question.getAf() == 2) {
            question.setAf(1);
        }
        if(question.getCognitive() == 2) {
            question.setCognitive(1);
        }
        if(question.getInjury() == 2) {
            question.setInjury(1);
        }
        if(question.getMiniStroke() == 2) {
            question.setMiniStroke(1);
        }
        if(question.getDiet() == 1) {
            question.setDiet(0);
        } else {
            question.setDiet(1);
        }
        if(question.getActivity() == 1) {
            question.setActivity(0);
        } else {
            question.setActivity(1);
        }
        return question;
    }
}
