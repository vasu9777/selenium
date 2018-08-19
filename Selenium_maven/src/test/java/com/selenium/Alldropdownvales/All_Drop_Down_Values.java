package com.selenium.Alldropdownvales;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
/**
 * 
 * @author vasu
 *
 */

public class All_Drop_Down_Values {
	public WebDriver driver;
  @Test
  public void Drop_Down_values() {
	   WebElement header = driver.findElement(By.id("searchDropdownBox"));
	   List<WebElement> dd = header.findElements(By.tagName("option"));
	   System.out.println(dd.size());
	   for (int i = 0; i < dd.size(); i++)
	   {
		System.out.println(dd.get(i).getText());
	}
	   
	}
  @Test(enabled=false)
  public void Amazon_Drop_Down_2() {
       WebElement header=driver.findElement(By.id("searchDropdownBox"));
      Select dd = new Select(header);
     List<WebElement> ddvalues =dd.getOptions();
     System.out.println(ddvalues.size());
     for (int i = 0; i < ddvalues.size(); i++) {
    	 System.out.println(ddvalues.get(i).getText());
		
	}
  }
      @BeforeMethod
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
  }

}
