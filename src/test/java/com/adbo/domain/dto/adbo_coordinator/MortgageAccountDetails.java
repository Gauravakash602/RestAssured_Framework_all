package com.adbo.domain.dto.adbo_coordinator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MortgageAccountDetails {

	int sequenceNumber;
	String accountNumber;

	String subAccountNumber;

	Double currentBalance;

	Double monthlyPayment;

	String repaymentType;

	String interestTypeDescription;
	String interestType;

	Double interestRate;

	String lastValuationDate;
	Double lastValuationAmount;
	String monthlyPaymentDueDate;
	String termEndDate;

	String buyToLet;

	public String getInterestTypeDescription() {
		return interestTypeDescription;
	}

	public void setInterestTypeDescription(String interestTypeDescription) {
		this.interestTypeDescription = interestTypeDescription;
	}

	public boolean getBuyToLlet() {
		boolean buyToLetFlag = false;
		switch (buyToLet.substring(0, 1).toLowerCase()) {

		case "y":
			buyToLetFlag = true;
			break;
		case "n":
			buyToLetFlag = false;
			break;

		default:

			buyToLetFlag = false;
			break;

		}
		return buyToLetFlag;

	}

	public void setBuyToLet(String buyToLet) {
		this.buyToLet = buyToLet;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSubAccountNumber() {
		return subAccountNumber;
	}

	public void setSubAccountNumber(String subAccountNumber) {
		this.subAccountNumber = subAccountNumber;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;

	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public String getLastValuationDate() {
		return lastValuationDate;
	}

	public void setLastValuationDate(String lastValuationDate) {
		this.lastValuationDate = this.getFormattedDate(lastValuationDate);
	}

	public Double getLastValuationAmount() {
		return lastValuationAmount;
	}

	public void setLastValuationAmount(Double lastValuationAmount) {
		this.lastValuationAmount = lastValuationAmount;
	}

	public String getMonthlyPaymentDueDate() {
		return monthlyPaymentDueDate;
	}

	public void setMonthlyPaymentDueDate(String monthlyPaymentDueDate) {
		this.monthlyPaymentDueDate = this.getFormattedDate(monthlyPaymentDueDate);
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public String getTermEndDate() {
		return termEndDate;
	}

	public void setTermEndDate(String termEndDate) {
		this.termEndDate = this.getFormattedDate(termEndDate);
	}

	public String getFormattedDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter finalFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime.format(finalFormatter);
	}
}
