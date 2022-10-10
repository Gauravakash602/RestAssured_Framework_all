
package com.adbo.domain.json.adbo_transformation_coordinator.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

		"accountNumber", "cin", "channel", "scope", "details" })
@Component

public class TokenResponseDetailDto {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("access_token")
	public String getAccessToken(){return accessToken;}

	@JsonProperty("access_token")
	private void  setAccessToken(String accessToken) {this.accessToken =accessToken	;}

	@JsonProperty("token_type")
	private String getTokenType() {return tokenType;}

	
	@JsonProperty("token_type")
	private void  setTokenType(String accessToken) {this.tokenType =tokenType	;}

	
}