package com.tuff.api.rest.RequestResponseDTO;

import com.tuff.api.rest.model.AuthUser;
import com.tuff.api.rest.model.User;

public class RegistrationResponse 
{
	private String reponse;
	private AuthUser authUser;
	private User user;
	public RegistrationResponse(String reponse, AuthUser authUser, User user) {
		this.reponse = reponse;
		this.authUser = authUser;
		this.user = user;
	}
	/**
	 * @return the reponse
	 */
	public String getReponse() {
		return reponse;
	}
	/**
	 * @param reponse the reponse to set
	 */
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	/**
	 * @return the authUser
	 */
	public AuthUser getAuthUser() {
		return authUser;
	}
	/**
	 * @param authUser the authUser to set
	 */
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "RegistrationResponse [reponse=" + reponse + ", authUser=" + authUser + ", user=" + user + "]";
	}
	public RegistrationResponse() {
		// TODO Auto-generated constructor stub
	}
	
}
