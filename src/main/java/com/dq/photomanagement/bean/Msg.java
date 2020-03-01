package com.dq.photomanagement.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	private int code;
	private String msg;
	private Map<String,Object>map=new HashMap<>();
	
	
	
	private Msg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public static Msg success() {
		return new Msg(100,"success");
	}
	
	public static Msg fail() {
		return new Msg(200,"failed");
	}
	
	public Msg add(String key,Object object) {
		this.getMap().put(key, object);
		return this;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public Msg setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
