package com.tuff.api.rest.model;

public class DealerCompProfile {
	private String brand;
	private String category2WB;
	private String category2W;
	private String category4W;
	private String categoryAB;
	private String categoryER;
	private TimeDuration timeDuration;
	
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the category2WB
	 */
	public String getCategory2WB() {
		return category2WB;
	}
	/**
	 * @param category2wb the category2WB to set
	 */
	public void setCategory2WB(String category2wb) {
		category2WB = category2wb;
	}
	/**
	 * @return the category2W
	 */
	public String getCategory2W() {
		return category2W;
	}
	/**
	 * @param category2w the category2W to set
	 */
	public void setCategory2W(String category2w) {
		category2W = category2w;
	}
	/**
	 * @return the category4W
	 */
	public String getCategory4W() {
		return category4W;
	}
	/**
	 * @param category4w the category4W to set
	 */
	public void setCategory4W(String category4w) {
		category4W = category4w;
	}
	/**
	 * @return the categoryAB
	 */
	public String getCategoryAB() {
		return categoryAB;
	}
	/**
	 * @param categoryAB the categoryAB to set
	 */
	public void setCategoryAB(String categoryAB) {
		this.categoryAB = categoryAB;
	}
	/**
	 * @return the categoryER
	 */
	public String getCategoryER() {
		return categoryER;
	}
	/**
	 * @param categoryER the categoryER to set
	 */
	public void setCategoryER(String categoryER) {
		this.categoryER = categoryER;
	}
	/**
	 * @return the timeDuration
	 */
	public TimeDuration getTimeDuration() {
		return timeDuration;
	}
	/**
	 * @param timeDuration the timeDuration to set
	 */
	public void setTimeDuration(TimeDuration timeDuration) {
		this.timeDuration = timeDuration;
	}
	
	public DealerCompProfile() {}
	
	public DealerCompProfile(String brand, String category2wb, String category2w, String category4w, String categoryAB,
			String categoryER, TimeDuration timeDuration) {
		this.brand = brand;
		category2WB = category2wb;
		category2W = category2w;
		category4W = category4w;
		this.categoryAB = categoryAB;
		this.categoryER = categoryER;
		this.timeDuration = timeDuration;
	}
	
	@Override
	public String toString() {
		return "DealerCompProfile [brand=" + brand + ", category2WB=" + category2WB + ", category2W=" + category2W
				+ ", category4W=" + category4W + ", categoryAB=" + categoryAB + ", categoryER=" + categoryER
				+ ", timeDuration=" + timeDuration + "]";
	}
	

	
}
