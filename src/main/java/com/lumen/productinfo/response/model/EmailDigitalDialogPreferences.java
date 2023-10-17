package com.lumen.productinfo.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDigitalDialogPreferences {

	public String subscribedEmail;
	public boolean repairSubscription;
	public boolean defaultContact;
	public boolean marketingSubscription;
	public boolean billingSubscription;
	public boolean orderSubscription;
	
	public String getSubscribedEmail() {
		return subscribedEmail;
	}
	
	public void setSubscribedEmail(String subscribedEmail) {
		this.subscribedEmail = subscribedEmail;
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
	
	public boolean isMarketingSubscription() {
		return marketingSubscription;
	}
	
	public void setMarketingSubscription(boolean marketingSubscription) {
		this.marketingSubscription = marketingSubscription;
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
