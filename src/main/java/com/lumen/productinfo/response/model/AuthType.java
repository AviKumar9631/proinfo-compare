package com.lumen.productinfo.response.model;

public class AuthType {
	
	 public String code;
	 
	 public String description;
	 
	 public AuthType() {
	    }

	 public AuthType(
	           java.lang.String code,
	           java.lang.String description) {
	           this.code = code;
	           this.description = description;
	    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
