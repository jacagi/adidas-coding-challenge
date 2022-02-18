package com.jacagi.SubscriptionPublicServices.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.jacagi.SubscriptionPublicServices.controller.SubscriptionRequest;
import com.jacagi.SubscriptionPublicServices.controller.SubscriptionResponse;

@Service
public class SubscriptionService {

	
	
	public Integer createSubscription(SubscriptionRequest subscriptionRequest){
		String uri = "http://localhost:8081/subscription/create";
		RestTemplate restTemplate = new RestTemplate();
		
		SubscriptionRequest subscriptionRequestAux = new SubscriptionRequest();
		subscriptionRequestAux.setEmail(subscriptionRequest.getEmail());
		subscriptionRequestAux.setCampaignId(subscriptionRequest.getCampaignId());
		SubscriptionResponse[] subList = findByFilter(subscriptionRequest);
		if(subList.length > 0) {
			throw new IllegalArgumentException();
		}
        
        return restTemplate.postForEntity(uri, subscriptionRequest, SubscriptionResponse.class).getBody().getSubscriptionId();
		
	}
	
	public void deleteSubscription(@RequestParam String email){
		RestTemplate restTemplate = new RestTemplate();
		String deleteUri = "http://localhost:8081/subscription/delete/{id}";
		
		SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
		subscriptionRequest.setEmail(email);
		SubscriptionResponse[] subList = findByFilter(subscriptionRequest);
		for(SubscriptionResponse s: subList) {
			restTemplate.getForEntity(deleteUri, Boolean.class, s.getSubscriptionId());
		}	
	}
	
	
	public SubscriptionResponse[] findByFilter(SubscriptionRequest subscriptionRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String findUri = "http://localhost:8081/subscription/find";
		return restTemplate.postForEntity(findUri, subscriptionRequest, SubscriptionResponse[].class).getBody();
	}
}
