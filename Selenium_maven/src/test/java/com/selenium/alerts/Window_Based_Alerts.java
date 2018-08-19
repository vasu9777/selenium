package com.selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * manage window based alerts using auto it tool and provide .exe file
 * by upload a photo
 * @author vasu
 *
 */

public class Window_Based_Alerts {
	public static WebDriver driver;
	@Test
	public static void verifylogin(){
		driver.findElement(By.linkText("HMS")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	}
	@Test
public static void verifyregistration(){
	driver.findElement(By.linkText("Registration")).click();
	driver.findElement(By.linkText("Perminent Registration")).click();
	
}
	@Test
public static void verifyPr() throws Exception{
	new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Self");
	new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Brother");
	new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
	driver.findElement(By.name("MOTHER_NAME")).sendKeys("chandrika");
	driver.findElement(By.name("PNT_NAME")).sendKeys("Siva");
	new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("AAdhar Card");
	driver.findElement(By.name("LAST_NAME")).sendKeys("raja");
	driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345678978");
	driver.findElement(By.name("DOB")).click();
	driver.findElement(By.xpath("/html/body/div[4]/table[2]/tbody/tr[2]/td[3]")).click();
	/*driver.findElement(By.name("image")).sendKeys("D:\\photos\\pooja.jpeg");*/
	Runtime.getRuntime().exec("D:\\Library\\AutoIt_Scripts\\pr_hms.exe");
	driver.findElement(By.name("AGE")).sendKeys("21");
	new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
	new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");
	new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("Yes");
	new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
	new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("MCA");
	new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Hindu");
	new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Employee");
	new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("Telugu");
	new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("O+");
	new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
	new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("Yes");	
}

@BeforeTest
public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.seleniumbymahesh.com/");
		driver.manage().window().maximize();
}
}