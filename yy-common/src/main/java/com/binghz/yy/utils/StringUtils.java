package com.binghz.yy.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String EMPTY = "";

	private StringUtils() {
		super();
	}

	public static boolean equal(String first, String last) {
		return first.equals(last);
	}

	public static boolean isBlank(String req) {
		if (req.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isNotBlank(String req){
		return !isBlank(req);
	}
	
}
