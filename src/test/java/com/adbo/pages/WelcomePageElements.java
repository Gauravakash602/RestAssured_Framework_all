package com.adbo.pages;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adbo.World;
import com.adbo.helpers.VisibilityHelper;
import com.adbo.runners.Hook;

import junit.framework.Assert;

@Component
public class WelcomePageElements implements BasePage {

	@Autowired
	private VisibilityHelper visibilityHelper;

	@Autowired
	private Hook hooks;

	@Autowired
	private World world;

	@Value("${nwb.Oracle.driver}")

	public static String Oracledriver;

	@Value("${nwb.Oracle. connection. String}")

	public static String connectionString;

	@Value("${nwb.Oracle.UserName}")

	public static String UserName;

	@Value("${nwb.Oracle.Password}")

	public static String Password;

	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomePageElements.class);
	@FindBy(how = How.XPATH, using = "//h3[contains(., 'How can we help?')]")

	public WebElement label_HowCanWeHelp;

	@FindBy(how = How.XPATH, using = "//h3[contains(., ‘How can we help?*)]//following: :p[1]")

	public WebElement Label_helpInfo;

	@FindBy(how = How.XPATH, using = "//hr[@class='hbo-footer__divider']")

	public WebElement divider_WhitelineBar;

	@FindBy(how = How.XPATH, using = "//p[contains(.,‘@ 2017 - 2021 National Westminster Bank plc’)]")
	public WebElement BottomNotes;
	@FindBy(how = How.XPATH, using = "//p[contains(.,‘@ 2017 - 2021 National Westminster Bank plc’)]")
	public WebElement link_FCFS;
	@FindBy(how = How.XPATH, using = "//a[contains(., 'Privacy & Cookies')]")
	public WebElement Link_PrivacyCookies;

	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")
	public WebElement Link_WebsiteFSCS;

	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")
	public WebElement NatwestLogo;
	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")
	public WebElement header;

	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")
	public WebElement btn_LogOut;
	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")
	public WebElement LogOut_Padlock;

	@FindBy(how = How.XPATH, using = "//a[contains(@href, ‘http: //www.facebook.com/NatWest')]")

	public WebElement link_FB;

	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")

	public WebElement link_Twitter;

	@FindBy(how = How.XPATH, using = "//div[@class='LPMcontainer LPMoverlay']//img[@class='LPMimage' ]")

	public WebElement link_NeedHelp;

	@FindBy(how = How.XPATH, using = "//a[contains(., ‘Website T&Cs & FSCS*)]")

	public WebElement label_chatheader;

	@FindBy(how = How.XPATH, using = "(//div[@aria-label='Chat messages‘ ]//div[contains(., ‘Connected with Cora')])[2]")
	public WebElement label_ConnetcedWithCora;

	@FindBy(how = How.XPATH, using = "//div[@id='lp_line_bubble_3']//div")

	public WebElement Link_Accessibility;

	@FindBy(how = How.XPATH, using = "//div[@id='lp_line_bubble_3']//div")

	private WebElement acceptCookies;

	@FindBy(how = How.XPATH, using = "//div[@class='banner-actions-container' ]//..//..//button[text()='Allow All Cookies']")
	private WebElement acceptCookiesProductSwitcher;

	@FindBy(how = How.XPATH, using = "//div[@id='lp_line_bubble_3']//div")

	public WebElement label_ChatMsg;

	public void acceptCookiesButton() throws Exception {
		hooks.doWait((long) 5000);
		visibilityHelper.waitForVisibilityOf(acceptCookies);
		acceptCookies.click();
		hooks.doWait((long) 5002);

	}

	public void acceptCookiesButtonProductSWitcher() throws Exception {
		try {
			visibilityHelper.waitForVisibilityOf(acceptCookiesProductSwitcher);
			acceptCookiesProductSwitcher.click();
			hooks.doWait((long) 2000);

		} catch (Exception e) {
			visibilityHelper.waitForVisibilityOf(acceptCookies);
			acceptCookies.click();
			hooks.doWait((long) 2000);
		}
	}

	public void fnLinkNewTab(String Link) throws Exception {
		hooks.doWait((long) 5000);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		switch (Link) {
		case "Privacy & Cookies":
			Link_PrivacyCookies.sendKeys(selectLinkOpeninNewTab);
			hooks.doWait((long) 5000);
			LOGGER.info(Link_PrivacyCookies.getText() + " Displayed and clicked");
			break;
		case "Website T&Cs & FSCS":
			Link_WebsiteFSCS.sendKeys(selectLinkOpeninNewTab);
			hooks.doWait((long) 5000);
			LOGGER.info(Link_WebsiteFSCS.getText() + " Displayed and clicked");
			break;
		case "Accessibility":
			Link_Accessibility.sendKeys(selectLinkOpeninNewTab);
			hooks.doWait((long) 5000);
			LOGGER.info(Link_Accessibility.getText() + " Displayed and clicked");
			break;
		}

	}

public void SwitchWindow(Integer Index) {
Set<String> handles = hooks.driver.getWindowHandles();
List<String> ls = new ArrayList<String> (handles) ;
String parenWindowID = ls.get(Index);
hooks .driver. switchTo().window(parenWindowID) ;
LOGGER. info("driver navigated to the window index " + Index);

}

public void getTitle(String ExpectedTitle) {
String title = hooks.driver.getTitle();
Assert.assertEquals(ExpectedTitle, title);
LOGGER. info("Title is displayed as " + title);}

public void FooterMsg(String Msg) throws Exception {
hooks .doWait((long) 2000);
switch (Msg) {

case "How can we help?":
//visibilityHelper .waitForVisibilityOf(label_HowCanwWeHelp) ;
label_HowCanWeHelp.isDisplayed();
String ActText = label_HowCanWeHelp.getText();
LOGGER. info("Footer message displayed as " + ActText);
Assert.assertEquals(Msg, ActText);
break;

case "Call us Mon-Fri, Yam-Spm: 0345 60@ @205":
//visibilityHelper.waitforVisibilityOf(Label_helpInfo);
Label_helpInfo.isDisplayed();
String ActText1 = Label_helpInfo.getText();
Assert.assertEquals(Msg, ActText1);
LOGGER. info("Footer message displayed as " + ActText1);
break;

case "© 2017 - 2021 National Westminster Bank plc":
//visibilityHelper.waitForVisibilityOf(BottomNotes) ;
BottomNotes.isDisplayed();
String ActText3 = BottomNotes.getText();
Assert.assertEquals(Msg, ActText3);
LOGGER.info("Footer message displayed as " + ActText3);



}}



public void FooterMsgNotPresent(String Msg) throws Exception {
hooks .doWait((long) 5000);
switch (Msg) {
case "How can we help?":
List<WebElement> list = hooks.driver.findElements(By.xpath("//*[contains(.,'How can we help?')]"));
System. out.println(list.size());
Assert.assertEquals(0, list.size());
break;
case "Call us Mon-Fri, 9am-Spm: @345 600 0205":
List<WebElement> list1 = hooks.driver.findElements(By.xpath("//*[contains(.,‘Call us Mon-Fri, 9am-Spm: @345 600 @205')]"));
System. out.println(list1.size());
Assert.assertEquals(0, list1.size());
break;

}}

public void WhiteBarDividerNotPresent() throws Exception {

hooks .doWait((long) 5000);
List<WebElement> list3 = hooks.driver.findElements(By.xpath("//*[contains(@class, ‘footer__divider')]"));

System. out.println(list3.size());
Assert.assertEquals(0, list3.size());
}
public void Whitebar() throws MalformedURLException {
//visibilityHelper.waitforVisibilityOf(divider_WhitelineBar) ;
boolean Exptval = true;
Boolean ele = divider_WhitelineBar.isDisplayed();
LOGGER.info("White bar displayed: " + ele);
//Assert.assertEquals(Exptval, ele);



}

public void Logo(String ExpLogo) throws MalformedURLException {
boolean headervale = true;
visibilityHelper.waitForVisibilityOf(NatwestLogo) ;
visibilityHelper.waitForVisibilityOf (header);
boolean ele = header.isDisplayed();


}





public void LogOutbtn(String LogOut) throws MalformedURLException {
	visibilityHelper.waitForVisibilityOf(btn_LogOut) ;

	String Actbtn = btn_LogOut.getText();

	LOGGER.info("Button displayed as: " + Actbtn);
	Assert.assertEquals(LogOut, Actbtn);
	visibilityHelper.waitForVisibilityOf(LogOut_Padlock);
	boolean msg = LogOut_Padlock.isDisplayed();

	LOGGER. info("Logout pad lock symbol got displayed: " + msg);
}



public void pdflinkFCSC() throws Exception {

visibilityHelper.waitForVisibilityOf(link_FCFS);
String linktext = link_FCFS.getText();

System. out.println(linktext) ;
hooks.doWait((long) 500);

//link_FCFS.click();

hooks . javaScriptClick(link_FCFS);

hooks .doWait((long) 10000) ;

LOGGER. info("File downloaded") ;
}
public void readpdfText(String ExpText) throws Exception {

boolean expval = true;

hooks .doWait((long) 2000);

URL url = new URL("file:///C:/Users/kumaphw/Downloads/FSCS_leaflet.pdf");
InputStream is = url.openStream() ;

BufferedInputStream fileparse= new BufferedInputStream(is) ;
PDDocument document = null;

document = PDDocument.load(fileparse) ;

String pdfContent = new PDFTextStripper().getText(document) ;
System. out.println(pdfContent) ;

boolean ele= pdfContent.contains(ExpText) ;
Assert.assertEquals(expval,ele) ;

Assert.assertTrue(ele) ;




LOGGER.info("File downloaded");







}

public void ChatTextVerification(String exptext, String expChatmsg) {
	// TODO Auto-generated method stub
	
}

public void NeedHelp() {
	// TODO Auto-generated method stub
	
}

public void SocialMediaLinks(String link) {
	// TODO Auto-generated method stub
	
}








}