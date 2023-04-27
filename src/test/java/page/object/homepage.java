package page.object;

import org.openqa.selenium.By;
import com.w2a.base.Page;

public class homepage extends Page{

	
	public void getSupport() {
		driver.findElement(By.cssSelector(".zh-support")).click();
		System.out.println("click on support");
	}
	
	public void getLogin() {
		driver.findElement(By.cssSelector(".zh-login")).click();
		System.out.println("Navigate to Login page");
	}
	
	public void getHomePageCRM() {
		driver.findElement(By.xpath("//span[@class='_logo-crm _logo-x96 zod-app-logo']")).click();

	}
}
