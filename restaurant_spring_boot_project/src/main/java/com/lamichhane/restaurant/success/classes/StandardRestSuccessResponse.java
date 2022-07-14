package com.lamichhane.restaurant.success.classes;



public class StandardRestSuccessResponse {

	private String status;
	private String message;
	private long timeStamp;
	
	public StandardRestSuccessResponse() {
		
	}

	public StandardRestSuccessResponse(String status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}







