package com.videoupload.service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	@Value("${value.serverPath.fileUpload}")
	String fileUploadPath;
	
	private String generateFileName(String fileType) throws Exception {		
		 StringBuilder fileName = new StringBuilder();
		 Random random = new Random();		 
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
         fileName.append("video_"+dateFormat.format(date)+random.nextInt(1000-0) + 0+"."+fileType);  
         return fileName.toString();		
	}
	
	public void handleFileUpload(MultipartFile file) throws Exception{		
		String fileName = file.getOriginalFilename();		
		//String[] fileType = file.getContentType().toString().split("/");		
		file.transferTo( new File(fileUploadPath + fileName));	
	}
}
