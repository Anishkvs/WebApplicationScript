package page.object.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class AlertPage extends TestBase{

	WebDriverWait wait;
	
	public void getEnterName(String AlertName) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(AlertName);
		Thread.sleep(2000);
	}
	
	public void getClickOnAlertButton() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(2000);
	}
	
	public void getAcceptAlert() throws InterruptedException {
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
				
	}
	
	public void getConfirm() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(2000);
		
	}
	
	public void getEnterNameInConfirm(String ConfirmName) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).sendKeys(ConfirmName);
		Thread.sleep(2000);
		//driver.switchTo().alert();

	}
	
	public void getConfirmOk() throws InterruptedException {
		//driver.switchTo().alert().dismiss();
		Alert alert = driver.switchTo().alert();
		
		String alertMgs = driver.switchTo().alert().getText();
		System.out.println(alertMgs);
		Thread.sleep(5000);
		alert.accept();
	}
	
	
		
}




