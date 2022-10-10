package com.adbo.model.mops;

public enum ValuationType {
HPI("HPI") ,
LAST_VALUATION("Last Valuation") ;
String label;
ValuationType(String label) {

this.label = label;

}

public String getLabel() {
return label;
}
}