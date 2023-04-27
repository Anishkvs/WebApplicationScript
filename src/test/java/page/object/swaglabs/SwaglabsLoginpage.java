package page.object.swaglabs;

import org.openqa.selenium.By;
import com.w2a.base.TestBase;

public class SwaglabsLoginpage extends TestBase{

	
	public void doLogin(String username, String password) {
		type("#user-name",username);
		type("#password",password);
		click("#login-button");
		//driver.findElement(By.cssSelector("#user-name")).sendKeys(username);

	}
	
	public void getPassword(String password) {
		
		//driver.findElement(By.cssSelector("#password")).sendKeys(password);

	}
	
	public void getLoginButton() {
       
		//driver.findElement(By.cssSelector("#login-button")).click();

	}
	
	public void verifyAlertMessage() throws InterruptedException {
		
		Boolean alertMgs = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
		System.out.println("Alert message is displayed "+ alertMgs );
		
	}
}
