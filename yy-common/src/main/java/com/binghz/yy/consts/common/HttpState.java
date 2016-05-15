package com.binghz.yy.consts.common;

public class HttpState {
	
	//http得到处理
	public static int HTTP_CHANNEL_SUCCESS = 0;
	public static String HTTP_CHANNEL_SUCCESS_STR="success";
	
	//http参数不正确
	public static int HTTP_PARAME_NORMAL = -1;
	public static String HTTP_PARAME_NORMAL_STR="参数不正确";
	
	//http头不正常
	public static int HTTP_ABNORMAL_ERROR = -2;
	public static String HTTP_ABNORMAL_ERROR_STR="参数不正确";
	
	//账号密码不正确
	public static int HTTP_USERNAMEPASSWD_ERROR = -3;
	public static String HTTP_USERNAMEPASSWD_ERROR_STR = "账号密码不正确";
}
