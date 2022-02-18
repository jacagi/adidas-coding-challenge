package com.jacagi.SubscriptionPublicServices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacagi.SubscriptionPublicServices.service.SubscriptionService;


@RestController
@RequestMapping(path="/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Integer> createSubscription(@RequestBody SubscriptionRequest subscriptionRequest){
		try {
			return new ResponseEntity<>(this.subscriptionService.createSubscription(subscriptionRequest), HttpStatus.OK);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "/delete")
	public ResponseEntity<Boolean> deleteSubscription(@RequestParam String email){
		this.subscriptionService.deleteSubscription(email);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
