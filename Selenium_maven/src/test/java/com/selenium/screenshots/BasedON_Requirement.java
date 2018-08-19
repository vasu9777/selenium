package com.selenium.screenshots;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * take screenshot with link name and save to destination folder
 * by using date and time format with out replace existing pics
 * @author vasu
 *
 */

public class BasedON_Requirement {
	public WebDriver driver;
  @Test
  public void f() throws IOException {
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  for (int i = 0; i < links.size(); i++) {
		  String linkname = links.get(i).getText();
		  System.out.println(linkname);
		  links.get(i).click();
		  if (driver.getTitle().contains("Register: Mercury Tours")) {
			 
		Date dt=new Date();
		DateFormat dtformat=new SimpleDateFormat("dd-MMM-yy HH-mm-ss");
			
		
		  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File("D:\\Library\\Screen_Shots\\"+""+linkname+"---"
		                                                                     +dtformat.format(dt)+"demo.png"));
		  }
			links = driver.findElements(By.tagName("a"));	
			
	  }
		  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
  }

}
