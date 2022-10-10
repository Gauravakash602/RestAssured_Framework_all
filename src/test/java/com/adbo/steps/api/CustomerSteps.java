package com.adbo.steps.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import com.adbo.World;
import com.adbo.domain.dto.adbo_coordinator.CustomerDetails;
import com.adbo.domain.dto.adbo_coordinator.MortgageAccountDetails;
import com.adbo.domain.json.adbo_coordinator.accounts.AccountsSummary;
import com.adbo.domain.json.adbo_coordinator.accounts.SubAccounts;
import com.adbo.helpers.ConnectionTemplate;
import com.adbo.services.RestClientHandler;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.response.Response;

public class CustomerSteps {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestClientHandler restClient;

	@Autowired
	ConnectionTemplate connectionTemplate;

	@Autowired
	World world;

	JdbcTemplate jdbcTemplate;

	@Value("${productswitch. coordinator. service. base}${productswitch.coordinator.service.account}")
	String productSwitchAccountEndPoint;

	@Value("${productswitch. coordinator. service. base}${productswitch. coordinator. service. customers}")
	String customersEndPoint;

	@Value("${spring.profiles.active:}")
	String activeProfile;

	List<MortgageAccountDetails> accountDetailsList;
	List<CustomerDetails> customerDetailsList;

	AccountsSummary accountSummary;
	SubAccounts subAccount;
	CustomerDetails customerDetails;
	Response response;

	HashMap<String, Object> requestHeaders;
	String accountNumber;

	String email;

	String brand;

	String channel;

	String cin;

	boolean runStep = true;

	Map<String, String> customerDetailsMap = new HashMap<String, String>();

	private String getActiveProfile() {
		String sActiveProfile = System.getProperty("${spring.profiles.active:}");
		if (sActiveProfile == null || sActiveProfile.isEmpty()) {
			sActiveProfile = System.getProperty("spring.profiles.active");
			LOGGER.info("Active Profile = " + sActiveProfile);
		}

		return sActiveProfile;
	}

	private void doSoftAssertion() {
		SoftAssertions softAssertions = new SoftAssertions();
	}

	private boolean runOnlyOnDev() {
		activeProfile = getActiveProfile();
		if (activeProfile.toLowerCase().contains("dev")) {
			LOGGER.info("###### Running this scenario on " + activeProfile + " #HHHH");
			runStep = true;

		}

		else {
			LOGGER.info("###### Not running this scenario on " + activeProfile + " #HHHH");
			runStep = false;

		}

		return runStep;

	}

	private boolean runOnlyOnDev(String sEnvironment) {
		System.setProperty("${spring. profiles.active:}", sEnvironment);
		activeProfile = getActiveProfile();
		if (activeProfile.toLowerCase().contains("dev")) {
			LOGGER.info("###### Running this scenario on " + activeProfile + " ##HHH");
			runStep = true;

		}

		else {
			LOGGER.info("###### Running this scenario on “+activeProfile+” ##HH##");
			runStep = false;

		}
		return runStep;
	}

	@And("user should get a response containing with value of customer email")

			public void userShouldGetAResponseContainingWithValueOfCustomerEmail() {
			this.customerDetails = restClient.mapToBean(CustomerDetails.class, response);
			Assert.assertEquals(email, customerDetails.getEmail());

	}
		@And("Error message is returned in response")
	public void responseErrorMessage(DataTable dataTable){

			Assert.assertEquals(true, response. asString().contains(dataTable.cell(1,0)));
			}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}