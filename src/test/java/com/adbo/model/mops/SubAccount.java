 

package com.adbo.model.mops;


import java.math. BigDecimal;


public class SubAccount {

public Integer getSequenceNumber() {
	return sequenceNumber;
}
public void setSequenceNumber(Integer sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public BigDecimal getInitialRate() {
	return initialRate;
}
public void setInitialRate(BigDecimal initialRate) {
	this.initialRate = initialRate;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public String getCurrentDealEndDate() {
	return currentDealEndDate;
}
public void setCurrentDealEndDate(String currentDealEndDate) {
	this.currentDealEndDate = currentDealEndDate;
}
public YesNoWaived getProductFeePayable() {
	return productFeePayable;
}
public void setProductFeePayable(YesNoWaived productFeePayable) {
	this.productFeePayable = productFeePayable;
}
public BigDecimal getProductfee() {
	return productfee;
}
public void setProductfee(BigDecimal productfee) {
	this.productfee = productfee;
}

private Integer sequenceNumber;
private String type;
private String productName;
private BigDecimal initialRate;
private String productCode;
private String currentDealEndDate;
private YesNoWaived productFeePayable; ///Yes/No/Waived
private BigDecimal productfee;
}