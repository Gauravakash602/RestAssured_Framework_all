
package com.adbo.domain.json.adbo_transformation_coordinator.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

		"accountNumber", "cin", "channel", "scope", "details" })
@Component

public class AuthenticationRequestDto {

	@JsonProperty("accountNumber")
	private String accountNumber;

	@JsonProperty("cin")
	private String cin;

	@JsonProperty("channel")
	private String channel;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("details")
	private String details;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {

	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {

		this.details = details;
	}

	@Override
	public String toString() {

		return "{\"accountNumber\":" + accountNumber + "," + "\"cin\":" + cin + "," + "\"channel\":\"" + channel
				+ "\"}";
	}
}