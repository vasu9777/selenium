package com.selenium.Reseizable;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Reseizable {
	public WebDriver driver;
  @Test
  public void Reseizable_element() {
	  driver.get("http://jqueryui.com/resizable/");
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  WebElement drag = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
	  Actions a=new Actions(driver);
	  /*a.dragAndDropBy(drag, 150, 200).perform();*/
	  a.clickAndHold(drag).moveByOffset(300, 75).release().build().perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
  }

}
