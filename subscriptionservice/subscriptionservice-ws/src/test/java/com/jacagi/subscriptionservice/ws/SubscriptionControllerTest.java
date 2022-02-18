package com.jacagi.subscriptionservice.ws;

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
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.service.SubscriptionService;
import com.jacagi.subscriptionservice.service.exception.ServiceException;

@RunWith(SpringRunner.class)
public class SubscriptionControllerTest {

	@InjectMocks
	private SubscriptionController subscriptionController;
	
	@Mock
	private SubscriptionService subscriptionService;
	
	EasyRandom easyRandom = new EasyRandom();
	
	@Test
	public void createWhenItsSuccessful() throws ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		SubscriptionResponse subscriptionResponse = easyRandom.nextObject(SubscriptionResponse.class);
		
		when(this.subscriptionService.createSubscription(subscriptionRequest)).thenReturn(subscriptionResponse);
		
		ResponseEntity<SubscriptionResponse> response = this.subscriptionController.create(subscriptionRequest);
		
		assertEquals(subscriptionResponse, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		verify(this.subscriptionService).createSubscription(subscriptionRequest);
	}
	
	@Test
	public void createWhenRequestParametersAreNull() throws ServiceException {
		SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
		
		ResponseEntity<SubscriptionResponse> response = this.subscriptionController.create(subscriptionRequest);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
	
	@Test
	public void createWhenServiceThrowsServiceException() throws ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionService.createSubscription(subscriptionRequest)).thenThrow(new ServiceException());
		
		ResponseEntity<SubscriptionResponse> response = this.subscriptionController.create(subscriptionRequest);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
		verify(this.subscriptionService).createSubscription(subscriptionRequest);
	}
	
	@Test
	public void findAllWhenItsSuccessful() throws ServiceException {
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionService.findAll()).thenReturn(subscriptionResponseList);
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findAll();
		
		assertEquals(subscriptionResponseList, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		verify(this.subscriptionService).findAll();
	}
	
	@Test
	public void findAllWhenServiceThrowsIllegalArgumentException() throws ServiceException {
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionService.findAll()).thenThrow(new IllegalArgumentException());
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findAll();
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
		verify(this.subscriptionService).findAll();
	}
	
	@Test
	public void findAllWhenServiceThrowsServiceException() throws ServiceException {
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionService.findAll()).thenThrow(new ServiceException());
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findAll();
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
		verify(this.subscriptionService).findAll();
	}
	
	@Test
	public void findByFilterWhenItsSuccessful() throws ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		List<SubscriptionResponse> subscriptionResponseList = new ArrayList<>();
		subscriptionResponseList.add(easyRandom.nextObject(SubscriptionResponse.class));
		
		when(this.subscriptionService.findByFilter(subscriptionRequest)).thenReturn(subscriptionResponseList);
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findByFilter(subscriptionRequest);
		
		assertEquals(subscriptionResponseList, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		verify(this.subscriptionService).findByFilter(subscriptionRequest);
	}
	
	@Test
	public void findByFilterWhenServiceThrowsIllegalArgumentException() throws ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionService.findByFilter(subscriptionRequest)).thenThrow(new IllegalArgumentException());
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findByFilter(subscriptionRequest);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
		verify(this.subscriptionService).findByFilter(subscriptionRequest);
	}
	
	@Test
	public void findByFilterWhenServiceThrowsServiceException() throws ServiceException {
		SubscriptionRequest subscriptionRequest = easyRandom.nextObject(SubscriptionRequest.class);
		
		when(this.subscriptionService.findByFilter(subscriptionRequest)).thenThrow(new ServiceException());
		
		ResponseEntity<List<SubscriptionResponse>> response = this.subscriptionController.findByFilter(subscriptionRequest);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
		verify(this.subscriptionService).findByFilter(subscriptionRequest);
	}
	
	@Test
	public void deleteWhenItsSuccessful() throws ServiceException {
		doNothing().when(this.subscriptionService).deleteById(1);
		
		ResponseEntity<Boolean> response = this.subscriptionController.delete(1);
		
		assertTrue(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		verify(this.subscriptionService).deleteById(1);
	}
	
	@Test
	public void deleteWhenServiceThrowsIllegalArgumentException() throws ServiceException {
		doThrow(new IllegalArgumentException()).when(this.subscriptionService).deleteById(1);
		
		ResponseEntity<Boolean> response = this.subscriptionController.delete(1);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
		verify(this.subscriptionService).deleteById(1);
	}
	
	@Test
	public void deleteWhenServiceThrowsServiceException() throws ServiceException {
		doThrow(new ServiceException()).when(this.subscriptionService).deleteById(1);
		
		ResponseEntity<Boolean> response = this.subscriptionController.delete(1);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
		verify(this.subscriptionService).deleteById(1);
	}
}
