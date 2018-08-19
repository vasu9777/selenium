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
 *another type for clicking a check box and return values
 */

public class Click_Check_Box {
	public WebDriver driver;
  @Test
  public void f() {
	  List<WebElement> checkbox = driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
	  for (int i = 0; i < checkbox.size(); i++) 
	  {
		if (!checkbox.get(i).isSelected()) 
		{
			checkbox.get(i).click();
		}
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
