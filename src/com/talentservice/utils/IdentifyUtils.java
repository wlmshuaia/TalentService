package com.talentservice.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.domain.Project;

/**
 * 验证码工具类
 * @author Administrator
 *
 */
public class IdentifyUtils {
	
	public static StringBuffer verifyCode(int digit){
		
		StringBuffer code  = new StringBuffer() ;
		
		for(int i = 0; i < digit; i ++){
			code.append((int)(Math.random()*10)) ;
		}
		
		return code ;
	}
	
	//MD5加密
	public static String Md5(String plainText) { 
		String str = null;
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i; 
			StringBuffer buf = new StringBuffer(""); 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) i+= 256; 
				if(i<16) 
					buf.append("0"); 
				buf.append(Integer.toHexString(i)); 
			} 
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) { 
			e.printStackTrace(); 
		} 
		return str;
	} 
	
}
