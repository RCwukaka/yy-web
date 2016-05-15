package com.binghz.yy.consts.user;

public class UserConstant {
	
	//登录成功
	public static int USER_LOGIN_SUCCESS = 0;

	//登录账号密码错误
	public static int USER_LOGIN_USERNAME_PASSWORD_ERROR = -1;
	
	//登录session失效
	public static int USER_LOGIN_SESSION_ERROR = -2;
	
	//登录未知错误
	public static int USER_LOGIN_ERROR = -3;
	
	//权限问题
	public static int USER_LOGIN_AUTH_ERROR = -4;
	
	//账号密码重复
	public static int USER_REGISTER_USERNAME = -5;
	public static String USER_REGISTER_USERNAME_STR = "用户账号已占用";
}