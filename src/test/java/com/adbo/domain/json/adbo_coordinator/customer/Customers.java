package com.adbo.domain.json.adbo_coordinator.customer;


import java.util.ArrayList;
import java.util.List;
public class Customers
{
    private String surname;

    private String forename;

    private String dateOfBirth;

    private String mobileNumber;

    private List<AdditionalBorrowers> additionalBorrowers;

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setForename(String forename){
        this.forename = forename;
    }
    public String getForename(){
        return this.forename;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public String getMobileNumber(){
        return this.mobileNumber;
    }
    public void setAdditionalBorrowers(List<AdditionalBorrowers> additionalBorrowers){
        this.additionalBorrowers = additionalBorrowers;
    }
    public List<AdditionalBorrowers> getAdditionalBorrowers(){
        return this.additionalBorrowers;
    }
}
