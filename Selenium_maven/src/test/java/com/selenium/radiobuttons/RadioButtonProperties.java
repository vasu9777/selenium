package com.selenium.radiobuttons;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
/**
 * 
 * @author vasu
 *to check radio button properties to click one by one
 */

public class RadioButtonProperties {
	public WebDriver driver;
  @Test
  public void f() {
	  @SuppressWarnings("unused")
	WebElement radio = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
	 /* List<WebElement> radioButton = driver.findElements(By.name("group2"));*/
	  /**
	   * to just change group name
	   */
	  List<WebElement> radioButton = driver.findElements(By.name("group1"));
	  for (int i = 0; i < radioButton.size(); i++) 
	  {
		System.out.println(radioButton.get(i).getAttribute("value")+"---"
	                                                                 +radioButton.get(i).getAttribute("checked"));
	}
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
  }

}
