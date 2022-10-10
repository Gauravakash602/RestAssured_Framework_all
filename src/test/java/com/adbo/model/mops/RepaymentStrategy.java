package com.adbo.model.mops;


import java.util.List;



// @Builder

public class RepaymentStrategy {
private List<String> selectedStdRepaymentElements;
public List<String> getSelectedStdRepaymentElements() {
	return selectedStdRepaymentElements;
}
public void setSelectedStdRepaymentElements(List<String> selectedStdRepaymentElements) {
	this.selectedStdRepaymentElements = selectedStdRepaymentElements;
}
public Boolean getRepaymentStrategyChanged() {
	return repaymentStrategyChanged;
}
public void setRepaymentStrategyChanged(Boolean repaymentStrategyChanged) {
	this.repaymentStrategyChanged = repaymentStrategyChanged;
}
public Boolean getRepaymentStrategyConfident() {
	return repaymentStrategyConfident;
}
public void setRepaymentStrategyConfident(Boolean repaymentStrategyConfident) {
	this.repaymentStrategyConfident = repaymentStrategyConfident;
}
public String getOtherSelectedDesc() {
	return otherSelectedDesc;
}
public void setOtherSelectedDesc(String otherSelectedDesc) {
	this.otherSelectedDesc = otherSelectedDesc;
}
private Boolean repaymentStrategyChanged;
private Boolean repaymentStrategyConfident;
private String otherSelectedDesc;


}