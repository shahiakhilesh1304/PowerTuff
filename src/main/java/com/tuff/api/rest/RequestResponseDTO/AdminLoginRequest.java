package com.tuff.api.rest.RequestResponseDTO;

public class AdminLoginRequest 
{
	private String user_id;
	private String password;
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLoginRequest [user_id=" + user_id + ", password=" + password + "]";
	}
	public AdminLoginRequest(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;
	}
	public AdminLoginRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
}
