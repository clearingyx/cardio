package com.common.model.auto;

import java.util.Date;

public class RadomQuestionRecordEntity {
    /**
     * <pre>
     * 
     * 表字段 : radom_question_record.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 回答试题的用户id
     * 表字段 : radom_question_record.person_id
     * </pre>
     */
    private Integer personId;

    /**
     * <pre>
     * 随机试题的id
     * 表字段 : radom_question_record.question_id
     * </pre>
     */
    private Integer questionId;

    /**
     * <pre>
     * 用户答案
     * 表字段 : radom_question_record.person_anwser
     * </pre>
     */
    private String personAnwser;

    /**
     * <pre>
     * 
     * 表字段 : radom_question_record.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question_record.id
     * </pre>
     *
     * @return radom_question_record.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question_record.id
     * </pre>
     *
     * @param id
     *            radom_question_record.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：回答试题的用户id
     * 表字段：radom_question_record.person_id
     * </pre>
     *
     * @return radom_question_record.person_id：回答试题的用户id
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * <pre>
     * 设置：回答试题的用户id
     * 表字段：radom_question_record.person_id
     * </pre>
     *
     * @param personId
     *            radom_question_record.person_id：回答试题的用户id
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * <pre>
     * 获取：随机试题的id
     * 表字段：radom_question_record.question_id
     * </pre>
     *
     * @return radom_question_record.question_id：随机试题的id
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * <pre>
     * 设置：随机试题的id
     * 表字段：radom_question_record.question_id
     * </pre>
     *
     * @param questionId
     *            radom_question_record.question_id：随机试题的id
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * <pre>
     * 获取：用户答案
     * 表字段：radom_question_record.person_anwser
     * </pre>
     *
     * @return radom_question_record.person_anwser：用户答案
     */
    public String getPersonAnwser() {
        return personAnwser;
    }

    /**
     * <pre>
     * 设置：用户答案
     * 表字段：radom_question_record.person_anwser
     * </pre>
     *
     * @param personAnwser
     *            radom_question_record.person_anwser：用户答案
     */
    public void setPersonAnwser(String personAnwser) {
        this.personAnwser = personAnwser == null ? null : personAnwser.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：radom_question_record.create_date
     * </pre>
     *
     * @return radom_question_record.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：radom_question_record.create_date
     * </pre>
     *
     * @param createDate
     *            radom_question_record.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}