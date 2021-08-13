package co.teamcook.fboard.vo;

import java.sql.Date;

public class FcommentsVO {
	private int fNo;
	private int fCno;
	private String fcName;
	private String fcSubject;
	private Date fcDate;

	public FcommentsVO() {
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public int getfCno() {
		return fCno;
	}

	public void setfCno(int fCno) {
		this.fCno = fCno;
	}

	public String getfcName() {
		return fcName;
	}

	public void setfcName(String fcName) {
		this.fcName = fcName;
	}

	public String getfcSubject() {
		return fcSubject;
	}

	public void setfcSubject(String fcSubject) {
		this.fcSubject = fcSubject;
	}

	public Date getfcDate() {
		return fcDate;
	}

	public void setfcDate(Date fcDate) {
		this.fcDate = fcDate;
	}

	@Override
	public String toString() {
		return "FcommentsVO [fNo=" + fNo + ", fCno=" + fCno + ", fcName=" + fcName + ", fcSubject=" + fcSubject
				+ ", fcDate=" + fcDate + "]";
	}
}
