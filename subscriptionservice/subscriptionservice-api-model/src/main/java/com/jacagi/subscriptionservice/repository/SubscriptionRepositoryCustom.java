package com.jacagi.subscriptionservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;
import com.jacagi.subscriptionservice.repository.exception.RepositoryException;


public interface SubscriptionRepositoryCustom {

	List<SubscriptionEntity> findByFilter(SubscriptionEntity subscriptionEntity) throws RepositoryException;
	
}
