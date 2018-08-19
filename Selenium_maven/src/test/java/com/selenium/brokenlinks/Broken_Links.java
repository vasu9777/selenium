package com.selenium.brokenlinks;

import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
/**
 * 
 * @author vasu
 *
 */

public class Broken_Links {
	public WebDriver driver;
  @Test
  public void Linkstest_1() {
	 List<WebElement> links =driver.findElements(By.tagName("a"));
	  System.out.println("Total Links are: "+links.size());
	  for (int i = 0; i < links.size(); i++) {
		String url = links.get(i).getAttribute("href");
		verifylinksActive(url);
		
		}
  }
  @SuppressWarnings("static-access")
private void verifylinksActive(String linkurl) {
	  try {
		URL url=new URL(linkurl);
		HttpURLConnection httpurlconn=(HttpURLConnection) url.openConnection();
		httpurlconn.setConnectTimeout(3000);
		httpurlconn.connect();
		if (httpurlconn.getResponseCode()==200) {
			System.out.println(linkurl+"-"+httpurlconn.getResponseMessage());
			}
		if (httpurlconn.getResponseCode()==httpurlconn.HTTP_NOT_FOUND) {
			System.out.println(linkurl+"-"+httpurlconn.getResponseMessage()+httpurlconn.HTTP_NOT_FOUND);
			
		}
			
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	
}
@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		/*driver.get("http://newtours.demoaut.com/");*/
		driver.get("http://www.durgasoft.com");
		driver.manage().window().maximize();
  }

}
