package com.lumen.productinfo.response.model;

public class MessageResponse {

	private String responseStatus;
	private String message;
	private String reasonCode;
	
	public String getResponseStatus() {
		return responseStatus;
	}
	
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getReasonCode() {
		return reasonCode;
	}
	
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	
}
