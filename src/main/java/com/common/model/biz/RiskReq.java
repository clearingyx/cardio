package com.common.model.biz;

/**
 * Created by Administrator on 2016/8/15.
 * 结果页面展示参数
 */
public class RiskReq {
    private Integer risk_level; //危险等级
    private Double risk_correct; //患病百分比
    private Integer multiple; //是正常的倍数
    private Integer tc;//总胆固醇，≥ 5.2 -> 1
    private Integer sbp;//血压,＞140 -> 1
    private Integer hDiab;//糖尿病,1,2 -> 1
    private Integer bmi;//bmi >24 -> 1
    private Integer hSmk;//吸烟 1 -> 1


    public Integer getRisk_level() {
        return risk_level;
    }

    public void setRisk_level(Integer risk_level) {
        this.risk_level = risk_level;
    }

    public Double getRisk_correct() {
        return risk_correct;
    }

    public void setRisk_correct(Double risk_correct) {
        this.risk_correct = risk_correct;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer gethDiab() {
        return hDiab;
    }

    public void sethDiab(Integer hDiab) {
        this.hDiab = hDiab;
    }

    public Integer gethSmk() {
        return hSmk;
    }

    public void sethSmk(Integer hSmk) {
        this.hSmk = hSmk;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }
}
