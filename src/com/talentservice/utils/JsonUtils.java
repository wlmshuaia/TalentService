package com.talentservice.utils;

public class JsonUtils {
	public static String getSuccessJson(String content) {
		String val = "{\"status\":\"success\", \"message\":\""+content+"\"}" ;
		return val ;
	}
	
	public static String getErrorJson(String content) {
		String val = "{\"status\":\"error\", \"message\":\""+content+"\"}" ;
		return val ;
	}
}
