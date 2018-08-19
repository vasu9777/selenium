package com.selenium.Drag_Drop;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class DragNDrop {
	public WebDriver driver;
	
  @Test
  public void Drag_Drop() {
	  driver.switchTo().frame(0);
	 WebElement drag = driver.findElement(By.id("draggable"));
	 WebElement drop = driver.findElement(By.id("droppable"));
	 Actions a=new Actions(driver);
	/* a.dragAndDrop(drag, drop).perform();*/
	 /**
	  * any one can use but build .perform uses multiple methods
	  */
	 a.clickAndHold(drag).moveToElement(drop).release().build().perform();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
	  
  }

}
