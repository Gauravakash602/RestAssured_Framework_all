package com.adbo.pages;

import com.adbo.World;

import com.adbo.helpers.VisibilityHelper;

import com.adbo.runners.Hook;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.sql.*;

import java.util.List;

import java.util.Properties;

@Component
public class ProductSwitcher_Organic_Broker_Utilities implements BasePage {

	@Autowired
	private VisibilityHelper visibilityHelper;

	@Autowired
	private Hook hooks;

	@Autowired
	private World world;

	@Value("${nwb.Oracle.driver}")
	public static String OracleDriver;
	@Value("${nwb.Oracle.connection.String}")

	public static String connectionStringPostSwitcher;
	@Value("${nwb.Oracle.UserName}")

	public static String OracleUserNameProductSwitcher;
	@Value("${nwb.Oracle.Password}")

	public static String OraclePasswordProductSwitcher;

	@Value("${start. application. baseUr1}")
	private String productSwitichStarturl;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductSwitcher_Organic_Broker_Utilities.class);
	@FindBy(how = How.XPATH, using = "//*[text()='Loss of protection (.PDF, 33KB)'']")
	public WebElement Link_Pdf_LossOFProtection;

	@FindBy(how = How.XPATH, using = "//p[contains(., ‘Mortgage switching document’ )]")
	public WebElement Link_Pdf_MortgageSwitchingDocs;

	@FindBy(how = How.XPATH, using = "(//div[@class='summary-panel__new-estimated-total-info' ]/following-sibling: :div)[2]")
	public WebElement summaryProductfee;

	@FindBy(how = How.XPATH, using = "(//div[@class='summary-panel__new-estimated-total-details'])[1]")
	public WebElement newEstiatedMonthlypayment;

	@FindBy(how = How.XPATH, using = "//fieldset[@class='mdsp-fieldset’ ]//legend")

	public WebElement optionsProductFeeAdd;

	@FindBy(how = How.XPATH, using = "//fieldset[@class='hbo-fieldset' ]//legend")

	public WebElement optionsProductFeeAddBroker;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), ‘Show me mortgage deals’)]")
	public WebElement btn_ShowMortgageDeal;

	@FindBy(how = How.XPATH, using = "(//span[@class='checkbox-button_button'])[1]")
	public WebElement Choose_deal;

	@FindBy(how = How.XPATH, using = "//div[@class='product']//span[contains(., ‘Product fee’) ]/span//following: : span[1]")
	public WebElement ChooseealWithoutProductFee;

	@FindBy(how = How.XPATH, using = "//div[@class='product' ]//span[2][contains(.,'3.14')]")
	public WebElement InitialIntrestRate;

	@FindBy(how = How.XPATH, using = "//fieldset//input[@id='upfront*]")
	public WebElement Radio_FeeUpfront;

	@FindBy(how = How.XPATH, using = "//p[contains(.,'If your client wants to pay upfront, they will make payment when they agree to the product switch.')]")
	public WebElement Msg_Upfront;

	@FindBy(how = How.XPATH, using = "//fieldset//input[@id='addToMortgage']")
	public WebElement Radio_addToMortgage;

	@FindBy(how = How.XPATH, using = "//div[@id='root']//button[@type='button' or @class='mdsp-button mdsp-button--primary '][contains(text(), 'Continue')]")
	public WebElement btn_MortgageDEalContinue;

	@FindBy(how = How.XPATH, using = "(//section)[1]//p[@class='mdsp-get-in-touch__paragraph--small*]")
	public WebElement stpverifictaipn; //

	@FindBy(how = How.XPATH, using = "//input[@value='Yes']/..//input")
	public WebElement yesCheckbox;

	@FindBy(how = How.XPATH, using = "(//input[@value='Yes']/..//input)[2]")
	public WebElement yesCheckboxConfirm;

	@FindBy(how = How.XPATH, using = "//p[contains(.,'Sorry, you need to add more sub-accounts so that you switch £10,000 or more')]")
	public WebElement pageerror;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	public WebElement continueRepaymnet;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Within 24 ')]")
	public WebElement stpverifictaipnbroker;

	@FindBy(how = How.XPATH, using = "(//div[@class='hbo-page-title’ ]/following: :p)[1]")
	public WebElement cancelpaymentStatus;

	@FindBy(how = How.XPATH, using = "//p[@id='resultText']")
	public WebElement paymentDecline;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='select to go to next page’ ][contains(.,'Continue')]")
	public WebElement btnContinue;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	public WebElement btnContinueafterPayment;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='select to go to next page' ][contains(.,'Confirm')]")
	public WebElement btnConfirm;

	@FindBy(how = How.XPATH, using = "//button[contains(.,‘get started')]")
	public WebElement btnLletsGetStarted;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'View')]")
	public WebElement btnViewMortgageDeals;

	@FindBy(how = How.XPATH, using = "//button[contains(., 'My client')]")
	public WebElement btn_MyClientsWantThisDeal;

	@FindBy(how = How.XPATH, using = "//button[@type='button']//..//button[text()='Cancel your switch'] ")
	public WebElement getBtn_CancelSwitch;

	@FindBy(how = How.XPATH, using = "//button[@type='button']//..//button[text()='Cancel this switch']")
	public WebElement getBtn_CancelSwitchBroker;

	@FindBy(how = How.XPATH, using = "//button[contains(., 'My client')]")
	public WebElement btn_MyClientWantsThisDeal;

	@FindBy(how = How.XPATH, using = "//button[@type='button'][contains(.,'Close')]")
	public WebElement Close_Button;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Continue button‘ ][contains(., 'Continue')]")
	public WebElement Continue_Button;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Choose a new mortgage deal')]")
	public WebElement Header_ChooseNewMortgageDeal;

	@FindBy(how = How.XPATH, using = "//input[contains(@id, '1-email')]")
	public WebElement Input_yourEmailAddress;

	@FindBy(how = How.XPATH, using = "//input[contains(@id, '1-confirm-email')]")
	public WebElement Input_ConfirmyourEmailAddress;

	@FindBy(how = How.XPATH, using = "//input[contains(@id, '2-email')]")
	public WebElement Input_KPHHRPEmailAddress;

	@FindBy(how = How.XPATH, using = "//input[contains(@id, '2-confirm-email')]")
	public WebElement Input_ConfirmKPHHRPEmailAddress;

	@FindBy(how = How.XPATH, using = "//button[contains(., 'want this deal')]")
	public WebElement btn_WantThisDeal;

	@FindBy(how = How.ID, using = "//*[@id='root']/div/main/section/div[4]/div/button")
	public WebElement btn_Continue;

	@FindBy(how = How.XPATH, using = "//hi[contains(., 'Read about our mortgage range')]")
	public WebElement heading_MortgageRange;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement heading_WeWillGetInTouch;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement PageHeader;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue]")
	public WebElement continuetostp;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'Within 3 working days')]")
	public WebElement stptoNonSTp;
	@FindBy(how = How.XPATH, using = "//h1//strong")

	public WebElement applcnInprogres;

	@FindBy(how = How.XPATH, using = "(//section[@class='zb-notification-body']//p)[last()]")
	public WebElement errorforRepayment;

	@FindBy(how = How.XPATH, using = "(//div[@class='zb-notification-inner' ]//p)[1]")
	public WebElement arrearInelegiblemsg;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement minimumPageHeader;

	@FindBy(how = How.XPATH, using = "//*[@class='zb-list hbo-custom-status-code__list']//*[contains(text(), ‘Eligible sub ‘)]")
	public WebElement eligiblityCheckstatus;
	@FindBy(how = How.XPATH, using = "//h2")

	public WebElement unableToCancel;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), ‘Please ask your’)]")
	public WebElement clientAskMesssage;

	@FindBy(how = How.XPATH, using = "//button[text()='Next']")
	public WebElement NextBUtton;

	@FindBy(how = How.XPATH, using = "(//button[text()='Close'])[last()]")
	public WebElement unableToCancelClosePopup;
	@FindBy(how = How.XPATH, using = "//h1//..//strong ")
	public WebElement pageCancelPage;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'To cancel your')]")
	public WebElement toCancelmsg;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Or get in touch to cancel:')]")
	public WebElement getIntouchCancel;

	@FindBy(how = How.XPATH, using = "//h1//strong")
	public WebElement overToYourClinet;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Continue button‘ ][contains(., ‘Continue’ )]")
	public WebElement continueToLast;

	@FindBy(how = How.XPATH, using = "//legend")
	public WebElement verifyOptions;

	@FindBy(how = How.XPATH, using = "//*[text()='No sub-account selected']")
	public WebElement noSelectiondealerror;

	@FindBy(how = How.XPATH, using = "//section[@class='zb-notification-body']//p")
	public WebElement noSelectionofproductfee;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Please tell us how your client wants to pay your')]")
	public WebElement noSelectionofproductfeeBroker;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), ‘Paslease provide ‘)]")
	public WebElement emailerror;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), ‘Please provide ‘)]")
	public WebElement emailerrorBrokerPAGE;
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Please enter')]")
	public WebElement phoneNoerrorBroker;

	@FindBy(how = How.XPATH, using = "(//section[@class='zb-notification-body']//..//p)[1ast()]")
	public WebElement noselectionLevelofService;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Please tell us if you are charging’)]")
	public WebElement charginFeeerror;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Please provide the amount of yo')]")
	public WebElement amountFeeError;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘No')]//input[@name='directIntroducerFee’]")
	public WebElement Rdo_DirIntroFee_No;

	@FindBy(how = How.XPATH, using = "//button[contains(., ‘Continue’)]")
	public WebElement contiueforérror;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Please tell us which sub-account')]")
	public WebElement errorfornoseelctionofproductfeebroker;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue’ ]")
	public WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement lastPage;

	@FindBy(how = How.XPATH, using = "//*//*[text()='New interest rate’]//..//p")
	public WebElement intrestRateCheckUrdetail;
	@FindBy(how = How.XPATH, using = "(//div[text()='New interest rate' ]//..//div[@class='selected-sub-account__content-details'])[last()]")

	public WebElement bewINtrestRateBrokerPage;

	@FindBy(how = How.XPATH, using = "//div[@class='summary-panel__new-estimated-total-check-your-details' ]//div[@class='summary-panel__new-estimated-total-check-your-details-details’]")
	public WebElement newUpdatePAyment;

	@FindBy(how = How.XPATH, using = "(//button[text()='Continue'])[2]")
	public WebElement ctnBtnCheckboxNoneSelection;

	@FindBy(how = How.XPATH, using = "//input[@class='hbo-input__element']")
	public WebElement inputTextForOtherSelection;

	@FindBy(how = How.XPATH, using = "//input[@value='Yes']")
	public WebElement ctnBtnCheckboxNoneYesSelection;

	@FindBy(how = How.XPATH, using = "//*[text()='Product fee']//..//p")
	public WebElement newlyupdatedProductfee;

	@FindBy(how = How.XPATH, using = "(//div[text()='Product fee'])[1]/following-sibling: :div")
	public WebElement newlyupdatedProductfeeBroker;

	@FindBy(how = How.XPATH, using = "//h1//following: :p[1]")
	public WebElement InflightpageMessage;

	@FindBy(how = How.XPATH, using = "//h1[contains(.,'Just one more thing..')]")
	public WebElement heading_Justonemorething;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement heading_LoggedOutSuccessfully;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement heading_Its_Over;

	@FindBy(how = How.XPATH, using = "//p[contains(text(), ‘Thanks for using our service.')]")
	public WebElement heading_ThanksforService;

	@FindBy(how = How.XPATH, using = "//h1[contains(.,‘Check your details’)]")
	public WebElement heading_CheckUrDetails;

	@FindBy(how = How.XPATH, using = "//h1[contains(.,'Choose a new mortgage deal')]")
	public WebElement heading_ChooseDealPage;

	@FindBy(how = How.XPATH, using = "//*[text()='Mortgage - Important information about our mortgage range (.PDF, 144KB)']")
	public WebElement Link_Pdf_MortgageFile;

	@FindBy(how = How.ID, using = "//*[@id='root' ]/div/main/section/div[2]/div/button")
	public WebElement btn_MortgageRangeContinue;

	@FindBy(how = How.XPATH, using = "//a[@arial-label='click to download a document with important information about our mortgage range' ]")
	public WebElement Ink_downloadDocsWithInfo;

	@FindBy(how = How.CSS, using = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement acceptCookies;

	@FindBy(how = How.XPATH, using = "//div[text()='Your client's contact telephone number']")
	public WebElement ParaClientTe1Num;

	@FindBy(how = How.XPATH, using = "//label[text()='Country code']//following: :input[@type='tel'][1]")
	public WebElement InputBox_CCode;

	@FindBy(how = How.XPATH, using = "//p[contains(.,'Country code is invalid')]")
	public WebElement errorMsg_CountryCode;

	@FindBy(how = How.XPATH, using = "//p[contains(.,‘Please enter a valid contact telephone number (Min length 11 digits). Please do not include special characters and letters.')]")
	public WebElement errorMsg_TelNo;

	@FindBy(how = How.XPATH, using = "//label[text()='Number ]//following: :input[@type='tel'][1]")
	public WebElement Input_CountryNum;

	@FindBy(how = How.XPATH, using = "(//input[@type='radio'][@name='levelsOfService’])[1]")
	public WebElement RdoBtn_ADVISED;

	@FindBy(how = How.XPATH, using = "(//input[@type=' radio' ][@name='levelsOfService’])[2]")
	public WebElement RdoBtn_EXECUTION_ONLY;

	@FindBy(how = How.XPATH, using = "(//input[@type='radio' ][@name='levelsOfService'])[3]")
	public WebElement RdoBtn_REJECTED_ADVICE;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘Yes‘)]//input[@name='directIntroducerfee']")
	public WebElement Rdo_DirIntroFee_Yes;

	@FindBy(how = How.XPATH, using = "//input[@name='directIntroducerfee' ][@type='text']")

	public WebElement Input_DirIntoFee;

	@FindBy(how = How.XPATH, using = "//legend[contains(.,'Can you confirm this is their repayment strategy?')]//following::input[@value='No']")
	public WebElement Rdo_RepayStrategyYes;

	@FindBy(how = How.XPATH, using = "//legend[contains(.,‘Can you confirm this is their repayment strategy?')]//following: :input[@value='No']")
	public WebElement Rdo_RepayStrategyNo;

	@FindBy(how = How.XPATH, using = "//legend[contains(.,'Are they confident that they can repay their mortgage balance at the end of the current term?')]//following::input[@value='Yes']")
	public WebElement Rdo_ConfirmRepayNo;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘agree with this declaration’)]")
	public WebElement Check_declaration;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘agree with this declaration’)]")
	public WebElement Check_declaration_Solo;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘What next?*)]")
	public WebElement heading_Next;

	@FindBy(how = How.XPATH, using = "//section)[1]//p")
	public WebElement TotalPara;

	@FindBy(how = How.XPATH, using = "(//span[contains(., 'Payment details')])[1]")
	public WebElement labe_paymentDetails;

	@FindBy(how = How.XPATH, using = "//input[@id='cardNumber’ and @name='cardNumber' ]")
	public WebElement input_CardNumber;

	@FindBy(how = How.XPATH, using = "//iframe[@title='Payment Pages’]")
	public WebElement frameCardPayment;

	@FindBy(how = How.XPATH, using = "//input[@id='cardholderName' and @name='cardholderName' ]")
	public WebElement input_CardholderName;

	@FindBy(how = How.XPATH, using = "//input[@id='expiryMonth' and @placeholder='MM']")

	public WebElement input_ExpiryMonth;

	@FindBy(how = How.XPATH, using = "//input[@id='expiryYear’ and @placeholder='YY']")

	public WebElement input_ExpiryYear;

	@FindBy(how = How.XPATH, using = "//input[@id='expiryYear’ and @placeholder='YY']")

	public WebElement input_SecurityCode;

	@FindBy(how = How.XPATH, using = "//input[@id='expiryYear’ and @placeholder='YY']")

	public WebElement btn_makepayment;

	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	public WebElement btn_makepaymentCancel;

	@FindBy(how = How.LINK_TEXT, using = "Yes")
	public WebElement btn_makepaymentCancelYes;

	@FindBy(how = How.LINK_TEXT, using = "Yes")
	public WebElement btn_makepaymentCancelNo;

	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	public WebElement continuePaymentaftercancel;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘How will they repay their mortgage?')]")
	public WebElement label_RepaymentMortgage;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘How will they repay their mortgage?')]//following: :label[contains(., ‘Endowment Policy’)]")
	public WebElement CheckboxRepay_EndowmentPolicy;

	@FindBy(how = How.XPATH, using = "//h2[contains(.,'‘How will they repay their mortgage?')]//following: :label[contains(.,‘Other’)]")
	public WebElement CheckboxRepay_Other;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘How will they repay their mortgage?‘)]//following: :label[contains(.,‘None’)]")
	public WebElement CheckboxRepay_None;

	@FindBy(how = How.XPATH, using = "//input[@name='otherDescription’ ]")

	public WebElement InputBox_RepayOther;

	@FindBy(how = How.XPATH, using = "//h2[contains(.,'‘How will they repay their mortgage?')]//following: :label[contains(.,‘Savings')]")

	public WebElement CheckboxRepay_Savings;

	@FindBy(how = How.XPATH, using = "//legend[contains(.,‘Are they confident that they can repay their mortgage balance at the end of the current term?')]//following: :input[@value='Yes']")
	public WebElement Radiobtn_AreTheyConfident_Yes;

	@FindBy(how = How.XPATH, using = "//legend[contains(.,‘Are they confident that they can repay their mortgage balance at the end of the current term?')]//following: : input[@value='No']")
	public WebElement Radiobtn_AreTheyConfident_No;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘Interest only mortgage balance')]")

	public WebElement PopUp_Header;

	@FindBy(how = How.XPATH, using = "//p[contains(.,‘You have told us your client is not confident that their repayment strategy will enable repayment of their Virerese only mortgage.']")
	public WebElement PopUpparal_InterestOnly;

	@FindBy(how = How.XPATH, using = "//p[contains(.,‘Please remind them they need a plan in place to repay the mortgage balance at the end of the term.‘)]")

	public WebElement PopUpparal_InterestOnly1;

	@FindBy(how = How.XPATH, using = "//p[contaips(.,‘Please remind them they need a plan in place to repay the mortgage balance at the end of the term.*)]")
	public WebElement PopUppara2_InterestOnly;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Close Interest only mortgage balance’ ]")

	public WebElement PopUpCrossClose_InterestOnly;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘Interest only mortgage balance’ )]//following: : section//button[contains(.,‘Continue')]")

	public WebElement PopUpContinuebtn_InterestOnly;

	@FindBy(how = How.XPATH, using = "//h2[contains(., ‘Interest only mortgage balance’ )]//following: : section//button[contains(.,‘Close’)]")

	public WebElement PopUpClosebtn_InterestOnly;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, ‘summary-panel_')][contains(., ‘Product fee’)])[2]//following: :div[1]")
	public WebElement lable_Productfee;

	@FindBy(how = How.XPATH, using = "//button[text()='No thanks‘ ]")
	public WebElement feedbacKNothanks;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘Journey')]//following: :span[contains(.,‘Product switch’)]")
	public WebElement Rdo_productSwitch;

	@FindBy(how = How.XPATH, using = "//label[contains(., ‘Journey’)]//following: :span[contains(.,‘Acquisition’)]")
	public WebElement Rdo_Acquisition;

	@FindBy(how = How.XPATH, using = "//span[contains(.,‘Channel')]//following::span[contains(., ‘Organic’)]")

	public WebElement Rdo_Organic;

	@FindBy(how = How.XPATH, using = "//span[contains(.,‘Channel')]//following: :span[contains(.,‘Broker’)]")

	public WebElement Rdo_Broker;

	@FindBy(how = How.XPATH, using = "//span[contains(., ‘Brand')]//following: :span[contains(., ‘NatWest')]")

	public WebElement Rdo_Natwest;

	@FindBy(how = How.XPATH, using = "//span[contains(., ‘Environment’ )]//following::span[contains(.,‘SIT‘)]")

	public WebElement Rdo_SIT;

	@FindBy(how = How.XPATH, using = "//label[contains(., ‘Customer Identification Number (CIN)*)]//following: :input[1]")
	public WebElement InputboxCin;

	@FindBy(how = How.XPATH, using = "//label[contains(., ‘Account number')]//following: :input[1]")

	public WebElement Inputbox_AccountNo;

	@FindBy(how = How.XPATH, using = "//details[conteins(., ‘Broker details')]")
	public WebElement Marker_brokerdetails;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘Postcode')]//following: :input[1]")
	public WebElement Inputbox_postcode;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘FCA Reference’ )]//following: :input[1]")

	public WebElement Inputbox_postcode1;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘FCA Reference’) ]//following: :input[1]")
	public WebElement Inputbox_FCARef;

	@FindBy(how = How.XPATH, using = "//label[contains(.,‘Firm name')]//following: :input[1]")
	public WebElement Inputbox_Firmname;

	@FindBy(how = How.XPATH, using = "//label[contains(., ‘Network info')]//following: :input[1]")
	public WebElement Inputbox_NetworkInfo;

	@FindBy(how = How.XPATH, using = "//button[contains(., ‘Generate token')]")

	public WebElement btn_GenerateToken;

	@FindBy(how = How.XPATH, using = "//h3[contains(., ‘Success')]//following: :a[1]")
	public WebElement link_url;

//Cancel Switch 74

	@FindBy(how = How.XPATH, using = "//button[contains(., ‘Cancel your switch')]")
	public WebElement btn_CancelSwitch;

	@FindBy(how = How.XPATH, using = "//button[contains(.,‘Cancel your switch’)])[2]")
	public WebElement btn_CancelSwitchPopUp;

	public void fnChooseDeals(String IntRate, String Productfee) throws Exception {

		hooks.doWait((long) 5000);
		List<WebElement> totalsubaccounts = hooks.driver.findElements(By.xpath("//div[@class=' sub-account' ]"));
		int NoOfSubtaccount = totalsubaccounts.size();
		for (int i = 1; i <= NoOfSubtaccount; i++) {
			hooks.doWait((long) 3000);
			String xpathParm = "(//span//following::span[text()='" + IntRate + "']//following::span[contains(.,'"
					+ Productfee + "')]//following::span[@class='checkbox'])[" + i + "]";
			By xpath = By.xpath(xpathParm);
			visibilityHelper.waitForPresenceOf(xpath);
			WebElement element = hooks.getDriver().findElement(xpath);
			element.click();
			LOGGER.info("Deal selected with the deatils: “+ “Interest Rate: " + IntRate + " and product fee: "
					+ Productfee);
		}
	}

	public void stptoNonStpPagePageHeading(String heading) {
		// TODO Auto-generated method stub
		System.out.println("dfdfd");
	}

	public void fnClickOnButtonProductSwitcher(String button) {
		// TODO Auto-generated method stub
		System.out.println("dfd");
	}

	public void fnEnvironmentSelections(String Journey, String Channel, String Brand, String Environment, String Cin,
			String AccountNum, String S1S2, String FieldtoUpdate) throws Exception {
		hooks.doWait((long) 500);
		hooks.driver
				.findElement(
						By.xpath("//label[contains(., 'Journey')]//following: :span[contains(.,'" + Journey + "')]"))
				.click();
		hooks.doWait((long) 2000);
		hooks.driver
				.findElement(By.xpath("//span[contains(., 'Channel')]//following::span[contains(.,'" + Channel + "')]"))
				.click();
		hooks.doWait((long) 2000);
		hooks.driver
				.findElement(By.xpath("//span[contains(., ‘Channel')]//following: :span[contains(.,'" + Brand + "')]"))
				.click();
		hooks.doWait((long) 2000);
		hooks.driver
				.findElement(By
						.xpath("//span[ contains(., ‘Channel')]//following:: span[contains(.,'" + Environment + "')]"))
				.click();
		hooks.doWait((long) 2000);
		InputboxCin.sendKeys(Cin);
		hooks.doWait((long) 2000);
		Inputbox_AccountNo.sendKeys(AccountNum);
		hooks.doWait((long) 2000);
//Source 1 and source 2 validation
		if (S1S2.equals("Yes")) {

			hooks.doWait((long) 5000);

			Marker_brokerdetails.click();

			hooks.doWait((long) 2000);

			String inputtext = hooks.driver
					.findElement(By.xpath("//label[contains(.,'" + FieldtoUpdate + "')]//following: :input[1]"))
					.getAttribute("value");

			if (inputtext != null) {

				for (int i = 0; i < inputtext.length(); i++) {
					hooks.driver
							.findElement(By.xpath("//label[contains(.,'" + FieldtoUpdate + "')]//following: :input[1]"))
							.sendKeys(Keys.BACK_SPACE);
				}
			}

			hooks.doWait((long) 5000);
			hooks.driver.findElement(By.xpath("//label[contains(.,'" + FieldtoUpdate + "')]//following: :input[1]"))
					.sendKeys("test1");
			hooks.doWait((long) 500);

		}
		btn_GenerateToken.click();

		hooks.doWait((long) 5000);

		String urltolaunch = link_url.getText();
		System.out.println(urltolaunch);

		hooks.driver.navigate().to(urltolaunch);
		hooks.doWait((long) 5000);

	}

}