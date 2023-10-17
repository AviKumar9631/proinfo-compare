package com.lumen.productinfo.response.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RxProductInfoResponse {
    public List<RecordsChoice> recordsChoice;
    
    public String rxSessionIdentifier;

    public AccountInformation accountInformation ;

    public List<ServiceLines> serviceLines;
    
    public ApiResponse apiResponse=new ApiResponse();

    public List<RecordsChoice> getRecordsChoice() {
		return recordsChoice;
	}

	public void setRecordsChoice(List<RecordsChoice> recordsChoice) {
		this.recordsChoice = recordsChoice;
	}
	
	public String getRxSessionIdentifier() {
		return rxSessionIdentifier;
	}

	public void setRxSessionIdentifier(String rxSessionIdentifier) {
		this.rxSessionIdentifier = rxSessionIdentifier;
	}

	public AccountInformation getAccountInformation ()
    {
        return accountInformation;
    }

    public void setAccountInformation (AccountInformation accountInformation)
    {
        this.accountInformation = accountInformation;
    }

	public List<ServiceLines> getServiceLines() {
		return serviceLines;
	}

	public void setServiceLines(List<ServiceLines> serviceLines) {
		this.serviceLines = serviceLines;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

}
