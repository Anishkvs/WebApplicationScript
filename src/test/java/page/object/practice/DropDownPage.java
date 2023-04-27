package page.object.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class DropDownPage extends TestBase{

	WebDriverWait wait;
	
	public void getDropDown() throws InterruptedException {
		
		driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		Thread.sleep(1000);
		
	}
	
	public void getOption1 () throws InterruptedException {
		
		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		dropDown.selectByVisibleText("Option1");
		Thread.sleep(1000);
		
	}
	public CheckBoxPage getOption2() throws InterruptedException {
		

		Select dropDown1 = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		dropDown1.selectByVisibleText("Option3");
		Thread.sleep(1000);
		
		return new CheckBoxPage();
		
	}
	
	
		
}
