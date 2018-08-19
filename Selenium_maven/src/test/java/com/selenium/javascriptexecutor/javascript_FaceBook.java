package com.selenium.javascriptexecutor;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
/**
 * some times we are unable to locate elements then we use javascript execuator type cast to driver
 * it is an interphase provided by openqa.selenium
 * @author vasu
 *
 */

public class javascript_FaceBook {
	public WebDriver driver;
  @Test
  public void LogIn_FaceBook() {
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('email').value='Vasu'");
	  js.executeScript("document.getElementById('pass').value='Vasu'");
	  js.executeScript("document.getElementById('u_0_8').click()");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
  }

}
