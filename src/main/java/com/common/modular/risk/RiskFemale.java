package com.common.modular.risk;

import com.common.model.auto.PersonQuestionEntity;

import java.math.BigDecimal;

/**
 * Created by zhang.peng on 2016/8/10.
 */
public class RiskFemale {
    public static double ce_age = 0.0657;
    public static double ce_sbp = 0.0197;
    public static double ce_hyprx = 2.5432;
    public static double ce_inter = 0.0134;
    public static double ce_dm = 0.5442;
    public static double ce_cigs = 0.5294;
    public static double ce_cvd = 0.4326;
    public static double ce_af = 1.1497;
    public static double ce_lvh = 0.8488;

    /**
     * 女性基础风险
     * @param question
     * @return
     */
    public static double getBaseRiskForWoman(PersonQuestionEntity question){
        double L = (question.getAge()*ce_age)+(119*ce_sbp);
        double d = 100 * (1 - Math.pow( 0.9353, Math.exp( L - 7.5766 )));
        BigDecimal bd = new BigDecimal(d);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 女性用户风险
     */
    public static double getWomanRisk(PersonQuestionEntity question){
        double L = (question.getAge() * ce_age) + (question.getSbp() * ce_sbp) +
                ( question.getHyprx() * ( ce_hyprx - ce_inter * question.getSbp() ) ) +
                (question.gethDiab() * ce_dm) + (question.gethSmk() * ce_cigs) +
                (question.getCvd() * ce_cvd) + (question.getAf() * ce_af) +
                (question.getLvh() * ce_lvh);

        //得到初始测评参数
        return 100 * (1 - Math.pow( 0.9353, Math.exp( L - 7.5766 )));
    }
}
