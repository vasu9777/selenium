package com.automation.ecommerce.gridtwo;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HubSelenium {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN8_1);
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		String hubURL = "http://192.168.0.3:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(hubURL), cap);
		driver.get("http://spicejet.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	}

}
