package com.tuff.api.rest.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuff.api.rest.RequestResponseDTO.AdminLoginRequest;
import com.tuff.api.rest.RequestResponseDTO.BatRequest;
import com.tuff.api.rest.RequestResponseDTO.DealerRequest;
import com.tuff.api.rest.RequestResponseDTO.RegistrationResponse;
import com.tuff.api.rest.RequestResponseDTO.StatusResponse;
import com.tuff.api.rest.model.AdminUser;
import com.tuff.api.rest.model.AuthUser;
import com.tuff.api.rest.model.Dealer;
import com.tuff.api.rest.model.User;
import com.tuff.api.rest.service.AdminUserService;
import com.tuff.api.rest.service.DealerService;
import com.tuff.api.rest.service.UserService;

//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PowerTuffController 
{	
	
	private static final Logger log = LoggerFactory.getLogger(PowerTuffController.class);
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	UserService userService;
	
	@Autowired
	DealerService dealerService;
	
	
	@Autowired
	AdminUserService adminService;
	
	@PostMapping("/firstLogin")
	public ResponseEntity<RegistrationResponse> firstLogin(@RequestBody BatRequest username)
	{
		RegistrationResponse regResponse;
		try 
		{
			
			return new ResponseEntity<RegistrationResponse>(this.userService.firstLogin(username.getUsername()),HttpStatus.OK);
		} catch (Exception e) 
		{
			log.error("Exception Occured in firstLogin at PowerTuffController",e);
		}
		regResponse = new RegistrationResponse();
		regResponse.setReponse("Error in computation");
		regResponse.setAuthUser(null);
		regResponse.setUser(null);
		return new ResponseEntity<RegistrationResponse>(regResponse,HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> registration(@RequestBody AuthUser user)
	{
		RegistrationResponse regResponse;
		try 
		{
			return new ResponseEntity<RegistrationResponse>(this.userService.registration(user),HttpStatus.OK);
		} catch (Exception e) 
		{
			log.error("Exception Occured in registration at PowerTuffController",e);
		}
		regResponse = new RegistrationResponse();
		regResponse.setReponse("Error in computation");
		regResponse.setAuthUser(null);
		regResponse.setUser(null);
		return new ResponseEntity<RegistrationResponse>(regResponse,HttpStatus.OK);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<?> login(@RequestBody BatRequest username)
	{
		try 
		{
			log.info(username.getUsername());
			AuthUser resultingUser = this.userService.loginUser(username.getUsername(),username.getPassword());
			if(resultingUser != null)
			{
				log.info("Save Dealer Json= {}", mapper.writeValueAsString(resultingUser));
				return new ResponseEntity<AuthUser>(resultingUser,HttpStatus.OK);
			}else
			{
				StatusResponse status = new StatusResponse();
				status.setStatus("203");
				status.setMsg("Authetication Failed : Invalid username or password");
				return new ResponseEntity<StatusResponse>(status,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
		} catch (Exception e) 
		{
			log.error("Exception occured in login controller = {}",e);
		}
		return new ResponseEntity<String>("User Not Found",HttpStatus.NO_CONTENT);
	}
	
	

	@PostMapping("/saveDealer")
	public ResponseEntity<StatusResponse> saveAccount(@Valid @RequestBody DealerRequest dealer) 
	{
		StatusResponse status = new StatusResponse();
		try 
		{	
			log.info("Save Dealer Json= {}",mapper.writeValueAsString(dealer));	
			status = this.dealerService.saveDealer(dealer);
			return new ResponseEntity<StatusResponse>(status, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			log.error("Exception in Save Dealer Method Exception={} ", e);
			status = new StatusResponse();
			status.setStatus("500");
			status.setMsg("Error:Internal Server error");
			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	//Admin access
	@PostMapping("/saveAdmin")
	public ResponseEntity<StatusResponse> saveAdmin(@Valid @RequestBody AdminUser user) 
	{
		StatusResponse status = new StatusResponse();
		try 
		{	
			log.info("Save Dealer Json= {}",mapper.writeValueAsString(user));	
			status = this.adminService.saveAdminUser(user);
			return new ResponseEntity<StatusResponse>(status, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			log.error("Exception in saveAdmin Method Exception={} ", e);
			status = new StatusResponse();
			status.setStatus("500");
			status.setMsg("Error:Internal Server error");
			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<?> loginAdmin(@Valid @RequestBody AdminLoginRequest request)
	{
		StatusResponse status = new StatusResponse();
		try {
			AdminUser resultingUser = this.adminService.loginAdmin(request);
			if(resultingUser != null)
			{
				return new ResponseEntity<AdminUser>(resultingUser,HttpStatus.OK);
			}else
			{
				status.setStatus("203");
				status.setMsg("Error: username of password is invalid");
				return new ResponseEntity<StatusResponse>(status,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
		} catch (Exception e) {
			log.error("Exception in loginAdmin Method Exception={} ", e);
			status = new StatusResponse();
			status.setStatus("500");
			status.setMsg("Error:Internal Server error");
			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	
//	@PostMapping("")
	
	
	
}