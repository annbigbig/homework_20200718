package com.kashu.website.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5Converter {

	public static String getMD5hash(String originalSTR) {
		//if something goes wrong , it will return a zero-length string by default
		String md5hash = "";
	
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(originalSTR.getBytes());
		    byte[] digest = md.digest();
		    md5hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
	
			e.printStackTrace();
		}
	    
		return md5hash;
		
	}
}
