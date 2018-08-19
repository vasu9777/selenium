package com.automation.ecommerce.PageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ecommerce.BasePage.BasePage;

public class CreateLoginInAccount extends BasePage{
	public static final Logger log=Logger.getLogger(CreateLoginInAccount.class.getName());
	@FindBy(linkText="Sign in")WebElement SignIn;
	@FindBy(id="email_create")WebElement emailID;
	@FindBy(id="SubmitCreate")WebElement Submit;
	@FindBy(xpath="//h1[text()='Create an account']")WebElement CreateAnAccount;
	@FindBy(id="id_gender1")WebElement gender;
	@FindBy(id="customer_firstname") WebElement customerfirstname;
	@FindBy(id="customer_lastname")WebElement customerlastname;
	@FindBy(id="passwd") WebElement passwd;
	@FindBy(id="days") WebElement day;
	@FindBy(id="months") WebElement month;
	@FindBy(id="years") WebElement year;
	@FindBy(id="address1") WebElement address;
	@FindBy(id="city") WebElement city;
	@FindBy(id="id_state") WebElement state;
	@FindBy(id="postcode") WebElement Postcode;
	@FindBy(id="id_country") WebElement country;
	@FindBy(id="phone_mobile") WebElement phoneNumber;
	@FindBy(id="submitAccount") WebElement registar;
	@FindBy(xpath="//h1[text()='My account']") WebElement myAccount;
	@FindBy(linkText="Sign out")WebElement Signout;
	
	
	public CreateLoginInAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void CreateAccount() throws Exception {
		SignIn.click();
		log.info("clicked on signin button with object:"+SignIn.toString());
		emailID.sendKeys(getData("customerfirstname")+getData("customerlastname")+randomNumber()+getData("domainName"));
		log.info("entering email id:"+emailID.getAttribute("value")+"Using object"+emailID.toString());
		Submit.click();
		log.info("clicking create an account:"+Submit.toString());
		elementVisible(CreateAnAccount,30);
		assertEquals(CreateAnAccount.getText(), "CREATE AN ACCOUNT");
		log.info("verified customer info page by using object:"+CreateAnAccount.toString());
		gender.click();
		log.info("clicking on radio button by using object:"+gender.toString());
		customerfirstname.sendKeys(getData("customerfirstname"));
		log.info("entering data into text box by using object:"+customerfirstname.toString());
		customerlastname.sendKeys(getData("customerlastname"));
		log.info("entering data into text box by using object:"+customerlastname.toString());
		passwd.sendKeys(getData("passwd"));
		log.info("entering password into text box by using object:"+passwd.toString());
		selectOption(day, 5);
		log.info("select day by using object:"+day.toString());
		selectOption(month, 7);
		log.info("select month by using object:"+month.toString());
		selectOption(year, 8);
		log.info("select year by using object:"+year.toString());
		address.sendKeys(getData("address"));
		log.info("entering adress into text box by using object:"+address.toString());
		city.sendKeys(getData("city"));
		log.info("entering city into text box by using object:"+city.toString());
		selectOption(state, 5);
		log.info("select state by using object:"+state.toString());
		Postcode.sendKeys(getData("Postcode"));
		log.info("entering postal code into text box by using object:"+Postcode.toString());
		selectOption(country, 1);
		log.info("select country by using object:"+country.toString());
		phoneNumber.sendKeys(getData("phoneNumber"));
		log.info("entering phonenumber into text box by using object:"+phoneNumber.toString());
		registar.click();
		log.info("clicking register button:"+registar.toString());
		elementVisible(myAccount, 30);
		assertEquals(myAccount.getText(),"MY ACCOUNT");
		log.info("verified customer info page by using object:"+CreateAnAccount.toString());
		Signout.click();
		log.info("clicking signout button:"+Signout.toString());
	}
	
}

