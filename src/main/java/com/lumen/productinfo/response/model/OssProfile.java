package com.lumen.productinfo.response.model;

public class OssProfile {

	private String ossProfileName;
	private String billingSource;
	private String inventorySource;
	private String ticketingSystem;
	private String dispatchSystem;
	
	public String getOssProfileName() {
		return ossProfileName;
	}
	
	public void setOssProfileName(String ossProfileName) {
		this.ossProfileName = ossProfileName;
	}
	
	public String getBillingSource() {
		return billingSource;
	}
	
	public void setBillingSource(String billingSource) {
		this.billingSource = billingSource;
	}
	
	public String getInventorySource() {
		return inventorySource;
	}
	
	public void setInventorySource(String inventorySource) {
		this.inventorySource = inventorySource;
	}
	
	public String getTicketingSystem() {
		return ticketingSystem;
	}
	
	public void setTicketingSystem(String ticketingSystem) {
		this.ticketingSystem = ticketingSystem;
	}
	
	public String getDispatchSystem() {
		return dispatchSystem;
	}
	
	public void setDispatchSystem(String dispatchSystem) {
		this.dispatchSystem = dispatchSystem;
	}
	
}
