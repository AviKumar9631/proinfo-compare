package com.lumen.productinfo.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordsChoice {
	
	public String listedName;
	
	public Address address;
	
	public String recordIdentifier;

	public String accountStatus;

    public String getListedName() {
		return listedName;
	}

	public void setListedName(String listedName) {
		this.listedName = listedName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRecordIdentifier() {
		return recordIdentifier;
	}

	public void setRecordIdentifier(String recordIdentifier) {
		this.recordIdentifier = recordIdentifier;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
