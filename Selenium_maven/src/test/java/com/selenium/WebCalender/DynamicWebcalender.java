package com.selenium.WebCalender;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
/**
 * web calender handling in checkin checkout dates 
 * @author vasu
 *
 */
public class DynamicWebcalender {
	public WebDriver driver;
  public void SelectDate(String Month_year,String day) throws Exception {
	  List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div/div/div"));
	  System.out.println(elements.size());
	  for (int i = 0; i < elements.size(); i++) {
		  i=0;
		  System.out.println(elements.get(i).getText());
		if (elements.get(i).getText().equals(Month_year)) {
			List<WebElement> tabledata = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a"));
			for(WebElement d :tabledata) {
				System.out.println(d.getText());
				if (d.getText().equals(day)) {
					d.click();
					break;
				}
			}
			break;
		}else {
			driver.findElement(By.xpath("//span[text()='Next']")).click();;
			Thread.sleep(5000);
			elements = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div/div/div"));
		}
	}
  }
  @Test
  public void f() throws Exception {
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	  driver.findElement(By.xpath("//*[@id=\"flightSearchContainer\"]/div[4]/button")).click();
	  Thread.sleep(3000);
	  //Check_in Date
	  String Chechin_date="18-November 2018";
	  String[] splitter=Chechin_date.split("-");
	  String Checkin_Date=splitter[0];
	  String Checkin_Month=splitter[1];
	  SelectDate(Checkin_Month, Checkin_Date);
	  Thread.sleep(5000);
	 
	  //Check_Out
	 
	  driver.findElement(By.xpath("//*[@id=\"Div1\"]/button")).click();
	  String Checkout_date="30-November 2018";
	  @SuppressWarnings("unused")
	String[]Chk_splitter=Checkout_date.split("-");
	  String Checkout_Date=splitter[0];
	  String Checkout_Month=splitter[1];
	  SelectDate(Checkout_Month, Checkout_Date);
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://spicejet.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

}
