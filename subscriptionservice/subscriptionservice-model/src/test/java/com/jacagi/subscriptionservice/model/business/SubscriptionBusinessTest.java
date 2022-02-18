package com.jacagi.subscriptionservice.model.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.jacagi.subscriptionservice.business.exception.BusinessException;
import com.jacagi.subscriptionservice.model.mapper.SubscriptionEntityMapper;
import com.jacagi.subscriptionservice.repository.SubscriptionRepository;
import com.jacagi.subscriptionservice.repository.entities.SubscriptionEntity;
import com.jacagi.subscriptionservice.repository.exception.RepositoryException;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.exception.ServiceException;


@RunWith(SpringRunner.class)
public class SubscriptionBusinessTest {

	@InjectMocks
	private SubscriptionBusinessImpl subscriptionBusines;
	
	@Mock
	private SubscriptionRepository subscriptionRepository;
	
	EasyRandom easyRandom = new EasyRandom();
	
	@Test
	public void createSubscriptionWhenItsSuccessful() throws BusinessException, ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		SubscriptionEntity subscriptionEntity = easyRandom.nextObject(SubscriptionEntity.class);
		
		when(this.subscriptionRepository.save(ArgumentMatchers.any())).thenReturn(subscriptionEntity);
		
		SubscriptionResponse response = this.subscriptionBusines.createSubscription(subscriptionRequest);
		
		assertTrue(response.equals(SubscriptionEntityMapper.toFindSubscriptionResponse(subscriptionEntity)));
		
		verify(this.subscriptionRepository).save(ArgumentMatchers.any());
	}
	
	@Test
	public void createSubscriptionWhenRepositoryThrowsException() throws BusinessException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionRepository.save(ArgumentMatchers.any())).thenThrow(new IllegalArgumentException());
		
		Assertions.assertThrows(BusinessException.class, () ->{
			this.subscriptionBusines.createSubscription(subscriptionRequest);
		});
		
		verify(this.subscriptionRepository).save(ArgumentMatchers.any());
	}
	
	@Test
	public void findAllWhenItsSuccessful() throws BusinessException {
		List<SubscriptionEntity> subscriptionEntityList = new ArrayList<>();
		subscriptionEntityList.add(easyRandom.nextObject(SubscriptionEntity.class));
		
		when(this.subscriptionRepository.findAll()).thenReturn(subscriptionEntityList);
		
		List<SubscriptionResponse> response = this.subscriptionBusines.findAll();
		
		assertTrue(response.get(0).equals(SubscriptionEntityMapper.toFindSubscriptionResponse(subscriptionEntityList.get(0))));
		
		verify(this.subscriptionRepository).findAll();
	}
	
	@Test
	public void findAllWhenRepositoryThrowsException() throws BusinessException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionRepository.findAll()).thenThrow(new IllegalArgumentException());
		
		Assertions.assertThrows(BusinessException.class, () ->{
			this.subscriptionBusines.findAll();
		});
		
		verify(this.subscriptionRepository).findAll();
	}
	
	@Test
	public void findByFilterWhenItsSuccessful() throws RepositoryException, BusinessException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		List<SubscriptionEntity> subscriptionEntityList = new ArrayList<>();
		subscriptionEntityList.add(easyRandom.nextObject(SubscriptionEntity.class));
		
		when(this.subscriptionRepository.findByFilter(ArgumentMatchers.any())).thenReturn(subscriptionEntityList);
		
		List<SubscriptionResponse> response = this.subscriptionBusines.findByFilter(subscriptionRequest);
		
		assertTrue(response.get(0).equals(SubscriptionEntityMapper.toFindSubscriptionResponse(subscriptionEntityList.get(0))));
		
		verify(this.subscriptionRepository).findByFilter(ArgumentMatchers.any());
	}
	
	@Test
	public void findByFilterWhenRepositoryThrowsRespositoryException() throws RepositoryException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionRepository.findByFilter(ArgumentMatchers.any())).thenThrow(new RepositoryException());
		
		Assertions.assertThrows(BusinessException.class, () ->{
			this.subscriptionBusines.findByFilter(subscriptionRequest);
		});
		
		verify(this.subscriptionRepository).findByFilter(ArgumentMatchers.any());
	}
	
	@Test
	public void deleteByIdWhenItsSuccessful() throws BusinessException {		
		doNothing().when(this.subscriptionRepository).deleteById(1);
		
		this.subscriptionBusines.deleteById(1);
		
		verify(this.subscriptionRepository).deleteById(1);
	}
	
	@Test
	public void deleteByIdWhenRepositoryThrowsException() throws RepositoryException {
		doThrow(new IllegalArgumentException()).when(this.subscriptionRepository).deleteById(1);
		
		Assertions.assertThrows(BusinessException.class, () ->{
			this.subscriptionBusines.deleteById(1);
		});
		
		verify(this.subscriptionRepository).deleteById(1);
	}
}
