//package com.w2a.base;
//
//import java.io.IOException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.safari.SafariOptions;
//import com.autobots.exception.AutomationException;
//import com.autobots.utils.AutomationConstants;
//
//public class AutomationBase {
//
//	public WebDriver driver;
//
//	/**
//	 * Method to start the WebDriver session based on the given browser
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 22-04-2020
//	 * @param browserName
//	 * @throws AutomationException
//	 */
//	public WebDriver startSession(String browserName, String gridIP, String gridPort)
//			throws AutomationException, InterruptedException {
//		switch (browserName.toLowerCase()) {
//		case "chrome":
//		case "headless-chrome":
//			if (!gridIP.equalsIgnoreCase("")) {
//				startExecutionInGrid(gridIP, gridPort, browserName);
//			} else {
//				startChrome(browserName);
//			}
//			break;
//
//		case "firefox":
//		case "headless-firefox":
//			if (!gridIP.equalsIgnoreCase("")) {
//				startExecutionInGrid(gridIP, gridPort, browserName);
//			} else {
//				startFirefox(browserName);
//			}
//			break;
//
//		case "ie":
//		case "internetexplorer":
//			if (!gridIP.equalsIgnoreCase("")) {
//				startExecutionInGrid(gridIP, gridPort, browserName);
//			} else {
//				startInternetExplorer();
//			}
//			break;
//
//		case "edge":
//			if (!gridIP.equalsIgnoreCase("")) {
//				startExecutionInGrid(gridIP, gridPort, browserName);
//			} else {
//				startEdge();
//			}
//			break;
//
//		case "safari":
//			if (!gridIP.equalsIgnoreCase("")) {
//				startExecutionInGrid(gridIP, gridPort, browserName);
//			} else {
//				startSafari();
//			}
//			break;
//
//		default:
//			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
//			break;
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		return driver;
//	}
//
//	/**
//	 * Method to launch Chrome browser with headless and without headless mode
//	 * 
//	 * @author sanoj.swaminathan
//	 * @throws AutomationException
//	 * @since 13-04-2020
//	 * @modified 16-03-2021
//	 * @param browserName
//	 */
//	private void startChrome(String browserName) throws AutomationException {
//		try {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--test-type");
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			options.setExperimentalOption("prefs", prefs);
//			options.addArguments("--remote-allow-origins=*");
//			if (browserName.equalsIgnoreCase("headless-chrome")) {
//				options.addArguments("--no-sandbox");
//				options.addArguments("--disable-dev-shm-usage");
//				options.addArguments("--headless=new");
//			}
//			driver = new ChromeDriver(options);
//		} catch (Exception e) {
//			throw new AutomationException(getExceptionMessage(), e);
//		}
//	}
//
//	/**
//	 * Method to launch FireFox browser with headless and without headless mode
//	 * 
//	 * @author sanoj.swaminathan
//	 * @throws AutomationException
//	 * @since 13-04-2020
//	 * @modified 16-03-2021
//	 * @param browserName
//	 */
//	private void startFirefox(String browserName) throws AutomationException {
//		try {
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//			FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
//			if (browserName.equalsIgnoreCase("headless-firefox")) {
//				firefoxOptions.addArguments("--no-sandbox");
//				firefoxOptions.addArguments("--disable-dev-shm-usage");
//				firefoxOptions.addArguments("--headless");
//			}
//			driver = new FirefoxDriver(firefoxOptions);
//		} catch (Exception e) {
//			throw new AutomationException(getExceptionMessage(), e);
//		}
//	}
//
//	/**
//	 * Launch Safari browser
//	 * 
//	 * @author sanoj.swaminathan
//	 * @throws InterruptedException
//	 * @since 19-05-2021
//	 */
//	private void startSafari() throws InterruptedException {
//		Process process;
//		try {
//			process = Runtime.getRuntime().exec("killall safaridriver");
//			process.waitFor();
//			process.destroy();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		SafariOptions options = new SafariOptions();
//		// options.useCleanSession(true);
//		options.setAutomaticInspection(true);
//		options.setUseTechnologyPreview(true);
//		driver = new SafariDriver(options);
//	}
//
//	/**
//	 * Launch Edge browser
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 19-05-2021
//	 */
//	private void startEdge() throws AutomationException {
//		try {
//			driver = new EdgeDriver();
//		} catch (Exception e) {
//			throw new AutomationException(getExceptionMessage(), e);
//		}
//	}
//
//	/**
//	 * Launch Internet Explorer browser
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 19-05-2021
//	 * @throws AutomationException
//	 */
//	private void startInternetExplorer() throws AutomationException {
//		try {
//			driver = new InternetExplorerDriver();
//		} catch (Exception e) {
//			throw new AutomationException(getExceptionMessage(), e);
//		}
//	}
//
//	/**
//	 * To start the selenium grid execution in the distributed environment
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 19-01-2022
//	 * @param gridIP
//	 * @param gridPort
//	 * @param browserName
//	 * @return
//	 * @throws AutomationException
//	 */
//	private RemoteWebDriver startExecutionInGrid(String gridIP, String gridPort, String browserName)
//			throws AutomationException {
//		DesiredCapabilities gridCap = new DesiredCapabilities();
//		String nodeURL = "", platformName = "";
//		try {
//			if (gridIP != "" && gridPort != null && gridIP != null && gridPort != "") {
//				nodeURL = ("http://" + gridIP + ":" + gridPort).toString().toLowerCase().trim();
//			} else {
//				Exception ex = new AutomationException(AutomationConstants.GRIDNODEIP_PORTMISSING);
//				throw new AutomationException(ex);
//			}
//
//			try {
//				if (browserName != "" && browserName != null) {
//					if ("firefox".equalsIgnoreCase(browserName))
//						gridCap.setBrowserName("firefox");
//					if (("internetExplorer".equalsIgnoreCase(browserName)) | ("IE".equalsIgnoreCase(browserName)))
//						gridCap.setBrowserName("internet explorer");
//					if ("chrome".equalsIgnoreCase(browserName))
//						gridCap.setBrowserName("chrome");
//					if ("safari".equalsIgnoreCase(browserName))
//						gridCap.setBrowserName("safari");
//					if ("edge".equalsIgnoreCase(browserName))
//						gridCap.setBrowserName("MicrosoftEdge");
//				} else {
//					throw new AutomationException(AutomationConstants.GRID_BROWSER_MISSING);
//				}
//
//				platformName = System.getProperty("os.name");
//				if (platformName != "" && platformName != null) {
//					if (platformName.equalsIgnoreCase("WINDOWS"))
//						gridCap.setPlatform(Platform.WINDOWS);
//					if (platformName.equalsIgnoreCase("LINUX"))
//						gridCap.setPlatform(Platform.LINUX);
//					if (platformName.equalsIgnoreCase("MAC"))
//						gridCap.setPlatform(Platform.MAC);
//					if (platformName.equalsIgnoreCase("ANY"))
//						gridCap.setPlatform(Platform.ANY);
//				}
//				driver = new RemoteWebDriver(new URL(nodeURL), gridCap);
//
//			} catch (Exception e) {
//				throw new AutomationException(e);
//			}
//		} catch (Exception e) {
//			throw new AutomationException(getExceptionMessage(), e);
//		}
//		return (RemoteWebDriver) driver;
//	}
//
//	/**
//	 * Method to get the Exception message, to pass the message whenever an
//	 * exception is encountered
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 13-04-2020
//	 */
//	public String getExceptionMessage() {
//		StringBuffer message = new StringBuffer();
//		try {
//			message.append("Exception in ");
//			message.append(Thread.currentThread().getStackTrace()[2].getClassName());
//			message.append(".");
//			message.append(Thread.currentThread().getStackTrace()[2].getMethodName());
//			message.append("()");
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getMessage();
//		}
//		return message.toString();
//	}
//
//	/**
//	 * Method to set driver for Web applications
//	 * 
//	 * @author sanoj.swaminathan
//	 * @since 03-02-2020
//	 * @param driver
//	 */
//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}
//
//	/**
//	 * Method to get current running driver
//	 * 
//	 * @since 03-02-2020
//	 * @author sanoj.swaminathan
//	 * @return driver
//	 */
//	public WebDriver getDriver() {
//		return this.driver;
//	}
//}
