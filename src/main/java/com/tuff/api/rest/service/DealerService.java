package com.tuff.api.rest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuff.api.rest.RequestResponseDTO.DealerRequest;
import com.tuff.api.rest.RequestResponseDTO.StatusResponse;
import com.tuff.api.rest.model.Dealer;
import com.tuff.api.rest.model.DealerCompProfile;
import com.tuff.api.rest.model.Status;
import com.tuff.api.rest.model.TimeDuration;
import com.tuff.api.rest.model.User;
import com.tuff.api.rest.repository.DealerRepository;
import com.tuff.api.rest.repository.UserRepository;
import com.tuff.api.rest.util.BatCodeGenerator;
import com.tuff.api.rest.util.OTPGenerator;
import com.tuff.api.rest.util.SequenceGenerator;

@Service
public class DealerService 
{
	private static final Logger log = LoggerFactory.getLogger(DealerService.class);
	
	@Autowired
	SequenceGenerator seqGen;
	
	@Autowired
	DealerRepository dealerRepo;
	
	@Autowired
	BatCodeGenerator createbat;
	
	@Autowired
	OTPGenerator otpGen;
	
	@Autowired
	UserRepository userRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	
	public StatusResponse saveDealer(DealerRequest dealer)
	{
		StatusResponse status = new StatusResponse();
		try 
		{
			Dealer checkAvailability = this.dealerRepo.findByPhone(dealer.getPhone());
			if(checkAvailability == null)
			{
					SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
					Date dt_1 = objSDF.parse("0000-00-00");
					log.info("The batcode is={}",dt_1);
					Dealer newDealer = new Dealer();
					int id = seqGen.generateSequence(newDealer.SEQUENCE_NAME);
					String OTP = new String(otpGen.OTP(4)); //Generating OTP
					String c;	
					String batCode = "bat";
					do {
						c = new String(this.createbat.batCode());
						batCode = batCode+c;
						log.info("The batcode is={}",batCode);
					}while(this.dealerRepo.findByDealerCode(batCode) != null);
					
					log.info("Batchode={}",batCode);
					
					//Populating dealer table
					newDealer.setId(id);	
					newDealer.setDealer_first_name(dealer.getFirst_name());
					newDealer.setDealer_last_name(dealer.getLast_name());
					newDealer.setDealer_address(dealer.getAddress());
					newDealer.setDealer_code(batCode);
					newDealer.setDealer_area(dealer.getArea());
					newDealer.setDealer_city(dealer.getCity());
					newDealer.setDealer_district(dealer.getDistrict());
					newDealer.setDealer_postal(dealer.getPostal());
					newDealer.setDealer_shop_name(dealer.getShop_name());
					newDealer.setDealer_shop_profile(dealer.getShop_profile());
					newDealer.setPhone(dealer.getPhone());
					newDealer.setDist_name(dealer.getDist_name());
					newDealer.setDist_code(dealer.getDist_code());
					List<DealerCompProfile> compProfile = new ArrayList<>();
					DealerCompProfile comp = new DealerCompProfile();
					comp.setBrand(" ");
					comp.setCategory2W(" ");
					comp.setCategory2WB(" ");
					comp.setCategory4W(" ");
					comp.setCategoryAB(" ");
					comp.setCategoryER(" ");
					comp.setTimeDuration(TimeDuration.M);
					compProfile.add(comp);
					newDealer.setCompProfileAddDealer(compProfile);
					log.info("Save Dealer Json= {}",mapper.writeValueAsString(dealer));	
					this.dealerRepo.save(newDealer);	
					
					//populating user table
					User user = new User();
					user.setUsername(batCode);
					id = seqGen.generateSequence(user.SEQUENCE_NAME);
					user.setId(id);
					user.setAddress(dealer.getAddress());
					user.setCity(dealer.getCity());
					user.setDate_joined(new Date());
					user.setCreated_timestamp(new Date());
					user.setDealership_name(" ");
					user.setDistributorcode(dealer.getDist_code());
					user.setDistributorname(dealer.getDist_name());
					user.setDistributorzone(" ");
					user.setEmail(dealer.getEmail());
					user.setErick_loyalty(0);
					user.setErick_tert_loyalty(0);
					user.setFirst_name(dealer.getFirst_name());
					user.setFourw_sec_loyalty(0);
					user.setIbups_sec_loyalty(0);
					user.setVerification_status("Not Verifired");
					user.setVerification_otp(OTP);
					user.setUpdated_timestamp(new Date());
					user.setType(0);
					user.setStatus(Status.active);
					user.setState(dealer.getState());
					user.setSmall_image("No Link");
					user.setLarge_image("No Link");
					user.setSalespersonname(dealer.getShop_name());
					user.setSalespersoncode(" ");
					user.setUser_id(0);
					user.setIs_staff(true);
					user.setIs_superuser(true);
					user.setJoining_bonus(0);
					user.setTotal_loyalty_tertiary(0);
					user.setTotal_loyalty(0);
					user.setLast_name(dealer.getLast_name());
					user.setPhone(dealer.getPhone());
					user.setPincode(dealer.getPostal());
					user.setLast_login(dt_1);
					log.info("Save USER Json= {}",mapper.writeValueAsString(user));	
					this.userRepo.save(user);
					status.setStatus("200");
					status.setMsg("Success: data saved BATCODE "+batCode);
					return status;
			}else
			{
				status.setStatus("409");
				status.setMsg("Conflict: Data Already exist with this Phone Try another number");
				return status;
			}
		} catch (Exception e) 
		{
			log.error("Exception occured while saving the dealer at saveDealer in DealerService={}", e);
			status = new StatusResponse();
			status.setStatus("500");
			status.setMsg("Internal Server Error");
			return status;
		}
	}
	
	public Dealer showData()
	{
		Dealer dealer = new Dealer();
		try {
			return dealer;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dealer;
		
	}
}
