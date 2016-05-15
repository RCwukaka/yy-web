package com.binghz.yy.utils;

/*
 * 设置相应返回对应的json对象
 */

public class JsonMessage {
	private int code;
	private String result;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public JsonMessage fill(int code ,String result){
		this.setCode(code);
		this.setResult(result);
		return this;
	}
}
