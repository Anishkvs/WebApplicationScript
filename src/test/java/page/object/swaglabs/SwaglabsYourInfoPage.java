package page.object.swaglabs;

import org.openqa.selenium.By;
import com.w2a.base.TestBase;

public class SwaglabsYourInfoPage extends TestBase{


	public void getFirstName(String FirstName) {
		driver.findElement(By.cssSelector("#first-name")).sendKeys(FirstName);
	}
	
		
	public void getLastName(String LastName) {
		driver.findElement(By.cssSelector("#last-name")).sendKeys(LastName);

	}
	public void getZipCode(String zipCode) {
		driver.findElement(By.cssSelector("#postal-code")).sendKeys(zipCode);

	}
	
	 public void getContinueInfo() {
		 driver.findElement(By.cssSelector("#continue")).click();
	}
	
	 public void getCancelInfo() {
		 driver.findElement(By.cssSelector("#cancel")).click();
	}
	 
	 
	
	
	
	
}
