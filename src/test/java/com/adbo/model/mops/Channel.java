package com.adbo.model.mops;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Channel {
	
	CS("ClearScore"),
	MSM("MoneySuperMarket") ,
	ORGANIC ("Organic");

	String label;
	Channel(String label) {

	this.label = label;
	}

	public String getLabel() {
	return label;
	}
	
}
