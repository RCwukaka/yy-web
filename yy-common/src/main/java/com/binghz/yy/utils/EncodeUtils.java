package com.binghz.yy.utils;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class EncodeUtils {
	
	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	
	private EncodeUtils() {
		super();
	}
	
	/**
	 * Base64编码.
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}

	/**
	 * Base64解码.
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}

	
	public static String base64Md5(String input) {
		if (input == null || "".equals(input.trim())) {
			return null;
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance("md5");
			m.update(input.getBytes(DEFAULT_URL_ENCODING));
			byte[] s = m.digest();
			return encodeBase64(s);
		} catch (Exception e) {
		}
		return encryptText;
	}
	
}

