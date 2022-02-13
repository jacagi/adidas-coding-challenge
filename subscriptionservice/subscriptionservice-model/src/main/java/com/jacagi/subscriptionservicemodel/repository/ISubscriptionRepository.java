package com.jacagi.subscriptionservicemodel.repository;

import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;

public interface ISubscriptionRepository {

	Integer createSubscription(CreateSubscriptionRequest createSubscriptionRequest);
	
}
