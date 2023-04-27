package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.autobots.exception.AutomationException;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.w2a.listeners.CustomListeners;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.Utilities;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;

	public static String browser;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			
			

			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
//
//				browser = System.getenv("browser");
//			} else {

				browser = config.getProperty("browser");

//			}

			if (browser.equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				// System.setProperty("webdriver.gecko.driver",
				// System.getProperty("user.dir") +
				// "\\src\\test\\resources\\executables\\geckodriver.exe");

				driver = new FirefoxDriver();
				System.out.println(driver);

				
			}
			
			
			else if (config.getProperty("browser").equals("chrome")) {

				/*
				 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				 * + "\\src\\test\\resources\\executables\\chromedriver.exe");
				 */			
				
				System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
				
				driver = new ChromeDriver();
				log.debug("Chrome Launched !!!");
			}

			// Edge///////////////////////
			else if (config.getProperty("browser").equals("edge")) {

				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\msedgedriver.exe");

				// WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				log.debug("Edge Launched !!!");
			}
			///////////////////////

			else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}

			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
		}

	}
	/**
	 * Method to launch Chrome browser with headless and without headless mode
	 
	 * @throws AutomationException
	 * @since 13-04-2020
	 * @modified 16-03-2021
	 * @param browserName
	 */
	private void startChrome(String browserName) throws AutomationException {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");
			if (browserName.equalsIgnoreCase("headless-chrome")) {
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless=new");
			}
			
			driver = new ChromeDriver(options);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Method to launch FireFox browser with headless and without headless mode
	 
	 * @throws AutomationException
	 * @since 13-04-2020
	 * @modified 16-03-2021
	 * @param browserName
	 */
	private void startFirefox(String browserName) throws AutomationException {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
			if (browserName.equalsIgnoreCase("headless-firefox")) {
				firefoxOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("--disable-notifications");
				firefoxOptions.addArguments("--disable-dev-shm-usage");
				firefoxOptions.addArguments("--headless");
			}
			driver = new FirefoxDriver(firefoxOptions);
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Launch Safari browser
	 * 
	 
	 * @throws InterruptedException
	 * @since 19-05-2021
	 */
	private void startSafari() throws InterruptedException {
		Process process;
		try {
			process = Runtime.getRuntime().exec("killall safaridriver");
			process.waitFor();
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SafariOptions options = new SafariOptions();
		// options.useCleanSession(true);
		options.setAutomaticInspection(true);
		options.setUseTechnologyPreview(true);
		driver = new SafariDriver(options);
	}

	/**
	 * Launch Edge browser
	 * 
	 * @since 19-05-2021
	 */
	private void startEdge() throws AutomationException {
		try {
			driver = new EdgeDriver();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}

	/**
	 * Launch Internet Explorer browser
	 * 
	
	 * @since 19-05-2021
	 * @throws AutomationException
	 */
	private void startInternetExplorer() throws AutomationException {
		try {
			driver = new InternetExplorerDriver();
		} catch (Exception e) {
			throw new AutomationException(getExceptionMessage(), e);
		}
	}
	
	public String getExceptionMessage() {
		StringBuffer message = new StringBuffer();
		try {
			message.append("Exception in ");
			message.append(Thread.currentThread().getStackTrace()[2].getClassName());
			message.append(".");
			message.append(Thread.currentThread().getStackTrace()[2].getMethodName());
			message.append("()");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return message.toString();
	}

	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		CustomListeners.testReport.get().log(Status.INFO, "Typing in : " + locator + " entered value as " + value);

	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		CustomListeners.testReport.get().log(Status.INFO,
				"Selecting from dropdown : " + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			CustomListeners.testReport.get().log(Status.FAIL,
					" Verification failed with exception : " + t.getMessage());
			CustomListeners.testReport.get().fail(
					"<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName).build());

		}

	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			//driver.quit();
		}

		log.debug("test execution completed !!!");
	}
}
