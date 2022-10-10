package com.adbo.runners;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;
import com.adbo.helpers.TokenHelper;

import ch.qos.logback.core.net.server.Client;

import org.openqa.selenium.chrome.ChromeDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import okhttp3.OkHttpClient;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.internal.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import org.openqa.selenium.remote.http.HttpClient;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.internal.*;
import java.io.File;
import java.net.*;
import java.net.Proxy;

import static java.lang.Boolean.TRUE;
import static org.springframework.util.ObjectUtils.isEmpty;

import javax.annotation.PostConstruct;

import org.aspectj.weaver.World;
import org.jsoup.select.Evaluator.IsEmpty;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

@Component
public class Hook {
	/**
	 * logger
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(Hook.class);

	@Value("${rbs.browser}")
	private String browser;

	@Value("${rbs.mss.flag}")
	private boolean mssflag;

	@Value("${rbs.application.mss.url}")
	private String rbsmssUrl;

	@Value("${rbs.application.mss.url}")
	private String nwbmssUrl; // rbsmmpUrl

	@Value("${rbs.application.mss.url}")
	private String rbsmmpUrl;
	@Value("${rbs.mmp.flag}")
	private boolean mmpflag; // nwommpUrl

	@Value("${rbs.application.mss.url}")
	private String nwommpUrl;
	@Value("${rbs.browser.headless}")
	private Boolean headless;

	@Value("${rbs. browserstack}")
	private Boolean browserstack;

	@Value("${rbs. browserstack.browser}")
	private String bsbrowser;

	@Value("${rbs.browser.remote}")
	private String remote;

	@Value("${rbs.application.baseUr1}")
	private String rbsbaseUrl;

	@Value("${nwb. application. baseUr1}")
	private String nwbbaseUrl;

	@Value("${rbs.application.mmp.baseUr1}")
	private String rbsmmpUr1;

	@Value("${nwb. application.mmp.baseUrl}")
	private String nwbmmpUr1;

	@Value("${rbs.application.mss.url}")
	private String rbsmssUr1;

	@Value("${nwb. application.mss.url}")
	private String nwomssUr1;

	@Value("${rbs.browserstack.proxy}")
	private String bsproxy;

	@Value("${rbs.browserstack.port}")
	private int bsport;

	@Value("${rbs. browserstack.domain}")
	private String bsdomain;

	@Value("${rbs.browserstack.proxy.user}")
	private String bsproxyuser;
	@Value("${start.application.baseUr1}")

	private String productSwitichStarturl;

	@Value("${nwbdevorganic.application.baseUr1}")
	private String nwbdevorganic;

	@Value("${rbs. browserstack. proxy.password}")
	private String bsproxypassword;

	@Value("${rbs.browserstack.url}")
	private String bsURL;

	@Value("${rbs. browserstack.batch}")
	private String bsBatchFileLocation;

	@Autowired
	private BSBrowserManager browserManager;

	@Autowired
	private com.adbo.World world;

	@Autowired
	private TokenHelper tokenHelper;

	@Autowired
	private AuthenticationRequestDto authenticationRequestDto;

	public WebDriver driver;

	private AppiumDriver<WebElement> mDriver;
	private WebDriverWait wait;

	@PostConstruct
	public void initialize() {
		// Shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			if (isDriverLoaded()) {
				LOGGER.info("Shutdown signal detected: Closing opened drivers");
				closeDriver();
				LOGGER.info("Opened drivers closed");
			}
		}));
	}

	private boolean isDriverLoaded() {

		return driver != null;
	}

	public WebDriver getDriver() throws MalformedURLException {
		if (isEmpty(driver)) {
			intialiseDriver();
		}

		return driver;

	}

	private boolean IsEmpty(WebDriver driver2) {
		// TODO Auto-generated method stub
		return false;
	}

	private void intialiseDriver() {
		// TODO Auto-generated method stub

	}

	public WebDriverWait getWait() throws MalformedURLException {
		if (isEmpty(wait)) {
			initialiseDriver();
		}

		return wait;

	}

	private boolean IsEmpty(WebDriverWait wait2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, bsBatchFileLocation, browser);

		}
	}

	public void closeDriver() {
		if (driver == null) {
			return;
		}

		driver.quit();
		driver = null;

	}

	private void initialiseDriver() {

		// Prevent mem leak

		if (!IsEmpty(driver)) {
		closeDriver();

		}

		// Disable driver log output
		System. setProperty("webdriver.chrome.silentOutput", "true");

		if ("chrome".equals(browser)) {
		try {
		setChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS) ;
		driver.manage() .deleteAllCookies();
		Thread. sleep(7000) ;
		goToBaseUrl();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		} else if ("firefox" .equals(browser))
		setFirefoxDriver();
		else if ("bs".equals(browser)) {
		try {
		setBrowserStack(bsbrowser) ;
		driver.manage().timeouts().pageLoadTimeout (40, TimeUnit. SECONDS) ;
		goToBaseUrl();
		} catch (Exception e) {
		e.printStackTrace();
		}

		}}

	private void setBrowserStack(String bsbrowser) throws Exception {

		if (world.bsFlag == false) {
			try {
				String file = System.getProperty("user.dir") + bsBatchFileLocation;
				String[] command = { "cmd.exe", "/C", "Start", file };
				Process p = Runtime.getRuntime().exec(command);

				Thread.sleep(10008);
				world.bsFlag = true;

			} catch (Exception e) {
				System.out.println("Browserstack.exe not initiated");
				e.printStackTrace();

			}

		}

		if (TRUE.equals(browserstack)) {
			URL url;
			try {

				url = new URL(bsURL);
			} catch (MalformedURLException e) {

				throw new RuntimeException(e.getMessage(), e);
			}

			okhttp3.OkHttpClient.Builder client = new okhttp3.OkHttpClient.Builder()
					.connectTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
					.readTimeout(60, TimeUnit.SECONDS)
					.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(bsproxy, bsport)));

			HttpClient.Factory factory = new MyHttpClientFactory(new OkHttpClient(client.build(),	url));

			HttpCommandExecutor executor = new HttpCommandExecutor(new HashMap<String, CommandInfo>(), url, factory);
			driver = new RemoteWebDriver(executor, browserManager.capabilities(bsbrowser));
			// driver = mDriver;

			// driver.manage() .window() .maximize();
			wait = new WebDriverWait(driver, 20, 1000);
		}
	}

	private void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("chrome.switches", "--disable-extensions");
		chromeOptions.addArguments("--disable-cache");

		chromeOptions.addArguments("--disable-application-cache");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-gpu");

		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setCapability("autoAcceptAlerts", "true");
		chromeOptions.setCapability("acceptInsecureCerts", true);
		chromeOptions.setCapability("acceptSslCerts", true);
		chromeOptions.setCapability("browser.cache.disk.enable", false);

		// Headless mode
		if (TRUE.equals(headless)) {

		}

		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("window-size=1920, 1080");

		if ("grid".equals(remote)) {
			try {
				driver = new RemoteWebDriver(new URL("http: //localhost:4444/wd/hub"), chromeOptions);
			} catch (MalformedURLException e) {
				LOGGER.error("Error", e);
			}

		} else

		{
			driver = new ChromeDriver(chromeOptions);
		}

		wait = new WebDriverWait(driver, 20, 3000);
	}

	private void setFirefoxDriver() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		FirefoxBinary firefoxBinary = new FirefoxBinary();

		// Headless mode

		if (TRUE.equals(headless)) {
			firefoxBinary.addCommandLineOptions("--headless");
			firefoxOptions.addArguments("--width=1920");
			firefoxOptions.addArguments("--height=1080");

		}

		firefoxOptions.setBinary(firefoxBinary);

		driver = new FirefoxDriver(firefoxOptions);

		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 20, 1000);

	}

	private void setIEDriver() {
		System.setProperty("webdriver.ie.driver", "src//test//resources//drivers//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20, 1000);

	}

	private void setEdgeDriver() {
		System.setProperty("webdriver.edge.driver", "src//test//resources//drivers//msedgedriver exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20, 1000);
	}

private void goToBaseUrl() throws InterruptedException, IOException {

try {
String url = null;

if (mssflag){
if ("rbs" .equalsIgnoreCase(world.brand) )
url = rbsmssUrl;
else if ("nwb".equalsIgnoreCase(world.brand))
url = nwbmssUrl;
}	else if(mmpflag){
if ("rbs".equalsIgnoreCase(world. brand) )
url = rbsmmpUrl+world.accessToken;
else if ("nwb".equalsIgnoreCase(world.brand))
url = nwommpUrl+world.accessToken;
}
else if ("Ui".equalsIgnoreCase(world.brand)) {
//url = Uitaccess_token+"&bk_dtl=dskjfksdfhks";
url = productSwitichStarturl;

}
else{
if ("rbs".equalsIgnoreCase(world.brand))
url = rbsbaseUrl+world.accessToken;
else if ("nwb".equalsIgnoreCase(world.brand))
url = nwbbaseUrl+world.accessToken;
}

if (TRUE.equals(browserstack)) {
driver. navigate().to("https: //v1-ui-coord-payment-dev.edi@1-apps.dev-pcf. 1b4. rbsgrp.net /mortgages /v1/ui-coord-payment/accounts") ;
Thread. sleep (3000) ;
driver. findElement (By. xpath("//*[contains(text(), 'Channel')]"));
driver.get(url);
LOGGER. info(world.brand + " URL to navigate : " + url);
} else {
driver.navigate().to(url);
LOGGER.info(world.brand + " URL to navigate : " + url);
	
}

} catch ( InterruptedException e ) {

String url = null;
authenticationRequestDto.setAccountNumber (world.searchValue.getAccountNumber()) ;
authenticationRequestDto.setCin(world.searchValue.getCinNumber());
authenticationRequestDto.setChannel (world.searchValue.getChannel());
authenticationRequestDto.setScope(world.searchValue.getScope());
authenticationRequestDto.setDetails(world.searchValue.getDetails());

String access_token = tokenHelper.getBearerToken(authenticationRequestDto) ;

if ("rbs".equalsIgnoreCase(world.brand))
url = rbsbaseUrl+access_token;
else if ("nwb".equalsIgnoreCase(world.brand))
url = nwbbaseUrl+access_token;
else if ("Ui".equalsIgnoreCase(world.brand))
//url = Uitaccess_token+"&bk_dtl=dskjfksdfhks";
url = productSwitichStarturl;
else if ("nwbdevorganic".equalsIgnoreCase(world.brand))
url = nwbdevorganic+access_token;

if (TRUE.equals(browserstack)) {
driver .navigate().to("https://v1-ui-coord-payment-dev.edi@1-apps.dev-pcf.1b4.rbsgrp.net/mortgages/v1/ui-coord-payment/accounts") ;
Thread. sleep(3000) ;
driver. findElement (By.xpath("//*[contains(text(), ‘Channel')]"));
driver.get(url);
LOGGER. info(world.brand + " URL to navigate : " + url);
} else {
driver.navigate().to(url);
LOGGER. info(world.brand + " URL to navigate : " + url);
}}}

	private static String getWorkstation() {
		Map<String, String> env = System.getenv();

		if (env.containsKey("COMPUTERNAME")) {
// Windows
			return env.get("COMPUTERNAME");
		} else if (env.containsKey("HOSTNAME")) {
// Unix/Linux/MacO0S
			return env.get("HOSTNAME");
		} else {
// From DNS
			try {
				return InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException ex) {
				return "Unknown";

			}
		}
//		return driver;

	}

	public void javaScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[@].click();", element);

	}

public void screenCapture(String caseName) throws IOException {
String pathName = System.getProperty("user.dir") + "\\results\\screenshots\\";
Date dt = new Date();
String FileName = caseName + "_" + dt.toString().replace(":", "_").replace(" ", "_") +
File screenshot = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE) ;
FileHandler.copy(screenshot, new File(pathName + FileName));

}

	public void javaScriptscroll(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window. scrol1By(0, 3800)", element);
	}

	public void pageReload() throws Exception {
		driver.navigate().refresh();

	}

	public void doWait(long waitMiliSeconds) throws Exception {
		Thread.sleep(waitMiliSeconds);
	}
}

// Remote mode
