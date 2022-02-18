package com.jacagi.subscriptionservice.business;

import java.util.List;

import com.jacagi.subscriptionservice.business.exception.BusinessException;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.exception.ServiceException;

public interface SubscriptionBusiness {

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws BusinessException;
	
	List<SubscriptionResponse> findAll() throws BusinessException;

	void deleteById(Integer Id) throws BusinessException;

	List<SubscriptionResponse> findByFilter(SubscriptionRequest subscriptionRequest) throws BusinessException;
}
