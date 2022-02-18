package com.jacagi.subscriptionservice.service;

import java.util.List;

import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.exception.ServiceException;

public interface SubscriptionService {

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws ServiceException;
	
	List<SubscriptionResponse> findAll() throws ServiceException;
	
	List<SubscriptionResponse> findByFilter(SubscriptionRequest subscriptionRequest) throws ServiceException;
	
	void deleteById(Integer Id) throws ServiceException;
}
