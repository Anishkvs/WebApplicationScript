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

public class MouseHoverPage extends TestBase{

	WebDriverWait wait;
	Actions actions = new Actions(driver);

   public void getScrollDown() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1200)");
	
	}
	public void getMouseHover() throws InterruptedException {
		
		// Locating the Main Menu (Parent element)
		WebElement mouseButton = driver.findElement(By.xpath("//button[@id='mousehover']"));

		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(mouseButton);

		WebElement subMenu = driver.findElement(By.cssSelector("a[href='#top']"));

		//To mouseover on sub menu
		actions.moveToElement(subMenu);
		Thread.sleep(4000);

		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
	}
	
	public void getSubMenu() {
		// Locating teh element from Sub Menu
				WebElement subMenu = driver.findElement(By.cssSelector("a[href='#top']"));

				//To mouseover on sub menu
				actions.moveToElement(subMenu);

				//build()- used to compile all the actions into a single step 
				actions.click().build().perform();
	}

	
	
	
	
		
}




