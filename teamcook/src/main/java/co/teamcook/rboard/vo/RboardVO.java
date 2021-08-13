package co.teamcook.rboard.vo;

import java.sql.Date;

public class RboardVO extends RcommentVO {
	private int rNo;
	private String rWriter;
	private Date rDate;
	private String rTitle;
	private String rContent;

	public RboardVO() {
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	@Override
	public String toString() {
		return "RboardVO [rNo=" + rNo + ", rWriter=" + rWriter + ", rDate=" + rDate + ", rTitle=" + rTitle + ", rContent="
				+ rContent + "]";
	}
}
