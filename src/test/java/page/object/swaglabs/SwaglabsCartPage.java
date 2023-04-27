package page.object.swaglabs;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class SwaglabsCartPage extends TestBase{


	public void getRemoveBackPack() {
		driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();
	}
	
		
	public void getCheckOut() {
		driver.findElement(By.cssSelector("#checkout")).click();

	}
	public void getContinueShopping() {
		driver.findElement(By.cssSelector("#continue-shopping")).click();

	}
	
	public void verifyBackPackProduct() {
		Boolean backPack = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).isDisplayed();
		System.out.println("BackPack product is displayed "+backPack);

	}
	
	public void verifyBikeLight() {
      Boolean BikeLight = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).isDisplayed();
      System.out.println("BikeLight product is displayed "+BikeLight);
		
	}
}
