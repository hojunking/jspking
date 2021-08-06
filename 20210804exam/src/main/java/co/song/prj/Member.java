package co.song.prj;

import java.math.BigDecimal;

public class Member {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.ID
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.PASSWORD
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.NAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.AGE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private BigDecimal age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.AUTHOR
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.STATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEMBER.GENDER
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String gender;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.ID
     *
     * @return the value of MEMBER.ID
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.ID
     *
     * @param id the value for MEMBER.ID
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.PASSWORD
     *
     * @return the value of MEMBER.PASSWORD
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.PASSWORD
     *
     * @param password the value for MEMBER.PASSWORD
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.NAME
     *
     * @return the value of MEMBER.NAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.NAME
     *
     * @param name the value for MEMBER.NAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.AGE
     *
     * @return the value of MEMBER.AGE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public BigDecimal getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.AGE
     *
     * @param age the value for MEMBER.AGE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setAge(BigDecimal age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.AUTHOR
     *
     * @return the value of MEMBER.AUTHOR
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.AUTHOR
     *
     * @param author the value for MEMBER.AUTHOR
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.STATE
     *
     * @return the value of MEMBER.STATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.STATE
     *
     * @param state the value for MEMBER.STATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEMBER.GENDER
     *
     * @return the value of MEMBER.GENDER
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEMBER.GENDER
     *
     * @param gender the value for MEMBER.GENDER
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}