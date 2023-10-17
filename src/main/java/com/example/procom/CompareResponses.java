package com.example.procom;


import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lumen.productinfo.response.model.CustomerAccountPrefInfo;
import com.lumen.productinfo.response.model.RecordsChoice;
import com.lumen.productinfo.response.model.RxProductInfoResponse;

public class CompareResponses {

	public static void main(String[] args) {
		compareApi();
	}

	public static void compareApi() {
		String[] tnArray = { "6363988017", "6363988018", "6363988019" };

		for (String tn : tnArray) {
			System.out.println("---------------------------------------------------");
			System.out.println("Called :: "+tn);
			RxProductInfoResponse existingApiResponse = callExistingApi(tn);
			RxProductInfoResponse newApiResponse = callNewApi(tn);

			Map<String, Object> resultMap= compareResponses(existingApiResponse, newApiResponse);
			System.out.println(resultMap);
		}
	}

	private static Map<String, Object> compareResponses(RxProductInfoResponse oldr,
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
  				return o1.recordIdentifier.compareTo(o2.recordIdentifier);
  			}
          });
          
          newr.recordsChoice.sort(new Comparator<RecordsChoice>() {
  			@Override
  			public int compare(RecordsChoice o1, RecordsChoice o2) {
  				return o1.recordIdentifier.compareTo(o2.recordIdentifier);
  			}
          });
          
        for(int i =0; i<oldr.recordsChoice.size(); i++){
        if(oldr.recordsChoice.get(i).listedName!= null && !oldr.recordsChoice.get(i).listedName .equals( newr.recordsChoice.get(i).listedName) )a.add("listed name is different");
        if(oldr.recordsChoice.get(i).recordIdentifier  !=null && !oldr.recordsChoice.get(i).recordIdentifier .equals( newr.recordsChoice.get(i).recordIdentifier)) a.add("recordIdentifier  is different");
        if(oldr.recordsChoice.get(i).accountStatus   !=null && !oldr.recordsChoice.get(i).accountStatus .equals( newr.recordsChoice.get(i).accountStatus)) a.add("accountStatus is different");
        if(oldr.recordsChoice.get(i).address.streetAddress  !=null && !oldr.recordsChoice.get(i).address.streetAddress .equals( newr.recordsChoice.get(i).address.streetAddress)) a.add("streetAddress is different");
        if( oldr.recordsChoice.get(i).address.addressLine1 !=null && !oldr.recordsChoice.get(i).address.addressLine1 .equals( newr.recordsChoice.get(i).address.addressLine1) )a.add("addressLine1 is different");
        if( oldr.recordsChoice.get(i).address.addressLine2  !=null && !oldr.recordsChoice.get(i).address.addressLine2 .equals( newr.recordsChoice.get(i).address.addressLine2)) a.add("addressLine2 is different");
        if( oldr.recordsChoice.get(i).address.city !=null && !oldr.recordsChoice.get(i).address.city .equals( newr.recordsChoice.get(i).address.city)) a.add("city is different");
        if( oldr.recordsChoice.get(i).address.stateProvince  !=null && !oldr.recordsChoice.get(i).address.stateProvince .equals( newr.recordsChoice.get(i).address.stateProvince)) a.add("stateProvince is different");
        if( oldr.recordsChoice.get(i).address.countryCode  !=null && !oldr.recordsChoice.get(i).address.countryCode .equals( newr.recordsChoice.get(i).address.countryCode)) a.add("countryCode is different");
        if(oldr.recordsChoice.get(i).address.postalCode  !=null && !oldr.recordsChoice.get(i).address.postalCode .equals( newr.recordsChoice.get(i).address.postalCode)) a.add("postalCode is different");
        }
      }

        

      //account
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
       if(oldr.accountInformation.customerDateTime != null && !oldr.accountInformation.customerDateTime .equals(  newr.accountInformation.customerDateTime) )a.add("customerDateTime is different");
       if(oldr.accountInformation.customerTimeGMTOffset != null &&!oldr.accountInformation.customerTimeGMTOffset  .equals(  newr.accountInformation.customerTimeGMTOffset)) a.add("customerTimeGMTOffset is different");
       if(oldr.accountInformation.customerTimeZoneAbbreviation!=null   &&!oldr.accountInformation.customerTimeZoneAbbreviation  .equals(  newr.accountInformation.customerTimeZoneAbbreviation)) a.add("customerTimeZoneAbbreviation is different");
       if(oldr.accountInformation.legacyDispatchTerritory !=null &&!oldr.accountInformation.legacyDispatchTerritory  .equals(  newr.accountInformation.legacyDispatchTerritory)) a.add("legacyDispatchTerritory is different");
       if(oldr.accountInformation.companyOwnerId != null &&!oldr.accountInformation.companyOwnerId  .equals(  newr.accountInformation.companyOwnerId)) a.add("companyOwnerId is different");
       if(oldr.accountInformation.billingSystem != null &&!oldr.accountInformation.billingSystem  .equals(  newr.accountInformation.billingSystem)) a.add("billingSystem is different");
       if(oldr.accountInformation.creditCardLastDigits !=null  &&!oldr.accountInformation.creditCardLastDigits  .equals(  newr.accountInformation.creditCardLastDigits) )a.add("creditCardLastDigits is different");
       if(oldr.accountInformation.verificationCode!=null  &&!oldr.accountInformation.verificationCode  .equals(  newr.accountInformation.verificationCode)) a.add("verificationCode is different");
       
       if(CollectionUtils.isEqualCollection(oldr.accountInformation.usocsOnAccount, newr.accountInformation.usocsOnAccount) ==  false) a.add("Usocs are different");
       
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
      }
      
      //service line check
      
	}
    	map.put("difference", a);
    	map.put("rxSessionOld", oldr.rxSessionIdentifier);
    	map.put("rxSessionNew", newr.rxSessionIdentifier);
    	
    	return map;
		
	}

	private static RxProductInfoResponse callExistingApi(String tn) {
		String encoding = Base64.getEncoder().encodeToString(("rxdsl" + ":" + "Cntl#2017").getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://rxmicro-test1.kubeodc-test.corp.intranet/rxmicro/services/rxProductInfo?etn=" + tn;
		ResponseEntity<RxProductInfoResponse> response = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), RxProductInfoResponse.class);
		System.out.println("Called Old APi");
		return response.getBody();
	}

	private static RxProductInfoResponse callNewApi(String tn) {
		String encoding = Base64.getEncoder().encodeToString(("rxdsl" + ":" + "Cntl#2017").getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://rxmicro-test1.kubeodc-test.corp.intranet/rxmicro/services/rxProductInfo?etn=" + tn;
		ResponseEntity<RxProductInfoResponse> response = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<>(headers), RxProductInfoResponse.class);
		System.out.println("Called New APi");
		return response.getBody();
	}

}
