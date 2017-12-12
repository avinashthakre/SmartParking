package com.infy.parking.utilities;

import java.util.Base64;

public class Encrypter {

	public static String getEncryptedValue(String password) {
	
		byte[]   bytesEncoded = Base64.getEncoder().encode(password.getBytes());
		System.out.println(new String(bytesEncoded));
		
		return new String(bytesEncoded);
	}
}
