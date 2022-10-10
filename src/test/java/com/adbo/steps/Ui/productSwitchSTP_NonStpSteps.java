package com.adbo.steps.Ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adbo.World;
import com.adbo.helpers.ApplicationHelper;
import com.adbo.helpers.DBHelper;
import com.adbo.helpers.ExcelUtility;
import com.adbo.pages.ProductSwitcher_Organic_Broker_Utilities;
import com.adbo.runners.Hook;

import io.cucumber.java.en.Then;

public class productSwitchSTP_NonStpSteps {
/* @Autowired
private BaseSteps UI basesteps;*/

@Autowired
private com.adbo.steps.BaseSteps basestep;

@Autowired
private World world;

@Autowired
private ProductSwitcher_Organic_Broker_Utilities  ProductSwitcher_Organic_Broker_Utilities;

@Autowired
private Hook hooks;

@Autowired
private DBHelper dbHelper;

@Autowired
private ExcelUtility testData;

@Autowired
private ApplicationHelper appHelp;

private List<String> infoTiplist;

private List<String> amentModelPopUpText;




//skelton method
@Then("User verify the page message {string}")
public void userVerifyThePageMessage(String heading) throws Exception {
ProductSwitcher_Organic_Broker_Utilities.stptoNonStpPagePageHeading(heading) ;
}

//skelton method
@Then("User click on the button cancel {string}")
public void userClickOnTheButtonCancel(String button) throws Exception {

ProductSwitcher_Organic_Broker_Utilities. fnClickOnButtonProductSwitcher (button) ;

}

//skelton method
@Then("I generate the token with journey as {string},channel as {string}, Brand as {string}, Environment as {string} with account {string} and cin {string} with S1S2 validation {string} with updated field {string}")
public void iGenerateTheTokenWithJourneyAsChannelAsBrandAsEnvironmentAsWithAccountAndCin(String Journey, String Channel, String Brand, String Environment, String Cin, String AccountNum,String S1S2, String FieldToUpdate) throws Exception {
ProductSwitcher_Organic_Broker_Utilities.fnEnvironmentSelections(Journey, Channel, Brand, Environment, AccountNum, Cin, S1S2, FieldToUpdate) ;

}}
