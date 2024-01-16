package Webtesting;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import main.java.Utilities.ExtentTestManager;

public class BaseTest {

	public WebDriver driver;
	WebDriverWait wait;

	public void sampleDriverSetUp(String browsername) 
	{
		if(browsername.equals("Edge"))
		{
		//WebDriverManager.edgedriver().setup();
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting_values.notifications", 2);

		
EdgeOptions options = new EdgeOptions();
		
		options.addArguments("start-maximized");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-notifications");
		options.setExperimentalOption("prefs", prefs);
		
		Map<String, Object> Prefs = new HashMap<String, Object>();
		Prefs.put("profile.default_content_settings.popups", 0);
		System.out.println("reports path : "+System.getProperty("user.dir") + "\\Utilities\\ExcelReports");
		Prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Utilities\\ExcelReports");
		Prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
		Prefs.put("download.prompt_for_download", false);

	    
	    options.setExperimentalOption("prefs", Prefs);
	    driver = new EdgeDriver(options);
	

		driver.get("https://www.instagram.com/");
		
		System.out.println("Running in BROWSER NAME  ::  "+ ((ChromiumDriver) driver).getCapabilities().getBrowserName());
		System.out.println("Running in BROWSER VERSION  ::  " + ((ChromiumDriver) driver).getCapabilities().getBrowserVersion());
		ExtentTestManager.getTest().log(Status.PASS, "Successfully Launched Browser - "+ "Browser Name - " + ((ChromiumDriver) driver).getCapabilities().getBrowserName() +"Browser Version - "+ ((ChromiumDriver) driver).getCapabilities().getBrowserVersion());
		}
		
		else if (browsername.equals("Chrome"))
		{
	//	WebDriverManager.chromedriver().setup();
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting_values.notifications", 2);

		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("start-maximized");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	

		driver.get("https://www.instagram.com/");
		
		ExtentTestManager.getTest().log(Status.PASS, "Successfully Launched Browser - "+ "Browser Name - " + ((ChromiumDriver) driver).getCapabilities().getBrowserName() +"Browser Version - "+ ((ChromiumDriver) driver).getCapabilities().getBrowserVersion());
		}
		
		else
		{
			System.out.println("Please Provide Valid Browser Name");
			ExtentTestManager.getTest().log(Status.FAIL, "Please provide valid broswer Name in testng.xml");
		}
	}
	}

