package com.jacagi.subscriptionservice.model.mapper;


import java.util.ArrayList;
import java.util.List;

import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;


public class SubscriptionEntityMapper {
	
	public static SubscriptionEntity toSubscriptionEntity(SubscriptionRequest subscriptionRequest) {
		
		SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
		subscriptionEntity.setBirthDate(subscriptionRequest.getBirthDate());
		subscriptionEntity.setCampaignId(subscriptionRequest.getCampaignId());
		subscriptionEntity.setConsent(subscriptionRequest.getConsent());
		subscriptionEntity.setEmail(subscriptionRequest.getEmail());
		subscriptionEntity.setFirstName(subscriptionRequest.getFirstName());
		subscriptionEntity.setGender(subscriptionRequest.getGender());
		return subscriptionEntity;
	}
	
	public static SubscriptionResponse toFindSubscriptionResponse(SubscriptionEntity subscriptionEntity) {
		
		SubscriptionResponse findSubscriptionResponse = new SubscriptionResponse();
		findSubscriptionResponse.setBirthDate(subscriptionEntity.getBirthDate());
		findSubscriptionResponse.setCampaignId(subscriptionEntity.getCampaignId());
		findSubscriptionResponse.setConsent(subscriptionEntity.getConsent());
		findSubscriptionResponse.setEmail(subscriptionEntity.getEmail());
		findSubscriptionResponse.setFirstName(subscriptionEntity.getFirstName());
		findSubscriptionResponse.setGender(subscriptionEntity.getGender());
		findSubscriptionResponse.setSubscriptionId(subscriptionEntity.getSubscriptionId());
		return findSubscriptionResponse;
	}
	
	public static List<SubscriptionResponse> toFindSubscriptionResponse(Iterable<SubscriptionEntity> subscriptionEntityIterable) {
		List<SubscriptionResponse> response = new ArrayList<>();
		subscriptionEntityIterable.forEach(e -> response.add(toFindSubscriptionResponse(e)));
		return response;
	}
	
}
