package com.binghz.yy.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String objectToString(Object obj){
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] objectToByte(Object obj){
		try {
			return objectMapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
