package com.lumen.productinfo.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsDigitalDialogPreferences {

	public String subscribedSmsNumber;
	public boolean repairSubscription;
	public boolean defaultContact;
	public boolean invalidFlag;
	public boolean billingSubscription;
	public boolean orderSubscription;
	
	public String getSubscribedSmsNumber() {
		return subscribedSmsNumber;
	}
	
	public void setSubscribedSmsNumber(String subscribedSmsNumber) {
		this.subscribedSmsNumber = subscribedSmsNumber;
	}
	
	public boolean isRepairSubscription() {
		return repairSubscription;
	}
	
	public void setRepairSubscription(boolean repairSubscription) {
		this.repairSubscription = repairSubscription;
	}
	
	public boolean isDefaultContact() {
		return defaultContact;
	}
	
	public void setDefaultContact(boolean defaultContact) {
		this.defaultContact = defaultContact;
	}
	
	public boolean isInvalidFlag() {
		return invalidFlag;
	}
	
	public void setInvalidFlag(boolean invalidFlag) {
		this.invalidFlag = invalidFlag;
	}
	
	public boolean isBillingSubscription() {
		return billingSubscription;
	}
	
	public void setBillingSubscription(boolean billingSubscription) {
		this.billingSubscription = billingSubscription;
	}
	
	public boolean isOrderSubscription() {
		return orderSubscription;
	}
	
	public void setOrderSubscription(boolean orderSubscription) {
		this.orderSubscription = orderSubscription;
	}
	
}
