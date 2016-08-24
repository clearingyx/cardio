package com.common.modular.risk;

import com.common.model.auto.PersonQuestionEntity;

import java.math.BigDecimal;

/**
 * Created by zhang.peng on 2016/8/10.
 */
public class RiskMale {
    public static double ce_age = 0.0505;
    public static double ce_sbp = 0.0140;
    public static double ce_hyprx = 0.3263;
    public static double ce_dm = 0.1060;
    public static double ce_cigs = 0.5147;
    public static double ce_cvd = 0.5195;
    public static double ce_af = 0.6061;
    public static double ce_lvh = 0.8415;

    /**
     * 男性基础风险
     * @param question
     * @return
     */
    public static double getBaseRiskForMan(PersonQuestionEntity question){
        double L = (question.getAge()*ce_age)+(119*ce_sbp);
        double d = 100 * (1 - Math.pow( 0.9044, Math.exp( L - 5.6770 )));
        BigDecimal bd = new BigDecimal(d);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 男性用户风险
     */
    public static double getManRisk(PersonQuestionEntity question){
        double L = (question.getAge() * ce_age) + (question.getSbp() * ce_sbp) +
                (question.getHyprx() * ce_hyprx) + (question.gethDiab() * ce_dm) +
                (question.gethSmk() * ce_cigs) + (question.getCvd() * ce_cvd) +
                (question.getAf() * ce_af) + (question.getLvh() * ce_lvh);

        //得到初始测评参数
        return 100 * (1 - Math.pow( 0.9044, Math.exp( L - 5.6770 )));
    }
}
