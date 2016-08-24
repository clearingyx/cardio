package com.common.model.auto;

public class RandomQuestionEntity {
    /**
     * <pre>
     * 
     * 表字段 : random_question.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 模版1-10
     * 表字段 : random_question.template_id
     * </pre>
     */
    private Integer templateId;

    /**
     * <pre>
     *  题干
     * 表字段 : random_question.stem
     * </pre>
     */
    private String stem;

    /**
     * <pre>
     * 答案a
     * 表字段 : random_question.option_a
     * </pre>
     */
    private String optionA;

    /**
     * <pre>
     * 
     * 表字段 : random_question.option_b
     * </pre>
     */
    private String optionB;

    /**
     * <pre>
     * 获取：
     * 表字段：random_question.id
     * </pre>
     *
     * @return random_question.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：random_question.id
     * </pre>
     *
     * @param id
     *            random_question.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：模版1-10
     * 表字段：random_question.template_id
     * </pre>
     *
     * @return random_question.template_id：模版1-10
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * <pre>
     * 设置：模版1-10
     * 表字段：random_question.template_id
     * </pre>
     *
     * @param templateId
     *            random_question.template_id：模版1-10
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * <pre>
     * 获取： 题干
     * 表字段：random_question.stem
     * </pre>
     *
     * @return random_question.stem： 题干
     */
    public String getStem() {
        return stem;
    }

    /**
     * <pre>
     * 设置： 题干
     * 表字段：random_question.stem
     * </pre>
     *
     * @param stem
     *            random_question.stem： 题干
     */
    public void setStem(String stem) {
        this.stem = stem == null ? null : stem.trim();
    }

    /**
     * <pre>
     * 获取：答案a
     * 表字段：random_question.option_a
     * </pre>
     *
     * @return random_question.option_a：答案a
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * <pre>
     * 设置：答案a
     * 表字段：random_question.option_a
     * </pre>
     *
     * @param optionA
     *            random_question.option_a：答案a
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：random_question.option_b
     * </pre>
     *
     * @return random_question.option_b：
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：random_question.option_b
     * </pre>
     *
     * @param optionB
     *            random_question.option_b：
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }
}