package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;

public class loginpage extends Page{

	
	
	public void getUsername(String user) {
		
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(user);
		
	}
	
	public void getPassword(String pass) {
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
	}
	
	public void getNext() {
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();

	}
	
	public void getSignin() {
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();


	}
	
	public void UnderstandButton() {

	boolean continue_buttonPresence = driver.findElement(By.xpath("//*[@id='continue_button']")).isDisplayed();
	boolean continue_buttonEnabled = driver.findElement(By.xpath("//*[@id='continue_button']")).isEnabled();
		 
	    if (continue_buttonPresence==true && continue_buttonEnabled==true)
		       {
                     // click on the search button
                   WebElement continue_button = driver.findElement(By.id("//*[@id='continue_button']"));
                   continue_button.click();
		       }
		 

	}
	
}
