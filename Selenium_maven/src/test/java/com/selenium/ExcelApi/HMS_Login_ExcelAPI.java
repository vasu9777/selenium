package com.selenium.ExcelApi;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class HMS_Login_ExcelAPI {
	public WebDriver driver;
	public ExcelApi e;
  @Test
  public void f() throws Exception {
	  e=new ExcelApi("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  int noOfRows=e.getRows("Sheet2");
	  for(int i=1;i<noOfRows;i++)
	  {
		  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.name("username")).sendKeys(e.getCellValue("Sheet2", 0, i));
	  Thread.sleep(3000);
	  //driver.findElement(By.name("password")).sendKeys(e.getCellValue("Sheet2", 1, 1));
	// driver.findElement(By.name("submit")).click();
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
  }

}
