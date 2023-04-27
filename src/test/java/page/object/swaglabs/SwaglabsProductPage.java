package page.object.swaglabs;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.w2a.base.TestBase;


public class SwaglabsProductPage extends TestBase{

	public SoftAssert softAssert;
	String ActualTitle;
	String ExpectedTitle;

	public void getAddToCartBackPack() {
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
	}
	
	public void getAddToCartBikeLight() {
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
		
	}
	
	public void getAddToCartT_Shirt() {
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
	}
	
	public void getShoppingCartBadge() {
		driver.findElement(By.cssSelector(".shopping_cart_badge")).click();

	}
	
	public void verifyProductTitle() {
		ActualTitle = driver.getTitle();
		ExpectedTitle = "Single Page Apps for GitHub Page";
		softAssert = new SoftAssert();
		softAssert.assertEquals(ActualTitle, ExpectedTitle);

	}
	
	
	
	
}
