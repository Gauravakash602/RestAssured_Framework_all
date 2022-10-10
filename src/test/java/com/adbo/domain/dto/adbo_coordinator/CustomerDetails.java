package com.adbo.domain.dto.adbo_coordinator;
import com.adbo.domain.json.adbo_coordinator.customer.AdditionalBorrowers;
import java.util.List;

public class CustomerDetails {
String forename;
String surname;
String dateOfBirth;
String email;
String mobileNumber;
String cin;
List<AdditionalBorrowers> additionalBorrowers;
String errorMessage;

public String getErrorMessage() {
return errorMessage;
}

public void setErrorMessage(String errorMessage) {
this.errorMessage = errorMessage;
}

public List<AdditionalBorrowers> getAdditionalBorrowers() {
return additionalBorrowers;
}

public void setAdditionalBorrowers(List<AdditionalBorrowers> additionalBorrowers) {
this.additionalBorrowers = additionalBorrowers;
}

public String getForename() {
return forename;
}

public void setForename(String forename) {
this. forename = forename;
}

public String getSurname() {
return surname;
}

public void setSurname(String surname) {
this. surname = surname;
}

public String getDateOfBirth() {
return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;

}

public String getMobileNumber() 
{ 
return mobileNumber; 
}

public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

public String getCin() { 
return cin; 
}

public void setCin(String cin) { this.cin = cin; }
}


 

 

 

 
