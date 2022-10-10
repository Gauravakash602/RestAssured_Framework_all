package com.adbo.model.mops;




public class MopsCustomer {
private String firstName;
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public Boolean getIsSignedBy() {
	return isSignedBy;
}

public void setIsSignedBy(Boolean isSignedBy) {
	this.isSignedBy = isSignedBy;
}

public Boolean getIsRequestInitiatedBy() {
	return isRequestInitiatedBy;
}

public void setIsRequestInitiatedBy(Boolean isRequestInitiatedBy) {
	this.isRequestInitiatedBy = isRequestInitiatedBy;
}

private String lastName;
private String email;

private String dateOfBirth; //dd-MM-YYYY
private Boolean isSignedBy;

private Boolean isRequestInitiatedBy;
}