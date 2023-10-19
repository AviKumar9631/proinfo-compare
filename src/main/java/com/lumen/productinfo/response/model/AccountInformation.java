package com.lumen.productinfo.response.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInformation {
	
	public String billingIdentifier;
	
	public String baid;
	
	public String billingName;
	
	public BillingAddress billingAddress = new BillingAddress();
	
	public BigDecimal previousBillAmount;
	
	public String customerType;
	
	public String customerSubType;
	
	public boolean allServicesDeniedForNonPayment;
	
	public String accountStatus;
	
	
	public boolean isMilitaryAccount;
	
	 
	public boolean isVacationSuspend;
	
	public String primaryClassOfServiceCode;
	
	public String classOfService;
	
	public List usocsOnAccount;

	public String last4SocialSecurityNumber;
	
	public boolean hasPrism;
	
	 
	public boolean isMadisonRiverCustomer;
    
	public String marketUnit;
	
	public String customerDateTime;
	
	public String customerTimeGMTOffset;
	
	public String customerTimeZoneAbbreviation;

	public String legacyDispatchTerritory;

	public String companyOwnerId;

	public String billingSystem;
	public String verificationCode;
	public String creditCardLastDigits;
	public SmsDigitalDialogPreferences smsDigitalDialogPreferences = new SmsDigitalDialogPreferences();
    
	public EmailDigitalDialogPreferences emailDigitalDialogPreferences = new EmailDigitalDialogPreferences();
    
	public List<ContactsAndAuthorizations> authorizationDetails;
    
	public List<CustomerAccountPrefInfo> customerAccountPreferenceInfo;

    public String getBillingIdentifier() {
		return billingIdentifier;
	}

	public void setBillingIdentifier(String billingIdentifier) {
		this.billingIdentifier = billingIdentifier;
	}

	public String getBaid() {
		return baid;
	}

	public void setBaid(String baid) {
		this.baid = baid;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerSubType() {
		return customerSubType;
	}

	public void setCustomerSubType(String customerSubType) {
		this.customerSubType = customerSubType;
	}

	public boolean isAllServicesDeniedForNonPayment() {
		return allServicesDeniedForNonPayment;
	}

	public void setAllServicesDeniedForNonPayment(boolean allServicesDeniedForNonPayment) {
		this.allServicesDeniedForNonPayment = allServicesDeniedForNonPayment;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getPrimaryClassOfServiceCode() {
		return primaryClassOfServiceCode;
	}

	public void setPrimaryClassOfServiceCode(String primaryClassOfServiceCode) {
		this.primaryClassOfServiceCode = primaryClassOfServiceCode;
	}

	public String getClassOfService() {
		return classOfService;
	}

	public void setClassOfService(String classOfService) {
		this.classOfService = classOfService;
	}

	public List getUsocsOnAccount() {
		return usocsOnAccount;
	}

	public void setUsocsOnAccount(List usocsOnAccount) {
		this.usocsOnAccount = usocsOnAccount;
	}

	public String getLast4SocialSecurityNumber() {
		return last4SocialSecurityNumber;
	}

	public void setLast4SocialSecurityNumber(String last4SocialSecurityNumber) {
		this.last4SocialSecurityNumber = last4SocialSecurityNumber;
	}

	public boolean isHasPrism() {
		return hasPrism;
	}

	public void setHasPrism(boolean hasPrism) {
		this.hasPrism = hasPrism;
	}

	@JsonProperty(value = "isMadisonRiverCustomer")
	public boolean isMadisonRiverCustomer() {
		return isMadisonRiverCustomer;
	}

	public void setMadisonRiverCustomer(boolean isMadisonRiverCustomer) {
		this.isMadisonRiverCustomer = isMadisonRiverCustomer;
	}
	
	@JsonProperty(value = "isVacationSuspend")
	public boolean isVacationSuspend() {
		return isVacationSuspend;
	}

	public void setVacationSuspend(boolean isVacationSuspend) {
		this.isVacationSuspend = isVacationSuspend;
	}

	public String getMarketUnit() {
		return marketUnit;
	}

	public void setMarketUnit(String marketUnit) {
		this.marketUnit = marketUnit;
	}

	public String getCustomerDateTime() {
		return customerDateTime;
	}

	public void setCustomerDateTime(String customerDateTime) {
		this.customerDateTime = customerDateTime;
	}

	public String getCustomerTimeGMTOffset() {
		return customerTimeGMTOffset;
	}

	public void setCustomerTimeGMTOffset(String customerTimeGMTOffset) {
		this.customerTimeGMTOffset = customerTimeGMTOffset;
	}

	public String getCustomerTimeZoneAbbreviation() {
		return customerTimeZoneAbbreviation;
	}

	public void setCustomerTimeZoneAbbreviation(String customerTimeZoneAbbreviation) {
		this.customerTimeZoneAbbreviation = customerTimeZoneAbbreviation;
	}

	public String getLegacyDispatchTerritory() {
		return legacyDispatchTerritory;
	}

	public void setLegacyDispatchTerritory(String legacyDispatchTerritory) {
		this.legacyDispatchTerritory = legacyDispatchTerritory;
	}

	public String getBillingSystem() {
		return billingSystem;
	}

	public void setBillingSystem(String billingSystem) {
		this.billingSystem = billingSystem;
	}

	public SmsDigitalDialogPreferences getSmsDigitalDialogPreferences() {
		return smsDigitalDialogPreferences;
	}

	public void setSmsDigitalDialogPreferences(SmsDigitalDialogPreferences smsDigitalDialogPreferences) {
		this.smsDigitalDialogPreferences = smsDigitalDialogPreferences;
	}

	public EmailDigitalDialogPreferences getEmailDigitalDialogPreferences() {
		return emailDigitalDialogPreferences;
	}

	public void setEmailDigitalDialogPreferences(EmailDigitalDialogPreferences emailDigitalDialogPreferences) {
		this.emailDigitalDialogPreferences = emailDigitalDialogPreferences;
	}
  public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	 @JsonProperty(value = "isMilitaryAccount")
	public boolean isMilitaryAccount() {
		return isMilitaryAccount;
	}

	public void setMilitaryAccount(boolean isMilitaryAccount) {
		this.isMilitaryAccount = isMilitaryAccount;
	}

	public List<ContactsAndAuthorizations> getAuthorizationDetails() {
		return authorizationDetails;
	}

	public void setAuthorizationDetails(List<ContactsAndAuthorizations> authorizationDetails) {
		this.authorizationDetails = authorizationDetails;
	}
	
	public List<CustomerAccountPrefInfo> getCustomerAccountPreferenceInfo() {
		return customerAccountPreferenceInfo;
	}

	public void setCustomerAccountPreferenceInfo(
			List<CustomerAccountPrefInfo> customerAccountPreferenceInfo) {
		this.customerAccountPreferenceInfo = customerAccountPreferenceInfo;
	}

	public BigDecimal getPreviousBillAmount() {
		return previousBillAmount;
	}

	public void setPreviousBillAmount(BigDecimal previousBillAmount) {
		this.previousBillAmount = previousBillAmount;
	}
	
	public String getCompanyOwnerId() {
		return companyOwnerId;
	}

	public void setCompanyOwnerId(String companyOwnerId) {
		this.companyOwnerId = companyOwnerId;
	}
	
	public String getCreditCardLastDigits() {
		return creditCardLastDigits;
	}

	public void setCreditCardLastDigits(String creditCardLastDigits) {
		this.creditCardLastDigits = creditCardLastDigits;
	}


	
}
