package com.w2a.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

import page.object.practice.AlertPage;
import page.object.practice.MouseHoverPage;

public class PracticeTest extends TestBase {

	public WebDriver driver;
	
	@Test
	public void run() throws InterruptedException {
		
//		HomePage home = new HomePage();
//		RadioPage radio =home.getHome();
//		radio.getRadio1();
//		radio.getRadio2();
//		DropDownPage dd = radio.getRadio3();
//		dd.getDropDown();
//		dd.getOption1();
//		//radio.getRadio3();
//		dd.getDropDown();
//		CheckBoxPage box = dd.getOption2();
//		box.getCheckBox1();
//		box.getCheckBox2();
//		SwitchToWindowPage switch1 = box.getDeselectCheckBox();
//		switch1.getOpenWindow();
//		switch1.getSwitchWindow();
//		switch1.getCourses();
//		SwitchToTabPage tab = switch1.getSwitchParent();
////		 //switch1.getSwitchChild();
//		
//    	radio.getRadio1();
//		radio.getRadio2();
//		tab.getOpenTab();
//		tab.getSwitchToNewTab();
//		//AlertPage alert = tab.getSwitchToParentTab();
//		AlertPage alert = new AlertPage();
//		alert.getEnterName("test_111");
//		alert.getClickOnAlertButton();
//		alert.getAcceptAlert();
//		
//		alert.getEnterName("test_222");
//		alert.getConfirm();
//		System.out.println("click on confirm ");
//		Thread.sleep(5000);
//		alert.getConfirmOk();
		
		MouseHoverPage mouse = new MouseHoverPage();
		Thread.sleep(5000);
		mouse.getScrollDown();
		Thread.sleep(5000);
		mouse.getMouseHover();
		Thread.sleep(5000);
		//mouse.getSubMenu();
		
		
		
		
	
	
	}

	
}
