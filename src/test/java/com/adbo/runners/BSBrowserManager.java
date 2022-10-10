package com.adbo.runners;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util. Iterator;
import java.util.Set;

@Component
public class BSBrowserManager {

Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
public DesiredCapabilities capabilities(String browser){

switch (browser){
case "chrome":
capsHashtable.put("browserstack.local", "true");
capsHashtable.put("browserstack.debug", "true");
capsHashtable.put("os", "Windows") ;
capsHashtable.put("os_version", "10");
capsHashtable. put("browserstack. localldentifier","arul");
capsHashtable.put("browser", "Chrome") ;
capsHashtable.put("browser_version", "88.0");
capsHashtable.put("resolution", "1920x1080") ;
capsHashtable.put("acceptSslCerts", "true");
capsHashtable.put("browserstack.console", "errors");
capsHashtable.put("browserstack.networkLogs", "true");
capsHashtable.put("browserstack.use_w3c", "true");
capsHashtable.put("browserstack.selenium_version", "3.141.59");
capsHashtable.put("browserStack.autoWait", "@");
capsHashtable.put("browserstack.safari.enablePopups", "true");
capsHashtable.put("safariAllowPopups", "true");
capsHashtable.put("autoAcceptAlerts"," true");
capsHashtable.put("browserstack.appium_version", "1.17.0");
break;
case "ff":

capsHashtable.put("os"," Windows");
capsHashtable.put("os_version", "10");

capsHashtable.put("browserstack. localIdentifier","arul");
capsHashtable.put("browser","Firefox");
capsHashtable.put("browser_version", "88.0");
capsHashtable.put("resolution", "1920x1080") ;
capsHashtable.put("acceptSslCerts", "true");
capsHashtable.put("browserstack.console", "errors");
capsHashtable. put ("browserstack.networkLogs", "true");
capsHashtable.put("browserstack.use_w3c", "true");
capsHashtable. put ("browserstack.selenium_version", "3.141.59");
capsHashtable.put("browserStack.autoWait", "@");
capsHashtable.put("browserstack.safari.enablePopups", "true");
capsHashtable.put("safariAllowPopups", "true");
capsHashtable. put ("autoAcceptAlerts"," true");
capsHashtable.put("browserstack.appium_version", "1.17.0");
break;



case "safari":
capsHashtable.put("os", "OS X");
capsHashtable.put("browserstack.localIdentifier", "arul");
capsHashtable.put("local", "true");
capsHashtable.put("browserName", "Safari");
capsHashtable.put("browserVersion", "14.0");
capsHashtable.put("resolution", "1920x108@") ;
capsHashtable.put("acceptSslCerts", "true");


capsHashtable.put("browserstack.console", "errors");
capsHashtable.put("browserstack.networkLogs", "true");
capsHashtable.put("browserstack.use_w3c", "true");
capsHashtable. put("browserstack.selenium_version", "3.141.59");
capsHashtable.put("browserStack.autoWait"," 0");
capsHashtable.put("browserstack.safari.enablePopups", "true");
capsHashtable.put("safariAllowPopups", "true");
capsHashtable.put("autoAcceptAlerts"," true");
capsHashtable.put("browserstack.appium_version", "1.17.0");
break;



case "s10":
capsHashtable.put("browserstack.debug", "true");
capsHashtable.put("browserstack.local", "true");
capsHashtable.put("browserstack.localIdentifier", "arul");
capsHashtable.put("os_version", "9.0");
capsHashtable.put("device", "Samsung Galaxy $10");
capsHashtable.put("acceptSslCert", "true");
capsHashtable.put("unicodeKeyboard", "true");
capsHashtable.put("real_mobile", "true");
capsHashtable.put("browserstack.console", "errors");
capsHashtable. put("browserstack.networkLogs", "true");
capsHashtable.put("browserStack.autoWait", "@");
break;

case "samsungtab":
capsHashtable.put("browserstack.debug", "true");
capsHashtable.put("browserstack. local", "true");
capsHashtable.put("os_version", "9.0");
capsHashtable.put("browserstack.localldentifier", "arul");
capsHashtable.put("device", "Samsung Galaxy Tab SSe");
capsHashtable.put("real_mobile", "true");
capsHashtable.put("acceptSslCert", "true");
capsHashtable.put("unicodeKeyboard", "true");
capsHashtable.put("deviceOrientation", "landscape");
capsHashtable.put("browserstack.console", "errors");
capsHashtable.put("browserstack.networkLogs", "true");
capsHashtable.put("browserStack.autoWait", "0");
break;




case "iphone":
capsHashtable.put("browserstack.debug", "true");
capsHashtable.put("browserstack.local", "true");
capsHashtable.put("osVersion", "14");
capsHashtable.put("browserstack.localIdentifier", "arul");
capsHashtable.put("deviceName", "iPhone 12 Pro");
capsHashtable.put("realMobile", "true");
capsHashtable.put("acceptSslCert", "true");
capsHashtable.put("autoAcceptAlerts", "true");
capsHashtable.put("browserstack.safari.enablePopups", "true");
capsHashtable.put("safarilgnorefraudWarning", "true");
capsHashtable.put("unicodeKeyboard", "true");
capsHashtable.put("browserstack.console", "errors");
capsHashtable.put("browserstack.networkLogs", "true");

capsHashtable.put("local", "false");

capsHashtable.put("browserStack.autoWait", "@");
break;

}

String key;
DesiredCapabilities caps = new DesiredCapabilities();
//Iterate over the hashtable and set the capabilities
Set<String> keys = capsHashtable.keySet();
Iterator<String> itr = keys.iterator();
while (itr.hasNext()) {

key = itr.next();

caps.setCapability(key, capsHashtable.get(key));
}

return caps;


}}


  

