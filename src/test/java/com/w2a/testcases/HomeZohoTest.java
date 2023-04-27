package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.w2a.base.Page;
import com.w2a.base.TestBase;
import com.w2a.base.TopMenu;
import page.object.homepage;
import page.object.loginpage;
import page.object.CRMAccountPage.CRMAccountPage;
import page.object.CRMAccountPage.CRMCreateAccountPage;

public class HomeZohoTest extends TestBase{

	WebDriver driver;
	TopMenu menu = new TopMenu(driver);
	public homepage home;
//	
	@Test
public void run() throws InterruptedException {		
//		
		homepage home = new homepage();
		Thread.sleep(2000);
		home.getLogin();
		//home.getSupport();
		loginpage login = new loginpage();
		Thread.sleep(2000);
		login.getUsername("anishkumarkvs24@gmail.com");
		login.getNext();
		login.getPassword("98435596999");
		login.getSignin();
		login.UnderstandButton();
		Thread.sleep(2000);
		//String actualTitle = driver.getTitle();
		//String expectedTitle = "Zoho Home";
//		
		//Assert.assertEquals(actualTitle, expectedTitle);
		//driver.quit();
		home.getHomePageCRM();
		Thread.sleep(2000);
		Page.menu.getCRMAccounts();
		CRMAccountPage account = new CRMAccountPage();
		account.goToCreateAccount();
		CRMCreateAccountPage accountPage1 = new CRMCreateAccountPage();
		accountPage1.accountName("accountTestName");
		
	}
}
