package com.tuff.api.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User 
{
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";	
	
	@Id
	private String _id;
	private int id;
	private String username; //batcode
	private String first_name;
	private String last_name;
	@Field(value = "phone")
	private String phone;
	private String salespersonname;
	private String salespersoncode;
	private String distributorname;
	private String distributorcode;
	private String distributorzone;
	private String email;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String dealership_name;
	private String verification_otp;
	private String verification_status;
	private String large_image;
	private String small_image;
	private Date last_login;
	private Date date_joined;
	private Date created_timestamp;
	private Date updated_timestamp;
	private int user_id;
	private int total_loyalty;
	private int type;
	private int erick_loyalty;
	private int total_loyalty_tertiary;
	private int erick_tert_loyalty;
	private int joining_bonus;
	private int ibups_sec_loyalty;
	private int fourw_sec_loyalty;
	private Status status;
	private Boolean is_staff;
	private Boolean is_superuser;
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
	 * @return the salespersonname
	 */
	public String getSalespersonname() {
		return salespersonname;
	}
	/**
	 * @param salespersonname the salespersonname to set
	 */
	public void setSalespersonname(String salespersonname) {
		this.salespersonname = salespersonname;
	}
	/**
	 * @return the salespersoncode
	 */
	public String getSalespersoncode() {
		return salespersoncode;
	}
	/**
	 * @param salespersoncode the salespersoncode to set
	 */
	public void setSalespersoncode(String salespersoncode) {
		this.salespersoncode = salespersoncode;
	}
	/**
	 * @return the distributorname
	 */
	public String getDistributorname() {
		return distributorname;
	}
	/**
	 * @param distributorname the distributorname to set
	 */
	public void setDistributorname(String distributorname) {
		this.distributorname = distributorname;
	}
	/**
	 * @return the distributorcode
	 */
	public String getDistributorcode() {
		return distributorcode;
	}
	/**
	 * @param distributorcode the distributorcode to set
	 */
	public void setDistributorcode(String distributorcode) {
		this.distributorcode = distributorcode;
	}
	/**
	 * @return the distributorzone
	 */
	public String getDistributorzone() {
		return distributorzone;
	}
	/**
	 * @param distributorzone the distributorzone to set
	 */
	public void setDistributorzone(String distributorzone) {
		this.distributorzone = distributorzone;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the dealership_name
	 */
	public String getDealership_name() {
		return dealership_name;
	}
	/**
	 * @param dealership_name the dealership_name to set
	 */
	public void setDealership_name(String dealership_name) {
		this.dealership_name = dealership_name;
	}
	/**
	 * @return the verification_otp
	 */
	public String getVerification_otp() {
		return verification_otp;
	}
	/**
	 * @param verification_otp the verification_otp to set
	 */
	public void setVerification_otp(String verification_otp) {
		this.verification_otp = verification_otp;
	}
	/**
	 * @return the verification_status
	 */
	public String getVerification_status() {
		return verification_status;
	}
	/**
	 * @param verification_status the verification_status to set
	 */
	public void setVerification_status(String verification_status) {
		this.verification_status = verification_status;
	}
	/**
	 * @return the large_image
	 */
	public String getLarge_image() {
		return large_image;
	}
	/**
	 * @param large_image the large_image to set
	 */
	public void setLarge_image(String large_image) {
		this.large_image = large_image;
	}
	/**
	 * @return the small_image
	 */
	public String getSmall_image() {
		return small_image;
	}
	/**
	 * @param small_image the small_image to set
	 */
	public void setSmall_image(String small_image) {
		this.small_image = small_image;
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
	/**
	 * @return the created_timestamp
	 */
	public Date getCreated_timestamp() {
		return created_timestamp;
	}
	/**
	 * @param created_timestamp the created_timestamp to set
	 */
	public void setCreated_timestamp(Date created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	/**
	 * @return the updated_timestamp
	 */
	public Date getUpdated_timestamp() {
		return updated_timestamp;
	}
	/**
	 * @param updated_timestamp the updated_timestamp to set
	 */
	public void setUpdated_timestamp(Date updated_timestamp) {
		this.updated_timestamp = updated_timestamp;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the total_loyalty
	 */
	public int getTotal_loyalty() {
		return total_loyalty;
	}
	/**
	 * @param total_loyalty the total_loyalty to set
	 */
	public void setTotal_loyalty(int total_loyalty) {
		this.total_loyalty = total_loyalty;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the erick_loyalty
	 */
	public int getErick_loyalty() {
		return erick_loyalty;
	}
	/**
	 * @param erick_loyalty the erick_loyalty to set
	 */
	public void setErick_loyalty(int erick_loyalty) {
		this.erick_loyalty = erick_loyalty;
	}
	/**
	 * @return the total_loyalty_tertiary
	 */
	public int getTotal_loyalty_tertiary() {
		return total_loyalty_tertiary;
	}
	/**
	 * @param total_loyalty_tertiary the total_loyalty_tertiary to set
	 */
	public void setTotal_loyalty_tertiary(int total_loyalty_tertiary) {
		this.total_loyalty_tertiary = total_loyalty_tertiary;
	}
	/**
	 * @return the erick_tert_loyalty
	 */
	public int getErick_tert_loyalty() {
		return erick_tert_loyalty;
	}
	/**
	 * @param erick_tert_loyalty the erick_tert_loyalty to set
	 */
	public void setErick_tert_loyalty(int erick_tert_loyalty) {
		this.erick_tert_loyalty = erick_tert_loyalty;
	}
	/**
	 * @return the joining_bonus
	 */
	public int getJoining_bonus() {
		return joining_bonus;
	}
	/**
	 * @param joining_bonus the joining_bonus to set
	 */
	public void setJoining_bonus(int joining_bonus) {
		this.joining_bonus = joining_bonus;
	}
	/**
	 * @return the ibups_sec_loyalty
	 */
	public int getIbups_sec_loyalty() {
		return ibups_sec_loyalty;
	}
	/**
	 * @param ibups_sec_loyalty the ibups_sec_loyalty to set
	 */
	public void setIbups_sec_loyalty(int ibups_sec_loyalty) {
		this.ibups_sec_loyalty = ibups_sec_loyalty;
	}
	/**
	 * @return the fourw_sec_loyalty
	 */
	public int getFourw_sec_loyalty() {
		return fourw_sec_loyalty;
	}
	/**
	 * @param fourw_sec_loyalty the fourw_sec_loyalty to set
	 */
	public void setFourw_sec_loyalty(int fourw_sec_loyalty) {
		this.fourw_sec_loyalty = fourw_sec_loyalty;
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
	
	public User(int id, String username, String first_name, String last_name, String phone, String salespersonname,
			String salespersoncode, String distributorname, String distributorcode, String distributorzone,
			String email, String address, String city, String state, String pincode, String dealership_name,
			String verification_otp, String verification_status, String large_image, String small_image,
			Date last_login, Date date_joined, Date created_timestamp, Date updated_timestamp, int user_id,
			int total_loyalty, int type, int erick_loyalty, int total_loyalty_tertiary, int erick_tert_loyalty,
			int joining_bonus, int ibups_sec_loyalty, int fourw_sec_loyalty, Status status, Boolean is_staff,
			Boolean is_superuser) {
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.salespersonname = salespersonname;
		this.salespersoncode = salespersoncode;
		this.distributorname = distributorname;
		this.distributorcode = distributorcode;
		this.distributorzone = distributorzone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.dealership_name = dealership_name;
		this.verification_otp = verification_otp;
		this.verification_status = verification_status;
		this.large_image = large_image;
		this.small_image = small_image;
		this.last_login = last_login;
		this.date_joined = date_joined;
		this.created_timestamp = created_timestamp;
		this.updated_timestamp = updated_timestamp;
		this.user_id = user_id;
		this.total_loyalty = total_loyalty;
		this.type = type;
		this.erick_loyalty = erick_loyalty;
		this.total_loyalty_tertiary = total_loyalty_tertiary;
		this.erick_tert_loyalty = erick_tert_loyalty;
		this.joining_bonus = joining_bonus;
		this.ibups_sec_loyalty = ibups_sec_loyalty;
		this.fourw_sec_loyalty = fourw_sec_loyalty;
		this.status = status;
		this.is_staff = is_staff;
		this.is_superuser = is_superuser;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", phone=" + phone + ", salespersonname=" + salespersonname + ", salespersoncode=" + salespersoncode
				+ ", distributorname=" + distributorname + ", distributorcode=" + distributorcode + ", distributorzone="
				+ distributorzone + ", email=" + email + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", dealership_name=" + dealership_name + ", verification_otp="
				+ verification_otp + ", verification_status=" + verification_status + ", large_image=" + large_image
				+ ", small_image=" + small_image + ", last_login=" + last_login + ", date_joined=" + date_joined
				+ ", created_timestamp=" + created_timestamp + ", updated_timestamp=" + updated_timestamp + ", user_id="
				+ user_id + ", total_loyalty=" + total_loyalty + ", type=" + type + ", erick_loyalty=" + erick_loyalty
				+ ", total_loyalty_tertiary=" + total_loyalty_tertiary + ", erick_tert_loyalty=" + erick_tert_loyalty
				+ ", joining_bonus=" + joining_bonus + ", ibups_sec_loyalty=" + ibups_sec_loyalty
				+ ", fourw_sec_loyalty=" + fourw_sec_loyalty + ", status=" + status + ", is_staff=" + is_staff
				+ ", is_superuser=" + is_superuser + "]";
	}
	
	public User() {}


}
