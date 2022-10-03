package caseStudy;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class AndroidKeys {
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
  public void f() throws InterruptedException {
	  System.out.println("App opened");
	  driver.findElement(MobileBy.AccessibilityId("App")).click();
	  System.out.println("Clicked on App");
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@text='Fragment']")).click();
	  System.out.println("Clicked on Fragment");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Alert Dialog\")")).click();
	  System.out.println("Clicked in Alert Dialog");
	  
	  AndroidElement show=(AndroidElement) driver.findElement(MobileBy.AccessibilityId("Show"));
	  tapByElement(show);
	  System.out.println("Tab on Show button");
	  
	  driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); // click on android phone back button        
      Thread.sleep(2000);
      
      driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));// click on android phone HOME button
      Thread.sleep(2000);
      
  }
  
	public void tapByElement(AndroidElement aelement) {
		new TouchAction(driver)
		.tap(tapOptions().withElement(element(aelement)))
		.waitAction(waitOptions(Duration.ofSeconds(10)))
		.perform();
	}
  @AfterTest
  public void afterTest() {
  }

}
