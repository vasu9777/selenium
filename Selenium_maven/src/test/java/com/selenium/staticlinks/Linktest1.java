package com.selenium.staticlinks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Linktest1 {
	public WebDriver driver;
	
  @Test
  public void f() {
	  int count=0;
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  System.out.println("the total links in application"+links.size());
	  for (int i = 0; i < links.size(); i++) 
	  {
		  if (!links.get(i).getText().isEmpty())
		  {
			count=count+1;
			String str=links.get(i).getText();
			System.out.println(str);
			links=driver.findElements(By.tagName("a"));
		}
		  }
	  System.out.println("the total visible links are:"+count);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
