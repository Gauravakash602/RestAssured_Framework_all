package com.adbo.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "classpath: features/",
plugin = {
"pretty",
"json: target/json-report/cucumber.json",
"html: target/cucumber.htm1",
"com.aventstack.extentreports. cucumber. adapter. ExtentCucumberAdapter:",
"summary"},
stepNotifications = false,
glue ={
"com.adbo"
},
snippets = CAMELCASE,
tags = "@Acc")
public class TestRunner {

}
