package com.tuff.api.rest.RequestResponseDTO;

public class DealerRegistrationInformationResponse 
{
	private String username;
	private String phone;
	private String dealer_name;
	private String email;
	private Register is_registered;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the dealer_name
	 */
	public String getDealer_name() {
		return dealer_name;
	}
	/**
	 * @param dealer_name the dealer_name to set
	 */
	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the is_registered
	 */
	public Register getIs_registered() {
		return is_registered;
	}
	/**
	 * @param is_registered the is_registered to set
	 */
	public void setIs_registered(Register is_registered) {
		this.is_registered = is_registered;
	}
	@Override
	public String toString() {
		return "DealerRegistrationInformationResponse [username=" + username + ", phone=" + phone + ", dealer_name="
				+ dealer_name + ", email=" + email + ", is_registered=" + is_registered + "]";
	}
	public DealerRegistrationInformationResponse(String username, String phone, String dealer_name, String email,
			Register is_registered) {
		this.username = username;
		this.phone = phone;
		this.dealer_name = dealer_name;
		this.email = email;
		this.is_registered = is_registered;
	}
	public DealerRegistrationInformationResponse() {
		// TODO Auto-generated constructor stub
	}
	
}
