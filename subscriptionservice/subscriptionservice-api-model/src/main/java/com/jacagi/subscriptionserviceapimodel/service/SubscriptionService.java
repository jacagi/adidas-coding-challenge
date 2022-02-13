package com.jacagi.subscriptionserviceapimodel.service;

import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;

public interface SubscriptionService {

	Integer createSubscription(CreateSubscriptionRequest createSubscriptionRequest);
	
}
