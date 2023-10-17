package com.lumen.productinfo.response.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceLines {
	public String centralOffice;

	public String locationTimeZone;
    
	public ServiceAddress serviceAddress = new ServiceAddress();
    
	public boolean hasGPON;
    
	public String accessTech;
    
	public boolean hasVectoring;
    
    
	public boolean isNIC;
    
    
	public boolean isClickConverted;
    
    
	public boolean isSfsConverted;
    
    
	public boolean isPrivateCarriage;
    
	public String ihstFid;

    
	public boolean isVISP;
    
	public boolean hasProfile17a;
    
	public boolean hasInsideWireMaintenancePlan;
    
	public boolean hasSynacor;
    
	public boolean hasVoiceMail;
    
	public String serviceTnOrCktId;

	public List<CustomerProducts> customerProducts = new ArrayList<CustomerProducts>();

	public boolean isHasSynacor() {
		return hasSynacor;
	}

	public void setHasSynacor(boolean hasSynacor) {
		this.hasSynacor = hasSynacor;
	}

	public String getCentralOffice() {
		return centralOffice;
	}

	public void setCentralOffice(String centralOffice) {
		this.centralOffice = centralOffice;
	}

	public String getLocationTimeZone() {
		return locationTimeZone;
	}

	public void setLocationTimeZone(String locationTimeZone) {
		this.locationTimeZone = locationTimeZone;
	}

	public ServiceAddress getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(ServiceAddress serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public boolean isHasGPON() {
		return hasGPON;
	}

	public void setHasGPON(boolean hasGPON) {
		this.hasGPON = hasGPON;
	}

	public String getAccessTech() {
		return accessTech;
	}

	public void setAccessTech(String accessTech) {
		this.accessTech = accessTech;
	}

	public boolean isHasVectoring() {
		return hasVectoring;
	}

	public void setHasVectoring(boolean hasVectoring) {
		this.hasVectoring = hasVectoring;
	}

	@JsonProperty(value = "isNIC")
	public boolean isNIC() {
		return isNIC;
	}

	public void setNIC(boolean isNIC) {
		this.isNIC = isNIC;
	}

	@JsonProperty(value = "isClickConverted")
	public boolean isClickConverted() {
		return isClickConverted;
	}

	public void setClickConverted(boolean isClickConverted) {
		this.isClickConverted = isClickConverted;
	}

	@JsonProperty(value = "isPrivateCarriage")
	public boolean isPrivateCarriage() {
		return isPrivateCarriage;
	}

	public void setPrivateCarriage(boolean isPrivateCarriage) {
		this.isPrivateCarriage = isPrivateCarriage;
	}

	@JsonProperty(value = "isVISP")
	public boolean isVISP() {
		return isVISP;
	}

	public void setVISP(boolean isVISP) {
		this.isVISP = isVISP;
	}

	public boolean isHasProfile17a() {
		return hasProfile17a;
	}

	public void setHasProfile17a(boolean hasProfile17a) {
		this.hasProfile17a = hasProfile17a;
	}

	public boolean isHasInsideWireMaintenancePlan() {
		return hasInsideWireMaintenancePlan;
	}

	public void setHasInsideWireMaintenancePlan(boolean hasInsideWireMaintenancePlan) {
		this.hasInsideWireMaintenancePlan = hasInsideWireMaintenancePlan;
	}

	public List<CustomerProducts> getCustomerProducts() {
		return customerProducts;
	}

	public void setCustomerProducts(List<CustomerProducts> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public String getServiceTnOrCktId() {
		return serviceTnOrCktId;
	}

	public void setServiceTnOrCktId(String serviceTnOrCktId) {
		this.serviceTnOrCktId = serviceTnOrCktId;
	}

	public String getIhstFid() {
		return ihstFid;
	}

	public void setIhstFid(String ihstFid) {
		this.ihstFid = ihstFid;
	}

	public boolean isHasVoiceMail() {
		return hasVoiceMail;
	}

	public void setHasVoiceMail(boolean hasVoiceMail) {
		this.hasVoiceMail = hasVoiceMail;
	}
	
	@JsonProperty(value = "isSfsConverted")
    public boolean isSfsConverted() {
		return isSfsConverted;
	}

	public void setSfsConverted(boolean isSfsConverted) {
		this.isSfsConverted = isSfsConverted;
	}

}
