package co.song.prj;

import java.util.Date;

public class Comments {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.SNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private Short sno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.CNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private Short cno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.CNAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String cname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.CSUBJECT
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private String csubject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.CDATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    private Date cdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.SNO
     *
     * @return the value of COMMENTS.SNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public Short getSno() {
        return sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.SNO
     *
     * @param sno the value for COMMENTS.SNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setSno(Short sno) {
        this.sno = sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.CNO
     *
     * @return the value of COMMENTS.CNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public Short getCno() {
        return cno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.CNO
     *
     * @param cno the value for COMMENTS.CNO
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setCno(Short cno) {
        this.cno = cno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.CNAME
     *
     * @return the value of COMMENTS.CNAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.CNAME
     *
     * @param cname the value for COMMENTS.CNAME
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.CSUBJECT
     *
     * @return the value of COMMENTS.CSUBJECT
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public String getCsubject() {
        return csubject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.CSUBJECT
     *
     * @param csubject the value for COMMENTS.CSUBJECT
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setCsubject(String csubject) {
        this.csubject = csubject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.CDATE
     *
     * @return the value of COMMENTS.CDATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public Date getCdate() {
        return cdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.CDATE
     *
     * @param cdate the value for COMMENTS.CDATE
     *
     * @mbg.generated Wed Aug 04 14:21:50 KST 2021
     */
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}