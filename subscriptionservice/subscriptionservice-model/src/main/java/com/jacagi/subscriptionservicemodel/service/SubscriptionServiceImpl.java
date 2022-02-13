package com.jacagi.subscriptionservicemodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacagi.subscriptionserviceapimodel.service.SubscriptionService;
import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;
import com.jacagi.subscriptionservicemodel.business.SubscriptionBusiness;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	private SubscriptionBusiness subscriptionBusiness;
	
	@Override
	public Integer createSubscription(CreateSubscriptionRequest createSubscriptionRequest) {
		return this.subscriptionBusiness.createSubscription(createSubscriptionRequest);
	}
	
	
}
