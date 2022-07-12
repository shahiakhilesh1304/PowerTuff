package com.tuff.api.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "admin_user")
public class AdminUser 
{
	@Transient
	public static final String SEQUENCE_NAME = "adminuser_sequence";	
	
	@Id
	private String _id;
	private int id;
	private String name;
	private String user_id;
	private String phone;
	private String email;
	private String password;
	private Status status;
	private Date last_login;
	private Date date_joined;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
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
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the last_login
	 */
	public Date getLast_login() {
		return last_login;
	}
	/**
	 * @param last_login the last_login to set
	 */
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	/**
	 * @return the date_joined
	 */
	public Date getDate_joined() {
		return date_joined;
	}
	/**
	 * @param date_joined the date_joined to set
	 */
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", name=" + name + ", user_id=" + user_id + ", phone=" + phone + ", email="
				+ email + ", password=" + password + ", status=" + status + ", last_login=" + last_login
				+ ", date_joined=" + date_joined + "]";
	}
	public AdminUser(int id, String name, String user_id, String phone, String email, String password, Status status,
			Date last_login, Date date_joined) {
		this.id = id;
		this.name = name;
		this.user_id = user_id;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.status = status;
		this.last_login = last_login;
		this.date_joined = date_joined;
	}
	public AdminUser() {}
	
}
