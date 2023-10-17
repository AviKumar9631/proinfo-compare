package com.lumen.productinfo.response.model;


public class OssProfileModel {
	
	private String product;
	private String territory;
	private String billingSource;
	private String clickConverted;
	private String isNic;
	private String ossProfileName;
	private String inventorySource;
	private String ticketingSystem;
	private String dispatchSystem;
	
	
	public String getOssProfileName() {
		return ossProfileName;
	}
	
	public void setOssProfileName(String ossProfileName) {
		System.out.println("OssProfileModel:: ossProfileName="+ossProfileName);
		this.ossProfileName = ossProfileName;
	}
	
	public String getBillingSource() {
		return billingSource;
	}
	
	public void setBillingSource(String billingSource) {
		System.out.println("OssProfileModel:: billingSource="+billingSource);
		this.billingSource = billingSource;
	}
	
	public String getInventorySource() {
		return inventorySource;
	}
	
	public void setInventorySource(String inventorySource) {
		System.out.println("OssProfileModel:: inventorySource="+inventorySource);
		this.inventorySource = inventorySource;
	}
	
	public String getTicketingSystem() {
		return ticketingSystem;
	}
	
	public void setTicketingSystem(String ticketingSystem) {
		System.out.println("OssProfileModel:: ticketingSystem="+ticketingSystem);
		this.ticketingSystem = ticketingSystem;
	}
	
	public String getDispatchSystem() {
		return dispatchSystem;
	}
	
	public void setDispatchSystem(String dispatchSystem) {
		System.out.println("OssProfileModel:: dispatchSystem="+dispatchSystem);
		this.dispatchSystem = dispatchSystem;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		System.out.println("OssProfileModel:: product="+product);
		this.product = product;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		System.out.println("OssProfileModel:: territory="+territory);
		this.territory = territory;
	}

	public String getClickConverted() {
		return clickConverted;
	}

	public void setClickConverted(String clickConverted) {
		System.out.println("OssProfileModel:: clickConverted="+clickConverted);
		this.clickConverted = clickConverted;
	}

	public String getIsNic() {
		return isNic;
	}

	public void setIsNic(String isNic) {
		System.out.println("OssProfileModel:: isNic="+isNic);
		this.isNic = isNic;
	}
	
}
