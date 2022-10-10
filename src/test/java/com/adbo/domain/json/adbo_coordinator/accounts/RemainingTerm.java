package com.adbo.domain.json.adbo_coordinator.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RemainingTerm
{
    private int years;

    private int months;

    public void setYears(int years){
        this.years = years;
    }
    public int getYears(){
        return this.years;
    }
    public void setMonths(int months){
        this.months = months;
    }
    public int getMonths(){
        return this.months;
    }
}