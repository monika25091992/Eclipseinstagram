package Appium;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static void main(String[] args) {
	
	 AppiumDriver driver;
	
		try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	//s	caps.setCapability("platformName","ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
	//	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
	    caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
	//	caps.setCapability(MobileCapabilityType.UDID,"8f3ae310a74c0da2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
	//	caps.setCapability(MobileCapabilityType.APP,"");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		
		URL url = new URL("https://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver(url, caps);
//		driver = new AndroidDriver<MobileElement>(url, caps);
//		driver = new IOSDriver<MobileElement>(url, caps);
//		
			
		
	}
		catch(Exception exp) {
			
			System.out.println("Cause is"+exp.getCause());
			System.out.println("Message is : " +exp.getMessage());
			exp.printStackTrace();
			
		}
	}
	
	@Test(enabled = true)
	public void sampleTest() throws InterruptedException, IOException  {
		
		System.out.println("I am inside sample Test");
	}
		
	@AfterTest
	public void teardown() {

	}

}

	
