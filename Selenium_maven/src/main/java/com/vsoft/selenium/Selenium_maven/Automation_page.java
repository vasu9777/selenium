package com.vsoft.selenium.Selenium_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
  * 
  * @author vasu
  *
  */
public class Automation_page {

	@FindBy(linkText="Sign in")WebElement signinloc;
	@FindBy(id="email")WebElement emailloc;
	@FindBy(id="passwd")WebElement passwdloc;
	@FindBy(name="SubmitLogin")WebElement submitloc;
	@FindBy(xpath="//div[@class='alert alert-danger']/ol/li")WebElement erroemsgloc;
	

public Automation_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public void login() {
	signinloc.click();
	emailloc.sendKeys("abc123@gmail.com");
	passwdloc.sendKeys("abc123");
	submitloc.click();
	
}
public String geterrormsg() {
	return erroemsgloc.getText();
}
}

