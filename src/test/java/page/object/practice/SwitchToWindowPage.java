package page.object.practice;

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

public class SwitchToWindowPage extends TestBase{

	WebDriverWait wait;
	
	public void getOpenWindow() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		
	}
	
	public void getSwitchWindow() throws InterruptedException {
		
		Set<String> handles = driver.getWindowHandles();

		Iterator it= handles.iterator();

		String parentid=(String) it.next();
		String childid=(String) it.next();

		driver.switchTo().window(childid);
		Thread.sleep(4000);
		

		
		
	}
	public void getCourses() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[normalize-space()='Courses'])[1]")).click();
		Thread.sleep(1000);
		
		
		
	}
	
	
	public SwitchToTabPage getSwitchParent() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();

		Iterator it= handles.iterator();

		String parentid=(String) it.next();
		String childid=(String) it.next();

		//driver.switchTo().window(childid);
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(parentid);
		return new SwitchToTabPage();
	}
	
	public void getSwitchChild() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();

		Iterator it= handles.iterator();

		String parentid=(String) it.next();
		String childid=(String) it.next();
		Thread.sleep(1000);
		driver.switchTo().window(childid);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.close();
		//driver.switchTo().window(parentid);
		//return new SwitchToTabPage();

	}
	
		
}
