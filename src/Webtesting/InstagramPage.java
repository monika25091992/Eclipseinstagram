package Webtesting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import main.java.Tests.Testcases.LoginInspire_angular;
import main.java.Utilities.ExtentTestManager;
import main.java.Utilities.ReadExcelData;

@Test
public class InstagramPage extends BaseTest {

	@Parameters({ "uname", "password", "browsername" })
	@BeforeTest()
	public void startUp(String uname, String password, String browsername) throws InterruptedException, IOException {
		ExtentTestManager.startTest("Browser_Launch");
		sampleDriverSetUp(browsername);
		LoginInspire_angular login = new LoginInspire_angular(driver);
		login.loginToInstagram(uname, password);
		ExtentTestManager.endTest();
		System.out.println("logged in succesfully");
	}
	
	@Test(enabled = true)
	public void Instagramfunctionality() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Instagramfunctionality");
		LoginInspire_angular login = new LoginInspire_angular(driver);
		login.clickOnSearch();
		login.likePost();
		ExtentTestManager.endTest();
		System.out.println("Instagram functionality in succesfully");
	}
	
	@Test(enabled = false)
	public void Instagramfunctionalityupload() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Instagramfunctionality");
		LoginInspire_angular login = new LoginInspire_angular(driver);
		login.clickOnSearch();
		login.fileUploadTest();
		ExtentTestManager.endTest();
		System.out.println("Instagram functionality in succesfully");
	}
	
	@Test(enabled = false)
	public void Instagramfunctionalitydelete() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Instagramfunctionality");
		LoginInspire_angular login = new LoginInspire_angular(driver);
		login.clickOnSearch();
		login.fileDeleteTest();
		ExtentTestManager.endTest();
		System.out.println("Instagram functionality in succesfully");
	}

	@Test(enabled = false)
	public void Instagramfunctionalitysearch() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Instagramfunctionality");
		LoginInspire_angular login = new LoginInspire_angular(driver);
		login.clickOnSearch();
		login.clickOnMessagelink();
		ExtentTestManager.endTest();
		System.out.println("Instagram functionality in succesfully");
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}
}
