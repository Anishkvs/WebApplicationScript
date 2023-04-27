package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;
import page.object.swaglabs.SwaglabsCartPage;
import page.object.swaglabs.SwaglabsCompletePage;
import page.object.swaglabs.SwaglabsLoginpage;
import page.object.swaglabs.SwaglabsOverviewPage;
import page.object.swaglabs.SwaglabsProductPage;
import page.object.swaglabs.SwaglabsYourInfoPage;

public class SwaglabsTest extends TestBase {

	public WebDriver driver;
	public SwaglabsLoginpage login;
	public SwaglabsProductPage product;
	public SwaglabsCartPage cart;
	public SwaglabsYourInfoPage info;
	public SoftAssert softAssert;
	public SwaglabsOverviewPage overview;
	public SwaglabsCompletePage finalMgs;
	
	@Test
	public void run() throws InterruptedException {

		SwaglabsLoginpage login = new SwaglabsLoginpage();
		Thread.sleep(2000);
		login.doLogin("standard_user", "secret_sauce");
		login.verifyAlertMessage();

		Thread.sleep(2000);
		
		product = new SwaglabsProductPage();
		product.verifyProductTitle();
		Thread.sleep(2000);
		
		product.getAddToCartBackPack();
		product.getAddToCartBikeLight();
		product.getAddToCartT_Shirt();
		Thread.sleep(2000);
		product.getShoppingCartBadge();
		Thread.sleep(3000);
		cart = new SwaglabsCartPage();
		cart.verifyBackPackProduct();
		cart.verifyBikeLight();
		cart.getRemoveBackPack();
		Thread.sleep(1000);
		cart.getCheckOut();
		Thread.sleep(2000);
		info = new SwaglabsYourInfoPage();
		info.getFirstName("Test01");
		info.getLastName("testLast01");
		info.getZipCode("689531");
		Thread.sleep(2500);
		info.getContinueInfo();
		
		overview = new SwaglabsOverviewPage();
		//overview.verifyBackPackInOverview();
		//overview.verifyBikeLightInOverview();
		Thread.sleep(2000);
		overview.FinishInOverview();
		Thread.sleep(3000);
		finalMgs = new SwaglabsCompletePage();
		finalMgs.OrderCompletedMessage();
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {
		SwaglabsTest ob = new SwaglabsTest();
		ob.run();
	}
}
