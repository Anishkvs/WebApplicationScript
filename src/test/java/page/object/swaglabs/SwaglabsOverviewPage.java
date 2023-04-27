package page.object.swaglabs;

import org.openqa.selenium.By;
import com.w2a.base.TestBase;

public class SwaglabsOverviewPage extends TestBase{


	public void verifyBackPackInOverview() {
		
		Boolean backpack = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']")).isDisplayed();
		System.out.println("BackPack product is displayed "+ backpack);
	}
	 
	public void verifyBikeLightInOverview() {
		
		Boolean lightPack = driver.findElement(By.cssSelector("a[id='item_0_title_link'] div[class='inventory_item_name']")).isDisplayed();
		System.out.println("lightPack product is displayed "+ lightPack);
	}
	
	public void FinishInOverview() {
		driver.findElement(By.cssSelector("#finish")).click();

	}

	
	
	
	
	
	
	
	
}
