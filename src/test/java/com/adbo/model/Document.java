package com.adbo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@Getter
@Setter
public class Document {

	private String name;
	private String url;

}