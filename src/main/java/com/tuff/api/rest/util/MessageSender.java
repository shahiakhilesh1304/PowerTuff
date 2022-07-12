package com.tuff.api.rest.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Base64;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.net.URLEncoder;
import java.util.Calendar;


@Component("messageSender")
public class MessageSender {
	private static final Logger log = LoggerFactory.getLogger(MessageSender.class);
	
	@Async
	public int sendMessage(String num, String msg) {
		try {
			String strURL = ConstantVariables.SMSURL;
			//log.info("Url={} num={} meg={}",strURL,num,msg);
			msg = msg.replace(" ", "%20").replace("\n", "%0A");
			strURL = strURL.replace("to_per", num).replace("message", msg);
			//log.info("Sms URL={} num={} sms={}",strURL,num,msg);
			URL url = new URL(strURL);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			InputStream buff = urlcon.getInputStream();
			byte[] b = new byte[buff.available()];
			buff.read(b);
			buff.close();
			String strResponse = new String(b);
			if(strResponse.equalsIgnoreCase("Sent."))
				return 1;
			log.info("Sent SMS to {}, Response={}", num, strResponse);
		}catch (Exception e) {
			log.info("Exception in Send Message Method",e);
		}
		return 0;
	}
	
	public int sendMessage1(String num, String messageText) {
		try {   
			String strURL = ConstantVariables.SMSURL;
			messageText = URLEncoder.encode(messageText, "UTF-8");
			strURL = strURL.replace("to_per", num).replace("message", messageText);
            Calendar start = Calendar.getInstance();
            URL url = new URL(strURL);
            HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
            conn1.setRequestMethod("GET");          
            conn1.setDoOutput(true);
            conn1.setConnectTimeout(100000);
            conn1.setReadTimeout(100000);
            int responseCode = conn1.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) 
                response.append(output);
            in.close();
            try {
                Calendar end= Calendar.getInstance();
                long duration = (end.getTimeInMillis() - start.getTimeInMillis())/1000;
                log.info("Number :: "+ num +"Response :: "+response.toString()+" :: Response Time in Second :: "+duration+" :: startDate :: "+start.getTime()+" :: endDate :: "+end.getTime());
                if(responseCode == 200 && response.toString().equalsIgnoreCase("Sent."))
    				return 1;
                else 
                	return 0;
            } catch(Exception e) {                
            	log.error("Exception in Response Json Parser :: "+e);
            }
        } catch(Exception e) {                
        	log.error("Exception in Send Message One :: "+e);
        }
		return 0;
	}
	
	public String sendToSap(String json) {
		try {
			log.info("Send Sap Json={}",json);
			String authString = ConstantVariables.SapUsername+":"+ConstantVariables.SapPassword;
            String authEncBytes = Base64.getEncoder().encodeToString(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
			String strURL = ConstantVariables.CREATE_SAP_CONSUMER_URL;
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");      
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            conn.setDoOutput(true);
            conn.setConnectTimeout(120000);
            conn.setReadTimeout(300000);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = conn.getResponseCode();
            log.info("Sending 'POST' Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) 
                response.append(output);
            in.close();
			log.info("Sent data to SAP Response={}", response);
			return response.toString();
		}catch (Exception e) {
			log.info("Exception in Send To SAP Method",e);
		}
		return "";
	}
	
	public String getStateCode(String state) {
		try {
			String code="";
			if(state.equalsIgnoreCase("Andhra Pradesh"))
				code="01";
			else if(state.equalsIgnoreCase("Arunachal Pradesh"))
				code="02";
			else if(state.equalsIgnoreCase("Assam"))
				code="03";
			else if(state.equalsIgnoreCase("Bihar"))
				code="04";
			else if(state.equalsIgnoreCase("Goa"))
				code="05";
			else if(state.equalsIgnoreCase("Gujarat"))
				code="06";
			else if(state.equalsIgnoreCase("Haryana"))
				code="07";
			else if(state.equalsIgnoreCase("Himachal Pradesh"))
				code="08";
			else if(state.equalsIgnoreCase("Jammu & Kashmir"))
				code="09";
			else if(state.equalsIgnoreCase("Karnataka"))
				code="10";
			else if(state.equalsIgnoreCase("Kerala"))
				code="11";
			else if(state.equalsIgnoreCase("Madhya Pradesh"))
				code="12";
			else if(state.equalsIgnoreCase("Maharashtra"))
				code="13";
			else if(state.equalsIgnoreCase("Manipur"))
				code="14";
			else if(state.equalsIgnoreCase("Meghalaya"))
				code="15";
			else if(state.equalsIgnoreCase("Mizoram"))
				code="16";
			else if(state.equalsIgnoreCase("Nagaland"))
				code="17";
			else if(state.equalsIgnoreCase("ODISHA"))
				code="18";
			else if(state.equalsIgnoreCase("Punjab"))
				code="19";
			else if(state.equalsIgnoreCase("Rajasthan"))
				code="20";
			else if(state.equalsIgnoreCase("Sikkim"))
				code="21";
			else if(state.equalsIgnoreCase("Tamil Nadu"))
				code="22";
			else if(state.equalsIgnoreCase("Tripura"))
				code="23";
			else if(state.equalsIgnoreCase("Uttar Pradesh"))
				code="24";
			else if(state.equalsIgnoreCase("West Bengal"))
				code="25";
			else if(state.equalsIgnoreCase("Andaman & Nicobar Islands"))
				code="26";
			else if(state.equalsIgnoreCase("Chandigarh"))
				code="27";
			else if(state.equalsIgnoreCase("Dadra and Nagr Hav."))
				code="28";
			else if(state.equalsIgnoreCase("DADRA & NAGAR HAVELI"))
				code="28";
			else if(state.equalsIgnoreCase("Daman and Diu"))
				code="29";
			else if(state.equalsIgnoreCase("Delhi"))
				code="30";
			else if(state.equalsIgnoreCase("Lakshadweep"))
				code="31";
			else if(state.equalsIgnoreCase("Puducherry"))
				code="32";
			else if(state.equalsIgnoreCase("CHATTISGARH"))
				code="33";
			else if(state.equalsIgnoreCase("Jharkhand"))
				code="34";
			else if(state.equalsIgnoreCase("Uttarakhand"))
				code="35";
			else if(state.equalsIgnoreCase("Telangana"))
				code="36";
			log.info("StateName={}, StateCode={}",state,code);
			return code;
		}catch (Exception e) {
			log.info("Exception in Get State Code Method",e);
		}
		return "";
	}
	
	public boolean validmobile(String s) 
    { 
        if(s.length() == 12)
            s=s.substring(2);
        else if(s.length() == 11)
            s=s.substring(1);
        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");	  
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    }
	
	public boolean validpincode(String z)
	{
		return z.matches("\\d{6}");
	}
	
	public boolean validUUID(String string) 
	{
		try {
			UUID.fromString(string);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
