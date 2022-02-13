package com.jacagi.subscriptionservicemodel.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;
import com.jacagi.subscriptionservicemodel.repository.ISubscriptionRepository;

@Component
public class SubscriptionBusinessImpl implements SubscriptionBusiness{

	@Autowired
	private ISubscriptionRepository subscriptionRepository;
	
	@Override
	public Integer createSubscription(CreateSubscriptionRequest createSubscriptionRequest) {
		return this.subscriptionRepository.createSubscription(createSubscriptionRequest);
	}

}
