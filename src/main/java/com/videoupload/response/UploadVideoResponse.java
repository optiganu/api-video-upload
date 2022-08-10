package com.videoupload.response;

import org.springframework.stereotype.Component;

@Component
public class UploadVideoResponse {
	private String Message;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
