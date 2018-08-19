package com.selenium.DynamicTables;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class Dynamic_Tables {
	public WebDriver driver;
  @Test
  public void Dynamic_Table_Handling() throws Exception {
	  Select table = new Select(driver.findElement(By.id("Select1")));
	  table.selectByIndex(4);
	  //checks for table row count
	   List<WebElement> tr_collection = driver.findElements(By.xpath("//table[@id='Table9']/tbody/tr")); 
	  System.out.println("Numbers of Rows in this Table : "+ tr_collection.size());
	  //checks for table row count
	  List<WebElement> td_collection = driver.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
	  System.out.println("Number of cells in this Table : "+td_collection.size());
	  //checks for table column count
	  System.out.println("Number of columns in this Table :"+td_collection.size()/tr_collection.size());
	 
	  //print all the data from table
	  int row_num,col_num;
	  row_num=1;
	  for (WebElement tr_Element : td_collection) {
		  List<WebElement> td_collection1 = tr_Element.findElements(By.tagName("td"));
		  col_num=1;
		  for (WebElement td_Element : td_collection1) {
			  System.out.println("Row # :"+row_num+" Column:"+" "+col_num+"Text : "
		                                                                            +td_Element.getText());
			  col_num++;
			  Thread.sleep(3000);
			
		}
		row_num++;
	}
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

}
