package com.jacagi.subscriptionservicemodel.business;

import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;

public interface SubscriptionBusiness {

	Integer createSubscription(CreateSubscriptionRequest createSubscriptionRequest);
	
}
