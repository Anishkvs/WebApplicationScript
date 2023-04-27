package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu extends Page{

	public WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getCRMHome() {


	}
	public void getCRMLeads() {


	}
	public void getCRMContacts() {


	}
	public void getCRMAccounts() {

		driver.findElement(By.xpath("//a[@id='Visible_Accounts']")).click();
	}
	public void getCRMDeals() {


	}
	public void getCRMTasks() {


	}
	
}
