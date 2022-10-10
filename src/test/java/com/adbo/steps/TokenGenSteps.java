package com.adbo.steps;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.adbo.World;
import com.adbo.domain.dto.adbo_coordinator.TestDataDto;
import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;
import com.adbo.helpers.ApplicationHelper;
import com.adbo.runners.Hook;
import com.aventstack.extentreports.model.Log;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenGenSteps {

	@Autowired
	World world;

	@Autowired
	Hook hooks;

	@Autowired
	private ApplicationHelper applicationHelper;

	@Autowired
	private AuthenticationRequestDto authenticationRequestDto;

//@Autowired
//private List<BasePage> pages;

	@Value("${rbs.browser}")
	private String browser;

	TestDataDto testDataDto = new TestDataDto();

@Given("user has generated the access token and set values for sub accounts")
public void generateAuthTokenAndSetAccoutValues (DataTable datatable) throws IOException {
/* if condition to check and skip if @getopdata annotation is used */
if(!world.getIsExcelDataNeeded()) {
Map<String, String> customerCredentials = datatable.asMap(String.class, String.class);
testDataDto. setAccountNumber(customerCredentials .get("account-number"));
testDataDto. setCinNumber(customerCredentials.get("cin"));
testDataDto. setSubAccountPayment1(customerCredentials.get("subaccount payment1"));
testDataDto. setSubAccountPayment2(customerCredentials.get("subaccount payment2"));
world.testDataDto = testDataDto;
authenticationRequestDto. setAccountNumber(world.testDataDto. getAccountNumber());
authenticationRequestDto. setCin(world.testDataDto.getCinNumber()) ;
world.accessToken = applicationHelper.getToken(authenticationRequestDto) ;
//initializeDriver();
}
 System.out.println("acces token " + world.accessToken);
}











}