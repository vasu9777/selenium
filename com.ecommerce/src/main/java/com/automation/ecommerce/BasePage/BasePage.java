package com.automation.ecommerce.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/**
 * 
 * @author vasu
 *
 */
public class BasePage {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	
	static 
	{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")
                                   +"/src/main/java/com/automation/ecommerce/htmlReports/test"
				                            +dateformat.format(cal.getTime())+".html",false);
	}
	public void BrowserLaunch(String browser,String Url) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			
			
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		
		}else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
	
			
		}
		driver.get(Url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(Log4Jpath);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static final String path="./config.properties";
	public String getData(String key) throws Exception {
		File f=new File(path);
		FileInputStream fi=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fi);
		return p.getProperty(key);
		
	}
	
	
	public int randomNumber() {
		Random r=new Random();
	    int random = r.nextInt(9999);
	    return random;
	}
	
public void selectOption(WebElement element,int option) {
	Select s= new Select(element);
	s.selectByIndex(option);
}

public void elementVisible(WebElement element,int time) {
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public String Log4Jpath="Log4j.properties";

@AfterMethod
public void endReport(ITestResult result) {
	      getResult(result);
	
}

public void getResult(ITestResult result2) {
	if(result2.getStatus()==ITestResult.SUCCESS) {
		test.log(LogStatus.PASS,result2.getName()+"Test is success");
	}else if (result2.getStatus()==ITestResult.FAILURE) {
		test.log(LogStatus.FAIL,result2.getName()+ " Test is failed reason is : "
	                                                               +result2.getThrowable());
	}else if (result2.getStatus()==ITestResult.SKIP) {
		test.log(LogStatus.SKIP,result2.getName()+ " Test is skipped reason is : "
                +result2.getThrowable());
	
         }
}
@BeforeMethod
public void startReport(Method result) {
	test=extent.startTest(result.getName());
	test.log(LogStatus.INFO, result.getName()+" Test is Started");
}
@AfterClass
public void endTest() {
	closeBrowser();
}


private void closeBrowser() {
	//driver.quit();
	extent.endTest(test);
	extent.flush();
	
}

}
