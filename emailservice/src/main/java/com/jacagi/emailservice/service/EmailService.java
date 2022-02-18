package com.jacagi.emailservice.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jacagi.emailservice.controller.SubscriptionRequest;
import com.jacagi.emailservice.controller.SubscriptionResponse;



@Service
public class EmailService {

	org.slf4j.Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public void sendByCampaign(Integer campaignId, String message){
		RestTemplate restTemplate = new RestTemplate();
		String findUri = "http://localhost:8081/subscription/find";
		SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
		subscriptionRequest.setCampaignId(campaignId);
		SubscriptionResponse[] subList = restTemplate.postForEntity(findUri, subscriptionRequest, SubscriptionResponse[].class).getBody();
		for(SubscriptionResponse s: subList) {
			this.sendEmailMock(s.getEmail(), message);
		}	
	}
	
	public void sendtoEveryone(String message){
		RestTemplate restTemplate = new RestTemplate();
		String findAllUri = "http://localhost:8081/subscription/findall";
		SubscriptionResponse[] subList = restTemplate.getForEntity(findAllUri, SubscriptionResponse[].class).getBody();
		
		for(SubscriptionResponse s: subList) {
			this.sendEmailMock(s.getEmail(), message);
		}	
	}
	
	private void sendEmailMock(String mail, String message) {
		logger.info("SENDING EMAIL to " + mail + " with message: " + message);
	}
}
