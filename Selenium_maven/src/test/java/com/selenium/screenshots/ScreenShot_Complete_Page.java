package com.selenium.screenshots;

import org.testng.annotations.Test;

/**
 * by using date and time format without replace existing pics
 * it will take entire screen shot on page
 */

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ScreenShot_Complete_Page {
	public WebDriver driver;
  @Test
  public void f() throws IOException {
	  Date dt=new Date();
	  DateFormat dtformat=new SimpleDateFormat("dd-MMM-yy HH-mm-ss");
	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scr, new File("D:\\Library\\Screen_Shots\\"+dtformat.format(dt)+"hms.jpeg"));
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
  }

}
