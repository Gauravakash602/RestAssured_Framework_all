package com.adbo.domain.dto.adbo_coordinator;

public class TestDataDto {

	private String dataType;

	private String accountNumber;
	private String cinNumber;

	private String subAccountPayment1;
	private String subAccountPayment2;

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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Double getSubAccountValueByName(String subAccount) {
		if (subAccount.equalsIgnoreCase("1"))
			return Double.parseDouble(getSubAccountPayment1());
		else
			return Double.parseDouble(getSubAccountPayment2());
	}

};
