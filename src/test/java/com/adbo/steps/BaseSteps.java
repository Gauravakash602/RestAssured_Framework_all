package com.adbo.steps;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.adbo.World;
import com.adbo.domain.dto.adbo_coordinator.TestDataDto;
import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;
import com.adbo.helpers.ApplicationHelper;
import com.adbo.helpers.ExcelUtility;
import com.adbo.pages.BasePage;
import com.adbo.runners.Hook;
import com.google.common.base.Predicate;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseSteps {

	/*
	 * Logger
	 * 
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseSteps.class);

	private static final String usersTypeTagRegexp = "@\\b(\\w*test\\w*)\\b";

	@Autowired
	private Hook hooks;

	@Autowired
	private World world;

//@Autowired
//private List<BasePage> pages;

	@Autowired
	private AuthenticationRequestDto authenticationRequestDto;

	@Autowired
	private ApplicationHelper applicationHelper;

	@Autowired
	private List<BasePage> pages;

	@Autowired
	private ExcelUtility testData;

	@Value("${rbs.browser}")
	private String browser;

	@Value("${spring.profiles.active:}")
	private String activeProfile;

	Predicate<String> dataTagPredicate = (String tag) -> {

		return tag.contains("overpayment") || tag.contains("deceased") || tag.contains("missedpymt")
				|| tag.contains("manualpymt");

	};

	/*
	 * @AfterStep(value = "not @api-test”) public void logScreenshot(Scenario
	 * scenario) throws IOException { if(hooks.getDriver()!=null) { File src =
	 * ((TakesScreenshot) hooks.getDriver()) .getScreenshotAs(OutputType. FILE);
	 * byte[] arr = FileUtils.readFileToByteArray(src); scenario.attach(arr,
	 * “image/png”, screenshot");
	 * 
	 * 
	 * 
	 * }
	 */

	@Before(order = 1)
	public void logBeforeScenario(final Scenario scenario) {
		LOGGER.debug(StringUtils.rightPad("Starting scenario:", 20) + "[{}] - [{}]", getFeatureName(scenario),
				scenario.getName());
		world.scenario = scenario;

	}

//@Before(order = 4,value = “@getopdata or @nmpdata and not @api-test")
/*@Before(order = 4,value = "@ui-test and not @api-test")
public void initializeDriver(Scenario scenario) throws IOException {
tokenInit(scenario);
final WebDriver driver = hooks.getDriver();
//Intialize all page elements
pages. stream().forEach(p -> {
initElements(driver, p);
});
}*/
	@Before(order = 4, value = "@getopdata or @mmpdata")
	public void apiInitializer(Scenario scenario) throws Exception {
		System.setProperty("${spring.profiles.active:}", "uat");// Inserted for debugging
		activeProfile = getActiveProfile();
		if (activeProfile.toLowerCase().contains("uat")) {
			LOGGER.info("Running tokenInit since we are on UAT");
			tokenInit(scenario);

		}

		/*
		 * else if(getTestEnvironment().length()>@ &&
		 * getTestEnvironment().toLowerCase().contains("uat")){ LOGGER.
		 * info("Running tokenInit since we are on UAT");
		 * 
		 * tokenInit(scenario) ; }
		 */
		else {
			LOGGER.info("Not running tokenInit since we are not on uat");
		}
	}

	@Before(order = 5, value = "@UI")

	public void initializeDriver() throws MalformedURLException {
		final WebDriver driver = hooks.getDriver();
//Intialize all page elements
		pages.stream().forEach(p -> {
			initElements(driver, p);
		});
	}

	/*
	 * This method handles the differences of retrieving activeProfile when running
	 * in debug mode versus running a maven goal
	 * 
	 * @return activeProfile
	 * 
	 * @author Reggy Williams
	 */

	private String getActiveProfile() {
		String sActiveProfile = System.getProperty("${spring.profiles.active:}");
		if (sActiveProfile == null || sActiveProfile.isEmpty()) {
			sActiveProfile = System.getProperty("spring.profiles.active");
			LOGGER.info("PARAMETER 2 = " + sActiveProfile);
		}
		return sActiveProfile;
	}
	/*
	 * public String getActiveProfiles(){ activeProfile = System.
	 * getProperty("${spring.profiles.active:}");
	 * LOGGER.info("Current active profile - " + activeProfile);
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * 
	 * @Value("${testenvironment}") private String testEnvironment=""; private
	 * String getTestEnvironment(){ if(testEnvironment.length()>0) { LOGGER.
	 * info("Current test environment: - " + testEnvironment);
	 * 
	 * }
	 * 
	 * return testEnvironment;
	 * 
	 * }
	 */

	@Before(order = 2)
	public void initializeBrand(Scenario scenario) throws Exception {
		try {
			world.brand = scenario.getSourceTagNames().stream().filter(tag -> tag.equals("@rbs") || tag.equals("@UI")
					|| tag.equals("@nwbdevorganic") || tag.equals("@nwb")).findFirst().get().replace("@", "");
		} catch (Exception e) {
			throw new Exception("Brand not specified for the scenario -> " + scenario.getName());

		}
	}

	@Before(order = 3, value = "@getopdata or @mmpdata or @getExcelData")
	public void initializelNwbData(Scenario scenario) throws IOException {
		try {
			ClassLoader loader = getClass().getClassLoader();
			String dataTypeTag = scenario.getSourceTagNames().stream().filter(dataTagPredicate).findFirst().get();
			dataTypeTag = dataTypeTag.replace("@", "@" + world.brand);
			System.out.println("Data tag value is : " + dataTypeTag);
			world.dataTypeTag = dataTypeTag;
			if (dataTypeTag.contains("overpayment")) {
				world.testDataDto = (TestDataDto) applicationHelper.getTestDataObject("overpaymentdata")
						.get(dataTypeTag);
			} else if (dataTypeTag.contains("missedpymt") || dataTypeTag.contains("manualpymt")) {
				world.testDataDto = (TestDataDto) applicationHelper.getTestDataObject("mmpdata").get(dataTypeTag);
			}
			world.setIsExcelDataNeeded(true);
		} catch (Exception e) {
			ClassLoader loader = getClass().getClassLoader();

			String dataTypeTag = scenario.getSourceTagNames().stream()
					.filter(tag -> tag.contains("Regression") || tag.contains("HeaderAndFooter")).findFirst().get();
			world.searchValue = testData.mortgagePaymentTestData(dataTypeTag);

		}
	}

	@After(order = 1, value = "not @api-test")

	public void closeDriver(final Scenario scenario) {
		hooks.tearDown(scenario);
		hooks.closeDriver();

	}

	@After(order = Integer.MAX_VALUE)
	public void logAfterScenario(final Scenario scenario) {
		LOGGER.debug(StringUtils.rightPad("Finished scenario:", 20) + "[{}] - [{}] [{}]", getFeatureName(scenario),
				scenario.getName(), scenario.getStatus());

	}

	@AfterStep(value = "not @api-test")
	public void logScreenshot(Scenario scenario) throws IOException {
		if (hooks.getDriver() != null) {
			File src = ((TakesScreenshot) hooks.getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] arr = FileUtils.readFileToByteArray(src);
			scenario.attach(arr, "image/png", "screenshot");
		}
	}

	private String getFeatureName(Scenario scenario) {
		String featureName = scenario.getId();
		featureName = StringUtils.substringBeforeLast(featureName, ". feature");
		featureName = StringUtils.substringAfterLast(featureName, "/");
		return featureName;

	}

	private void tokenInit(Scenario scenario) throws IOException {
		authenticationRequestDto.setAccountNumber(world.testDataDto.getAccountNumber());
		authenticationRequestDto.setCin(world.testDataDto.getCinNumber());
		world.accessToken = applicationHelper.getToken(authenticationRequestDto);

	}

//Monica trial and error
//ProxySpecification proxySpecification= new ProxySpecification("userproxy.rbsgrp.net”,8080, "http", "natarmh", "Eadduddav1") ;
//proxySpecification.withAuth(“natarmh”, “Eadduddav1")

}