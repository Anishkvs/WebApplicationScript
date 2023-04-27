package com.w2a.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	//public ExtentReports rep = ExtentManager
	public static String browser; 
	public static TopMenu menu;

	public Page() {
		if (driver==null)
		{
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		menu = new TopMenu(driver);
		}
	}
}

