package com.vsoft.selenium.Selenium_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author vasu
 *
 */
public class PageUI {
	@FindBy(linkText="HMS")WebElement hmsloc;
	@FindBy(name="username")WebElement usernameloc;
	@FindBy(name="password")WebElement passwordloc;
	@FindBy(name="submit")WebElement loginloc;
	@FindBy(linkText="Logout")WebElement logoutloc;
	
	public PageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void hmsLogin() {
		hmsloc.click();
		usernameloc.sendKeys("admin");
		passwordloc.sendKeys("admin");
		loginloc.click();
		
	}
	public void hmsLogout() {
		logoutloc.click();
	}
	

}
