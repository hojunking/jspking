package co.teamcook.rboard.vo;

import java.sql.Date;

public class RcommentVO {
	private int rNo;
	private int rCno;
	private String rcWriter;
	private String rcSubject;
	private Date rcDate;

	public RcommentVO() {
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getrCno() {
		return rCno;
	}

	public void setrCno(int rCno) {
		this.rCno = rCno;
	}

	public String getrcWriter() {
		return rcWriter;
	}

	public void setrcWriter(String rcWriter) {
		this.rcWriter = rcWriter;
	}

	public String getrcSubject() {
		return rcSubject;
	}

	public void setrcSubject(String rcSubject) {
		this.rcSubject = rcSubject;
	}

	public Date getrcDate() {
		return rcDate;
	}

	public void setrcDate(Date rcDate) {
		this.rcDate = rcDate;
	}

	@Override
	public String toString() {
		return "RcommentVO [rNo=" + rNo + ", rCno=" + rCno + ", rcWriter=" + rcWriter + ", rcSubject=" + rcSubject
				+ ", rcDate=" + rcDate + "]";
	}
}
