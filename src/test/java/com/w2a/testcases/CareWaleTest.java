package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

import page.object.carwale.CarWaleHomePage;
import page.object.swaglabs.SwaglabsCartPage;
import page.object.swaglabs.SwaglabsCompletePage;
import page.object.swaglabs.SwaglabsLoginpage;
import page.object.swaglabs.SwaglabsOverviewPage;
import page.object.swaglabs.SwaglabsProductPage;
import page.object.swaglabs.SwaglabsYourInfoPage;

public class CareWaleTest extends TestBase {

	public WebDriver driver;
	public SwaglabsLoginpage login;
	
	
	@Test
	public void run() throws InterruptedException {

		CarWaleHomePage home = new CarWaleHomePage();
		//home.getNewCars();
		Thread.sleep(2000);
		home.getAlert();
		home.GetMouseHoverCars();
		System.out.println("Alerts");
		
		home.getFindDealer();
		
		
		
	
	
	}

	
}
