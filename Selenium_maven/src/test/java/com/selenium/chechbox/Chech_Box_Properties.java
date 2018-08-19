package com.selenium.chechbox;

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
 *to click check box s their return true and null values
 */

public class Chech_Box_Properties {
	public WebDriver driver;
  @Test
  public void Click_Check_Box() {
	  List<WebElement> checkbox = driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
	  System.out.println(checkbox.size());
	  for (int i = 0; i < checkbox.size(); i++) 
	  {
		  System.out.println(checkbox.get(i).getAttribute("value")+"---"+checkbox.get(i).getAttribute("checked"));
		}
	   
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
  }

}
