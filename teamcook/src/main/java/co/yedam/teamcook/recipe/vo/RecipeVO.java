package co.yedam.teamcook.recipe.vo;

import java.sql.Date;

public class RecipeVO {
	private int rpId;
	private String rpTitle;
	private String rpIn;
	private String rpDiet;
	private String rpMethod;
	private int rpLikes;
	private Date rpDate;
	private String rpRecommend;
	private String rpImg;
	
	public RecipeVO() {
		super();
	}
	
//	getter and setters
	

	public String getRpTitle() {
		return rpTitle;
	}

	public void setRpTitle(String rpTitle) {
		this.rpTitle = rpTitle;
	}

	public String getRpIn() {
		return rpIn;
	}

	public void setRpIn(String rpIn) {
		this.rpIn = rpIn;
	}

	public String getRpDiet() {
		return rpDiet;
	}

	public void setRpDiet(String rpDiet) {
		this.rpDiet = rpDiet;
	}

	public String getRpMethod() {
		return rpMethod;
	}

	public void setRpMethod(String rpMethod) {
		this.rpMethod = rpMethod;
	}

	public int getRpLikes() {
		return rpLikes;
	}

	public void setRpLikes(int rpLikes) {
		this.rpLikes = rpLikes;
	}

	public Date getRpDate() {
		return rpDate;
	}

	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}

	public String getRpRecommend() {
		return rpRecommend;
	}

	public void setRpRecommend(String rpRecommend) {
		this.rpRecommend = rpRecommend;
	}

	public String getRpImg() {
		return rpImg;
	}

	public void setRpImg(String rpImg) {
		this.rpImg = rpImg;
	}

	public int getRpId() {
		return rpId;
	}

	public void setRpId(int rpId) {
		this.rpId = rpId;
	}

	@Override
	public String toString() {
		return "RecipeVO [rpId=" + rpId + ", rpTitle=" + rpTitle + ", rpIn=" + rpIn + ", rpDiet=" + rpDiet
				+ ", rpMethod=" + rpMethod + ", rpLikes=" + rpLikes + ", rpDate=" + rpDate + ", rpRecommend="
				+ rpRecommend + ", rpImg=" + rpImg + "]";
	}

	
	
	
}
