package com.tuff.api.rest.util;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OTPGenerator 
{
	public char[] OTP(int length)
	{
		char[] otp = new char[length];
		String numbers="0123456789";
		Random rndm_method = new Random();
		for (int i = 0; i < length; i++)
		{
			otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}
}
