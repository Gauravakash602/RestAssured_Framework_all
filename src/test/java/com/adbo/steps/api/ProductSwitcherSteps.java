package com.adbo.steps.api;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import com.adbo.World;
import com.adbo.domain.dto.adbo_coordinator.CustomerDetails;
import com.adbo.domain.dto.adbo_coordinator.MortgageAccountDetails;
import com.adbo.domain.dto.adbo_coordinator.mapper.CustomerDetailsMapper;
import com.adbo.domain.dto.adbo_coordinator.mapper.MortgageAccountsDetailsMapper;
import com.adbo.domain.json.adbo_coordinator.accounts.AccountsSummary;
import com.adbo.domain.json.adbo_coordinator.accounts.HoldCode;
import com.adbo.domain.json.adbo_coordinator.accounts.HoldCodes;
import com.adbo.domain.json.adbo_coordinator.accounts.SubAccounts;
import com.adbo.helpers.ConnectionTemplate;
import com.adbo.services.RestClientHandler;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ProductSwitcherSteps {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestClientHandler restClient;

	@Autowired
	ConnectionTemplate connectionTemplate;

	@Autowired
	World world;

	JdbcTemplate jdbcTemplate;

	@Value("${adbosit. coordinator. service.base}${adbosit. coordinator. service.account}")
	String AdboAccountEndPointSit;

	@Value("${adbosit. coordinator. service. base}${adbosit. coordinator. service. customers}")
	String customersEndPoint;

	@Value("${spring.profiles.active:}")
	String activeProfile;

	List<MortgageAccountDetails> accountDetailsList;
	List<CustomerDetails> customerDetailsList;
	AccountsSummary accountSummary;
	AccountsSummary apiResponseBean;

	HoldCode holdcodeSummary;

	HoldCodes holdcodes;

	SubAccounts subAccount;

	CustomerDetails customerDetails;

	Response response;

	HashMap<String, Object> requestHeaders;
	String accountNumber;

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
			LOGGER.info("###### Running this scenario on " + activeProfile + " #HHH#");
			runStep = true;

		} else {
			LOGGER.info("###### Not running this scenario on " + activeProfile + " HHH");
			runStep = false;

		}

		return runStep;

	}

	private boolean runOnlyOnDev(String sEnvironment) {

		System.setProperty("${spring.profiles.active:}", sEnvironment);

		activeProfile = getActiveProfile();

		if (activeProfile.toLowerCase().contains("dev")) {
			LOGGER.info("###### Running this scenario on " + activeProfile + " ##HHHHE");
			runStep = true;

		} else {
			LOGGER.info("###### Running this scenario on " + activeProfile + " ######");
			runStep = false;

		}

		return runStep;
	}

	@Given("user has account number {} of the product switcher customer")

	public void userHasTheEndpointOfTheAccounts(String accountNumber) {
		this.runStep = runOnlyOnDev("dev");
		requestHeaders = new HashMap<>();
		requestHeaders.put("account_number", this.accountNumber = accountNumber);
		requestHeaders.put("brand", this.brand = world.brand);
//requestHeaders.put("channel", this.channel = “organic”);

	}

	@Given("user has the account number {},cin number {} of customer")

	public boolean userHasTheEndpointOfTheCustomer(String accountNumber, String cin) {
		this.runStep = runOnlyOnDev("dev");
		requestHeaders = new HashMap<>();
		requestHeaders.put("“account_number", this.accountNumber = accountNumber);
		requestHeaders.put("cin", this.cin = cin);
		requestHeaders.put("channel", this.channel = "cs");
		return this.runStep;

	}

	@Given("user has account number {},cin number {},channel {},brand {} of customer")
	public boolean userHasTheEndpointOfCustomer(String accountNumber, String cin, String channel, String brand) {
		this.runStep = runOnlyOnDev("dev");
		requestHeaders = new HashMap<>();
		requestHeaders.put("account_number", this.accountNumber = accountNumber);
		requestHeaders.put("cin", this.cin = cin);
		requestHeaders.put("channel", this.channel = channel);
		requestHeaders.put("brand", this.brand = brand);
		return this.runStep;
	}

	@When("user accesses the adbo sit end-point in accounts coordinator")
	public void userAccessesTheAdboSitEndPointInAccountsCoordinator() {
		if (this.runStep == true) {
			this.response = restClient.get(this.AdboAccountEndPointSit, requestHeaders, world.scenario);
			world.accountsSummary = restClient.mapToBean(AccountsSummary.class, response);
		}

	}

	@When("user accesses the customer end-point to get customer details")
	public void userAccessesLandingPageApplication() {
		if (this.runStep == true) {
			this.response = restClient.get(this.customersEndPoint, requestHeaders, world.scenario);
		}

	}

	@And("user should get a response containing the accountNumber key with value of {}")

	public void verifyAccountBalanceExpectedFieldAndValue(String accountNumber) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(accountNumber, accountSummary.getAccountNumber());

	}

	@And("user should get a response containing the totalOutstandingBalance key with value of {}")

	public void verifyTotal0utstandingBalanceExpectedFieldAndValue(Double total0utstandingBalance)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(total0utstandingBalance, accountSummary.getTotal0utstandingBalance());

	}

	@And("user should get a response containing the monthlyPayment key with value of {}")

	public void verifyMonthlyPaymentExpectedFieldAndValue(Double monthlyPayment) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(monthlyPayment, accountSummary.getMonthlyPayment());

	}

	@And("user should get a response containing the buyToLet key with value of {}")

	public void verifyBuyToLetExpectedFieldAndValue(boolean buyToLet) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(buyToLet, accountSummary.getBuyToLet());

	}

	@And("user should get a response containing the monthlyPaymentDueDate key with value of {}")

	public void verifyMonthlyPaymentDueDateExpectedFieldAndValue(String monthlyPaymentDueDate)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(monthlyPaymentDueDate, accountSummary.getMonthlyPaymentDueDate());

	}

	@And("user should get a response containing the lastValuationDate key with value of {}")

	public void verifyLastValuationDateExpectedFieldAndValue(String lastValuationDate) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(lastValuationDate, accountSummary.getLastValuationDate());
	}

	@And("user should get a response containing the lastValuationAmount key with value of {}")

	public void verifyLastValuationAmountExpectedFieldAndValue(Double lastValuationAmount) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(lastValuationAmount, accountSummary.getLastValuationAmount());

	}

	@And("user should get a response containing the hpiValuationAmount key with value of {}")

	public void verifyHpiVeluationAmountExpectedFieldAndValue(Double hpiValuationAmount) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(hpiValuationAmount, accountSummary.getHpiValuationAmount());

	}

	@And("user should get a response containing the loanToValueValuated key with value of {}")

	public void verifyLoanToValueValuatedExpectedFieldAndValue(String loanToValueValuated) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(loanToValueValuated, accountSummary.getLoanToValueValuated());

	}

	@And("user should get a response containing the hpiValuationDate key with value of {}")

	public void verifyHpiValuationDateExpectedFieldAndValue(String hpiValuationDate) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(hpiValuationDate, accountSummary.getHpiValuationDate());

	}

	@And("user should get a response containing the loanToValue key with value of {}")

	public void verifyLoanToValueExpectedFieldAndValue(int loanToValue) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(loanToValue, accountSummary.getLoanToValue());

	}

	@And("user should get a response containing the sysDate key with value of {}")

	public void verifySysDateExpectedFieldAndValue(String sysDate) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(sysDate, accountSummary.getSysDate());

	}

	@And("user should get a response containing the customStatusCode key with value of {}")

	public void verifyCustomStatusCodeExpectedFieldAndValue(int customStatusCode) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertTrue(checkListForStatusCode(customStatusCode, accountSummary.getCustomStatusCode()));

	}

	@And("user should get a response of sequenceNumber {} and customStatusCode key with value of {}")

	public void userShouldGetResponseContainingSequenceNumberAndcustomStatusCodekeywithvalueof(int sequenceNumber,
			int customStatusCode) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertTrue(checkListForStatusCode(customStatusCode,
				accountSummary.subAccounts.get(sequenceNumber - 1).getCustomStatusCode()));

	}

	private boolean checkListForStatusCode(int customStatusCode, List<Integer> customStatusCodeList) {
		boolean check = false;
		if (customStatusCode == 0) {
			if (customStatusCodeList.size() == 0) {
				check = true;
			}

		} else {
			check = customStatusCodeList.contains(customStatusCode);
		}

		return check;

	}

	@And("user should get a response containing sequenceNumber {}")

	public void userShouldGetAResponseContainingSubAccounts(int sequenceNumber) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true,
				accountSummary.subAccounts.get(sequenceNumber - 1).getSequenceNumber() == sequenceNumber);

	}

	@And("user should get a response containing subAccountNumber {}")

	public void userShouldGetAResponseContainingSubAccountNumber(int subAccountNumber) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true,
				accountSummary.subAccounts.get(subAccountNumber - 1).getSequenceNumber() == subAccountNumber);

	}

	@And("user should get a response of sequenceNumber {} and currentBalance of {}")

	public void userShouldGetResponseContainingSequenceNumberAndCurrentBalance(int sequenceNumber,
			double currentBalance) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true,
				accountSummary.subAccounts.get(sequenceNumber - 1).getCurrentBalance() == currentBalance);

	}

	@And("user should get a response of sequenceNumber {} and repaymentType of {}")

	public void userShouldGetResponseContainingSequenceNumberAndRepaymentType(int sequenceNumber, String repaymentType)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(accountSummary.subAccounts.get(sequenceNumber - 1).getRepaymentType(), repaymentType);

	}

	@And("user should get a response of sequenceNumber {} and interestType of {}")

	public void userShouldGetResponseContainingSequenceNumberAndInterestType(int sequenceNumber, String interestType)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(accountSummary.subAccounts.get(sequenceNumber - 1).getInterestType(), interestType);

	}

	@And("user should get a response of sequenceNumber {} and interestRate of {}")

	public void userShouldGetResponseContainingSequenceNumberAndInterestRate(int sequenceNumber, double interestRate)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true, accountSummary.subAccounts.get(sequenceNumber - 1).getInterestRate() == interestRate);

	}

	@And("user should get a response of sequenceNumber {} and monthlyPayments of {}")

	public void userShouldGetResponseContainingSequenceNumberAndMonthlyPayments(int sequenceNumber,
			double monthlyPayments) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true,
				accountSummary.subAccounts.get(sequenceNumber - 1).getMonthlyPayment() == monthlyPayments);

	}

	@And("user should get a response of sequenceNumber {} and remainTermYears of {}")

	public void userShouldGetResponseContainingSequenceNumberAndRemainTermYears(int sequenceNumber, int remainTermYears)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true,
				accountSummary.subAccounts.get(sequenceNumber - 1).getRemainingTerm().get("years") == remainTermYears);

	}

	@And("user should get a response of sequenceNumber {} and remainTermMonths of {}")

	public void userShouldGetResponseContainingSequenceNumberAndRemainTermMonths(int sequenceNumber,
			int remainTermMonths) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(true, accountSummary.subAccounts.get(sequenceNumber - 1).getRemainingTerm()
				.get("“months") == remainTermMonths);

	}

	@And("user should get a response of sequenceNumber {} and termEndDate of {}")

	public void userShouldGetResponseContainingSequenceNumberAndTermEndDate(int sequenceNumber, String termEndDate)
			throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(accountSummary.subAccounts.get(sequenceNumber - 1).getTermEndDate(), termEndDate);

	}

	@And("user should get a response of sequenceNumber {} and currentDealEnds of {}")

	public void userShouldGetResponseContainingSequenceNumberAndCurrentDealEnds(int sequenceNumber,
			String currentDealEnds) throws CucumberException {
		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);
		Assert.assertEquals(accountSummary.subAccounts.get(sequenceNumber - 1).currentDealEnds, currentDealEnds);

	}

	@Then("user should get a response code of {} in the response")
	public void verifyStatusCode(int statusCode) {
		if (this.runStep == true) {
			Assert.assertEquals(statusCode, response.getStatusCode());
		}

	}

	@And("user should verify the response details against database records with {} interest type")
	public void verifyResponseAgainstDatabaseRecords(String sInterestType) {
		try {
			this.jdbcTemplate = connectionTemplate.getAccountsJDBCTemplateForBrand();
			String sql = FileCopyUtils.copyToString(new InputStreamReader(
					new ClassPathResource("sql\\api\\adbo-queries\\MortgageAccountDetails.sql").getInputStream()));
			accountDetailsList = jdbcTemplate.query(sql, new Object[] { this.accountNumber, this.accountNumber },
					new MortgageAccountsDetailsMapper());
			this.compareResponses(accountDetailsList, accountSummary, sInterestType);
		} catch (Exception e) {
			LOGGER.error("unable to get mortgage account details from database", e);
		}

	}

public void compareResponses(List<MortgageAccountDetails> sqlList, AccountsSummary apiResponseBean) {
try {

/*Verification of high level details*/
MortgageAccountDetails highLevelDetails = sqlList.get(0);
Assert.assertEquals("account number verification", highLevelDetails.getAccountNumber(), apiResponseBean.getAccountNumber());
Assert.assertEquals("total balance verification", this.calculateTotalOutstandingBalance(sqlList), apiResponseBean.getTotal0utstandingBalance());
Assert.assertEquals("total monthly payment verification", this.calculateTotalMonthlyPayment(sqlList), apiResponseBean.getMonthlyPayment());
Assert.assertEquals("monthly payment due date verification", highLevelDetails.getMonthlyPaymentDueDate(), apiResponseBean.getMonthlyPaymentDueDate());
Assert.assertEquals("last valuation date verification", highLevelDetails.getLastValuationDate(), apiResponseBean.getLastValuationDate());
Assert.assertEquals("last valuation verification", highLevelDetails.getLastValuationAmount(), apiResponseBean.getLastValuationAmount());
Assert.assertEquals("buy to let verification", highLevelDetails.getBuyToLlet(), apiResponseBean.getBuyToLet());

/*Verification of sub account details*/

sqlList.forEach(sqlSubAccount -> {
SubAccounts apiSubAccount = apiResponseBean.getSubAccount (Integer. parseInt(sqlSubAccount.getSubAccountNumber())) ;
// Assert.assertEquals("sub account sequence number verification” ,sqlSubAccount.getSequenceNumber() ,apiSubAccount.getSequenceNumber());


Assert.assertEquals("current balance verification", sqlSubAccount.getCurrentBalance(), apiSubAccount.getCurrentBalance());
Assert.assertEquals("repayment type verification", sqlSubAccount.getRepaymentType(), apiSubAccount.getRepaymentType());
Assert.assertEquals("interest rate verification", sqlSubAccount.getInterestRate(), apiSubAccount.getInterestRate());
System.out.println("Account Number: " + Integer.parseInt(sqlSubAccount.getSubAccountNumber()) + "-->");
Assert.assertEquals("interest type verification", sqlSubAccount.getInterestType().substring(0, 1), apiSubAccount.getInterestType());



Assert. assertEquals(" interest type description verification", sqlSubAccount. getInterestTypeDescription(). toLowerCase(), parseInterestTypeDescription(apiSubAccount. getInteres
Assert.assertEquals("monthly payment amount verification", sqlSubAccount.getMonthlyPayment(), apiSubAccount.getMonthlyPayment());
Assert.assertEquals("term end date verification", sqlSubAccount.getTermEndDate(), apiSubAccount.getTermEndDate());

});



} catch ( Exception e ) {
LOGGER. error(e.getMessage());
Assert.fail("Database Checks Failed Due To :" + e.getMessage());

}}

public void compareResponses(List<MortgageAccountDetails> sqlList, AccountsSummary apiResponseBean, String intType) {
try {

/*Verification of high level details*/
MortgageAccountDetails highLevelDetails = sqlList.get(0);
Assert.assertEquals("account number verification", highLevelDetails.getAccountNumber(), apiResponseBean.getAccountNumber());
Assert.assertEquals("total balance verification", this.calculateTotalOutstandingBalance(sqlList), apiResponseBean.getTotal0utstandingBalance());
Assert.assertEquals("total monthly payment verification", this.calculateTotalMonthlyPayment(sqlList), apiResponseBean.getMonthlyPayment());
Assert.assertEquals("monthly payment due date verification", highLevelDetails.getMonthlyPaymentDueDate(), apiResponseBean.getMonthlyPaymentDueDate());
Assert.assertEquals("last valuation date verification", highLevelDetails.getLastValuationDate(), apiResponseBean.getLastValuationDate());
Assert.assertEquals("last valuation verification", highLevelDetails.getLastValuationAmount(), apiResponseBean.getLastValuationAmount());
Assert.assertEquals("buy to let verification", highLevelDetails.getBuyToLlet(), apiResponseBean.getBuyToLet());

/*Verification of sub account details*/

sqlList.forEach(sqlSubAccount -> {
SubAccounts apiSubAccount = apiResponseBean.getSubAccount (Integer. parseInt(sqlSubAccount. getSubAccountNumber()))5
//Assert.assertEquals("sub account sequence number verification”, sqlSubAccount.getSequenceNumber() ,apiSubAccount. getSequenceNumber());
Assert.assertEquals("current balance verification", sqlSubAccount.getCurrentBalance(), apiSubAccount.getCurrentBalance());
Assert.assertEquals("repayment type verification", sqlSubAccount.getRepaymentType(), apiSubAccount.getRepaymentType());
Assert.assertEquals("interest rate verification", sqlSubAccount.getInterestRate(), apiSubAccount.getInterestRate());
Assert.assertEquals("interest type verification", intType.substring(0, 1), apiSubAccount.getInterestType());
Assert.assertEquals("interest type description verification", sqlSubAccount.getInterestTypeDescription().toLowerCase(), parseInterestTypeDescription(apiSubAccount.getInteres
Assert.assertEquals("monthly payment amount verification", sqlSubAccount.getMonthlyPayment(), apiSubAccount.getMonthlyPayment());
Assert.assertEquals("term end date verification", sqlSubAccount.getTermEndDate(), apiSubAccount.getTermEndDate());

});

} catch ( Exception e ) {
LOGGER. error(e.getMessage());
//Assert.fail("Database Checks Failed Due To :" + e.getMessage());

}}

	@And("user should get a valid response body with customer details with {} additional borrowers")
	public void verifyCustomerResponse(int additionalBorrowers) {
		this.customerDetails = restClient.mapToBean(CustomerDetails.class, response);

		Assert.assertTrue(!StringUtils.isEmpty(customerDetails.getForename()));
		Assert.assertTrue(!StringUtils.isEmpty(customerDetails.getSurname()));
		customerDetailsMap.put("fname", customerDetails.getForename());
		customerDetailsMap.put("sname", customerDetails.getSurname());
		/*
		 * if (IcustomerDetails.getDateOfBirth().isEmpty() ||
		 * customerDetails.getDateOfBirth() != null) { customerDetailsMap.put("dob",
		 * customerDetails.getDateOfBirth()); } else { customerDetailsMap.put("dob",
		 * “");}
		 */
		try {
			if (!customerDetails.getEmail().isEmpty() || customerDetails.getEmail() != null) {
				customerDetailsMap.put("email", customerDetails.getEmail());
			} else {
				customerDetailsMap.put("email", "");
			}

		} catch (Exception ex) {
			ex.getMessage();
			LOGGER.info("No Email Held");
		}
		try {

			if (!customerDetails.getMobileNumber().isEmpty() || customerDetails.getMobileNumber() != null) {
				customerDetailsMap.put("mobile", customerDetails.getMobileNumber());

			} else {
				customerDetailsMap.put("mobile", "");

			}

		} catch (Exception ex) {
			LOGGER.info("No Mobile Number Exists");
		}

		customerDetailsMap.put("addBorrowers", additionalBorrowers + "");

		Assert.assertTrue(customerDetails.getAdditionalBorrowers().size() == additionalBorrowers);

	}

	@And("user should verify the customer details against database records")
	public void verifyCustomerDetailsAgainstDatabaseRecords() {
		try {
			this.jdbcTemplate = connectionTemplate.getAccountsJDBCTemplateForBrand();
			String sql = FileCopyUtils.copyToString(new InputStreamReader(
					new ClassPathResource("sql\\api\\adbo-queries\\CustomerDetails.sql").getInputStream()));
			LOGGER.info("This is the query:\r\n" + sql);
			customerDetailsList = jdbcTemplate.query(sql, new Object[] { this.accountNumber },
					new CustomerDetailsMapper());
			this.compareResponses(customerDetailsList, customerDetails);
		} catch (Exception e) {
			LOGGER.error("unable to get customer details from database", e);
		}

	}

	public void compareResponses(List<CustomerDetails> sqlList, CustomerDetails apiResponseBean) {

		try {
			/* Nerification of main applicant details */
			CustomerDetails highLevelDetails = sqlList.get(sqlList.size() - 0);
			Assert.assertEquals("Forename verification", highLevelDetails.getForename(), apiResponseBean.getForename());
			Assert.assertEquals("Surname verification", highLevelDetails.getSurname(), apiResponseBean.getSurname());
			try {
				if (!apiResponseBean.getEmail().isEmpty() || apiResponseBean.getEmail() != null) {
					Assert.assertEquals("Email verification", highLevelDetails.getEmail(), apiResponseBean.getEmail());
				}

			} catch (Exception ex) {
				ex.getMessage();
				LOGGER.info("No Email Found");
			}
			try {
				if (!apiResponseBean.getMobileNumber().isEmpty() && highLevelDetails.getMobileNumber() != null
						&& apiResponseBean.getMobileNumber() != null) {
					Assert.assertEquals("Mobile verification", highLevelDetails.getMobileNumber(),
							apiResponseBean.getMobileNumber());
				}

			} catch (Exception ex) {
				ex.getMessage();
				LOGGER.info("No Mobile Phone Found");

			}

			try {

				/* Nerification of additional borrower details */

				if (customerDetails.getAdditionalBorrowers().size() == 1) {
					CustomerDetails additionalBorrowerDetails = sqlLlist.get(0);
					Assert.assertEquals("Forename verification", additionalBorrowerDetails.getForename(),
							apiResponseBean.getAdditionalBorrowers().get(0).getForename());
					Assert.assertEquals("Surname verification", additionalBorrowerDetails.getSurname(),
							apiResponseBean.getAdditionalBorrowers().get(0).getSurname());
					try {

						if (!apiResponseBean.getEmail().isEmpty() || apiResponseBean.getEmail() != null) {
							Assert.assertEquals("Email verification", additionalBorrowerDetails.getEmail(),
									apiResponseBean.getEmail());

						}
					} catch (Exception ex) {
						ex.getMessage();
						LOGGER.info("No Email Found");
					}
				}
			} catch (Exception ex) {
				ex.getMessage();
				LOGGER.info("No Additional Borrower details Found");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
//Assert.fail("Database Checks Failed Due To :"+e.getMessage());
		}
	}

	public String parseInterestTypeDescription(String interestType) {
		String description = "";
		switch (interestType.toLowerCase()) {
		case "f":
			description = "std. rate plus diff. (fixed)";
			break;

		case "v":
			description = "standard rate";
			break;
		case "t":

			description = "std. rate plus differentil";
			break;

		}

		return description;

	}

	public Double calculateTotalOutstandingBalance(List<MortgageAccountDetails> sqlList) {
		AtomicReference<Double> totalOutstandingBalance = new AtomicReference<>(0.0);
		sqlList.forEach(subAccount -> {
			totalOutstandingBalance.getAndUpdate(balance -> balance + subAccount.getCurrentBalance());
		});
		return Math.round(totalOutstandingBalance.get() * 100.0) / 100.0;
	}

	public Double calculateTotalMonthlyPayment(List<MortgageAccountDetails> sqlList) {
		AtomicReference<Double> totalMonthlyPayment = new AtomicReference<>(0.2);
		sqlList.forEach(subAccount -> {
			totalMonthlyPayment.getAndUpdate(balance -> balance + subAccount.getMonthlyPayment());

		});
		return Math.round(totalMonthlyPayment.get() * 100.0) / 100.0;
	}

	@And("user should get a valid error response {} in the response body")
	public void userShouldGetAValidErrorResponseErrorMessageInTheResponseBody(String errorMessage) {
		Assert.assertEquals(errorMessage, response.asString());
	}

	@And("user should get a response containing the holdCode key with value of {}")
	public void userShouldGetAResponseContainingTheHoldCodeKeyWithValueOfHoldCode(String holdCode) {

		this.accountSummary = restClient.mapToBean(AccountsSummary.class, response);

		if (holdCode.equalsIgnoreCase("2ND CHARGE QUEST COMPLETED")) {
			Assert.assertEquals(holdCode, accountSummary.getHoldCodes().getHoldCode().getSCQC());

		}

		if (holdCode.equalsIgnoreCase("RIGHT TO BUY CASE")) {
			Assert.assertEquals(holdCode, accountSummary.getHoldCodes().getHoldCode().getRBC());
		}

		if (holdCode.equalsIgnoreCase("POWER OF ATTORNEY ")) {
		}
	}

	@Given("the user has account number {} and brand {} of the product switcher customer")
	public void userHasTheEndpointOf(String accountNumber, String brand) {
		this.runStep = runOnlyOnDev("dev");
		requestHeaders = new HashMap<>();
		requestHeaders.put("account_number", this.accountNumber = accountNumber);
		requestHeaders.put("brand", this.brand = brand);
//requestHeaders.put("channel", this.channel = “organic");
	}

	@Given("the user has without headers account number and brand")
	public void userHasTheEndpointWithoutHeaders() {
		this.runStep = runOnlyOnDev("dev");
		requestHeaders = new HashMap<>();
		requestHeaders.put("", "");
		requestHeaders.put("", "");
//requestHeaders.put("channel", this.channel = “organic”);

	}

	@And("The Response object should have error {string}")
	public void theResponseObjectShouldHaveError(String errorMessage) {
		Assert.assertEquals("Incorrect validation errorMsg", errorMessage,
				response.body().jsonPath().get("errorMessage"));

	}

}
