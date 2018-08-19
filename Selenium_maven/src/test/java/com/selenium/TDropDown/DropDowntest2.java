package com.selenium.TDropDown;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
/**
 * 
 * @author vasu
 *
 */

public class DropDowntest2 {
	public WebDriver driver;
  @Test
  public void AmazonDD_1() {
	  driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computrescience");
	  driver.findElement(By.className("nav-input")).click();
	  String act_val = driver.getTitle();
	  String exp_val = "Amazon.in: Computrescience: Books";
	  Assert.assertEquals(act_val, exp_val);
	  
  }
  @Test
  public void AmazonDD_2() {
	 WebElement dd = driver.findElement(By.id("searchDropdownBox"));
	Select webelem=new Select(dd);
	webelem.selectByIndex(10);
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computrescience");
	  driver.findElement(By.className("nav-input")).click();
	  String act_val = driver.getTitle();
	  String exp_val = "Amazon.in: Computrescience: Books";
	  Assert.assertEquals(act_val, exp_val);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
  }

}
