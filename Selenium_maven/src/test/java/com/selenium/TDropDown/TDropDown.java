package com.selenium.TDropDown;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
/**
 * 
 * @author vasu
 *
 */

public class TDropDown {
	public WebDriver driver;
  @Test
  public void DropDownTest() {
	  WebElement dd = driver.findElement(By.id("month"));
	       Select monthdd = new Select(dd);
	       monthdd.selectByVisibleText("Jul");
	       monthdd.selectByValue("12");
	       monthdd.selectByIndex(3);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
  }

}
