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
 * to all the radio button properties values as order by using for loops 
 */

public class Print_Radio_Button_Properties {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  WebElement radio = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
	  for (int k = 0; k < 3; k++) {
		  List<WebElement> radiobutton = radio.findElements(By.name("group"+k));
		  for (int i = 0; i < radiobutton.size(); i++) {
			  radiobutton.get(i).click();
			  for (int j = 0; j < radiobutton.size(); j++) {
				System.out.println(radiobutton.get(i).getAttribute("value")+"---"+
			                                                      radiobutton.get(j).getAttribute("checked"));
				Thread.sleep(3000);
			}
			
		}
		
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
