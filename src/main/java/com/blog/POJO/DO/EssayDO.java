package com.blog.POJO.DO;

public class EssayDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column essay.id
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column essay.title
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column essay.content
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column essay.user_name
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    private String userName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column essay.id
     *
     * @return the value of essay.id
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column essay.id
     *
     * @param id the value for essay.id
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column essay.title
     *
     * @return the value of essay.title
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column essay.title
     *
     * @param title the value for essay.title
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column essay.content
     *
     * @return the value of essay.content
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column essay.content
     *
     * @param content the value for essay.content
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column essay.user_name
     *
     * @return the value of essay.user_name
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column essay.user_name
     *
     * @param userName the value for essay.user_name
     *
     * @mbg.generated Sat Mar 30 20:01:42 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}