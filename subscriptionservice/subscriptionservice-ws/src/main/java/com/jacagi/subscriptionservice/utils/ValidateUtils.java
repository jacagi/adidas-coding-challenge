package com.jacagi.subscriptionservice.utils;

import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;

public class ValidateUtils {

	public static void validateCreateRequest(SubscriptionRequest subscriptionRequest) {
		
		if(subscriptionRequest.getEmail() == null || subscriptionRequest.getBirthDate() == null || subscriptionRequest.getCampaignId() ==null
				|| subscriptionRequest.getConsent() == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void validateFindRequest(SubscriptionRequest subscriptionRequest) {
		if(subscriptionRequest.getEmail() == null && subscriptionRequest.getGender() == null && subscriptionRequest.getCampaignId() == null
				&& subscriptionRequest.getConsent() == null && subscriptionRequest.getFirstName() == null) {
			throw new IllegalArgumentException();
		}
	}
	
}
