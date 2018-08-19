package com.vsoft.selenium.Selenium_maven;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * @author vasu
 *
 */
public class BasePage {
	public WebDriver driver;
	public void BrowserLaunch(String browser,String Url) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
