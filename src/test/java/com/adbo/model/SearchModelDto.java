package com.adbo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchModelDto {

	private String dataType;

	private String accountNumber;
	private String cinNumber;
	private String channel;
	private String scope;

	private String details;

	private String subAccountPayment1;
	private String subAccountPayment2;
	private String currentmonthlyPayment;

	private String continuedMonthlyPayment;
	private String currentMortgageBalance;
	private String newEstimatedBalance;

	public SearchModelDto() {

	}

	public SearchModelDto(String dataType, String channel, String searchText) {
		super();
		this.dataType = dataType;
		this.channel = channel;
		this.subAccountPayment1 = searchText;

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
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

	public String getSubAccountPayment1() {
		return subAccountPayment1;
	}

	public void setSubAccountPayment1(String subAccountPayment1) {
		this.subAccountPayment1 = subAccountPayment1;
	}

	public String getSubAccountPayment2() {
		return subAccountPayment2;
	}

	public void setSubAccountPayment2(String subAccountPayment2) {
		this.subAccountPayment2 = subAccountPayment2;
	}

	public String getCurrentmonthlyPayment() {
		return currentmonthlyPayment;
	}

	public void setCurrentmonthlyPayment(String currentmonthlyPayment) {
		this.currentmonthlyPayment = currentmonthlyPayment;
	}

	public String getContinuedMonthlyPayment() {
		return continuedMonthlyPayment;
	}

	public void setContinuedMonthlyPayment(String continuedMonthlyPayment) {
		this.continuedMonthlyPayment = continuedMonthlyPayment;
	}

	public String getCurrentMortgageBalance() {
		return currentMortgageBalance;
	}

	public void setCurrentMortgageBalance(String currentMortgageBalance) {
		this.currentMortgageBalance = currentMortgageBalance;
	}

	public String getNewEstimatedBalance() {
		return newEstimatedBalance;
	}
	
	public void setNewEstimatedBalance(String newEstimatedBalance) {
		this.newEstimatedBalance = newEstimatedBalance;
	}

		public String getDataType() {
		return dataType;
		}

		public void setDataType(String dataType) {
		this.dataType = dataType;
		}
		

}