package com.videoupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.videoupload.response.UploadVideoResponse;
import com.videoupload.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadService service;
	
	@PostMapping("uploadvideo")
	public ResponseEntity<Object> upload(@RequestParam MultipartFile file) {
		UploadVideoResponse response = new UploadVideoResponse();
		try {	
			if(!file.isEmpty()) {
				service.handleFileUpload(file);		
				response.setMessage("File Uploaded Successfully");
				return new ResponseEntity<Object>(response,HttpStatus.OK);	
			}
			response.setMessage("File is Not Available");
			return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);				
		}catch(Exception ex) {
			response.setMessage(ex.getMessage());
			return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
	}
}
