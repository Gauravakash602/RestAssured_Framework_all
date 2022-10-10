package com.adbo.helpers;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.openqa.selenium.*;
import com.adbo.runners.Hook;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Component
public class VisibilityHelper {

@Autowired
private Hook hooks;

WebDriver driver;

/**
 * wait unitl
 * @param locater
 * @throws MalformedURLException
 */

public void waitForVisibilityOf(WebElement element) throws MalformedURLException {
  hooks.getWait().until(waitForVisibilityOf(element));
 

}

public void waitUntilTheFrameIsVisibleAndSwitch(WebElement element) throws MalformedURLException {
hooks.getWait().until(frameToBeAvailableAndSwitchToIt(element)) ;
}

/*
 * frame
 */
public void waitUntilElementIsNotVisible(By locater) throws MalformedURLException {
hooks. getWait().until(invisibilityOfElementLocated(locater)) ;
}






/*
* Wait until the element is clickable
* @param element
* @throws MalformedURLException
*/

public void waitFor£lementTobeClickable(WebElement element) throws MalformedURLException {
hooks.getWait().until(elementToBeClickable(element));
}


/* Method to find the element is visible on the page
* @param element
* @return
*/
public Boolean IsElementVisible(WebElement element) {
try {
return element. isDisplayed();
} catch (NoSuchElementException e) {
return false;
}

}

/* Waits for presence and visibility of the element matched by given selector.
* The element can be present in the DOM or not before the waiting starts

.

* @param by Selector of the element

*/






/* Waits for presence and visibility of the element matched by given selector.
* The element can be present in the DOM or not before the waiting starts
*
*/ 

public void waitForPresenceOf(By by) throws MalformedURLException {
hooks .getWait().until(visibilityOfElementLocated(by));
}

/* Waits for the page load.

*
*
x
*/
public void waitForPageLoad() throws MalformedURLException {
new WebDriverWait(getWebDriver(), 30).until(
webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

}

public void waitUntilTheTextIsPresent(String text) throws MalformedURLException {
By by = By.xpath(String. format("//*[contains(text(),\"%s\")]", text));
hooks .getWait().until(presenceOfElementLocated(by));

}

/* Manage  methods

* WebDriver Helpers

*

* gets  webdriver

*/

public WebDriver getWebDriver() throws MalformedURLException {
return hooks.getDriver();
}
}

