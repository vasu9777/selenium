package com.selenium.paticularportion;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class LinkTest3 {
	public WebDriver driver;

  @Test
  public void f() throws Exception {
	  WebElement header=driver.findElement(By.xpath(" /html/body/div[8]/div/section[6]/div/div/div[2]"));
	  
	  List<WebElement>links=header.findElements(By.tagName("a"));
	  System.out.println("availablle links are:"+links.size());
	  for (int i = 0; i < links.size(); i++) {
		  System.out.println(links.get(i).getText());
		  links.get(i).click();
		  Thread.sleep(8000);
		  System.out.println(driver.getCurrentUrl());
		  driver.navigate().back();
		  Thread.sleep(5000);
		  links=driver.findElements(By.tagName("a"));
		  links.get(i).click();
		  System.out.println(links.get(i).getText());
	}
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://bbc.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
