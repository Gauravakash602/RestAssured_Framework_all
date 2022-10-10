package com.adbo.steps.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.adbo.World;
import com.adbo.helpers.RestAssuredExtension;
import com.adbo.model.Document;
import com.adbo.model.mops.Channel;
import com.adbo.model.mops.JourneyException;
import com.adbo.model.mops.MopsCustomer;
import com.adbo.model.mops.MopsEmailApiRequest;
import com.adbo.model.mops.RepaymentStrategy;
import com.adbo.model.mops.SubAccount;
import com.adbo.model.mops.ValuationType;
import com.adbo.model.mops.YesNoWaived;
import com.adbo.services.RestClientHandler;
import com.google.gson.Gson;

import io.cucumber.datatable.DataTable;
//	import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class EmailToMOPS {

	String baseuri;
	String HOST_NAME = "https: //v1-msvc-int-email-dev.edi@1-apps.dev-pcf. 1b4. rbsgrp.net/mortgages/v1/msvc-int-email/email/mops";

	@Autowired
	RestClientHandler restClient;

	@Autowired
	World world;

	private RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
	private ResponseOptions responseOptions;

	private MopsEmailApiRequest request;

	ObjectMapper objMapper = new ObjectMapper();

	HashMap<String, Object> requestHeaders;

	Response response;

	String brand;

	@Given("create a default request for MopsEmailRequest")

	public void create_a_default_request_for_MopsEmailRequest() {
		request = new MopsEmailApiRequest();

	}

	private void addCustomerDetails(DataTable table) {
		MopsCustomer customer = new MopsCustomer();
		List<MopsCustomer> customers = new ArrayList<MopsCustomer>();
//List<List<String>> lists = table.asLists();//stream().collect(Collectors.toList());
//List<Customer> list = lists.subList(1,lists.size()).stream().map(dataRow->addCustomers(dataRow) ).collect(Collectors.toList());
		for (Map<String, String> data : table.asMaps()) {

			customer.setEmail(data.get("email"));
			customer.setFirstName(data.get("firstName"));
			customer.setLastName(data.get("lastName"));
			customer.setDateOfBirth(data.get("dateOfBirth"));
			customer.setIsRequestInitiatedBy(Boolean.parseBoolean(data.get("isRequestInitiatedBy")));
			customer.setIsSignedBy(Boolean.parseBoolean(data.get("isSignedBy")));
		}

		request.setCustomers(customers);

	}

	@When("I submit the MopsEmailRequest to switch deal")
	public void i_submit_the_MopsEmailRequest_to_switch_deal() {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(request);
		System.out.println("++++++++++4+ HHH" + jsonInString);
//String url = "/msvc-int-email/email/mops”;
		System.out.println("Calling API" + HOST_NAME);
		requestHeaders = new HashMap<>();
		requestHeaders.put("brand", this.brand = world.brand);
		this.response = restClient.post(HOST_NAME, requestHeaders, jsonInString, world.scenario);
//responseOptions = RestAssuredExtension.postOpswWithMultipleHeadersAndBody(HOST_NAME + url, headerParams, jsonInString);
//ResponseBody body = responseOptions.getBody();
//System.out.print1n(body.asString());
//response = objMapper.readValue(body.asString(), EmailResponse.class);

	}

	@Then("the mail is delivered to {string} brandwise")
	public void the_mail_is_delivered_to_brandwise(String string) {

	}

	@Then("the mail is delivered to MOG Product Switches")
	public void the_mail_is_delivered_to_MOG_Product_Switches() {

	}

	@Then("the repayment strategy vehicles are also sent in email")
	public void the_repayment_strategy_vehicles_are_also_sent_in_email() {//

	}

	@Then("The MopsEmailRequest should be successful")

	public void the_MopsEmailRequest_should_be_successful() {
//Assert.assertThat (responseOptions.getStatusCode() ,equalTo(20@)) ;
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("The MopsEmailRequest should be Failed")

	public void the_MopsEmailRequest_should_be_failed() {
//Assert.assertThat(responseOptions.getStatusCode() ,equalTo(49@)) ;
		Assert.assertEquals(400, response.getStatusCode());
	}

	@Then("error message should be displayed {string}")

	public void error_message_should_be_displayed(String string) {
//Assert.assertThat (responseOptions.getBody().jsonPath().get(“errorMessage”) ,equalTo(string));
		Assert.assertEquals(responseOptions.getBody().jsonPath().get("errorMessage"), equalTo(string));

	}

	Map<String, String> headerParams = new HashMap<>();

	@Given("set brand to MopsEmailRequest")

	public void set_brand_to_MopsEmailRequest(DataTable dataTable) {
		headerParams.put("Content-Type", "application/json;charset=utf-8");
		String brand = dataTable.asList().get(1);
		headerParams.put("brand", brand);

	}

	private void addAccountDetails(DataTable table) {

//List<SubAccount> sassList= new ArrayList<>();

		for (Map<String, String> data : table.asMaps()) { // asMaps(String.class,String.class)){
			request.setAccountNumber(data.get("accountNumber"));
			request.setAddFeeToMortgage(Boolean.parseBoolean(data.get("addFeeToMortgage")));
			request.setBuyToLet(Boolean.parseBoolean(data.get("buyToLet")));
//request.setBuyToLet (Boolean. parseBoolean(data.get("buyToLet™)));
//request.. setApplicationRefNumber(data.get("applicationRefNumber"));
			request.setChannel(Channel.valueOf(data.get("channel")));
			request.setPendingUpfrontfee(new BigDecimal(new Double(data.get("pendingUpfrontFee"))));
			request.setValuationDate(data.get("valuationDate"));
			request.setLoanToValue(new BigDecimal(data.get("loanToValue")));
			request.setValuationAmount(new BigDecimal((data.get("valuationAmount"))));
			String valType = data.get("valuationType");
			request.setPaymentStatusUnknown(data.get("paymentStatusUnknown"));
			request.setValuationType(ValuationType.valueOf(valType));
			request.setGmsFinalSubmissionFailed(Boolean.valueOf(data.get("gmsFinalSubmissionFailed")));
			request.setRequestedBy(data.get("requestedBy"));
		}
	}

	@Given("add account details to MopsEmailRequest")
	public void add_account_details_to_MopsEmailRequest(DataTable dataTable) {
		addAccountDetails(dataTable);
// Map<String,Object> accDet = dataTable.transpose().asMap(String.class , Object.class);
	}

	@Given("add customer details to MopsEmailRequest")

	public void add_customer_details_to_MopsEmailRequest(DataTable dataTable) {
		addCustomerDetails(dataTable);

	}

	@Given("add document details to MopsEmailRequest")
	public void add_document_details_to_MopsEmailRequest(DataTable dataTable) {
		/*
		 * Document document = new Document(); List<Document> documents = new
		 * ArrayList<Document>(); document. setName(dataTable.cell(1, @));
		 * document.setUr1(dataTable.cell(1, 1)); documents .add(document) ;
		 */
		List<Document> documents = new ArrayList<Document>();
		System.out.print(documents);
		request.setDocuments(documents);

	}

	@Given("add repayment strategy details to MopsEmailRequest")

	public void add_repayment_strategy_details_to_MopsEmailRequest(DataTable dataTable) {
		addRepaymentStrategyDetails(dataTable);

	}

	@Then("the mail is delivered to {string}")
	public void the_mail_is_delivered_to(String string) {

	}

	private void addRepaymentStrategyDetails(DataTable table) {

//Map<String, String> rs = dataTable.transpose().asMap(String.class,String.class);

		RepaymentStrategy rs = new RepaymentStrategy();

		List<String> repVehicles = new ArrayList<>();

		Map<String, String> data = table.transpose().asMap(String.class, String.class);

		rs.setRepaymentStrategyChanged(Boolean.valueOf(data.get("repaymentStrategyChanged ")));

		rs.setRepaymentStrategyConfident(Boolean.valueOf(data.get("repaymentStrategyConfident")));

		rs.setOtherSelectedDesc(data.get("otherSelectedDesc"));

		for (String mulRS : data.get("selectedStdRepaymentElements").split(",")) {
			repVehicles.add(mulRS);

		}

		rs.setSelectedStdRepaymentElements(repVehicles);
		request.setRepaymentStrategy(rs);
	}

	@Given("add sub account details to MopsEmailRequest")
	public void add_sub_account_details_to_MopsEmailRequest(DataTable dataTable) {

	}

	private void addSubAccountDetails(DataTable table) {

//\initialRate| | productCode| productFee|productName| |type|
		List<SubAccount> sassList = new ArrayList<>();
		for (Map<String, String> data : table.asMaps()) {
			SubAccount sass = new SubAccount();
			sass.setInitialRate(new BigDecimal(data.get("intialRate")));
			sass.setCurrentDealEndDate(data.get("currentDealEndDate"));
			sass.setProductfee(new BigDecimal(data.get("productFee")));
			String ynw = data.get("productFeePayable");
			sass.setProductFeePayable(YesNoWaived.valueOf(data.get("productFeePayable")));
			sass.setProductCode(data.get("productCode"));
			sass.setProductName(data.get("productName"));
			sass.setSequenceNumber(Integer.valueOf(data.get("sequenceNumber")));
			sass.setType(data.get("type"));
			sassList.add(sass);

		}

		request.setSubAccounts(sassList);

	}

	@Given("add exception flag details to MopsEmailRequest")
	public void add_exception_flag_details_to_MopsEmailRequest(DataTable dataTable) {
//request .setExceptions(dataTable.getTableConverter().toList(dataTable, JourneyException.class));
		List<JourneyException> appliedExc = new ArrayList<>();
		for (String exFlag : dataTable.transpose().asList()) {
			if (exFlag == null) {
				request.setExceptions(appliedExc);
				break;

			}

			System.out.print(JourneyException.valueOf(exFlag));
			appliedExc.add(JourneyException.valueOf(exFlag));

		}

		request.setExceptions(appliedExc);
	}

	@Then("The MopsEmailRequest should show Bad Request")

	public void the_MopsEmailRequest_should_show_Bad_Request() throws Exception {
		System.out.println("Received status code" + responseOptions.getStatusCode());
		Assert.assertEquals(400, responseOptions.getStatusCode());
	}

}