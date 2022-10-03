package caseStudy;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class LongPress {
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
	public void f() {

		System.out.println("App Opened");

		scrollToExactElement("Views");
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		System.out.println("clicked on Views");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		System.out.println("Clicked on Expandable Lists");
		
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"1. Custom Adapter\")")).click();
		
		AndroidElement btn=(AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator("text(\"People Names\")"));
		longPressElement(btn,5);
		System.out.println("Button Long pressed");

	}

//linktext - pass complete value
	public void scrollToExactElement(String str) {
		((AndroidDriver<WebElement>) driver).findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ str + "\").instance(0))"));
	}

	
	 public void longPressElement(AndroidElement aElement, long seconds ) { new
	  TouchAction<>(driver) .longPress(element(aElement))
	  .waitAction(waitOptions(Duration.ofSeconds(seconds))) 
	  .release() 
	  .perform();
	  }
	 
	@AfterTest
	public void afterTest() {
	}

}
