package com.adbo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
public class Customer
{
	
	
	private String firstName;
	private String email;
	private  String lastName;
}