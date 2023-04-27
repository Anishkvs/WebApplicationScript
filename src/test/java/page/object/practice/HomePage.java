package page.object.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class HomePage extends TestBase{

	WebDriverWait wait;
	
	public RadioPage getHome() throws InterruptedException {
		System.out.println("Click on New cars");
		
		return new RadioPage();
		
	}
	
		
}
