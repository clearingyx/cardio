package com.common.model.auto;

import java.util.Date;

public class PersonQuestionEntity {
    /**
     * <pre>
     * 
     * 表字段 : person_question.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 用户openid
     * 表字段 : person_question.open_id
     * </pre>
     */
    private String openId;

    /**
     * <pre>
     * 测评时间
     * 表字段 : person_question.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 患者年龄(范围：20-90)
     * 表字段 : person_question.age
     * </pre>
     */
    private Integer age;

    /**
     * <pre>
     * 患者性别 1、男性;0、女性;
     * 表字段 : person_question.gender
     * </pre>
     */
    private Integer gender;

    /**
     * <pre>
     * 体重(单位:公斤(kg))(范围：40-250)
     * 表字段 : person_question.weight
     * </pre>
     */
    private Integer weight;

    /**
     * <pre>
     * 身高(单位:厘米(cm))(范围：99-231)
     * 表字段 : person_question.height
     * </pre>
     */
    private Integer height;

    /**
     * <pre>
     * 吸烟史  1、是; 0、否;
     * 表字段 : person_question.h_smk
     * </pre>
     */
    private Integer hSmk;

    /**
     * <pre>
     * 饮酒史  1、是; 0、否;
     * 表字段 : person_question.h_drink
     * </pre>
     */
    private Integer hDrink;

    /**
     * <pre>
     * 每天使用水果和蔬菜情况  1、是; 0、否;
     * 表字段 : person_question.diet
     * </pre>
     */
    private Integer diet;

    /**
     * <pre>
     * 体育锻炼：至少进行2小时30分钟 1、是; 0、否;
     * 表字段 : person_question.activity
     * </pre>
     */
    private Integer activity;

    /**
     * <pre>
     * 精神压力史  1、是; 0、否;
     * 表字段 : person_question.stress
     * </pre>
     */
    private Integer stress;

    /**
     * <pre>
     * 父母65岁之前是否发生过中风或心脏病  1、是; 0、否;
     * 表字段 : person_question.familys
     * </pre>
     */
    private Integer familys;

    /**
     * <pre>
     * 收缩压：即血压读数中高的值(mmHg)（范围：90-250）  连续变量；99、我不知道; 
     * 表字段 : person_question.sbp
     * </pre>
     */
    private Integer sbp;

    /**
     * <pre>
     * 正在服用降压药  1、是; 0、否;
     * 表字段 : person_question.hyprx
     * </pre>
     */
    private Integer hyprx;

    /**
     * <pre>
     * 总胆固醇(mmol/L)（范围：0.0-30.0）  连续变量；90、>30；99、我不知道;
     * 表字段 : person_question.tc
     * </pre>
     */
    private Double tc;

    /**
     * <pre>
     * 低密度脂蛋白胆固醇(mmol/L)(范围：0.0-20.0)   连续变量；90、>20；99、我不知道;
     * 表字段 : person_question.ldl
     * </pre>
     */
    private Double ldl;

    /**
     * <pre>
     * 是否被医生诊断为糖尿病  2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.h_diab
     * </pre>
     */
    private Integer hDiab;

    /**
     * <pre>
     * 是否被医生诊断患有心血管/外周血管疾病  2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.cvd
     * </pre>
     */
    private Integer cvd;

    /**
     * <pre>
     * 是否被医生诊断为左心室肥厚  2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.lvh
     * </pre>
     */
    private Integer lvh;

    /**
     * <pre>
     * 是否被医生诊断为房颤   2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.af
     * </pre>
     */
    private Integer af;

    /**
     * <pre>
     * 是否被医生告知具有认知问题或患有老年痴呆症  2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.cognitive
     * </pre>
     */
    private Integer cognitive;

    /**
     * <pre>
     * 您或您周围的人认为您是否记忆力差  1、是; 0、否;
     * 表字段 : person_question.poor_memory
     * </pre>
     */
    private Integer poorMemory;

    /**
     * <pre>
     * 是否被医生诊断为创伤性脑损伤  2、是一年前;1、是一年内; 0、没有;
     * 表字段 : person_question.injury
     * </pre>
     */
    private Integer injury;

    /**
     * <pre>
     * 是否被医生诊断为中风或短暂性脑缺血发作（小中风） 2、是一年前;1、是一年内; 0、没有; 
     * 表字段 : person_question.mini_stroke
     * </pre>
     */
    private Integer miniStroke;

    /**
     * <pre>
     * 获取：
     * 表字段：person_question.id
     * </pre>
     *
     * @return person_question.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：person_question.id
     * </pre>
     *
     * @param id
     *            person_question.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：用户openid
     * 表字段：person_question.open_id
     * </pre>
     *
     * @return person_question.open_id：用户openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：用户openid
     * 表字段：person_question.open_id
     * </pre>
     *
     * @param openId
     *            person_question.open_id：用户openid
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * <pre>
     * 获取：测评时间
     * 表字段：person_question.create_date
     * </pre>
     *
     * @return person_question.create_date：测评时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：测评时间
     * 表字段：person_question.create_date
     * </pre>
     *
     * @param createDate
     *            person_question.create_date：测评时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：患者年龄(范围：20-90)
     * 表字段：person_question.age
     * </pre>
     *
     * @return person_question.age：患者年龄(范围：20-90)
     */
    public Integer getAge() {
        return age;
    }

    /**
     * <pre>
     * 设置：患者年龄(范围：20-90)
     * 表字段：person_question.age
     * </pre>
     *
     * @param age
     *            person_question.age：患者年龄(范围：20-90)
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * <pre>
     * 获取：患者性别 1、男性;0、女性;
     * 表字段：person_question.gender
     * </pre>
     *
     * @return person_question.gender：患者性别 1、男性;0、女性;
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * <pre>
     * 设置：患者性别 1、男性;0、女性;
     * 表字段：person_question.gender
     * </pre>
     *
     * @param gender
     *            person_question.gender：患者性别 1、男性;0、女性;
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * <pre>
     * 获取：体重(单位:公斤(kg))(范围：40-250)
     * 表字段：person_question.weight
     * </pre>
     *
     * @return person_question.weight：体重(单位:公斤(kg))(范围：40-250)
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * <pre>
     * 设置：体重(单位:公斤(kg))(范围：40-250)
     * 表字段：person_question.weight
     * </pre>
     *
     * @param weight
     *            person_question.weight：体重(单位:公斤(kg))(范围：40-250)
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * <pre>
     * 获取：身高(单位:厘米(cm))(范围：99-231)
     * 表字段：person_question.height
     * </pre>
     *
     * @return person_question.height：身高(单位:厘米(cm))(范围：99-231)
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * <pre>
     * 设置：身高(单位:厘米(cm))(范围：99-231)
     * 表字段：person_question.height
     * </pre>
     *
     * @param height
     *            person_question.height：身高(单位:厘米(cm))(范围：99-231)
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * <pre>
     * 获取：吸烟史  1、是; 0、否;
     * 表字段：person_question.h_smk
     * </pre>
     *
     * @return person_question.h_smk：吸烟史  1、是; 0、否;
     */
    public Integer gethSmk() {
        return hSmk;
    }

    /**
     * <pre>
     * 设置：吸烟史  1、是; 0、否;
     * 表字段：person_question.h_smk
     * </pre>
     *
     * @param hSmk
     *            person_question.h_smk：吸烟史  1、是; 0、否;
     */
    public void sethSmk(Integer hSmk) {
        this.hSmk = hSmk;
    }

    /**
     * <pre>
     * 获取：饮酒史  1、是; 0、否;
     * 表字段：person_question.h_drink
     * </pre>
     *
     * @return person_question.h_drink：饮酒史  1、是; 0、否;
     */
    public Integer gethDrink() {
        return hDrink;
    }

    /**
     * <pre>
     * 设置：饮酒史  1、是; 0、否;
     * 表字段：person_question.h_drink
     * </pre>
     *
     * @param hDrink
     *            person_question.h_drink：饮酒史  1、是; 0、否;
     */
    public void sethDrink(Integer hDrink) {
        this.hDrink = hDrink;
    }

    /**
     * <pre>
     * 获取：每天使用水果和蔬菜情况  1、是; 0、否;
     * 表字段：person_question.diet
     * </pre>
     *
     * @return person_question.diet：每天使用水果和蔬菜情况  1、是; 0、否;
     */
    public Integer getDiet() {
        return diet;
    }

    /**
     * <pre>
     * 设置：每天使用水果和蔬菜情况  1、是; 0、否;
     * 表字段：person_question.diet
     * </pre>
     *
     * @param diet
     *            person_question.diet：每天使用水果和蔬菜情况  1、是; 0、否;
     */
    public void setDiet(Integer diet) {
        this.diet = diet;
    }

    /**
     * <pre>
     * 获取：体育锻炼：至少进行2小时30分钟 1、是; 0、否;
     * 表字段：person_question.activity
     * </pre>
     *
     * @return person_question.activity：体育锻炼：至少进行2小时30分钟 1、是; 0、否;
     */
    public Integer getActivity() {
        return activity;
    }

    /**
     * <pre>
     * 设置：体育锻炼：至少进行2小时30分钟 1、是; 0、否;
     * 表字段：person_question.activity
     * </pre>
     *
     * @param activity
     *            person_question.activity：体育锻炼：至少进行2小时30分钟 1、是; 0、否;
     */
    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    /**
     * <pre>
     * 获取：精神压力史  1、是; 0、否;
     * 表字段：person_question.stress
     * </pre>
     *
     * @return person_question.stress：精神压力史  1、是; 0、否;
     */
    public Integer getStress() {
        return stress;
    }

    /**
     * <pre>
     * 设置：精神压力史  1、是; 0、否;
     * 表字段：person_question.stress
     * </pre>
     *
     * @param stress
     *            person_question.stress：精神压力史  1、是; 0、否;
     */
    public void setStress(Integer stress) {
        this.stress = stress;
    }

    /**
     * <pre>
     * 获取：父母65岁之前是否发生过中风或心脏病  1、是; 0、否;
     * 表字段：person_question.familys
     * </pre>
     *
     * @return person_question.familys：父母65岁之前是否发生过中风或心脏病  1、是; 0、否;
     */
    public Integer getFamilys() {
        return familys;
    }

    /**
     * <pre>
     * 设置：父母65岁之前是否发生过中风或心脏病  1、是; 0、否;
     * 表字段：person_question.familys
     * </pre>
     *
     * @param familys
     *            person_question.familys：父母65岁之前是否发生过中风或心脏病  1、是; 0、否;
     */
    public void setFamilys(Integer familys) {
        this.familys = familys;
    }

    /**
     * <pre>
     * 获取：收缩压：即血压读数中高的值(mmHg)（范围：90-250）  连续变量；99、我不知道; 
     * 表字段：person_question.sbp
     * </pre>
     *
     * @return person_question.sbp：收缩压：即血压读数中高的值(mmHg)（范围：90-250）  连续变量；99、我不知道; 
     */
    public Integer getSbp() {
        return sbp;
    }

    /**
     * <pre>
     * 设置：收缩压：即血压读数中高的值(mmHg)（范围：90-250）  连续变量；99、我不知道; 
     * 表字段：person_question.sbp
     * </pre>
     *
     * @param sbp
     *            person_question.sbp：收缩压：即血压读数中高的值(mmHg)（范围：90-250）  连续变量；99、我不知道; 
     */
    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    /**
     * <pre>
     * 获取：正在服用降压药  1、是; 0、否;
     * 表字段：person_question.hyprx
     * </pre>
     *
     * @return person_question.hyprx：正在服用降压药  1、是; 0、否;
     */
    public Integer getHyprx() {
        return hyprx;
    }

    /**
     * <pre>
     * 设置：正在服用降压药  1、是; 0、否;
     * 表字段：person_question.hyprx
     * </pre>
     *
     * @param hyprx
     *            person_question.hyprx：正在服用降压药  1、是; 0、否;
     */
    public void setHyprx(Integer hyprx) {
        this.hyprx = hyprx;
    }

    /**
     * <pre>
     * 获取：总胆固醇(mmol/L)（范围：0.0-30.0）  连续变量；90、>30；99、我不知道;
     * 表字段：person_question.tc
     * </pre>
     *
     * @return person_question.tc：总胆固醇(mmol/L)（范围：0.0-30.0）  连续变量；90、>30；99、我不知道;
     */
    public Double getTc() {
        return tc;
    }

    /**
     * <pre>
     * 设置：总胆固醇(mmol/L)（范围：0.0-30.0）  连续变量；90、>30；99、我不知道;
     * 表字段：person_question.tc
     * </pre>
     *
     * @param tc
     *            person_question.tc：总胆固醇(mmol/L)（范围：0.0-30.0）  连续变量；90、>30；99、我不知道;
     */
    public void setTc(Double tc) {
        this.tc = tc;
    }

    /**
     * <pre>
     * 获取：低密度脂蛋白胆固醇(mmol/L)(范围：0.0-20.0)   连续变量；90、>20；99、我不知道;
     * 表字段：person_question.ldl
     * </pre>
     *
     * @return person_question.ldl：低密度脂蛋白胆固醇(mmol/L)(范围：0.0-20.0)   连续变量；90、>20；99、我不知道;
     */
    public Double getLdl() {
        return ldl;
    }

    /**
     * <pre>
     * 设置：低密度脂蛋白胆固醇(mmol/L)(范围：0.0-20.0)   连续变量；90、>20；99、我不知道;
     * 表字段：person_question.ldl
     * </pre>
     *
     * @param ldl
     *            person_question.ldl：低密度脂蛋白胆固醇(mmol/L)(范围：0.0-20.0)   连续变量；90、>20；99、我不知道;
     */
    public void setLdl(Double ldl) {
        this.ldl = ldl;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断为糖尿病  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.h_diab
     * </pre>
     *
     * @return person_question.h_diab：是否被医生诊断为糖尿病  2、是一年前;1、是一年内; 0、没有;
     */
    public Integer gethDiab() {
        return hDiab;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断为糖尿病  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.h_diab
     * </pre>
     *
     * @param hDiab
     *            person_question.h_diab：是否被医生诊断为糖尿病  2、是一年前;1、是一年内; 0、没有;
     */
    public void sethDiab(Integer hDiab) {
        this.hDiab = hDiab;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断患有心血管/外周血管疾病  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.cvd
     * </pre>
     *
     * @return person_question.cvd：是否被医生诊断患有心血管/外周血管疾病  2、是一年前;1、是一年内; 0、没有;
     */
    public Integer getCvd() {
        return cvd;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断患有心血管/外周血管疾病  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.cvd
     * </pre>
     *
     * @param cvd
     *            person_question.cvd：是否被医生诊断患有心血管/外周血管疾病  2、是一年前;1、是一年内; 0、没有;
     */
    public void setCvd(Integer cvd) {
        this.cvd = cvd;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断为左心室肥厚  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.lvh
     * </pre>
     *
     * @return person_question.lvh：是否被医生诊断为左心室肥厚  2、是一年前;1、是一年内; 0、没有;
     */
    public Integer getLvh() {
        return lvh;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断为左心室肥厚  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.lvh
     * </pre>
     *
     * @param lvh
     *            person_question.lvh：是否被医生诊断为左心室肥厚  2、是一年前;1、是一年内; 0、没有;
     */
    public void setLvh(Integer lvh) {
        this.lvh = lvh;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断为房颤   2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.af
     * </pre>
     *
     * @return person_question.af：是否被医生诊断为房颤   2、是一年前;1、是一年内; 0、没有;
     */
    public Integer getAf() {
        return af;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断为房颤   2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.af
     * </pre>
     *
     * @param af
     *            person_question.af：是否被医生诊断为房颤   2、是一年前;1、是一年内; 0、没有;
     */
    public void setAf(Integer af) {
        this.af = af;
    }

    /**
     * <pre>
     * 获取：是否被医生告知具有认知问题或患有老年痴呆症  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.cognitive
     * </pre>
     *
     * @return person_question.cognitive：是否被医生告知具有认知问题或患有老年痴呆症  2、是一年前;1、是一年内; 0、没有;
     */
    public Integer getCognitive() {
        return cognitive;
    }

    /**
     * <pre>
     * 设置：是否被医生告知具有认知问题或患有老年痴呆症  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.cognitive
     * </pre>
     *
     * @param cognitive
     *            person_question.cognitive：是否被医生告知具有认知问题或患有老年痴呆症  2、是一年前;1、是一年内; 0、没有;
     */
    public void setCognitive(Integer cognitive) {
        this.cognitive = cognitive;
    }

    /**
     * <pre>
     * 获取：您或您周围的人认为您是否记忆力差  1、是; 0、否;
     * 表字段：person_question.poor_memory
     * </pre>
     *
     * @return person_question.poor_memory：您或您周围的人认为您是否记忆力差  1、是; 0、否;
     */
    public Integer getPoorMemory() {
        return poorMemory;
    }

    /**
     * <pre>
     * 设置：您或您周围的人认为您是否记忆力差  1、是; 0、否;
     * 表字段：person_question.poor_memory
     * </pre>
     *
     * @param poorMemory
     *            person_question.poor_memory：您或您周围的人认为您是否记忆力差  1、是; 0、否;
     */
    public void setPoorMemory(Integer poorMemory) {
        this.poorMemory = poorMemory;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断为创伤性脑损伤  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.injury
     * </pre>
     *
     * @return person_question.injury：是否被医生诊断为创伤性脑损伤  2、是一年前;1、是一年内; 0、没有;
     */
    public Integer getInjury() {
        return injury;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断为创伤性脑损伤  2、是一年前;1、是一年内; 0、没有;
     * 表字段：person_question.injury
     * </pre>
     *
     * @param injury
     *            person_question.injury：是否被医生诊断为创伤性脑损伤  2、是一年前;1、是一年内; 0、没有;
     */
    public void setInjury(Integer injury) {
        this.injury = injury;
    }

    /**
     * <pre>
     * 获取：是否被医生诊断为中风或短暂性脑缺血发作（小中风） 2、是一年前;1、是一年内; 0、没有; 
     * 表字段：person_question.mini_stroke
     * </pre>
     *
     * @return person_question.mini_stroke：是否被医生诊断为中风或短暂性脑缺血发作（小中风） 2、是一年前;1、是一年内; 0、没有; 
     */
    public Integer getMiniStroke() {
        return miniStroke;
    }

    /**
     * <pre>
     * 设置：是否被医生诊断为中风或短暂性脑缺血发作（小中风） 2、是一年前;1、是一年内; 0、没有; 
     * 表字段：person_question.mini_stroke
     * </pre>
     *
     * @param miniStroke
     *            person_question.mini_stroke：是否被医生诊断为中风或短暂性脑缺血发作（小中风） 2、是一年前;1、是一年内; 0、没有; 
     */
    public void setMiniStroke(Integer miniStroke) {
        this.miniStroke = miniStroke;
    }
}