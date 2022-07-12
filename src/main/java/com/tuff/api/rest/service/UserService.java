package com.tuff.api.rest.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuff.api.rest.RequestResponseDTO.RegistrationResponse;
import com.tuff.api.rest.RequestResponseDTO.StatusResponse;
import com.tuff.api.rest.model.AuthUser;
import com.tuff.api.rest.model.Status;
import com.tuff.api.rest.model.User;
import com.tuff.api.rest.repository.AuthUserRepository;
import com.tuff.api.rest.repository.UserRepository;
import com.tuff.api.rest.util.OTPGenerator;
import com.tuff.api.rest.util.SequenceGenerator;

@Service("userService")
public class UserService 
{	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SequenceGenerator seqGen;
	
	@Autowired
	OTPGenerator otpGen;
	
	@Autowired
	AuthUserRepository authRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	public RegistrationResponse firstLogin(String username)
	{
		RegistrationResponse regResponse = new RegistrationResponse();
		try {
			if(this.authRepo.existsByUsername(username))
			{		
				regResponse = new RegistrationResponse();
				regResponse.setReponse("User Already Exist");
				regResponse.setAuthUser(this.authRepo.findByUsername(username));
				regResponse.setUser(null);
			}else if(!this.userRepo.existsByUsername(username))
			{
				regResponse = new RegistrationResponse();
				regResponse.setReponse("Dealer Does Not Exist ");
				regResponse.setAuthUser(null);
				regResponse.setUser(null);
			}else
			{
				regResponse = new RegistrationResponse();
				User existingDetail = this.userRepo.findByUsername(username);
				String OTP = new String(otpGen.OTP(4)); //Generating OTP
				log.info("The OTP Generated while firstLogin is OTP = {}",OTP);
				//Setting generated new otp to the user collection as Not Verified
				existingDetail.setVerification_status("Not Verifiead");
				existingDetail.setVerification_otp(OTP);
				existingDetail.setUpdated_timestamp(new Date());
				this.userRepo.save(existingDetail);
				//Setting Response
				regResponse = new RegistrationResponse();
				regResponse.setReponse("OTP has been generated");
				regResponse.setUser(existingDetail);
				regResponse.setAuthUser(new AuthUser());
			}
		} catch (Exception e) {
			log.error("Exception Occured in firstLogin at userService=>{}",e);
		}
		return regResponse;
	}
	
	public RegistrationResponse registration(AuthUser authUser)
	{
		RegistrationResponse regResponse;
		try {
			if(!this.authRepo.existsByUsername(authUser.getUsername()))
			{
				regResponse = new RegistrationResponse();
				AuthUser registration = new AuthUser();
				int id = seqGen.generateSequence(authUser.SEQUENCE_NAME);
				User existingDetail = this.userRepo.findByUsername(authUser.getUsername());
				//Setting verification Status Veriofied in User Collection.
				existingDetail.setVerification_status("Verifiead");
				existingDetail.setUpdated_timestamp(new Date());
				existingDetail.setUser_id(id);
				this.userRepo.save(existingDetail);
				//Populating Auth USer Table (Registration)
				registration.setId(id);
				registration.setPassword(authUser.getPassword());
				registration.setFirst_name(authUser.getFirst_name());
				registration.setUsername(authUser.getUsername());
				registration.setDate_joined(new Date());
				registration.setStatus(Status.active);
				registration.setEmail(authUser.getEmail());
				registration.setLast_name(authUser.getLast_name());
				registration.setLast_login(authUser.getLast_login());
				registration.setFirst_name(authUser.getFirst_name());
				registration.setIs_staff(true);
				registration.setIs_superuser(true);
				this.authRepo.save(registration);
				regResponse = new RegistrationResponse();
				regResponse.setReponse("Successful");
				regResponse.setUser(existingDetail);
				regResponse.setAuthUser(registration);
				return regResponse;
			}else
			{
				regResponse = new RegistrationResponse();
				regResponse.setReponse("User is already created");
				regResponse.setUser(this.userRepo.findByUsername(authUser.getUsername()));
				regResponse.setAuthUser(this.authRepo.findByUsername(authUser.getUsername()));
				return regResponse;
			}
		} catch (Exception e) 
		{
			log.error("Exception Occured in registration at UserService=>{} ",e);
		}
		regResponse = new RegistrationResponse();
		regResponse.setReponse("Error while registration");
		regResponse.setUser(null);
		regResponse.setAuthUser(null);
		return regResponse;
		
	}
	
	
	public AuthUser loginUser(String username,String password)
	{
		try {
			log.info("I am in Service",username);
			AuthUser user = this.authRepo.findByUsernameAndPassword(username,password);
			if(user.getStatus().equals(Status.active))
			{
				user.setLast_login(new Date());
				this.authRepo.save(user);
				return user;
			}else
			{
				AuthUser inactiveuser = new AuthUser();
				return inactiveuser;
			}
		} catch (Exception e) {
			log.error("Exception Occured in firstLogin at UserService = {}",e);
		}
		return new AuthUser();
	}
	
}
