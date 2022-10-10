package com.adbo.domain.json.adbo_coordinator.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsSummary {

	public Double total0utstandingBalance;
	public Double monthlyPayment;
	public Boolean buyToLet;
	public String monthlyPaymentDueDate;
	public String lastValuationDate;
	public Double lastValuationAmount;
	public Double hpiValuationAmount;
	public String loanToValueValuated;
	public String hpiValuationDate;
	public int loanToValue;
	public String sysDate;
	public List<Integer> customStatusCode;
	public List<SubAccounts> subAccounts;
	public String nwbLossOfProtectionDocumentUrl;
	public String rbsLossOfProtectionDocumentUrl;
	public String nwbMortgageInformationDocumentUrl;
	public String rbsMortgageInformationDocumentUr1;
	public String nwbFCSCLeafletDocumentUrl;
	public String rbsFCSCLeafletDocumentUr1l;

	public HoldCodes holdCodes;

	public String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getTotal0utstandingBalance() {
		return total0utstandingBalance;
	}

	public void setTotal0utstandingBalance(Double total0utstandingBalance) {
		this.total0utstandingBalance = total0utstandingBalance;
	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public Boolean getBuyToLet() {
		return buyToLet;
	}

	public void setBuyToLet(Boolean buyToLet) {
		this.buyToLet = buyToLet;
	}

	public String getMonthlyPaymentDueDate() {
		return monthlyPaymentDueDate;
	}

	public void setMonthlyPaymentDueDate(String monthlyPaymentDueDate) {
		this.monthlyPaymentDueDate = monthlyPaymentDueDate;
	}

	public String getLastValuationDate() {
		return lastValuationDate;
	}

	public void setLastValuationDate(String lastValuationDate) {
		this.lastValuationDate = lastValuationDate;
	}

	public Double getLastValuationAmount() {
		return lastValuationAmount;
	}

	public void setLastValuationAmount(Double lastValuationAmount) {
		this.lastValuationAmount = lastValuationAmount;
	}

	public Double getHpiValuationAmount() {
		return hpiValuationAmount;
	}

	public void setHpiValuationAmount(Double hpiValuationAmount) {
		this.hpiValuationAmount = hpiValuationAmount;
	}

	public String getLoanToValueValuated() {
		return loanToValueValuated;
	}

	public void setLoanToValueValuated(String loanToValueValuated) {
		this.loanToValueValuated = loanToValueValuated;
	}

	public String getHpiValuationDate() {
		return hpiValuationDate;
	}

	public void setHpiValuationDate(String hpiValuationDate) {
		this.hpiValuationDate = hpiValuationDate;
	}

	public int getLoanToValue() {
		return loanToValue;
	}

	public void setLoanToValue(int loanToValue) {
		this.loanToValue = loanToValue;
	}

	public String getSysDate() {
		return sysDate;
	}

	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

	public List<Integer> getCustomStatusCode() {
		return customStatusCode;
	}

	public void setCustomStatusCode(List<Integer> customStatusCode) {
		this.customStatusCode = customStatusCode;
	}

	public List<SubAccounts> getSubAccounts() {
		return subAccounts;
	}

	public void setSubAccounts(List<SubAccounts> subAccounts) {
		this.subAccounts = subAccounts;
	}

	public String getNwbLossOfProtectionDocumentUrl() {
		return nwbLossOfProtectionDocumentUrl;
	}

	public void setNwbLossOfProtectionDocumentUrl(String nwbLossOfProtectionDocumentUrl) {
		this.nwbLossOfProtectionDocumentUrl = nwbLossOfProtectionDocumentUrl;
	}

	public String getRbsLossOfProtectionDocumentUrl() {
		return rbsLossOfProtectionDocumentUrl;
	}

	public void setRbsLossOfProtectionDocumentUrl(String rbsLossOfProtectionDocumentUrl) {
		this.rbsLossOfProtectionDocumentUrl = rbsLossOfProtectionDocumentUrl;
	}

	public String getNwbMortgageInformationDocumentUrl() {
		return nwbMortgageInformationDocumentUrl;
	}

	public void setNwbMortgageInformationDocumentUrl(String nwbMortgageInformationDocumentUrl) {
		this.nwbMortgageInformationDocumentUrl = nwbMortgageInformationDocumentUrl;
	}

	public String getRbsMortgageInformationDocumentUr1() {
		return rbsMortgageInformationDocumentUr1;
	}

	public void setRbsMortgageInformationDocumentUr1(String rbsMortgageInformationDocumentUr1) {
		this.rbsMortgageInformationDocumentUr1 = rbsMortgageInformationDocumentUr1;
	}

	public String getNwbFCSCLeafletDocumentUrl() {
		return nwbFCSCLeafletDocumentUrl;
	}

	public void setNwbFCSCLeafletDocumentUrl(String nwbFCSCLeafletDocumentUrl) {
		this.nwbFCSCLeafletDocumentUrl = nwbFCSCLeafletDocumentUrl;
	}

	public String getRbsFCSCLeafletDocumentUr1l() {
		return rbsFCSCLeafletDocumentUr1l;
	}

	public void setRbsFCSCLeafletDocumentUr1l(String rbsFCSCLeafletDocumentUr1l) {
		this.rbsFCSCLeafletDocumentUr1l = rbsFCSCLeafletDocumentUr1l;
	}

	public HoldCodes getHoldCodes() {
		return holdCodes;
	}

	public void setHoldCodes(HoldCodes holdCodes) {
		this.holdCodes = holdCodes;
	}

	public Supplier<Exception> subAccountException = () -> new Exception("sub account not found");

	public SubAccounts getSubAccount(int subAccountNumber) {
		try {
			return this.getSubAccounts().stream()
					.filter(subAccount -> subAccount.getSubAccountNumber() == subAccountNumber).findAny()
					.orElseThrow(subAccountException);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("unable to find sub account number");
			return null;
		}
	}

}