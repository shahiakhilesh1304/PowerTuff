package com.tuff.api.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auth_user")
public class AuthUser 
{
	@Transient
	public static final String SEQUENCE_NAME = "authuser_sequence";	
	
	@Id
	private String _id;
	private int id;
	private String password;
	private String email;
	private String first_name;
	private String last_name;
	private String username;
	private Date date_joined;
	private Date last_login;
	private Boolean is_superuser;
	private Boolean is_staff;
	private Status status;
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
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
	 * @return the is_superuser
	 */
	public Boolean getIs_superuser() {
		return is_superuser;
	}
	/**
	 * @param is_superuser the is_superuser to set
	 */
	public void setIs_superuser(Boolean is_superuser) {
		this.is_superuser = is_superuser;
	}
	/**
	 * @return the is_staff
	 */
	public Boolean getIs_staff() {
		return is_staff;
	}
	/**
	 * @param is_staff the is_staff to set
	 */
	public void setIs_staff(Boolean is_staff) {
		this.is_staff = is_staff;
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
	public AuthUser(int id, String password, String email, String first_name, String last_name, String username,
			Date date_joined, Date last_login, Boolean is_superuser, Boolean is_staff, Status status) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.date_joined = date_joined;
		this.last_login = last_login;
		this.is_superuser = is_superuser;
		this.is_staff = is_staff;
		this.status = status;
	}
	public AuthUser() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthUser [id=" + id + ", password=" + password + ", email=" + email + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", username=" + username + ", date_joined=" + date_joined
				+ ", last_login=" + last_login + ", is_superuser=" + is_superuser + ", is_staff=" + is_staff
				+ ", status=" + status + "]";
	}
	
	
}
