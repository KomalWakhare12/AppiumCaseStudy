package caseStudy;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class Calc {
  
	AndroidDriver driver;
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "8.1");
      cap.setCapability("deviceName", "emulator-5554");
      cap.setCapability("appPackage","com.android.calculator2");
      cap.setCapability("appActivity","com.android.calculator2.Calculator");
      
      driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
  }

  @Test
  public void multiply() {
	  System.out.println("App opened");
	  driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_8']")).click();
	  System.out.println("Clicked on 8");
	  driver.findElement(By.xpath("//android.widget.Button[@content-desc='multiply']")).click();
	  System.out.println("Cicked on Multiply");
	  driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
	  System.out.println("Clicked on 9");
	  driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();
      System.out.println("clicked on =");
	  Assert.assertEquals(72, 72);
	  System.out.println("Validation done");
  }
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.closeApp();
	  
  }

}
