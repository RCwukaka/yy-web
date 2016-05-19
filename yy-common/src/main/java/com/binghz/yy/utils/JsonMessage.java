package com.binghz.yy.utils;

import java.util.List;
import java.util.Map;

/*
 * 设置相应返回对应的json对象
 */

public class JsonMessage {
	private int code;
	private String result;
	private Map<String,String> map;
	private List<Map<String,Object>> maps;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public JsonMessage fill(int code ,String result){
		this.setCode(code);
		this.setResult(result);
		return this;
	}
	public JsonMessage fill(int code ,String result,Map<String, String> map){
		this.setCode(code);
		this.setResult(result);
		this.setMap(map);
		return this;
	}
	public JsonMessage fill(int code ,String result,Map<String, String> map,List<Map<String, Object>> maps){
		this.setCode(code);
		this.setResult(result);
		this.setMap(map);
		this.setMaps(maps);
		return this;
	}
	public List<Map<String, Object>> getMaps() {
		return maps;
	}
	public void setMaps(List<Map<String, Object>> maps) {
		this.maps = maps;
	}
	
}
