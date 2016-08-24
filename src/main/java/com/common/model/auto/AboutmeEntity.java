package com.common.model.auto;

public class AboutmeEntity {
    /**
     * <pre>
     * 
     * 表字段 : aboutme.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 关于我们信息
     * 表字段 : aboutme.contents
     * </pre>
     */
    private String contents;

    /**
     * <pre>
     * 获取：
     * 表字段：aboutme.id
     * </pre>
     *
     * @return aboutme.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：aboutme.id
     * </pre>
     *
     * @param id
     *            aboutme.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：关于我们信息
     * 表字段：aboutme.contents
     * </pre>
     *
     * @return aboutme.contents：关于我们信息
     */
    public String getContents() {
        return contents;
    }

    /**
     * <pre>
     * 设置：关于我们信息
     * 表字段：aboutme.contents
     * </pre>
     *
     * @param contents
     *            aboutme.contents：关于我们信息
     */
    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}