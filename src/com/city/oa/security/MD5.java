package com.city.oa.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {

	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		BASE64Encoder base64en = new BASE64Encoder();
		
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		
		return newstr;
	}
	
	public static boolean getMD5(String strnew,String strold) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		if(strnew.equals(strold)){
			return true;
		}
		else{
			return false;
		}
	}
}
