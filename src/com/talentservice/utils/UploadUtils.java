package com.talentservice.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class UploadUtils {
	
	/**
	 * 将文件保存到 /WEB-INF/upload 文件夹下
	 * @param upload
	 * @return
	 */
	public static String saveUploadFile(File upload){
		//把日期格式化成字符串的一个帮助类 
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		/*
		 * 得到upload文件夹的绝对路径
		 * ServletActionContext.getServletContext()
		 * =
		 * C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\itcastoa823\WEB-INF/upload/2012\02\16\aaaaadfasdf
		 */
		String basePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//把日期类型格式化为"/yyyy/MM/dd/"这种形式的字符串
		String subPath = sdf.format(new Date());
		//如果文件夹不存在，就创建文件夹
		File dir = new File(basePath+subPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		//String path = basePath+"/"+this.uploadFileName;
		//UUID.randomUUID().toString()能够保证名字的唯一性
		String path = basePath+subPath+UUID.randomUUID().toString();
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		return path;
	}
	
	/**
	 * 获取文件
	 * 
	 * @return
	 */
	public static void getUploadFile(String url) {
	
	}
	
	/**
	 * 删除单个文件
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		boolean flag = false ;
		File file = new File(filePath) ;
		if(file.isFile() && file.exists()){
			flag = file.delete() ;
		}
		return flag ;
	}
	
	/**
	 * 删除指定文件夹及该文件夹下所有文件
	 * @param folderPath
	 * @return
	 */
	public static boolean deleteFolder(String folderPath) {
		// 不以文件分隔符结尾则加上文件分隔符
		if (!folderPath.endsWith(File.separator)) {  
			folderPath = folderPath + File.separator;  
	    }  
		
		File dirFolder = new File(folderPath) ;
		// 指定文件夹不存在，或者不是一个目录
		if(!dirFolder.exists() || !dirFolder.isDirectory()){
			return false ;
		}
		
		File[] dirFiles = dirFolder.listFiles() ;
		boolean flag = true ;
		for(File f : dirFiles){
			if(f.isFile()){	// 子文件是文件，则删除文件
				flag = deleteFile(f.getAbsolutePath()) ;
				if(!flag) break ;
			}else{	// 子文件是文件夹，则递归删除文件夹
				flag = deleteFolder(f.getAbsolutePath()) ;
				if(!flag) break ;
			}
		}
		
		if(!flag) return false ;
		
		// 删除空文件夹
		if(dirFolder.delete()){
			return true ;
		}else{
			return false ;
		}
	}
	
}
