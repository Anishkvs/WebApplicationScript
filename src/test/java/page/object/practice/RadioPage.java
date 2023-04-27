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

public class RadioPage extends TestBase{

	WebDriverWait wait;
	
	public void getRadio1() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		radio1.click();
		Thread.sleep(1000);
		
	}
	
	public void getRadio2() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio2']"));
		radio1.click();
		Thread.sleep(1000);
		
	}
	public DropDownPage getRadio3() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio3']"));
		radio1.click();
		Thread.sleep(1000);
		
		return new DropDownPage();
		
	}
	
	
		
}
