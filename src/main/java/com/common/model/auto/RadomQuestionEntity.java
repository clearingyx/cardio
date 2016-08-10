package com.common.model.auto;

import java.util.Date;

public class RadomQuestionEntity {
    /**
     * <pre>
     * 
     * 表字段 : radom_question.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     *  题干
     * 表字段 : radom_question.stem
     * </pre>
     */
    private String stem;

    /**
     * <pre>
     * a,b,c,d
     * 表字段 : radom_question.answer
     * </pre>
     */
    private String answer;

    /**
     * <pre>
     * 答案a
     * 表字段 : radom_question.option_a
     * </pre>
     */
    private String optionA;

    /**
     * <pre>
     * 
     * 表字段 : radom_question.option_b
     * </pre>
     */
    private String optionB;

    /**
     * <pre>
     * 
     * 表字段 : radom_question.option_c
     * </pre>
     */
    private String optionC;

    /**
     * <pre>
     * 
     * 表字段 : radom_question.option_d
     * </pre>
     */
    private String optionD;

    /**
     * <pre>
     * 题目序列
     * 表字段 : radom_question.order
     * </pre>
     */
    private Integer order;

    /**
     * <pre>
     * 
     * 表字段 : radom_question.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question.id
     * </pre>
     *
     * @return radom_question.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question.id
     * </pre>
     *
     * @param id
     *            radom_question.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取： 题干
     * 表字段：radom_question.stem
     * </pre>
     *
     * @return radom_question.stem： 题干
     */
    public String getStem() {
        return stem;
    }

    /**
     * <pre>
     * 设置： 题干
     * 表字段：radom_question.stem
     * </pre>
     *
     * @param stem
     *            radom_question.stem： 题干
     */
    public void setStem(String stem) {
        this.stem = stem == null ? null : stem.trim();
    }

    /**
     * <pre>
     * 获取：a,b,c,d
     * 表字段：radom_question.answer
     * </pre>
     *
     * @return radom_question.answer：a,b,c,d
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * <pre>
     * 设置：a,b,c,d
     * 表字段：radom_question.answer
     * </pre>
     *
     * @param answer
     *            radom_question.answer：a,b,c,d
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * <pre>
     * 获取：答案a
     * 表字段：radom_question.option_a
     * </pre>
     *
     * @return radom_question.option_a：答案a
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * <pre>
     * 设置：答案a
     * 表字段：radom_question.option_a
     * </pre>
     *
     * @param optionA
     *            radom_question.option_a：答案a
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question.option_b
     * </pre>
     *
     * @return radom_question.option_b：
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question.option_b
     * </pre>
     *
     * @param optionB
     *            radom_question.option_b：
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question.option_c
     * </pre>
     *
     * @return radom_question.option_c：
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question.option_c
     * </pre>
     *
     * @param optionC
     *            radom_question.option_c：
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC == null ? null : optionC.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question.option_d
     * </pre>
     *
     * @return radom_question.option_d：
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question.option_d
     * </pre>
     *
     * @param optionD
     *            radom_question.option_d：
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD == null ? null : optionD.trim();
    }

    /**
     * <pre>
     * 获取：题目序列
     * 表字段：radom_question.order
     * </pre>
     *
     * @return radom_question.order：题目序列
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * <pre>
     * 设置：题目序列
     * 表字段：radom_question.order
     * </pre>
     *
     * @param order
     *            radom_question.order：题目序列
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question.create_date
     * </pre>
     *
     * @return radom_question.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question.create_date
     * </pre>
     *
     * @param createDate
     *            radom_question.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}