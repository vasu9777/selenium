package com.selenium.switchTOwindows;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
/**
 * to switch multiple windows one single application by using below code hdfc banking login
 * @author vasu
 *
 */
public class Switch_To_Windows {
	public WebDriver driver;

  @Test
  public void verifyPopUp() throws Exception {
	  String title = driver.getTitle();
	  System.out.println("title of the window:"+title);
	  String mainWindow = driver.getWindowHandle();
	  System.out.println("main window ID:"+mainWindow);
	  driver.findElement(By.id("loginsubmit")).click();
	  Set<String> windows = driver.getWindowHandles();
	  System.out.println("Avilable windows ID's are:"+windows);
	  Iterator<String> itr=windows.iterator();
	  while (itr.hasNext()) {
		String currentWindow = itr.next();
		System.out.println("current windoww ID:"+currentWindow);
		if (!currentWindow.equalsIgnoreCase(mainWindow)) {
			driver.switchTo().window(currentWindow);
			System.out.println("current window title:"+driver.getTitle());
			
		}
		
	}
	  driver.manage().window().maximize();
	  /*driver.findElement(By.xpath("(\\a[@class'btn btn-default redBtn'])[2]")).click();*/
	  driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
	  Thread.sleep(3000);
	  driver.close();
	  driver.switchTo().window(mainWindow);
	  System.out.println("title:"+driver.getTitle());
  }
  @BeforeTest
  public void beforeTest() {
	  
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://hdfcbank.com");
			driver.manage().window().maximize();
  }

}

