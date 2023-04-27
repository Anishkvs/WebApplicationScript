package page.object.CRMAccountPage;

import org.openqa.selenium.By;
import com.w2a.base.Page;

public class CRMCreateAccountPage extends Page{

	public void accountName(String accountName) {
		driver.findElement(By.xpath("//*[@id='Crm_Accounts_ACCOUNTNAME_LInput']")).sendKeys("accountName");

	}
}

