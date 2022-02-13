package com.jacagi.subscriptionserviceapirest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jacagi.subscriptionserviceapirest.dto.CreateSubscriptionRequest;
import com.jacagi.subscriptionserviceapirest.dto.FindSubscriptionResponse;

public interface SubscriptionEndpointsApi {

	default ResponseEntity<Integer> create(CreateSubscriptionRequest createSubscriptionRequest){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	default ResponseEntity<Boolean> delete(String email){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	default ResponseEntity<FindSubscriptionResponse> find(Integer id){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	default ResponseEntity<List<String>> findAll(){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
}
