package com.jacagi.emailservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacagi.emailservice.service.EmailService;


@RestController
@RequestMapping(path="/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping(value = "/send/{campaignId}")
	public ResponseEntity<Boolean> sendByCampaign(@PathVariable("campaignId") Integer campaignId, @RequestBody EmailRequest emailRequest){
		this.emailService.sendByCampaign(campaignId, emailRequest.getMessage());
		return new ResponseEntity<>(true, HttpStatus.OK);
		
	}
	@PostMapping(value = "/send")
	public ResponseEntity<Boolean> sendtoEveryone(@RequestBody EmailRequest emailRequest){
		this.emailService.sendtoEveryone(emailRequest.getMessage());
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
