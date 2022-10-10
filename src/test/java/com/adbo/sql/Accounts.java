package com.adbo.sql;

public class Accounts {
	private Integer subAccountNo;
	private Double currentBanlance;
	private Double interestRate;
	private String accountType;
	private Integer termMonths;

	public Integer getSubAccountNo() {
		return subAccountNo;
	}

	public Double getCurrentBanlance() {
		return currentBanlance;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public String getAccountType() {
		return accountType;
	}

	public Integer getTermMonths() {
		return termMonths;
	}

	public void setSubAccountNo(Integer subAccountNo) {
		this.subAccountNo = subAccountNo;
	}

	public void setCurrentBanlance(Double currentBanlance) {
		this.currentBanlance = currentBanlance;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setTermMonths(Integer termMonths) {
		this.termMonths = termMonths;
	}

}
