package com.w2a.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChrome {

	public static WebDriver driver;
	public static TopMenu menu;

	public HeadLessChrome() {
		if (driver==null)
		{
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		//menu = new TopMenu(driver);
		}
	}
}

