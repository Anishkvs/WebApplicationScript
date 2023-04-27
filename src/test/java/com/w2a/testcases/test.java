package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test {


	
	
	@Test
	public void run() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);

     	
        driver.get("https://www.carwale.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'NEW CARS')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Find Dealer')]")).click();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		test ob = new test();
		ob.run();
	}
	
}

