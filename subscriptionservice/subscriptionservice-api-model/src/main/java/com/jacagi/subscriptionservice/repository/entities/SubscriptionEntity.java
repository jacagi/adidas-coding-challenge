package com.jacagi.subscriptionservice.repository.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SUBSCRIPTION", schema ="USER_DATA")
public class SubscriptionEntity {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name = "SUBSCRIPTION_ID")
	  private Integer subscriptionId;

	  @Column(name = "EMAIL")
	  private String email;
		
	  @Column(name = "FIRST_NAME")
	  private String firstName;
			
	  @Column(name = "GENDER")
	  private String gender;
			
	  @Column(name = "BIRTH_DATE")
	  private Date birthDate;
			
	  @Column(name = "CONSENT")
	  private Boolean consent;
			
	  @Column(name = "CAMPAIGN_ID")
	  private Integer campaignId;
	  
	  public Integer getSubscriptionId() {
		  return subscriptionId;
	  }

	  public void setSubscriptionId(Integer subscriptionId) {
		  this.subscriptionId = subscriptionId;
	  }

	  public String getEmail() {
		  return email;
	  }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getConsent() {
		return consent;
	}

	public void setConsent(Boolean consent) {
		this.consent = consent;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
}
