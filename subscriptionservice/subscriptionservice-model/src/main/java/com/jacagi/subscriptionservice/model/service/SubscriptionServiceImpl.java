package com.jacagi.subscriptionservice.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacagi.subscriptionservice.business.SubscriptionBusiness;
import com.jacagi.subscriptionservice.business.exception.BusinessException;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.SubscriptionService;
import com.jacagi.subscriptionservice.service.exception.ServiceException;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);
	
	@Autowired
	private SubscriptionBusiness subscriptionBusiness;
	
	@Override
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws ServiceException {
		logger.info("Called SubscriptionService#createSubscription({})", subscriptionRequest);
		try {
			return this.subscriptionBusiness.createSubscription(subscriptionRequest);
		}catch(BusinessException e) {
			logger.error("BusinessException catched at SubscriptionService#createSubscription({})",subscriptionRequest);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SubscriptionResponse> findAll() throws ServiceException {
		logger.info("Called SubscriptionService#findAll()");
		try {
			return this.subscriptionBusiness.findAll();
		}catch(BusinessException e) {
			logger.error("BusinessException catched at SubscriptionService#findAll()");
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void deleteById(Integer Id) throws ServiceException {
		logger.info("Called SubscriptionService#deleteById({})", Id);
		try {
			this.subscriptionBusiness.deleteById(Id);
		}catch(BusinessException e) {
			logger.error("BusinessException catched at SubscriptionService#deleteById({})",Id);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SubscriptionResponse> findByFilter(SubscriptionRequest subscriptionRequest) throws ServiceException {
		logger.info("Called SubscriptionService#findByFilter({})", subscriptionRequest);
		try {
			return this.subscriptionBusiness.findByFilter(subscriptionRequest);
		}catch(BusinessException e) {
			logger.error("BusinessException catched at SubscriptionService#findByFilter({})",subscriptionRequest);
			throw new ServiceException(e);
		}
	}
}
