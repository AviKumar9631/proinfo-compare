package com.lumen.productinfo.response.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"success", "deleted"})
public class CustomerProducts {
	public String customerProductIdentifier;
	public OssProfile ossProfile = new OssProfile();
    
	public String usoc;
    
	public List otherUsocs;
    
	public String highLevelProduct;
    
    
	public boolean isActive;
    
	public String activationDate;
    
	public String productStatus;
    
    
	public boolean hasAtEaseFeature;
    
	public String purchasedSpeedDownKbps;
    
	public String purchasedSpeedUpKbps;
    
    
	public boolean isVacationSuspend;
    
    
	public boolean allServicesDeniedForNonPayment;

	public String atEaseLevel;

	public String hasTechInstallUSOC;
    
	public String connectionType;
    
	public String isCentralizedBRAS;
    
	public String invariantId;
    
	public String isGIDRelevant;
    
	public String sourceOfOpenSessionInfo;
    
	public String modemOwnership;
    
    
	public List<Features> features = new ArrayList<Features>();
   

	public String getCustomerProductIdentifier() {
		return customerProductIdentifier;
	}

	public void setCustomerProductIdentifier(String customerProductIdentifier) {
		this.customerProductIdentifier = customerProductIdentifier;
	}

	public OssProfile getOssProfile() {
		return ossProfile;
	}

	public void setOssProfile(OssProfile ossProfile) {
		this.ossProfile = ossProfile;
	}

	public String getUsoc() {
		return usoc;
	}

	public void setUsoc(String usoc) {
		this.usoc = usoc;
	}

	public List getOtherUsocs() {
		return otherUsocs;
	}

	public void setOtherUsocs(List otherUsocs) {
		this.otherUsocs = otherUsocs;
	}

	public String getHighLevelProduct() {
		return highLevelProduct;
	}

	public void setHighLevelProduct(String highLevelProduct) {
		this.highLevelProduct = highLevelProduct;
	}

	@JsonProperty(value = "isActive")
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@JsonProperty(value = "isVacationSuspend")
	public boolean isVacationSuspend() {
		return isVacationSuspend;
	}

	public void setVacationSuspend(boolean isVacationSuspend) {
		this.isVacationSuspend = isVacationSuspend;
	}
	
	@JsonProperty(value = "allServicesDeniedForNonPayment")
	public boolean isAllServicesDeniedForNonPayment() {
		return allServicesDeniedForNonPayment;
	}

	public void setAllServicesDeniedForNonPayment(boolean allServicesDeniedForNonPayment) {
		this.allServicesDeniedForNonPayment = allServicesDeniedForNonPayment;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	@JsonProperty(value = "hasAtEaseFeature")
	public boolean isHasAtEaseFeature() {
		return hasAtEaseFeature;
	}

	public void setHasAtEaseFeature(boolean hasAtEaseFeature) {
		this.hasAtEaseFeature = hasAtEaseFeature;
	}

	public String getPurchasedSpeedDownKbps() {
		return purchasedSpeedDownKbps;
	}

	public void setPurchasedSpeedDownKbps(String purchasedSpeedDownKbps) {
		this.purchasedSpeedDownKbps = purchasedSpeedDownKbps;
	}

	public String getPurchasedSpeedUpKbps() {
		return purchasedSpeedUpKbps;
	}

	public void setPurchasedSpeedUpKbps(String purchasedSpeedUpKbps) {
		this.purchasedSpeedUpKbps = purchasedSpeedUpKbps;
	}

	public String getAtEaseLevel() {
		return atEaseLevel;
	}

	public void setAtEaseLevel(String atEaseLevel) {
		this.atEaseLevel = atEaseLevel;
	}

	public String getHasTechInstallUSOC() {
		return hasTechInstallUSOC;
	}

	public void setHasTechInstallUSOC(String hasTechInstallUSOC) {
		this.hasTechInstallUSOC = hasTechInstallUSOC;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getIsCentralizedBRAS() {
		return isCentralizedBRAS;
	}

	public void setIsCentralizedBRAS(String isCentralizedBRAS) {
		this.isCentralizedBRAS = isCentralizedBRAS;
	}

	public String getInvariantId() {
		return invariantId;
	}

	public void setInvariantId(String invariantId) {
		this.invariantId = invariantId;
	}

	public String getIsGIDRelevant() {
		return isGIDRelevant;
	}

	public void setIsGIDRelevant(String isGIDRelevant) {
		this.isGIDRelevant = isGIDRelevant;
	}

	public String getSourceOfOpenSessionInfo() {
		return sourceOfOpenSessionInfo;
	}

	public void setSourceOfOpenSessionInfo(String sourceOfOpenSessionInfo) {
		this.sourceOfOpenSessionInfo = sourceOfOpenSessionInfo;
	}
	
	 public List<Features> getFeatures() {
			return features;
		}

		public void setFeatures(List<Features> features) {
			this.features = features;
		}

		public String getModemOwnership() {
			return modemOwnership;
		}

		public void setModemOwnership(String modemOwnership) {
			this.modemOwnership = modemOwnership;
		}

}
