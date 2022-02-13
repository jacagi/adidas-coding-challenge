package com.jacagi.subscriptionserviceapirest.dto;

import java.util.Date;
import lombok.Data;

@Data
public class CreateSubscriptionRequest {

	private String email;
	
	private String firstName;
	
	private String gender;
	
	private Date birthDate;
	
	private Boolean consent;
	
	private Integer campaignId;
	
}
