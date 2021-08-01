package co.prj.sports.sns.vo;

import java.sql.Date;

import co.prj.sports.comments.vo.CommentsVO;

public class SnsVO extends CommentsVO{
	private int sNo;
	private String sWriter;
	private Date sDate;
	private String sTitle;
	private String sContents;
	private int sAno;

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsWriter() {
		return sWriter;
	}

	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContents() {
		return sContents;
	}

	public void setsContents(String sContents) {
		this.sContents = sContents;
	}

	public int getsAno() {
		return sAno;
	}

	public void setsAno(int sAno) {
		this.sAno = sAno;
	}

	public SnsVO() {
	}

}