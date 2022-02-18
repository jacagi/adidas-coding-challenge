package com.jacagi.subscriptionservice.model.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jacagi.subscriptionservice.model.business.SubscriptionBusinessImpl;
import com.jacagi.subscriptionservice.repository.SubscriptionRepositoryCustom;
import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;
import com.jacagi.subscriptionservice.repository.exception.RepositoryException;

@Repository
@Transactional(readOnly = true)
public class SubscriptionRepositoryImpl implements SubscriptionRepositoryCustom{

	org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionRepositoryImpl.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<SubscriptionEntity> findByFilter(SubscriptionEntity subscriptionEntity) throws RepositoryException{
		logger.info("Called SubscriptionRepositoryImpl#findByFilter({})", subscriptionEntity);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SubscriptionEntity> query = cb.createQuery(SubscriptionEntity.class);
		Root<SubscriptionEntity> sub = query.from(SubscriptionEntity.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if(subscriptionEntity.getEmail() != null) {
			predicates.add(cb.equal(sub.get("email"), subscriptionEntity.getEmail()));
		}
		
		if(subscriptionEntity.getFirstName() != null) {
			predicates.add(cb.equal(sub.get("firstName"), subscriptionEntity.getFirstName()));
		}
		
		if(subscriptionEntity.getCampaignId() != null) {
			predicates.add(cb.equal(sub.get("campaignId"), subscriptionEntity.getCampaignId()));
		}
		
		if(subscriptionEntity.getConsent() != null) {
			predicates.add(cb.equal(sub.get("consent"), subscriptionEntity.getConsent()));
		}
		
		if(subscriptionEntity.getSubscriptionId() != null) {
			predicates.add(cb.equal(sub.get("subscriptionId"), subscriptionEntity.getSubscriptionId()));
		}
		
		if(subscriptionEntity.getGender() != null) {
			predicates.add(cb.equal(sub.get("gender"), subscriptionEntity.getGender()));
		}
		query = query.select(sub)
        .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		try {
			return entityManager.createQuery(query)
		            .getResultList();
		}catch(Exception e) {
			logger.error("Exception catched at SubscriptionRepositoryImpl#findByFilter({})",subscriptionEntity);
			throw new RepositoryException(e);
		}
	}
	
}
