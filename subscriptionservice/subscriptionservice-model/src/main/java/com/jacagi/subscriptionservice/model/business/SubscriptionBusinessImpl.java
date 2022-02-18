package com.jacagi.subscriptionservice.model.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacagi.subscriptionservice.business.SubscriptionBusiness;
import com.jacagi.subscriptionservice.business.exception.BusinessException;
import com.jacagi.subscriptionservice.model.mapper.SubscriptionEntityMapper;
import com.jacagi.subscriptionservice.repository.SubscriptionRepository;
import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;
import com.jacagi.subscriptionservice.repository.exception.RepositoryException;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;

@Component
public class SubscriptionBusinessImpl implements SubscriptionBusiness{

	org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionBusinessImpl.class);
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Override
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws BusinessException {
		logger.info("Called SubscriptionBusiness#createSubscription({})", subscriptionRequest);
		try {	
			SubscriptionEntity res =  this.subscriptionRepository.save(SubscriptionEntityMapper.toSubscriptionEntity(subscriptionRequest));
			return SubscriptionEntityMapper.toFindSubscriptionResponse(res);
		}catch(Exception e) {
			logger.error("Exception catched at SubscriptionBusiness#createSubscription({})",subscriptionRequest);
			throw new BusinessException(e);
		}
	}

	@Override
	public List<SubscriptionResponse> findAll() throws BusinessException {
		logger.info("Called SubscriptionBusiness#findAll()");
		try {
			return SubscriptionEntityMapper.toFindSubscriptionResponse(subscriptionRepository.findAll());
		}catch(Exception e) {
			logger.error("Exception catched at SubscriptionBusiness#findAll()");
			throw new BusinessException(e);
		}
	}

	@Override
	public void deleteById(Integer Id) throws BusinessException {
		logger.info("Called SubscriptionBusiness#deleteById({})", Id);
		try {
			this.subscriptionRepository.deleteById(Id);
		}catch(Exception e) {
			logger.error("Exception catched at SubscriptionBusiness#deleteById({})",Id);
			throw new BusinessException(e);
		}
	}

	@Override
	public List<SubscriptionResponse> findByFilter(SubscriptionRequest subscriptionRequest) throws BusinessException {
		logger.info("Called SubscriptionBusiness#findByFilter({})", subscriptionRequest);
		try {
			return SubscriptionEntityMapper.toFindSubscriptionResponse(this.subscriptionRepository.findByFilter(SubscriptionEntityMapper.toSubscriptionEntity(subscriptionRequest)));
		}catch(RepositoryException e) {
			logger.error("RepositoryException catched at SubscriptionBusiness#findByFilter({})",subscriptionRequest);
			throw new BusinessException(e);
		}
	}

}
