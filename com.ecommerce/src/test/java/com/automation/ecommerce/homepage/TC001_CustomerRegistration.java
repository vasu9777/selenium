package com.automation.ecommerce.homepage;

import org.testng.annotations.Test;
import com.automation.ecommerce.BasePage.BasePage;
import com.automation.ecommerce.PageUI.CreateLoginInAccount;
import com.automation.ecommerce.PageUI.SignInAccount;

import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class TC001_CustomerRegistration extends BasePage{
	public static final Logger log=Logger.getLogger(TC001_CustomerRegistration.class.getName());
  @Test
   public void CustomerRegistration() throws Exception {
	  log.info("************test started****************");
	 CreateLoginInAccount login=new CreateLoginInAccount(driver);
	 login.CreateAccount();
	log.info("************test ended*******************");
	 
  }
  /*(dependsOnMethods= {"CustomerRegistration"})*/
  @Test
	 public void customerSign() throws Exception {
	  log.info("************test started****************");
		SignInAccount sa=new SignInAccount(driver);
		sa.SignIn();
		log.info("************test ended*******************");
		}
  
@BeforeTest
  public void setUp() throws Exception {
	  BrowserLaunch(getData("browser"), getData("Url"));
  }

  @AfterTest
  public void killProcess() {
  }

}
