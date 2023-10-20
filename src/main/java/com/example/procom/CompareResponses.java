package com.example.procom;


import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.lumen.productinfo.response.model.AccountInformation;
import com.lumen.productinfo.response.model.CustomerAccountPrefInfo;
import com.lumen.productinfo.response.model.CustomerProducts;
import com.lumen.productinfo.response.model.Features;
import com.lumen.productinfo.response.model.RecordsChoice;
import com.lumen.productinfo.response.model.RxProductInfoResponse;
import com.lumen.productinfo.response.model.ServiceLines;

@Service
public class CompareResponses {

	public static void main(String[] args) {
		CompareResponses objCompareResponses = new CompareResponses();
		List<Map<String, Object>> oList = objCompareResponses.compareApi(List.of("3034661089", "3034691892",
				 "3034608491", "3034652184", "3034690381","3034662795", "9704742483", "3034654171", "3034661237",
				"3034660225" ));

		System.out.println(oList);
	
	}

	public  List<Map<String, Object>> compareApi(List<String> tnArray) {
		
		List<Map<String, Object>> list = new ArrayList<>();

		for (String tn : tnArray) {
			System.out.println("---------------------------------------------------");
			System.out.println("Called :: "+tn);	Map<String, Object> resultMap= null;
			try {
			RxProductInfoResponse existingApiResponse = callExistingApi(tn);
			RxProductInfoResponse newApiResponse = callNewApi(tn);
			try {
			resultMap= compareResponses(existingApiResponse, newApiResponse);
			}catch(Exception e) {
				resultMap = new HashMap<String, Object>();
				resultMap.put("difference", "Error while comparing");
			}
			}catch(Exception e) {
				resultMap = new HashMap<String, Object>();
				resultMap.put("difference", "Error while fetch");
			}
			resultMap.put("Tn", tn);
			list.add(resultMap);
			System.out.println(resultMap);
		}
		
		System.out.println("-*******************************************************************-");

		System.out.println(list);
		
		return list;
	}

	private  Map<String, Object> compareResponses(RxProductInfoResponse oldr,
			RxProductInfoResponse newr) {
		System.out.println("Called Compare API");

		Map<String, Object> map = new HashMap<>();
		
		List<String> a = new ArrayList<>();
		
	      //api response
	     if( oldr.apiResponse.code != null && oldr.apiResponse.code != newr.apiResponse.code)a.add("code is different");
	       if( oldr.apiResponse.type != null && !oldr.apiResponse.type.equals( newr.apiResponse.type)) a.add("type is different");
	       if( oldr.apiResponse.message != null && !oldr.apiResponse.message .equals( newr.apiResponse.message)) a.add("message is different");

	       if(oldr.apiResponse.type != null && !oldr.apiResponse.type.equals("Failure")){
	       
    	  //record choice
        if(oldr.recordsChoice != null &&oldr.recordsChoice.size() != newr.recordsChoice.size()) {
        	 a.add("length of recordChoice is different");
        }
        

      if(oldr.recordsChoice != null &&oldr.recordsChoice.size() == newr.recordsChoice.size()){
    	  
    	  oldr.recordsChoice.sort(new Comparator<RecordsChoice>() {
  			@Override
  			public int compare(RecordsChoice o1, RecordsChoice o2) {
  				if(o1.recordIdentifier != null ) {
  				return o1.recordIdentifier.compareTo(o2.recordIdentifier);}
  				else {
  					return o1.listedName.compareTo(o2.listedName);}
  				}
          });
          
          newr.recordsChoice.sort(new Comparator<RecordsChoice>() {
  			@Override
  			public int compare(RecordsChoice o1, RecordsChoice o2) {
  				if(o1.recordIdentifier != null ) {
  				return o1.recordIdentifier.compareTo(o2.recordIdentifier);}
  				else {
  					return o1.listedName.compareTo(o2.listedName);
  				}
  			}
          });
//    		 oldr.recordsChoice.sort(new Comparator<RecordsChoice>() {
//    	  			@Override
//    	  			public int compare(RecordsChoice o1, RecordsChoice o2) {
//    	  				return o1.recordIdentifier.compareTo(o2.listedName);
//    	  			}
//    	          });
//    	          
//    	          newr.recordsChoice.sort(new Comparator<RecordsChoice>() {
//    	  			@Override
//    	  			public int compare(RecordsChoice o1, RecordsChoice o2) {
//    	  				return o1.recordIdentifier.compareTo(o2.listedName);
//    	  			}
//    	          }); 
          
        for(int i =0; i<oldr.recordsChoice.size(); i++){
        if(oldr.recordsChoice.get(i).listedName!= null && !oldr.recordsChoice.get(i).listedName .equals( newr.recordsChoice.get(i).listedName) )a.add("listed name is different");
        if(oldr.recordsChoice.get(i).recordIdentifier  !=null && !oldr.recordsChoice.get(i).recordIdentifier .equals( newr.recordsChoice.get(i).recordIdentifier)) a.add("recordIdentifier  is different");
        if(oldr.recordsChoice.get(i).accountStatus   !=null && !oldr.recordsChoice.get(i).accountStatus .equals( newr.recordsChoice.get(i).accountStatus)) a.add("accountStatus is different");
        if(oldr.recordsChoice.get(i).address != null) {
        if(oldr.recordsChoice.get(i).address.streetAddress  !=null && !oldr.recordsChoice.get(i).address.streetAddress .equals( newr.recordsChoice.get(i).address.streetAddress)) a.add("streetAddress is different");
        if( oldr.recordsChoice.get(i).address.addressLine1 !=null && !oldr.recordsChoice.get(i).address.addressLine1 .equals( newr.recordsChoice.get(i).address.addressLine1) )a.add("addressLine1 is different");
        if( oldr.recordsChoice.get(i).address.addressLine2  !=null && !oldr.recordsChoice.get(i).address.addressLine2 .equals( newr.recordsChoice.get(i).address.addressLine2)) a.add("addressLine2 is different");
        if( oldr.recordsChoice.get(i).address.city !=null && !oldr.recordsChoice.get(i).address.city .equals( newr.recordsChoice.get(i).address.city)) a.add("city is different");
        if( oldr.recordsChoice.get(i).address.stateProvince  !=null && !oldr.recordsChoice.get(i).address.stateProvince .equals( newr.recordsChoice.get(i).address.stateProvince)) a.add("stateProvince is different");
        if( oldr.recordsChoice.get(i).address.countryCode  !=null && !oldr.recordsChoice.get(i).address.countryCode .equals( newr.recordsChoice.get(i).address.countryCode)) a.add("countryCode is different");
        if(oldr.recordsChoice.get(i).address.postalCode  !=null && !oldr.recordsChoice.get(i).address.postalCode .equals( newr.recordsChoice.get(i).address.postalCode)) a.add("postalCode is different");
        }}
      }

        

      //account
      if(oldr.accountInformation != null) {
       if(oldr.accountInformation.billingIdentifier!= null && !oldr.accountInformation.billingIdentifier .equals( newr.accountInformation.billingIdentifier)) a.add("billingIdentifier is different");
       if(oldr.accountInformation.baid != null &&!oldr.accountInformation.baid  .equals(  newr.accountInformation.baid)) a.add("baid is different");
       if(oldr.accountInformation.billingName != null && !oldr.accountInformation.billingName  .equals(  newr.accountInformation.billingName) )a.add("billingName is different");
       if(oldr.accountInformation.previousBillAmount!= null  && oldr.accountInformation.previousBillAmount.compareTo( newr.accountInformation.previousBillAmount) != 0) a.add("previousBillAmounts is different");
       if(oldr.accountInformation.customerType != null  &&!oldr.accountInformation.customerType  .equals(  newr.accountInformation.customerType)) a.add("customerType is different");
       if(oldr.accountInformation.customerSubType != null &&!oldr.accountInformation.customerSubType .equals( newr.accountInformation.customerSubType)) a.add("customerSubType is different");
       if( oldr.accountInformation.allServicesDeniedForNonPayment != newr.accountInformation.allServicesDeniedForNonPayment) a.add("allServicesDeniedForNonPayment is different");
       if(oldr.accountInformation.accountStatus != null &&!oldr.accountInformation.accountStatus  .equals(  newr.accountInformation.accountStatus)) a.add("accountStatus is different");
       if( oldr.accountInformation.isMilitaryAccount != newr.accountInformation.isMilitaryAccount) a.add("isMilitaryAccount is different");
       if(oldr.accountInformation.isVacationSuspend != newr.accountInformation.isVacationSuspend) a.add("isVacationSuspend is different");
       if(oldr.accountInformation.primaryClassOfServiceCode  != null &&  !oldr.accountInformation.primaryClassOfServiceCode  .equals(  newr.accountInformation.primaryClassOfServiceCode) )a.add("primaryClassOfServiceCode is different");
       if(oldr.accountInformation.classOfService != null  &&!oldr.accountInformation.classOfService  .equals(  newr.accountInformation.classOfService)) a.add("classOfService is different");
       if(oldr.accountInformation.last4SocialSecurityNumber!= null  &&!oldr.accountInformation.last4SocialSecurityNumber  .equals(  newr.accountInformation.last4SocialSecurityNumber)) a.add("last4SocialSecurityNumber is different");
       if(oldr.accountInformation.hasPrism != newr.accountInformation.hasPrism) a.add("hasPrism is different");
       if(oldr.accountInformation.isMadisonRiverCustomer != newr.accountInformation.isMadisonRiverCustomer) a.add("isMadisonRiverCustomer is different");
       if(oldr.accountInformation.marketUnit != null &&!oldr.accountInformation.marketUnit  .equals(  newr.accountInformation.marketUnit)) a.add("marketUnit is different");
//       if(oldr.accountInformation.customerDateTime != null && !oldr.accountInformation.customerDateTime .equals(  newr.accountInformation.customerDateTime) )a.add("customerDateTime is different");
       if(oldr.accountInformation.customerTimeGMTOffset != null &&!oldr.accountInformation.customerTimeGMTOffset  .equals(  newr.accountInformation.customerTimeGMTOffset)) a.add("customerTimeGMTOffset is different");
       if(oldr.accountInformation.customerTimeZoneAbbreviation!=null   &&!oldr.accountInformation.customerTimeZoneAbbreviation  .equals(  newr.accountInformation.customerTimeZoneAbbreviation)) a.add("customerTimeZoneAbbreviation is different");
       if(oldr.accountInformation.legacyDispatchTerritory !=null &&!oldr.accountInformation.legacyDispatchTerritory  .equals(  newr.accountInformation.legacyDispatchTerritory)) a.add("legacyDispatchTerritory is different");
       if(oldr.accountInformation.companyOwnerId != null &&!oldr.accountInformation.companyOwnerId  .equals(  newr.accountInformation.companyOwnerId)) a.add("companyOwnerId is different");
       if(oldr.accountInformation.billingSystem != null &&!oldr.accountInformation.billingSystem  .equals(  newr.accountInformation.billingSystem)) a.add("billingSystem is different");
       if(oldr.accountInformation.creditCardLastDigits !=null  &&!oldr.accountInformation.creditCardLastDigits  .equals(  newr.accountInformation.creditCardLastDigits) )a.add("creditCardLastDigits is different");
       if(oldr.accountInformation.verificationCode!=null  &&!oldr.accountInformation.verificationCode  .equals(  newr.accountInformation.verificationCode)) a.add("verificationCode is different");
		if (oldr.accountInformation.usocsOnAccount != null) {
			Collections.sort(oldr.accountInformation.usocsOnAccount);
			Collections.sort(newr.accountInformation.usocsOnAccount);
			if (oldr.accountInformation.usocsOnAccount.equals(newr.accountInformation.usocsOnAccount) == false)a.add("Usocs are different");
		}
       if(oldr.accountInformation.smsDigitalDialogPreferences.subscribedSmsNumber!= null&& !oldr.accountInformation.smsDigitalDialogPreferences.subscribedSmsNumber .equals( newr.accountInformation.smsDigitalDialogPreferences.subscribedSmsNumber)) a.add("subscribedSmsNumber is different");
       if(oldr.accountInformation.smsDigitalDialogPreferences.repairSubscription != newr.accountInformation.smsDigitalDialogPreferences.repairSubscription) a.add("repairSubscription is different");
       if(oldr.accountInformation.smsDigitalDialogPreferences.defaultContact != newr.accountInformation.smsDigitalDialogPreferences.defaultContact) a.add("defaultContact is different");
       if(oldr.accountInformation.smsDigitalDialogPreferences.invalidFlag != newr.accountInformation.smsDigitalDialogPreferences.invalidFlag) a.add("invalidFlag is different");
       if(oldr.accountInformation.smsDigitalDialogPreferences.billingSubscription != newr.accountInformation.smsDigitalDialogPreferences.billingSubscription) a.add("billingSubscription is different");
       if(oldr.accountInformation.smsDigitalDialogPreferences.orderSubscription != newr.accountInformation.smsDigitalDialogPreferences.orderSubscription) a.add("orderSubscription is different");
     
     
      if(oldr.accountInformation.emailDigitalDialogPreferences.subscribedEmail !=null&&  !oldr.accountInformation.emailDigitalDialogPreferences.subscribedEmail .equals( newr.accountInformation.emailDigitalDialogPreferences.subscribedEmail)) a.add("subscribedEmail is different");
      if(oldr.accountInformation.emailDigitalDialogPreferences.repairSubscription != newr.accountInformation.emailDigitalDialogPreferences.repairSubscription) a.add("repairSubscription is different");
      if(oldr.accountInformation.emailDigitalDialogPreferences.defaultContact != newr.accountInformation.emailDigitalDialogPreferences.defaultContact) a.add("defaultContact is different");
      if(oldr.accountInformation.emailDigitalDialogPreferences.marketingSubscription != newr.accountInformation.emailDigitalDialogPreferences.marketingSubscription) a.add("marketingSubscription is different");
      if(oldr.accountInformation.emailDigitalDialogPreferences.billingSubscription != newr.accountInformation.emailDigitalDialogPreferences.billingSubscription) a.add("billingSubscription is different");
      if(oldr.accountInformation.emailDigitalDialogPreferences.orderSubscription != newr.accountInformation.emailDigitalDialogPreferences.orderSubscription) a.add("orderSubscription is different");
     
      if(oldr.accountInformation.customerAccountPreferenceInfo != null 
    		  && oldr.accountInformation.customerAccountPreferenceInfo.size()
    		  == newr.accountInformation.customerAccountPreferenceInfo.size() ) {
    	  for(int  i =0; i<oldr.accountInformation.customerAccountPreferenceInfo.size() ; i++) {
    	
    		  if(oldr.accountInformation.customerAccountPreferenceInfo.get(i).contactNumber !=null &&!oldr.accountInformation.customerAccountPreferenceInfo.get(i).contactNumber.equals(newr.accountInformation.customerAccountPreferenceInfo.get(i).contactNumber)) a.add("ContactNumber is different");
    		  if(oldr.accountInformation.customerAccountPreferenceInfo.get(i).contactMode !=null &&!oldr.accountInformation.customerAccountPreferenceInfo.get(i).contactMode.equals(newr.accountInformation.customerAccountPreferenceInfo.get(i).contactMode)) a.add("contactMode is different");
    		  if(oldr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveFrom !=null &&!oldr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveFrom.equals(newr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveFrom)) a.add("effectiveFrom is different");
    		  if(oldr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveTo !=null &&!oldr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveTo.equals(newr.accountInformation.customerAccountPreferenceInfo.get(i).effectiveTo)) a.add("effectiveTo is different");
    	  }
      }
      
      if(oldr.accountInformation.authorizationDetails != null 
    		  && oldr.accountInformation.authorizationDetails.size()
    		  == newr.accountInformation.authorizationDetails.size() ) {
    	  for(int  i =0; i<oldr.accountInformation.authorizationDetails.size() ; i++) {
    	
    		  if(oldr.accountInformation.authorizationDetails.get(i).name != null &&!oldr.accountInformation.authorizationDetails.get(i).name.equals(newr.accountInformation.authorizationDetails.get(i).name)) a.add("name is different");
    		  if(oldr.accountInformation.authorizationDetails.get(i).tn != null &&!oldr.accountInformation.authorizationDetails.get(i).tn.equals(newr.accountInformation.authorizationDetails.get(i).tn)) a.add("tn is different");
    		  if(oldr.accountInformation.authorizationDetails.get(i).address != null &&!oldr.accountInformation.authorizationDetails.get(i).address.equals(newr.accountInformation.authorizationDetails.get(i).address)) a.add("address is different");
    		  if(oldr.accountInformation.authorizationDetails.get(i).email != null &&!oldr.accountInformation.authorizationDetails.get(i).email.equals(newr.accountInformation.authorizationDetails.get(i).email)) a.add("email is different");
    		  if(oldr.accountInformation.authorizationDetails.get(i).remark != null &&!oldr.accountInformation.authorizationDetails.get(i).remark.equals(newr.accountInformation.authorizationDetails.get(i).remark)) a.add("remark is different");
    	  
    		  if(oldr.accountInformation.authorizationDetails.get(i).authType != null ) {
        		  if(!oldr.accountInformation.authorizationDetails.get(i).authType.code.equals(newr.accountInformation.authorizationDetails.get(i).authType.code)) a.add("authType.code is different");
        		  if(!oldr.accountInformation.authorizationDetails.get(i).authType.description.equals(newr.accountInformation.authorizationDetails.get(i).authType.description)) a.add("authType.description is different");
    		  }
    	  }
      }}
      
      //service line check
      
      if(oldr.serviceLines != null && oldr.serviceLines.size() != newr.serviceLines.size()) a.add("serviceLines length is different");
      
      if(oldr.serviceLines != null && oldr.serviceLines.size() == newr.serviceLines.size()) {
	    	  oldr.serviceLines.sort(new Comparator<ServiceLines>() {
	    		  @Override
	    		  public int compare(ServiceLines s1, ServiceLines s2) {
	    			  return s1.serviceTnOrCktId.compareTo(s2.serviceTnOrCktId);
	    		  }  
			});
		    	  newr.serviceLines.sort(new Comparator<ServiceLines>() {
		    		  @Override
		    		  public int compare(ServiceLines s1, ServiceLines s2) {
		    			  return s1.serviceTnOrCktId.compareTo(s2.serviceTnOrCktId);
		    		  }
				});
    	for(int i=0; i<oldr.serviceLines.size(); i++) {
    		if(oldr.serviceLines.get(i).serviceTnOrCktId != null && !oldr.serviceLines.get(i).serviceTnOrCktId.equals(newr.serviceLines.get(i).serviceTnOrCktId))a.add("serviceTnOrCktId is different");
    		if(oldr.serviceLines.get(i).centralOffice!=null && !oldr.serviceLines.get(i).centralOffice.equals(newr.serviceLines.get(i).centralOffice))a.add("centralOffice is different");
    		if(oldr.serviceLines.get(i).locationTimeZone!= null && !oldr.serviceLines.get(i).locationTimeZone.equals(newr.serviceLines.get(i).locationTimeZone))a.add("locationTimeZone is different");
    		if(oldr.serviceLines.get(i).serviceAddress !=null) {
    			if(oldr.serviceLines.get(i).serviceAddress.streetAddress!=null && !oldr.serviceLines.get(i).serviceAddress.streetAddress.equals(newr.serviceLines.get(i).serviceAddress.streetAddress))a.add("streetAddress of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.addressLine1!=null && !oldr.serviceLines.get(i).serviceAddress.addressLine1.equals(newr.serviceLines.get(i).serviceAddress.addressLine1))a.add("addressLine1 of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.addressLine2!=null && !oldr.serviceLines.get(i).serviceAddress.addressLine2.equals(newr.serviceLines.get(i).serviceAddress.addressLine2))a.add("addressLine2 of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.city!=null && !oldr.serviceLines.get(i).serviceAddress.city.equals(newr.serviceLines.get(i).serviceAddress.city))a.add("city of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.stateProvince!=null && !oldr.serviceLines.get(i).serviceAddress.stateProvince.equals(newr.serviceLines.get(i).serviceAddress.stateProvince))a.add("stateProvince of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.postalCode!=null && !oldr.serviceLines.get(i).serviceAddress.postalCode.equals(newr.serviceLines.get(i).serviceAddress.postalCode))a.add("postalCode of serviceAddress is different");
    			if(oldr.serviceLines.get(i).serviceAddress.countryCode!=null && !oldr.serviceLines.get(i).serviceAddress.countryCode.equals(newr.serviceLines.get(i).serviceAddress.countryCode))a.add("countryCode of serviceAddress is different");
    		}
    		if(oldr.serviceLines.get(i).hasGPON != newr.serviceLines.get(i).hasGPON)a.add("hasGPON is different");
    		if(oldr.serviceLines.get(i).accessTech != null && !oldr.serviceLines.get(i).accessTech.equals(newr.serviceLines.get(i).accessTech))a.add("accessTech is different");
    		if(oldr.serviceLines.get(i).hasVectoring != newr.serviceLines.get(i).hasVectoring)a.add("hasVectoring is different");
    		if(oldr.serviceLines.get(i).isNIC != newr.serviceLines.get(i).isNIC)a.add("isNIC is different");
    		if(oldr.serviceLines.get(i).isClickConverted != newr.serviceLines.get(i).isClickConverted)a.add("isClickConverted is different");
    		if(oldr.serviceLines.get(i).isSfsConverted != newr.serviceLines.get(i).isSfsConverted)a.add("isSfsConverted is different");
    		if(oldr.serviceLines.get(i).isPrivateCarriage != newr.serviceLines.get(i).isPrivateCarriage)a.add("isPrivateCarriage is different");
    		if(oldr.serviceLines.get(i).ihstFid != newr.serviceLines.get(i).ihstFid)a.add("ihstFid is different");
    		if(oldr.serviceLines.get(i).isVISP != newr.serviceLines.get(i).isVISP)a.add("isVISP is different");
    		if(oldr.serviceLines.get(i).hasProfile17a != newr.serviceLines.get(i).hasProfile17a)a.add("hasProfile17a is different");
    		if(oldr.serviceLines.get(i).hasInsideWireMaintenancePlan != newr.serviceLines.get(i).hasInsideWireMaintenancePlan)a.add("hasInsideWireMaintenancePlan is different");
    		if(oldr.serviceLines.get(i).hasSynacor != newr.serviceLines.get(i).hasSynacor)a.add("hasSynacor is different");
    		if(oldr.serviceLines.get(i).customerProducts != null) {
    			oldr.serviceLines.get(i).customerProducts.sort(new Comparator<CustomerProducts>() {
  	    		  @Override
  	    		  public int compare(CustomerProducts c1, CustomerProducts c2) {
  	    			  return c1.highLevelProduct.compareTo(c2.highLevelProduct);
  	    		  }  
  			});
  	    	  newr.serviceLines.get(i).customerProducts.sort(new Comparator<CustomerProducts>() {
  	    		  @Override
  	    		  public int compare(CustomerProducts c1, CustomerProducts c2) {
  	    			  return c1.highLevelProduct.compareTo(c2.highLevelProduct);
  	    		  }
  			});
    			for(int k=0; k<oldr.serviceLines.get(i).customerProducts.size(); k++) {
//	    		if(oldr.serviceLines.get(i).customerProducts.get(k).customerProductIdentifier != null && oldr.serviceLines.get(i).customerProducts.get(i).customerProductIdentifier.equals( newr.serviceLines.get(i).customerProducts.get(i).customerProductIdentifier))a.add("customerProductIdentifier is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).usoc != null && !oldr.serviceLines.get(i).customerProducts.get(k).usoc.equals(  newr.serviceLines.get(i).customerProducts.get(k).usoc))a.add("usoc is different"); 		
	    		if (oldr.serviceLines.get(i).customerProducts.get(k).otherUsocs != null) {
	    			Collections.sort(oldr.serviceLines.get(i).customerProducts.get(k).otherUsocs);
	    			Collections.sort(newr.serviceLines.get(i).customerProducts.get(k).otherUsocs);
	    			if (oldr.serviceLines.get(i).customerProducts.get(k).otherUsocs.equals(newr.serviceLines.get(i).customerProducts.get(k).otherUsocs) == false)a.add("Usocs are different");
	    		}
	    		if(CollectionUtils.isEqualCollection(oldr.serviceLines.get(i).customerProducts.get(k).otherUsocs ,  newr.serviceLines.get(i).customerProducts.get(k).otherUsocs) ==  false) a.add("otherUsocs are different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).highLevelProduct != null && !oldr.serviceLines.get(i).customerProducts.get(k).highLevelProduct.equals(  newr.serviceLines.get(i).customerProducts.get(k).highLevelProduct))a.add("highLevelProduct is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).isActive != newr.serviceLines.get(i).customerProducts.get(k).isActive)a.add("isActive is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).activationDate != null && !oldr.serviceLines.get(i).customerProducts.get(k).activationDate.equals( newr.serviceLines.get(i).customerProducts.get(k).activationDate))a.add("activationDate is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).productStatus != null && !oldr.serviceLines.get(i).customerProducts.get(k).productStatus.equals( newr.serviceLines.get(i).customerProducts.get(k).productStatus))a.add("productStatus is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).hasAtEaseFeature != newr.serviceLines.get(i).customerProducts.get(k).hasAtEaseFeature)a.add("hasAtEaseFeature is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).purchasedSpeedDownKbps != null && !oldr.serviceLines.get(i).customerProducts.get(k).purchasedSpeedDownKbps.equals(newr.serviceLines.get(i).customerProducts.get(k).purchasedSpeedDownKbps))a.add("purchasedSpeedDownKbps is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).isVacationSuspend != newr.serviceLines.get(i).customerProducts.get(k).isVacationSuspend)a.add("isVacationSuspend is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).allServicesDeniedForNonPayment != newr.serviceLines.get(i).customerProducts.get(k).allServicesDeniedForNonPayment)a.add("allServicesDeniedForNonPayment is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).atEaseLevel != null && !oldr.serviceLines.get(i).customerProducts.get(k).atEaseLevel.equals(newr.serviceLines.get(i).customerProducts.get(k).atEaseLevel))a.add("atEaseLevel is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).hasTechInstallUSOC != null && !oldr.serviceLines.get(i).customerProducts.get(k).hasTechInstallUSOC.equals(newr.serviceLines.get(i).customerProducts.get(k).hasTechInstallUSOC))a.add("hasTechInstallUSOC is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).connectionType != null && !oldr.serviceLines.get(i).customerProducts.get(k).connectionType.equals(newr.serviceLines.get(i).customerProducts.get(k).connectionType))a.add("connectionType is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).isCentralizedBRAS != null && !oldr.serviceLines.get(i).customerProducts.get(k).isCentralizedBRAS.equals(newr.serviceLines.get(i).customerProducts.get(k).isCentralizedBRAS))a.add("isCentralizedBRAS is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).invariantId != null && !oldr.serviceLines.get(i).customerProducts.get(k).invariantId.equals(newr.serviceLines.get(i).customerProducts.get(k).invariantId))a.add("invariantId is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).isGIDRelevant != null && !oldr.serviceLines.get(i).customerProducts.get(k).isGIDRelevant.equals(newr.serviceLines.get(i).customerProducts.get(k).isGIDRelevant))a.add("isGIDRelevant is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).sourceOfOpenSessionInfo != null && !oldr.serviceLines.get(i).customerProducts.get(k).sourceOfOpenSessionInfo.equals(newr.serviceLines.get(i).customerProducts.get(k).sourceOfOpenSessionInfo))a.add("sourceOfOpenSessionInfo is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).modemOwnership != null && !oldr.serviceLines.get(i).customerProducts.get(k).modemOwnership.equals(newr.serviceLines.get(i).customerProducts.get(k).modemOwnership))a.add("modemOwnership is different");
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile !=null) {
	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.ossProfileName != null && !oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.ossProfileName.equals(newr.serviceLines.get(i).customerProducts.get(k).ossProfile.ossProfileName))a.add("ossProfileName is different");
	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.billingSource!= null && !oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.billingSource.equals(newr.serviceLines.get(i).customerProducts.get(k).ossProfile.billingSource))a.add("billingSource is different");
	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.inventorySource != null && !oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.inventorySource.equals(newr.serviceLines.get(i).customerProducts.get(k).ossProfile.inventorySource))a.add("inventorySource is different");
	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.ticketingSystem != null && !oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.ticketingSystem.equals(newr.serviceLines.get(i).customerProducts.get(k).ossProfile.ticketingSystem))a.add("ticketingSystem is different");
	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.dispatchSystem != null && !oldr.serviceLines.get(i).customerProducts.get(k).ossProfile.dispatchSystem.equals(newr.serviceLines.get(i).customerProducts.get(k).ossProfile.dispatchSystem))a.add("dispatchSystem is different");
	    		  }   
	    		
	    		if(oldr.serviceLines.get(i).customerProducts.get(k).features.size()==
	    				newr.serviceLines.get(i).customerProducts.get(k).features.size()){
//		    			if(oldr.serviceLines.get(i).customerProducts.get(k).features.size()>0 && oldr.serviceLines.get(i).customerProducts.get(k).features !=null ) {
			    		if( oldr.serviceLines.get(i).customerProducts.get(k).features !=null ) {
		    				oldr.serviceLines.get(i).customerProducts.get(k).features.sort(new Comparator<Features>() {
	    	  	    		  @Override
	    	  	    		  public int compare(Features f1, Features f2) {
	    	  	    			  if(f1.featureName != null) {
	    	  	    			  return f1.featureName.compareTo(f2.featureName);}
	    	  	    			  else {
	    	  	    				return f1.featureIndicator.compareTo(f2.featureIndicator);
	    	  	    			  }
	    	  	    		  }  
	    	  			});
		    	  	    	  newr.serviceLines.get(i).customerProducts.get(k).features.sort(new Comparator<Features>() {
		    	  	    		  @Override
		    	  	    		  public int compare(Features f1, Features f2) {
		    	  	    			if(f1.featureName != null) {
		    	  	    			  return f1.featureName.compareTo(f2.featureName);}
		    	  	    			else {
		    	  	    				return f1.featureIndicator.compareTo(f2.featureIndicator);
		    	  	    			  }
		    	  	    		  }
		    	  			});
		    			for(int j =0; j<oldr.serviceLines.get(i).customerProducts.get(k).features.size() ; j++) {	 
		    	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureName != null && !oldr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureName.equals(newr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureName))a.add("featureName is different");
		    	    			  if(oldr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureIndicator != null && !oldr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureIndicator.equals(newr.serviceLines.get(i).customerProducts.get(k).features.get(j).featureIndicator))a.add("featureIndicator is different");
	    	    		  
	    			}}
	    			
	    		}}
    	}  
    	}  
    }  
	}
    	map.put("difference", a);
    	map.put("rxSessionOld", oldr.rxSessionIdentifier);
    	map.put("rxSessionNew", newr.rxSessionIdentifier);
    	map.put("oldRes", (new Gson().toJson(oldr)));
    	map.put("newRes",  (new Gson().toJson(newr)));
    	
    	return map;
		
	}

	private  RxProductInfoResponse callExistingApi(String tn) {
		String encoding = Base64.getEncoder().encodeToString(("rxdsl" + ":" + "Cntl#2017").getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://rxmicro-test2.kubeodc-test.corp.intranet/rxmicro/services/rxProductInfo?etn=" + tn;
		ResponseEntity<RxProductInfoResponse> response = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), RxProductInfoResponse.class);
		System.out.println("Called Old APi");
		return response.getBody();
	}

	private  RxProductInfoResponse callNewApi(String tn) {
		String encoding = Base64.getEncoder().encodeToString(("rxdsl" + ":" + "Cntl#2017").getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://rxmicro-test1.kubeodc-test.corp.intranet/rxmicro/services/rxProductInfo?etn=" + tn;
		String url = "http://localhost:8084/rxProductInfo?etn="+tn;
		ResponseEntity<RxProductInfoResponse> response = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), RxProductInfoResponse.class);
		System.out.println("Called New APi");
		return response.getBody();
	}

}