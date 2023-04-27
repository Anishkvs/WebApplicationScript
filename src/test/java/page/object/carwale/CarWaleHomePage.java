package page.object.carwale;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class CarWaleHomePage extends TestBase{

	WebDriverWait wait;
	
	public void getNewCars() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'NEW CARS')]")).click();
		System.out.println("Click on New cars");
		
		
	}
	
		
	public void GetMouseHoverCars() {
		WebElement elementToHover = driver.findElement(By.xpath("//*[contains(text(),'NEW CARS')]"));
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).build().perform();

		//driver.findElement(By.cssSelector("#checkout")).click();

	}
	public void getFindDealer() {
		driver.findElement(By.xpath("//div[contains(text(),'Find Dealer')]")).click();

	}
	
	public void getAlert() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//*[contains(text(),'Allow')]")).click();
//		WebElement allowButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("allow-button")));
//		allowButton.click();

		
		//WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Allow')]")));
		//notification.click();

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Allow')]")));

		WebElement allowButton = driver.findElement(By.xpath("//button[contains(text(),'Allow')]"));
		allowButton.click();
	}
	
	public void verifyBikeLight() {
      Boolean BikeLight = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).isDisplayed();
      System.out.println("BikeLight product is displayed "+BikeLight);
		
	}
}
