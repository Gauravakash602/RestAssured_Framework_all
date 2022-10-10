package com.adbo.steps.Ui;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adbo.World;
import com.adbo.helpers.ApplicationHelper;
import com.adbo.helpers.DBHelper;
import com.adbo.helpers.ExcelUtility;
import com.adbo.pages.WelcomePageElements;
import com.adbo.runners.Hook;
import com.adbo.steps.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WelcomePageSteps {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(SubAccountModelElements.class) ;

	@Autowired
	private BaseSteps basesteps;

	@Autowired
	private WelcomePageElements WelcomePageElements;

	@Autowired
	private World world;

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

	@Then("^I click on the footer link \"(.*)\" and open in new tab$")
	public void fnLInk(String Link) throws Exception {
		WelcomePageElements.fnLinkNewTab(Link);

	}

	@Then("^I Switch Window at index \"(.*)\"$")
	public void fnwindowsSwitch(Integer index) {
		WelcomePageElements.SwitchWindow(index);

	}

	@Then("^I verify the title as \"(.*)\"$")
	public void fngetTitle(String title) {

		WelcomePageElements.getTitle(title);
	}

	@Then("^I verify the footer message as \"(.*)\"$")
	public void fnFootermsg(String msg) throws Exception {
		WelcomePageElements.FooterMsg(msg);

	}

	@Then("^I verify the footer message \"(.*)\" is not present for unsuccessful token$")
	public void fnFootermsgNotPresent(String msg) throws Exception {

		WelcomePageElements.FooterMsgNotPresent(msg);
	}

	@Then("^I verify the White Bar Divider at footer is not present for unsuccessful token$")
	public void fnlhiteBarDividerNotPresent() throws Exception {

		WelcomePageElements.WhiteBarDividerNotPresent();
	}

	@Then("^I verify White bar at the footer$")

	public void fnFooterwhitebar() throws Exception {
		WelcomePageElements.Whitebar();

	}

	@Then("^I verify logo as \"(.*)\"$")
	public void iVerifyLogoAs(String Logo) throws MalformedURLException {
		WelcomePageElements.Logo(Logo);

	}

	@Then("^I verify LogOut button as \"(.*)\"$")

	public void fnLogoutbutton(String btnLogOut) throws MalformedURLException {
		WelcomePageElements.LogOutbtn(btnLogOut);
	}

	@Then("I verify the FSCS pdf link at the footer and download the file")
	public void iVerifyTheFSCSPdfLinkAtTheFooter() throws Exception {
		WelcomePageElements.pdflinkFCSC();

	}

	@Then("^I verify the pdf content \"(.*)\" from the pdf$")
	public void iVerifyTheContentOfThePdfFile(String text) throws Exception {
		WelcomePageElements.readpdfText(text);

	}

	@Then("^I verify the social link \"(.*)\" is present at the footer$")

	public void iVerifyTheSocialLinkIsPresentAtTheFooter(String link) throws Exception {
		WelcomePageElements.SocialMediaLinks(link);

	}

	@Then("I click on the Need help icon present at the footer and verify the chat header")
	public void iClickOnTheNeedHelpLink() throws Exception {
		WelcomePageElements.NeedHelp();

	}

	@Then("^I verify the text \"(.*)\" from the chat window and verify the \"(.*?)\" Chat msg$")

	public void iVerifyTheTextFromTheChat(String Exptext, String ExpChatmsg) throws Exception {
		WelcomePageElements.ChatTextVerification(Exptext, ExpChatmsg);

	}

	@And("^user is on Welcome page and accept the cookies$")
			public void customerIsOnLumpsumOverPaymentPage() throws Exception {
			WelcomePageElements .acceptCookiesButton();}

	@And("^user is on Welcome page of product switcher and accept the cookies$")
	public void customerIsOnLumpsumOverPaymentPageProductSwitcher() throws Exception {
		WelcomePageElements.acceptCookiesButton();
	}

}
