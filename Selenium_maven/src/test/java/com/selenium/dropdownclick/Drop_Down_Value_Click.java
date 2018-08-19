package com.selenium.dropdownclick;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Drop_Down_Value_Click {
	public WebDriver driver;
  @Test
  public void Clickdropdown() {
	  driver.findElement(By.linkText("More")).click();
	  WebElement header = driver.findElement(By.xpath("//*[@id='orb-panel-more']/div/ul"));
	  List<WebElement> links = header.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  for (int i = 0; i < links.size(); i++)
	  {
		 /*if (links.get(i).getText().equalsIgnoreCase("Radio"))*/
			 if (links.get(i).getText().equalsIgnoreCase("CBBC"))
		 {
			links.get(i).click();
			break;
		} 
		
	}
	  	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.bbc.com");
		driver.manage().window().maximize();
  }

}
