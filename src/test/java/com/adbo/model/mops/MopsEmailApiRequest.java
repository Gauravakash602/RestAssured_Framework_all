package com.adbo.model.mops;

import com.adbo.model.*;
import lombok.Getter;

import lombok.Setter;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;



public class MopsEmailApiRequest {

	public Boolean getBuyToLet() {
		return buyToLet;
	}

	public void setBuyToLet(Boolean buyToLet) {
		this.buyToLet = buyToLet;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getLoanToValue() {
		return loanToValue;
	}

	public void setLoanToValue(BigDecimal loanToValue) {
		this.loanToValue = loanToValue;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public ValuationType getValuationType() {
		return valuationType;
	}

	public void setValuationType(ValuationType valuationType) {
		this.valuationType = valuationType;
	}

	public String getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	public BigDecimal getValuationAmount() {
		return valuationAmount;
	}

	public void setValuationAmount(BigDecimal valuationAmount) {
		this.valuationAmount = valuationAmount;
	}

	public Boolean getAddFeeToMortgage() {
		return addFeeToMortgage;
	}

	public void setAddFeeToMortgage(Boolean addFeeToMortgage) {
		this.addFeeToMortgage = addFeeToMortgage;
	}

	public BigDecimal getPendingUpfrontfee() {
		return pendingUpfrontFee;
	}

	public void setPendingUpfrontfee(BigDecimal pendingUpfrontfee) {
		this.pendingUpfrontFee = pendingUpfrontfee;
	}

	public RepaymentStrategy getRepaymentStrategy() {
		return repaymentStrategy;
	}

	public void setRepaymentStrategy(RepaymentStrategy repaymentStrategy) {
		this.repaymentStrategy = repaymentStrategy;
	}

	public List<SubAccount> getSubAccounts() {
		return subAccounts;
	}

	public void setSubAccounts(List<SubAccount> subAccounts) {
		this.subAccounts = subAccounts;
	}

	public List<MopsCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<MopsCustomer> customers) {
		this.customers = customers;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<JourneyException> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<JourneyException> exceptions) {
		this.exceptions = exceptions;
	}

	public String getPaymentStatusUnknown() {
		return paymentStatusUnknown;
	}

	public void setPaymentStatusUnknown(String paymentStatusUnknown) {
		this.paymentStatusUnknown = paymentStatusUnknown;
	}

	public Boolean getGmsFinalSubmissionFailed() {
		return gmsFinalSubmissionFailed;
	}

	public void setGmsFinalSubmissionFailed(Boolean gmsFinalSubmissionFailed) {
		this.gmsFinalSubmissionFailed = gmsFinalSubmissionFailed;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	private Boolean buyToLet;
	private String accountNumber;

	private BigDecimal loanToValue;

	private Channel channel;

	private ValuationType valuationType;

	private String valuationDate;

	private BigDecimal valuationAmount;

	private Boolean addFeeToMortgage;// No if feeToBePaid is not null or >zero

	private BigDecimal pendingUpfrontFee;// Needed in case of card payment related errors only
	private RepaymentStrategy repaymentStrategy;

	private List<SubAccount> subAccounts;

	private List<MopsCustomer> customers;

	private List<Document> documents;

	private List<JourneyException> exceptions;

	private String paymentStatusUnknown;

	private Boolean gmsFinalSubmissionFailed;

	private String requestedBy;
}