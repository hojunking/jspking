package co.prj.sports.event.vo;

public class EventVO {
	private int eId;
	private String eTitle;
	private String eEvent;
	private int eNumber;
	private int eCount;
	private String eDate;
	
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteEvent() {
		return eEvent;
	}
	public void seteEvent(String eEvent) {
		this.eEvent = eEvent;
	}
	public int geteNumber() {
		return eNumber;
	}
	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
	public int geteCount() {
		return eCount;
	}
	public void seteCount(int eCount) {
		this.eCount = eCount;
	}
	public EventVO() {
		super();
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	
}
