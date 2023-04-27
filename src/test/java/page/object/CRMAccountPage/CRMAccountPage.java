package page.object.CRMAccountPage;

import org.openqa.selenium.By;
import com.w2a.base.Page;

public class CRMAccountPage extends Page{
	
	
	public void goToCreateAccount() {
		driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")).click();
	}
	
	public void goTOImportAccounts() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='importIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//link-to[@data-zcqa='cv_importParent']")).click();
	
	}
	
}

