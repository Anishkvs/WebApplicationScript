package page.object.swaglabs;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.w2a.base.TestBase;

public class SwaglabsCompletePage extends TestBase{


	public void OrderCompletedMessage() {

		Boolean thankYouMgs = driver.findElement(By.cssSelector(".complete-header")).isDisplayed();
		System.out.println("ThankYou Message is displayed "+ thankYouMgs);
	}
	
}
