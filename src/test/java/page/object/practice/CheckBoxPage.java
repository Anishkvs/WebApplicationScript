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

public class CheckBoxPage extends TestBase{

	WebDriverWait wait;
	
	public void getCheckBox1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		
		Thread.sleep(1000);
		
	}
	
	public void getCheckBox2() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		Thread.sleep(1000);

	}
	public SwitchToWindowPage getDeselectCheckBox() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Thread.sleep(1000);

		return new SwitchToWindowPage();
	}
	
	
		
}
