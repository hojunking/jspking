package co.yedam.sns.vo;

import java.sql.Date;

import co.yedam.Lms.sns.vo.CommentsVO;
//sns는 comments를 상속받음 => 확장 VO 주테이블과 서브테이블 개념, 상속으로 확장한다.
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
