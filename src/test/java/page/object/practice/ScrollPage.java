package page.object.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class ScrollPage extends TestBase{

	WebDriverWait wait;
	Actions actions = new Actions(driver);

	public void getScrollDown() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1200)");
	
	}
	
	public void getSubMenu() {
		
	}

	
	
	
	
		
}




