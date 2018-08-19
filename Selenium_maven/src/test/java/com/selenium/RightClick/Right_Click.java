package com.selenium.RightClick;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Right_Click {
	public WebDriver driver;
  @Test
  public void Rightclick() {
	  driver.get("http://jqueryui.com/resizable/");
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement element = driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[4]/a"));
	  Actions a=new Actions(driver);
	  a.contextClick(element).perform();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }

}
