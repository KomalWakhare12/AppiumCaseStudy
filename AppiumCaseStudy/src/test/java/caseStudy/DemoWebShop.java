package caseStudy;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;


import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoWebShop {
	
	AndroidDriver driver;
	
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
	  cap.setCapability(MobileCapabilityType.BROWSER_NAME,MobileBrowserType.CHROME);
	  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");
	  
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }
  
  @Test
  public void f() {
	  System.out.println("Browser Opened");
	  
	  driver.get("http://demowebshop.tricentis.com/");
	  System.out.println("Website Opened");
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop");
	  System.out.println("Validation done");
	  
	  driver.findElement(By.linkText("Register")).click();
	  System.out.println("Title is:"+driver.getTitle());
	  System.out.println("Current URL is:"+driver.getCurrentUrl());
	  
	  driver.findElement(By.id("gender-female")).click();
	  driver.findElement(By.name("FirstName")).sendKeys("Komal");
	  driver.findElement(By.id("LastName")).sendKeys("Wakhare");
	  driver.findElement(By.name("Email")).sendKeys("komal.wakhare89@gmail.com");
	  driver.findElement(By.name("Password")).sendKeys("komal321");
	  driver.findElement(By.name("ConfirmPassword")).sendKeys("komal321");
	  driver.findElement(By.id("register-button")).click();
	  System.out.println("Registration Successful");
	  
	  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
	  
	  driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
	  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Search");
	  System.out.println("Title Matched");
	  driver.findElement(By.linkText("Log out")).click();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }

}
