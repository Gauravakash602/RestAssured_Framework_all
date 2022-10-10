package com.adbo.model.mops;
public enum YesNoWaived {
YES("Yes"),
NO("No"),
WAIVED("Waived") ;
String label;
YesNoWaived(String label) {
this.label = label;
}

public String getLabel() {
return label;
}
}