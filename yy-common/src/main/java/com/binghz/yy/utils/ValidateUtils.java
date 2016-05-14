package com.binghz.yy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
	
	public static boolean userNameVail(String userName){
		Pattern pattern = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}
	
	public static boolean emailVail(String email){
		Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean phoneVail(String phone){
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
	
	public static boolean nicknameVail(String nickname){
		Pattern pattern=Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z_\u4e00-\u9fa5]+$");
		Matcher matcher = pattern.matcher(nickname);
		return matcher.matches();
	}
}
