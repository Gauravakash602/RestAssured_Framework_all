package com.adbo.domain.json.adbo_coordinator.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccounts
{
    public String getcurrentDealEndss() {
		return currentDealEnds;
	}
	public void setcurrentDealEnds(String currentDealEnds) {
		this.currentDealEnds = currentDealEnds;
	}
	public String getTrueBalance() {
		return trueBalance;
	}
	public void setTrueBalance(String trueBalance) {
		this.trueBalance = trueBalance;
	}
	public Map<String, Object> getRemainingAllowance() {
		return remainingAllowance;
	}
	public void setRemainingAllowance(Map<String, Object> remainingAllowance) {
		this.remainingAllowance = remainingAllowance;
	}
	public List<Integer> getCustomStatusCode() {
		return customStatusCode;
	}
	public void setCustomStatusCode(List<Integer> customStatusCode) {
		this.customStatusCode = customStatusCode;
	}
	public void setRemainingTerm(Map<String, Integer> remainingTerm) {
		this.remainingTerm = remainingTerm;
	}
	public int sequenceNumber;

    public String subAccountNumber;

    public double currentBalance;

    public String repaymentType;

    public String interestType;

    public double interestRate;

    public double monthlyPayment;

    public Map<String,Integer> remainingTerm;

    public String termEndDate;
    
    public String currentDealEnds;
 
    
    public String trueBalance;
    
    
    public Map<String ,Object> remainingAllowance;
    
    public List<Integer> customStatusCode;
    public void setSequenceNumber(int sequenceNumber){
        this.sequenceNumber = sequenceNumber;
    }
    public int getSequenceNumber(){
        return this.sequenceNumber;
    }
    public void setSubAccountNumber(String subAccountNumber){
        this.subAccountNumber = subAccountNumber;
    }
    public String getSubAccountNumber(){
        return this.subAccountNumber;
    }
    public void setCurrentBalance(double currentBalance){
        this.currentBalance = currentBalance;
    }
    public double getCurrentBalance(){
        return this.currentBalance;
    }
    public void setRepaymentType(String repaymentType){
        this.repaymentType = repaymentType;
    }
    public String getRepaymentType(){
        return this.repaymentType;
    }
    public void setInterestType(String interestType){
        this.interestType = interestType;
    }
    public String getInterestType(){
        return this.interestType;
    }
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
    public double getInterestRate(){
        return this.interestRate;
    }
    public void setMonthlyPayment(double monthlyPayment){
        this.monthlyPayment = monthlyPayment;
    }
    public double getMonthlyPayment(){
        return this.monthlyPayment;
    }
   
    public Map<String, Integer> getRemainingTerm(){
        return this.remainingTerm;
    }
    public void setTermEndDate(String termEndDate){
        this.termEndDate = termEndDate;
    }
    public String getTermEndDate(){
        return this.termEndDate;
    }
}
