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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang.peng on 2016/8/10.
 */
@Controller
@RequestMapping("/risk")
public class RiskBiz {
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

    /**
     * 计算测评结果
     * @param personQuestionEntity
     */
    @RequestMapping(value = "risk",method = RequestMethod.POST)
    public Map risk(PersonQuestionEntity personQuestionEntity
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
            risk = RiskMale.getManRisk(question);
            base_risk = RiskMale.getBaseRiskForMan(question);
        } else {
            //得到女性基本模型
            risk = RiskFemale.getWomanRisk(question);
            base_risk = RiskFemale.getBaseRiskForWoman(question);
        }

        //患病几率
        double risk_correct = getRiskCorrect(question, risk);

        //患病倍数
        int multiple = getMultiple(risk_correct,base_risk);

        //危险等级
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

        Map<String, Object> map = new HashMap();
        if(personQuestionEntity.getDiet() == 0){
            personQuestionEntity.setDiet(1);
        } else {
            personQuestionEntity.setDiet(0);
        }
        if(personQuestionEntity.getActivity() == 0){
            personQuestionEntity.setActivity(1);
        } else {
            personQuestionEntity.setActivity(0);
        }
        map.put("personQuestion", personQuestionEntity);
        map.put("riskReq", riskReq);
        return map;
    }

    /**
     * 得到患病的倍数
     * @return
     */
    public int getMultiple(double risk_correct, double base_risk){
        double multiple = risk_correct/base_risk - 1;
        BigDecimal bd = new BigDecimal(multiple);
        return bd.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 根据测评结果计算危险等级
     */
    public int getRiskLevel(double risk){
        if(risk > 92.99){
            risk = 92.99;
        }

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
     * 获得修正后的bmi
     * @param question
     * @return
     */
    public double getRr_bmi(PersonQuestionEntity question){
        //得到bmi，中国看模型是减去24，如果为负数，则为0
        // 体重/身高（米）平方，中国 -24
        double rr_bmi;
        double dbmi = ( question.getWeight() / (Math.pow( (double)question.getHeight()/100, 2 ) ) ) - 24;
        if (dbmi < 0) {
            rr_bmi = 0;
        } else {
            rr_bmi = 0.02*(1 + dbmi);
        }
        return rr_bmi;
    }

    /**
     * 修正参数后风险
     */
    public double getRiskCorrect(PersonQuestionEntity question, double risk){
        //获得修正后的bmi
        double rr_bmi = getRr_bmi(question);

        //修正测评参数
        risk = risk + ( rr_bmi + 0.2 * 1 + //rr_race * d33 +  //d33来源： race == "white" d33 = 1；这里不用
                0.2 * question.getDiet() + 0.1 * question.gethDrink() +
                0.1 * question.getStress() + 0.1 * question.getActivity() +
                0.05 * question.getFamilys()
        );
        //认知障碍
        if (question.getCognitive() == 1) {
            risk = 1.8 * risk;
            //记忆力差
        } else if (question.getCognitive() == 0 && question.getPoorMemory() == 1) {
            risk = 1.4 * risk;
        }
        //脑损伤
        if (question.getInjury() == 1) {
            risk = 1.2 * risk;
        }
        //小中风
        if (question.getMiniStroke() == 1) {
            risk = 15 + risk;
        }

        BigDecimal bd = new BigDecimal(risk);
        risk = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if(risk > 92.99){
            risk = 92.99;
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
