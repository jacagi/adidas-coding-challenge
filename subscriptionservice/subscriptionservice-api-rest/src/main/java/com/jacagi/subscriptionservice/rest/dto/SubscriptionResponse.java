package com.jacagi.subscriptionservice.rest.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class SubscriptionResponse {

	  @JsonProperty("subscriptionId")
	  private Integer subscriptionId;

	  @JsonProperty("email")
	  private String email;

	  @JsonProperty("firstName")
	  private String firstName;

	  @JsonProperty("gender")
	  private String gender;

	  @JsonProperty("birthDate")
	  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
	  private Date birthDate;

	  @JsonProperty("campaignId")
	  private Integer campaignId;

	  @JsonProperty("consent")
	  private Boolean consent;

	  public SubscriptionResponse subscriptionId(Integer subscriptionId) {
	    this.subscriptionId = subscriptionId;
	    return this;
	  }

	  /**
	   * Get subscriptionId
	   * @return subscriptionId
	  */
	  @ApiModelProperty(value = "")


	  public Integer getSubscriptionId() {
	    return subscriptionId;
	  }

	  public void setSubscriptionId(Integer subscriptionId) {
	    this.subscriptionId = subscriptionId;
	  }

	  public SubscriptionResponse email(String email) {
	    this.email = email;
	    return this;
	  }

	  /**
	   * Get email
	   * @return email
	  */
	  @ApiModelProperty(value = "")


	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public SubscriptionResponse firstName(String firstName) {
	    this.firstName = firstName;
	    return this;
	  }

	  /**
	   * Get firstName
	   * @return firstName
	  */
	  @ApiModelProperty(value = "")


	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public SubscriptionResponse gender(String gender) {
	    this.gender = gender;
	    return this;
	  }

	  /**
	   * Get gender
	   * @return gender
	  */
	  @ApiModelProperty(value = "")


	  public String getGender() {
	    return gender;
	  }

	  public void setGender(String gender) {
	    this.gender = gender;
	  }

	  public SubscriptionResponse birthDate(Date birthDate) {
	    this.birthDate = birthDate;
	    return this;
	  }

	  /**
	   * Get birthDate
	   * @return birthDate
	  */
	  @ApiModelProperty(value = "")

	  @Valid

	  public Date getBirthDate() {
	    return birthDate;
	  }

	  public void setBirthDate(Date birthDate) {
	    this.birthDate = birthDate;
	  }

	  public SubscriptionResponse campaignId(Integer campaignId) {
	    this.campaignId = campaignId;
	    return this;
	  }

	  /**
	   * Get campaignId
	   * @return campaignId
	  */
	  @ApiModelProperty(value = "")


	  public Integer getCampaignId() {
	    return campaignId;
	  }

	  public void setCampaignId(Integer campaignId) {
	    this.campaignId = campaignId;
	  }

	  public SubscriptionResponse consent(Boolean consent) {
	    this.consent = consent;
	    return this;
	  }

	  /**
	   * Get consent
	   * @return consent
	  */
	  @ApiModelProperty(value = "")


	  public Boolean getConsent() {
	    return consent;
	  }

	  public void setConsent(Boolean consent) {
	    this.consent = consent;
	  }


	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    SubscriptionResponse subscriptionResponse = (SubscriptionResponse) o;
	    return Objects.equals(this.subscriptionId, subscriptionResponse.subscriptionId) &&
	        Objects.equals(this.email, subscriptionResponse.email) &&
	        Objects.equals(this.firstName, subscriptionResponse.firstName) &&
	        Objects.equals(this.gender, subscriptionResponse.gender) &&
	        Objects.equals(this.birthDate, subscriptionResponse.birthDate) &&
	        Objects.equals(this.campaignId, subscriptionResponse.campaignId) &&
	        Objects.equals(this.consent, subscriptionResponse.consent);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(subscriptionId, email, firstName, gender, birthDate, campaignId, consent);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class SubscriptionResponse {\n");
	    
	    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
	    sb.append("    email: ").append(toIndentedString(email)).append("\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
	    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
	    sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
	    sb.append("    consent: ").append(toIndentedString(consent)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	
}
