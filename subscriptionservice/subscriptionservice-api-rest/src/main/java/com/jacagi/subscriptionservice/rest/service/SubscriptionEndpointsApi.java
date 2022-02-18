package com.jacagi.subscriptionservice.rest.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacagi.subscriptionservice.rest.dto.SubscriptionRequest;
import com.jacagi.subscriptionservice.rest.dto.SubscriptionResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "SubscriptionEndpointsApi", description = "the SubscriptionEndpoints Api")
@RequestMapping(path="/subscription")
public interface SubscriptionEndpointsApi {

    /**
     * POST /create : Create a new subscription
     * Create a new subscription in db. Returns the id of the object created.
     *
     * @param subscriptionRequest  (required)
     * @return OK (status code 200)
     *         or Request contains invalid parameters (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Create a new subscription", nickname = "create", notes = "Create a new subscription in db. Returns the id of the object created.", response = String.class, tags={ "subscription-service-endpoint", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 400, message = "Request contains invalid parameters"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(
        value = "/create",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
	default ResponseEntity<SubscriptionResponse> create(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SubscriptionRequest createSubscriptionRequest){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
    /**
     * GET /delete/{subscriptionId} : Delete the subscription using the id in the path
     * Delete the subscription that corresponds the id in the input to.
     *
     * @param subscriptionId Id of the subscription (required)
     * @return OK (status code 200)
     *         or Request contains invalid parameters (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Delete the subscription using the id in the path", nickname = "delete", notes = "Delete the subscription that corresponds the id in the input to.", response = Boolean.class, tags={ "subscription-service-endpoint", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Boolean.class),
        @ApiResponse(code = 400, message = "Request contains invalid parameters"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(
        value = "/delete/{subscriptionId}",
        produces = { "application/json" }
    )
	default ResponseEntity<Boolean> delete(@ApiParam(value = "Id of the subscription",required=true) @PathVariable("subscriptionId") Integer id){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

    /**
     * GET /findall : Find all subscriptions
     * Returns all subscriptions stored in the database.
     *
     * @return OK (status code 200)
     *         or Request contains invalid parameters (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Find all subscriptions", nickname = "findAll", notes = "Returns all subscriptions stored in the database.", response = SubscriptionResponse.class, responseContainer = "List", tags={ "subscription-service-endpoint", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SubscriptionResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Request contains invalid parameters"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @GetMapping(
        value = "/findall",
        produces = { "application/json" }
    )
	default ResponseEntity<List<SubscriptionResponse>> findAll(){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
    /**
     * POST /find : Find subscriptions using the input parameters as filter
     * Returns the subscriptions that match the input parameters. The birth date is the only parameter that cannot be used
     *
     * @param subscriptionRequest  (required)
     * @return OK (status code 200)
     *         or Request contains invalid parameters (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Find subscriptions using the input parameters as filter", nickname = "findByFilter", notes = "Returns the subscriptions that match the input parameters. The birth date is the only parameter that cannot be used", response = SubscriptionResponse.class, responseContainer = "List", tags={ "subscription-service-endpoint", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SubscriptionResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Request contains invalid parameters"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(
        value = "/find",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
	default ResponseEntity<List<SubscriptionResponse>> findByFilter(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SubscriptionRequest subscriptionRequest){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
