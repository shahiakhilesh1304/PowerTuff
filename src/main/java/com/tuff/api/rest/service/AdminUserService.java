package com.tuff.api.rest.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuff.api.rest.RequestResponseDTO.AdminLoginRequest;
import com.tuff.api.rest.RequestResponseDTO.StatusResponse;
import com.tuff.api.rest.model.AdminUser;
import com.tuff.api.rest.model.Status;
import com.tuff.api.rest.repository.AdminUserRepository;
import com.tuff.api.rest.util.SequenceGenerator;

@Service
public class AdminUserService 
{
	private static final Logger log = LoggerFactory.getLogger(AdminUserService.class);
	
	@Autowired
	AdminUserRepository adminRepo;
	
	@Autowired
	SequenceGenerator seqGen;
	
	//saving admin user
	public StatusResponse saveAdminUser(AdminUser user)
	{
		AdminUser checkAvailability = new AdminUser();
		StatusResponse status = new StatusResponse();
		try 
		{
			checkAvailability  = this.adminRepo.findByUserId(user.getUser_id());
			if(checkAvailability == null)
			{
				checkAvailability  = this.adminRepo.findByPhone(user.getPhone());
				if(checkAvailability == null)
				{
					checkAvailability = this.adminRepo.findByEmail(user.getEmail());
					if(checkAvailability == null)
					{
							int id = seqGen.generateSequence(user.SEQUENCE_NAME);
							SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
							Date dt_1 = objSDF.parse("0000-00-00");
							user.setId(id);
							user.setDate_joined(new Date());
							user.setLast_login(dt_1);
							user.setStatus(Status.active);
							this.adminRepo.save(user);
							status = new StatusResponse();
							status.setStatus("200");
							status.setMsg("Success : User saved");
							return status;
					}else
					{
						status = new StatusResponse();
						status.setStatus("409");
						status.setMsg("Conflict : User already exist with this email,Please use different email");
						return status;
					}
				}else {
					status = new StatusResponse();
					status.setStatus("409");
					status.setMsg("Conflict : User already exist with this phone,Please use different phone");
					return status;
				}
			}else
			{
				status = new StatusResponse();
				status.setStatus("409");
				status.setMsg("Conflict : User already exist with this userid,Please use different userid");
				return status;
			}
		} catch (Exception e) {
			log.info("Exception occured in saveUser at AdminUserService={}",e);
			status = new StatusResponse();
			status.setStatus("500");
			status.setMsg("Error : Internal Server error");
			return status;
		}
	}
	
	
	
	
	public AdminUser loginAdmin(AdminLoginRequest request)
	{
		try 
		{
			log.info("username={}, password={}",request.getUser_id(),request.getPassword());
			AdminUser user = this.adminRepo.findByUserIdAndPassword(request.getUser_id(),request.getPassword());
			if(user != null && (user.getStatus()).equals(Status.active))
			{
				return user;
			}else
			{
				AdminUser invalid = null;
				return invalid;
			}
		} catch (Exception e) 
		{
			log.info("Exception occured in loginAdmin at AdminUserService={}",e);
			return null;
		}
	}
}
