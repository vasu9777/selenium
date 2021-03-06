package com.selenium.alerts;

import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
/**
 * to manage notification alerts on red bus by using chrome options below code
 * @author vasu
 *
 */

public class Notification_Alert_Red_Bus {
	 public WebDriver driver;
  @Test
	 public void BootStarp_Alert() throws Exception {
		  driver.findElement(By.id("i-icon-profile")).click();
		  Thread.sleep(15000);
		  driver.findElement(By.id("signInLink")).click();
		  Thread.sleep(8000);
		  driver.switchTo().frame(driver.findElement(By.className("modelIframe")));
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id='facebookBtn']/button")).click();
		  Set<String> windows = driver.getWindowHandles();
		  System.out.println(windows.size());
		  System.out.println(windows);
		  Object[] str = windows.toArray();
		  driver.switchTo().window(str[1].toString());
		  driver.findElement(By.id("email")).sendKeys("vasurajaboyina@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("abc123");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("---disable-notifications");
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver(options);
			driver.get("http://redbus.in");
			driver.manage().window().maximize();
	  }

	}

  
  
