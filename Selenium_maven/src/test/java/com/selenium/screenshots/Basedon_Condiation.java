package com.selenium.screenshots;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
/**
 * based on condiation we take scrn shot
 * @author vasu
 *
 */

public class Basedon_Condiation {
	public WebDriver driver;
  @Test
  public void f() throws IOException {
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  for (int i = 0; i < links.size(); i++) {
		  System.out.println(links.get(i).getText());
		
	}
	  if (!(links.size()==0)) {
		  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File("D:\\Library\\Screen_Shots\\hms.png"));
			  
	}
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
  }

}
