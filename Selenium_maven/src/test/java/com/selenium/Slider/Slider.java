package com.selenium.Slider;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class Slider {
	public WebDriver driver;
  @Test(enabled=false)
  public void slider() {
	  driver.get("http://jqueryui.com/slider/");
	  driver.switchTo().frame(0);
	  WebElement drag = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
	  Actions a=new Actions(driver);
	 /* a.dragAndDropBy(drag, 200, 0).perform();*/
	  a.clickAndHold(drag).moveByOffset(400, 0).release().build().perform();
  }
	  @Test
	  public void browserslider() {
		  driver.get("https://www.seleniumhq.org/download/");
		  ((RemoteWebDriver)driver).executeScript("window.scrollBy(0,1000)");
	  }
	  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }

}
