package com.jacagi.subscriptionservice.model.service;

import static org.junit.Assert.assertEquals;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.jacagi.subscriptionservice.business.SubscriptionBusiness;
import com.jacagi.subscriptionservice.business.exception.BusinessException;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class SubscriptionServiceTest {

	@InjectMocks
	private SubscriptionServiceImpl subscriptionService;
	
	@Mock
	private SubscriptionBusiness subscriptionBusiness;
	
	EasyRandom easyRandom = new EasyRandom();
	
	@Test
	public void createSubscriptionWhenItsSuccessful() throws BusinessException, ServiceException {
		SubscriptionResponse subscriptionResponse = easyRandom.nextObject(SubscriptionResponse.class);
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionBusiness.createSubscription(subscriptionRequest)).thenReturn(subscriptionResponse);
		
		SubscriptionResponse response = this.subscriptionService.createSubscription(subscriptionRequest);
		
		assertEquals(subscriptionResponse, response);
		
		verify(this.subscriptionBusiness).createSubscription(subscriptionRequest);
	}
	
	@Test
	public void createSubscriptionWhenBusinessThrowsBusinessException() throws BusinessException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionBusiness.createSubscription(subscriptionRequest)).thenThrow(new BusinessException());
		
		Assertions.assertThrows(ServiceException.class, () ->{
			this.subscriptionService.createSubscription(subscriptionRequest);
		});
		
		verify(this.subscriptionBusiness).createSubscription(subscriptionRequest);
	}

	@Test
	public void findAllWhenItsSuccessful() throws BusinessException, ServiceException {
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionBusiness.findAll()).thenReturn(subscriptionResponseList);
		
		List<SubscriptionResponse> response = this.subscriptionService.findAll();
		
		assertEquals(subscriptionResponseList, response);
		
		verify(this.subscriptionBusiness).findAll();
	}
	
	@Test
	public void findAllWhenBusinessThrowsBusinessException() throws BusinessException {
		
		when(this.subscriptionBusiness.findAll()).thenThrow(new BusinessException());
		
		Assertions.assertThrows(ServiceException.class, () ->{
			this.subscriptionService.findAll();
		});
		
		verify(this.subscriptionBusiness).findAll();
	}
	
	@Test
	public void findByFilterWhenItsSuccessful() throws BusinessException, ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionBusiness.findByFilter(subscriptionRequest)).thenReturn(subscriptionResponseList);
		
		List<SubscriptionResponse> response = this.subscriptionService.findByFilter(subscriptionRequest);
		
		assertEquals(subscriptionResponseList, response);
		
		verify(this.subscriptionBusiness).findByFilter(subscriptionRequest);
	}
	
	@Test
	public void findByFilterWhenBusinessThrowsBusinessException() throws BusinessException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionBusiness.findByFilter(subscriptionRequest)).thenThrow(new BusinessException());
		
		Assertions.assertThrows(ServiceException.class, () ->{
			this.subscriptionService.findByFilter(subscriptionRequest);
		});
		
		verify(this.subscriptionBusiness).findByFilter(subscriptionRequest);
	}
	
	@Test
	public void deleteByIdWhenItsSuccessful() throws BusinessException, ServiceException {
		
		doNothing().when(this.subscriptionBusiness).deleteById(1);
		
		this.subscriptionService.deleteById(1);
		
		verify(this.subscriptionBusiness).deleteById(1);
	}
	
	@Test
	public void deleteByIdWhenBusinessThrowsBusinessException() throws BusinessException, ServiceException {
		doThrow(new BusinessException()).when(this.subscriptionBusiness).deleteById(1);
		
		Assertions.assertThrows(ServiceException.class, () ->{
			this.subscriptionService.deleteById(1);
		});
		
		verify(this.subscriptionBusiness).deleteById(1);
	}
}
