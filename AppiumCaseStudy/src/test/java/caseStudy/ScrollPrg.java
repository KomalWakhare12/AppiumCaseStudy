package caseStudy;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class ScrollPrg {
	
	AndroidDriver driver;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {

	  File app = new File(System.getProperty("user.dir") + "/App/ApiDemos-debug.apk");        
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // install app in device
      cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "8.1");
      cap.setCapability("deviceName", "emulator-5554");   

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }

  @Test
  public void scrollDemo() throws InterruptedException {
	  

		System.out.println("App Opened");

		scrollToExactElement("Views");
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		System.out.println("clicked on Views");
		
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Controls\")")).click();
		System.out.println("Clicked on Controls");
		
		driver.findElement(MobileBy.AccessibilityId("2. Dark Theme")).click();
		System.out.println("Clicked on Dark Theme");
		
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Test");
		
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); // click on android phone back button        
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner1']")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Mars\")")).click();
		System.out.println("Mars selected");
		
		/*
		 * AndroidElement planet=(AndroidElement) driver.findElement(By.xpath(
		 * "//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner1']"
		 * ));
		 * 
		 * Select sel=new Select(planet); 
		 * sel.selectByVisibleText("Mars");
		 * System.out.println("Mars selected from dropdown");
		 */		 
  }
  
//linktext - pass complete value
	public void scrollToExactElement(String str) {
		((AndroidDriver<WebElement>) driver).findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ str + "\").instance(0))"));
	}
  
  @AfterTest
  public void afterTest() {
  }

}
