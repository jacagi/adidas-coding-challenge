package com.jacagi.subscriptionservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;


@Repository
public interface SubscriptionRepository  extends CrudRepository<SubscriptionEntity, Integer>, SubscriptionRepositoryCustom {
	
}
