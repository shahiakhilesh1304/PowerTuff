package com.tuff.api.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tuff.api.rest.config.WebConfiguration;

public class ConstantVariables {
	
	private static final Logger log = LoggerFactory.getLogger(ConstantVariables.class);
	
	public static final String SMSURL;
	public static final String CREATE_SAP_CONSUMER_URL;
	public static final String SapUsername;
	public static final String SapPassword;
	
	static {
		log.info("Initializing ConstantVariables : {}", WebConfiguration.env);
		SMSURL = WebConfiguration.env.getProperty("SmsUrl");
		CREATE_SAP_CONSUMER_URL =  WebConfiguration.env.getProperty("CreateSapConsumerUrl");
		SapUsername = WebConfiguration.env.getProperty("SapUsername");
		SapPassword = WebConfiguration.env.getProperty("SapPassword");
	}
}
