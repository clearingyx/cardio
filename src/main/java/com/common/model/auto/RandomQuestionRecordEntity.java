package com.common.model.auto;

import java.util.Date;

public class RandomQuestionRecordEntity {
    /**
     * <pre>
     * 
     * 表字段 : random_question_record.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 回答试题的用户id
     * 表字段 : random_question_record.open_id
     * </pre>
     */
    private String openId;

    /**
     * <pre>
     * 随机试题的id
     * 表字段 : random_question_record.question_id
     * </pre>
     */
    private Integer questionId;

    /**
     * <pre>
     * 用户答案
     * 表字段 : random_question_record.person_anwser
     * </pre>
     */
    private String personAnwser;

    /**
     * <pre>
     * 
     * 表字段 : random_question_record.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：random_question_record.id
     * </pre>
     *
     * @return random_question_record.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：random_question_record.id
     * </pre>
     *
     * @param id
     *            random_question_record.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：回答试题的用户id
     * 表字段：random_question_record.open_id
     * </pre>
     *
     * @return random_question_record.open_id：回答试题的用户id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <pre>
     * 设置：回答试题的用户id
     * 表字段：random_question_record.open_id
     * </pre>
     *
     * @param openId
     *            random_question_record.open_id：回答试题的用户id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * <pre>
     * 获取：随机试题的id
     * 表字段：random_question_record.question_id
     * </pre>
     *
     * @return random_question_record.question_id：随机试题的id
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * <pre>
     * 设置：随机试题的id
     * 表字段：random_question_record.question_id
     * </pre>
     *
     * @param questionId
     *            random_question_record.question_id：随机试题的id
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * <pre>
     * 获取：用户答案
     * 表字段：random_question_record.person_anwser
     * </pre>
     *
     * @return random_question_record.person_anwser：用户答案
     */
    public String getPersonAnwser() {
        return personAnwser;
    }

    /**
     * <pre>
     * 设置：用户答案
     * 表字段：random_question_record.person_anwser
     * </pre>
     *
     * @param personAnwser
     *            random_question_record.person_anwser：用户答案
     */
    public void setPersonAnwser(String personAnwser) {
        this.personAnwser = personAnwser == null ? null : personAnwser.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：random_question_record.create_date
     * </pre>
     *
     * @return random_question_record.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：random_question_record.create_date
     * </pre>
     *
     * @param createDate
     *            random_question_record.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}