package com.adbo.domain.json.adbo_coordinator.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HoldCodes
{
    private HoldCode holdCode;

    public void setHoldCode(HoldCode holdCode){
        this.holdCode = holdCode;
    }
    public HoldCode getHoldCode(){
        return this.holdCode;
    }
}