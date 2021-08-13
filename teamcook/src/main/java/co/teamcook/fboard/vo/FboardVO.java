package co.teamcook.fboard.vo;

import java.sql.Date;

public class FboardVO extends FcommentsVO {
	private int fNo;
	private String fWriter;
	private String fTitle;
	private Date fDate;
	private String fContents;
	private int fHit;

	public FboardVO() {
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getfWriter() {
		return fWriter;
	}

	public void setfWriter(String fWriter) {
		this.fWriter = fWriter;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	public String getfContents() {
		return fContents;
	}

	public void setfContents(String fContents) {
		this.fContents = fContents;
	}

	public int getfHit() {
		return fHit;
	}

	public void setfHit(int fHit) {
		this.fHit = fHit;
	}

	@Override
	public String toString() {
		return "FboardVO [fNo=" + fNo + ", fWriter=" + fWriter + ", fTitle=" + fTitle + ", fDate=" + fDate
				+ ", fContents=" + fContents + ", fHit=" + fHit + "]";
	}
}
