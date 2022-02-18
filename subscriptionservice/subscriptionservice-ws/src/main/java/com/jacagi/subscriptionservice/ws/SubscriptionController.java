package com.jacagi.subscriptionservice.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;
import com.jacagi.subscriptionservice.rest.service.SubscriptionEndpointsApi;
import com.jacagi.subscriptionservice.service.SubscriptionService;
import com.jacagi.subscriptionservice.service.exception.ServiceException;
import com.jacagi.subscriptionservice.utils.ValidateUtils;

@RestController
public class SubscriptionController implements SubscriptionEndpointsApi{

	org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Override
	public ResponseEntity<SubscriptionResponse> create(SubscriptionRequest subscriptionRequest){
		logger.info("Called SubscriptionController#create({})", subscriptionRequest);
		try {
			SubscriptionRequest subscriptionRequestValidate = new SubscriptionRequest();
			subscriptionRequestValidate.setCampaignId(subscriptionRequest.getCampaignId());
			subscriptionRequestValidate.setEmail(subscriptionRequest.getEmail());
			ValidateUtils.validateCreateRequest(subscriptionRequest);
			return new ResponseEntity<>(this.subscriptionService.createSubscription(subscriptionRequest), HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			logger.error("IllegalArgumentException catched at SubscriptionController#create({})\\n Error Message: {}", subscriptionRequest, e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(ServiceException e) {
			logger.error("ServiceException catched at SubscriptionController#create({})\n Error Message: {}",subscriptionRequest, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<SubscriptionResponse>> findAll(){	
		logger.info("Called SubscriptionController#findAll()");
		try {
			return new ResponseEntity<>(this.subscriptionService.findAll(), HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			logger.error("IllegalArgumentException catched at SubscriptionController#findAll()\\n Error Message: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(ServiceException e) {
			logger.error("ServiceException catched at SubscriptionController#findAll()\n Error Message: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<SubscriptionResponse>> findByFilter(SubscriptionRequest subscriptionRequest){
		logger.info("Called SubscriptionController#findByFilter({})", subscriptionRequest);
		try {
			ValidateUtils.validateFindRequest(subscriptionRequest);
			return new ResponseEntity<>(this.subscriptionService.findByFilter(subscriptionRequest), HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			logger.error("IllegalArgumentException catched at SubscriptionController#findByFilter({})\\n Error Message: {}", subscriptionRequest, e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(ServiceException e) {
			logger.error("ServiceException catched at SubscriptionController#findByFilter({})\n Error Message: {}", subscriptionRequest, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@Override
	public ResponseEntity<Boolean> delete(Integer id){
		logger.info("Called SubscriptionController#delete({})", id);
		try {
			this.subscriptionService.deleteById(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			logger.error("IllegalArgumentException catched at SubscriptionController#delete({})\\n Error Message: {}", id, e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(ServiceException e) {
			logger.error("ServiceException catched at SubscriptionController#delete({})\n Error Message: {}", id, e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
