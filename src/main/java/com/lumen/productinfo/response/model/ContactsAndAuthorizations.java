package com.lumen.productinfo.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsAndAuthorizations {	

	 public String name;
	 public String tn;
	 public String address;
	 public AuthType authType;
	 public String email;
	 public String remark;
	 
	public ContactsAndAuthorizations() {
	 
	 }
	
	 
	public ContactsAndAuthorizations(String name, String tn, String address,
			AuthType authType, String email, String remark) {
		super();
		this.name = name;
		this.tn = tn;
		this.address = address;
		this.authType = authType;
		this.email = email;
		this.remark = remark;
	}
	
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getTn() {
		return tn;
	}
	public void setTn(java.lang.String tn) {
		this.tn = tn;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public AuthType getAuthType() {
		return authType;
	}
	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	 
}
