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
	
	/*codes inside this function were inspired by here:
	 * 
	 * https://stackoverflow.com/questions/24160989/password-encryption-in-java-using-md5-and-salt
	 */
	
	public static String getMD5hash(String salt, String originalSTR) {
		//if something goes wrong , it will return a zero-length string by default
		String md5hash = "";
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			if (salt != null) {
				md.update(salt.getBytes());
			}
			md.update(originalSTR.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			md5hash = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
				
		return md5hash;		
	}
	
}
