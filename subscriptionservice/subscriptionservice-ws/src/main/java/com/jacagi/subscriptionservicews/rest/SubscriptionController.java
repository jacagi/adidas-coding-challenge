package com.jacagi.subscriptionservicews.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jacagi.subscriptionserviceapimodel.service.SubscriptionService;
import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;
import com.jacagi.subscriptionserviceapirest.service.SubscriptionEndpointsApi;

@RestController
public class SubscriptionController implements SubscriptionEndpointsApi{

	@Autowired
	private SubscriptionService subscriptionService;
	
	public ResponseEntity<Integer> create(CreateSubscriptionRequest createSubscriptionRequest){
		Integer response = this.subscriptionService.createSubscription(createSubscriptionRequest);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
