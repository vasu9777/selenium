package com.automation.ecommerce.PageUI;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ecommerce.BasePage.BasePage;

public class SignInAccount extends BasePage{
	public static final Logger log=Logger.getLogger(SignInAccount.class.getName());
	@FindBy(linkText="Sign in")WebElement SignIn;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passwd")WebElement passwd;
	@FindBy(id="SubmitLogin")WebElement SubmitLogin;
	
	public SignInAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn() throws Exception {
		log.info("clicked on signin button with object:"+SignIn.toString());
		SignIn.click();
		log.info("entering email id:"+email.getAttribute("value")+"Using object"+email.toString());
		email.sendKeys(getData("email"));
		log.info("entering passwd:"+passwd.getAttribute("value")+"Using object"+passwd.toString());
		passwd.sendKeys(getData("passwd"));
		log.info("clicked on signin button with object:"+SignIn.toString());
		SignIn.click();
	}

} 

