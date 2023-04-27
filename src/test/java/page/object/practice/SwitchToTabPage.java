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

public class SwitchToTabPage extends TestBase{

	WebDriverWait wait;
	
	public void getOpenTab() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		
	}
	
	public void getSwitchToNewTab() throws InterruptedException {
		
		
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//li[@class='nav-item']//a[@href='about.html'][normalize-space()='About us']")).click();
	    System.out.println("switch Tab");
	    Thread.sleep(4000);
	    	
		
	}
	public AlertPage getSwitchToParentTab() throws InterruptedException {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles()); 
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
	    Thread.sleep(4000);
	   
	    return new AlertPage();
	    
		
		
	}
	
		
}
