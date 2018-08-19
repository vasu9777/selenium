package com.vsoft.selenium.Selenium_maven;

import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

/**
 * @author vasu
 *
 */
public class TC001_HMS extends BasePage{
	ATUTestRecorder recorder;
  @Test(description="this testcase is to verify hms login&logout in HMS")
  public void TC001() throws Exception {
	  PageUI page=new PageUI(driver);
	  page.hmsLogin();
	  page.hmsLogout();
	  recorder.stop();
      
	
	/*@Test(description="this test case to get error msg on automation practice login page")
	public void TC002() {
		Automation_page ap =new Automation_page(driver);
		ap.login();
		Assert.assertEquals(ap.geterrormsg(), "Authentication failed.");
		*/
	}
  @BeforeTest
  public void beforeTest() throws Exception  { 
	  recorder=new ATUTestRecorder("D:\\Library\\ATUTest recorder", "HMS_LOGIN",false);
	  recorder.start();
	  BrowserLaunch("chrome", "http://seleniumbymahesh.com");
  }

  @AfterTest
  public void afterTest() {
  }

}
