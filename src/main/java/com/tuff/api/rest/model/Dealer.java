package com.tuff.api.rest.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dealer")
public class Dealer {

	@Transient
	public static final String SEQUENCE_NAME = "dealer_sequence";

	@Id
	private String _id;
	private int id;
	private String dist_name;
	private String dist_code;
	private String dealer_shop_name;
	private String dealer_first_name;
	private String dealer_last_name;
	private String phone;
	private String dealer_address;
	private String dealer_area;
	private String dealer_postal;
	private String dealer_city;
	private String dealer_district;
	private String dealer_state;
	private String dealer_code;
	private String dealer_shop_profile;
	private String gstin;
	private List<DealerCompProfile> compProfileAddDealer;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dist_name
	 */
	public String getDist_name() {
		return dist_name;
	}
	/**
	 * @param dist_name the dist_name to set
	 */
	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}
	/**
	 * @return the dist_code
	 */
	public String getDist_code() {
		return dist_code;
	}
	/**
	 * @param dist_code the dist_code to set
	 */
	public void setDist_code(String dist_code) {
		this.dist_code = dist_code;
	}
	/**
	 * @return the dealer_shop_name
	 */
	public String getDealer_shop_name() {
		return dealer_shop_name;
	}
	/**
	 * @param dealer_shop_name the dealer_shop_name to set
	 */
	public void setDealer_shop_name(String dealer_shop_name) {
		this.dealer_shop_name = dealer_shop_name;
	}
	/**
	 * @return the dealer_first_name
	 */
	public String getDealer_first_name() {
		return dealer_first_name;
	}
	/**
	 * @param dealer_first_name the dealer_first_name to set
	 */
	public void setDealer_first_name(String dealer_first_name) {
		this.dealer_first_name = dealer_first_name;
	}
	/**
	 * @return the dealer_last_name
	 */
	public String getDealer_last_name() {
		return dealer_last_name;
	}
	/**
	 * @param dealer_last_name the dealer_last_name to set
	 */
	public void setDealer_last_name(String dealer_last_name) {
		this.dealer_last_name = dealer_last_name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the dealer_address
	 */
	public String getDealer_address() {
		return dealer_address;
	}
	/**
	 * @param dealer_address the dealer_address to set
	 */
	public void setDealer_address(String dealer_address) {
		this.dealer_address = dealer_address;
	}
	/**
	 * @return the dealer_area
	 */
	public String getDealer_area() {
		return dealer_area;
	}
	/**
	 * @param dealer_area the dealer_area to set
	 */
	public void setDealer_area(String dealer_area) {
		this.dealer_area = dealer_area;
	}
	/**
	 * @return the dealer_postal
	 */
	public String getDealer_postal() {
		return dealer_postal;
	}
	/**
	 * @param dealer_postal the dealer_postal to set
	 */
	public void setDealer_postal(String dealer_postal) {
		this.dealer_postal = dealer_postal;
	}
	/**
	 * @return the dealer_city
	 */
	public String getDealer_city() {
		return dealer_city;
	}
	/**
	 * @param dealer_city the dealer_city to set
	 */
	public void setDealer_city(String dealer_city) {
		this.dealer_city = dealer_city;
	}
	/**
	 * @return the dealer_district
	 */
	public String getDealer_district() {
		return dealer_district;
	}
	/**
	 * @param dealer_district the dealer_district to set
	 */
	public void setDealer_district(String dealer_district) {
		this.dealer_district = dealer_district;
	}
	/**
	 * @return the dealer_state
	 */
	public String getDealer_state() {
		return dealer_state;
	}
	/**
	 * @param dealer_state the dealer_state to set
	 */
	public void setDealer_state(String dealer_state) {
		this.dealer_state = dealer_state;
	}
	/**
	 * @return the dealer_code
	 */
	public String getDealer_code() {
		return dealer_code;
	}
	/**
	 * @param dealer_code the dealer_code to set
	 */
	public void setDealer_code(String dealer_code) {
		this.dealer_code = dealer_code;
	}
	/**
	 * @return the dealer_shop_profile
	 */
	public String getDealer_shop_profile() {
		return dealer_shop_profile;
	}
	/**
	 * @param dealer_shop_profile the dealer_shop_profile to set
	 */
	public void setDealer_shop_profile(String dealer_shop_profile) {
		this.dealer_shop_profile = dealer_shop_profile;
	}
	/**
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}
	/**
	 * @param gstin the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	/**
	 * @return the compProfileAddDealer
	 */
	public List<DealerCompProfile> getCompProfileAddDealer() {
		return compProfileAddDealer;
	}
	/**
	 * @param compProfileAddDealer the compProfileAddDealer to set
	 */
	public void setCompProfileAddDealer(List<DealerCompProfile> compProfileAddDealer) {
		this.compProfileAddDealer = compProfileAddDealer;
	}
	public Dealer(int id, String dist_name, String dist_code, String dealer_shop_name, String dealer_first_name,
			String dealer_last_name, String phone, String dealer_address, String dealer_area, String dealer_postal,
			String dealer_city, String dealer_district, String dealer_state, String dealer_code,
			String dealer_shop_profile, String gstin, List<DealerCompProfile> compProfileAddDealer) {
		this.id = id;
		this.dist_name = dist_name;
		this.dist_code = dist_code;
		this.dealer_shop_name = dealer_shop_name;
		this.dealer_first_name = dealer_first_name;
		this.dealer_last_name = dealer_last_name;
		this.phone = phone;
		this.dealer_address = dealer_address;
		this.dealer_area = dealer_area;
		this.dealer_postal = dealer_postal;
		this.dealer_city = dealer_city;
		this.dealer_district = dealer_district;
		this.dealer_state = dealer_state;
		this.dealer_code = dealer_code;
		this.dealer_shop_profile = dealer_shop_profile;
		this.gstin = gstin;
		this.compProfileAddDealer = compProfileAddDealer;
	}
	public Dealer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dealer [id=" + id + ", dist_name=" + dist_name + ", dist_code=" + dist_code + ", dealer_shop_name="
				+ dealer_shop_name + ", dealer_first_name=" + dealer_first_name + ", dealer_last_name="
				+ dealer_last_name + ", phone=" + phone + ", dealer_address=" + dealer_address + ", dealer_area="
				+ dealer_area + ", dealer_postal=" + dealer_postal + ", dealer_city=" + dealer_city
				+ ", dealer_district=" + dealer_district + ", dealer_state=" + dealer_state + ", dealer_code="
				+ dealer_code + ", dealer_shop_profile=" + dealer_shop_profile + ", gstin=" + gstin
				+ ", compProfileAddDealer=" + compProfileAddDealer + "]";
	}

	
}
