package main.java.Tests.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.Status;

import main.java.Utilities.ExtentTestManager;


public class LoginInspire_angular {
	WebDriver driver;
	WebDriverWait wait, waitCM;
	JavascriptExecutor executor;

	By username = By.xpath("//input[@name='username']");
	By pwd = By.xpath("//input[@name='password']");
	By login = By.xpath("//*[text()='Log in']");
	By search = By.xpath("//span[contains(text(),'Search')]");
	By searchtext = By.xpath("//input[@placeholder='Search']");
	By searchclick = By.xpath("//span[normalize-space()='monikacreate']"); 
	By notNow = By.xpath("//div[@role='button' and text()='Not now']"); 
	By postphoto = By.xpath("//a[@href='/p/C106BKAy64oazVlEil3DuUycPDW6oBqZ9LFSuQ0/']");
	By circle =By.xpath("//div//a[text()='monikacreate']");
	By elipses = By.xpath("//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x6s0dn4 x1oa3qoh xl56j7k']//*[name()='svg']");
	By clickLike = By.xpath("//span[@class='xp7jhwk']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']");
	By likeCountes = By.xpath("//a[@href='/p/C106BKAy64oazVlEil3DuUycPDW6oBqZ9LFSuQ0/liked_by/']/span/span");
	By clickGotopost = By.xpath("//button/a[@href='/p/C106BKAy64oazVlEil3DuUycPDW6oBqZ9LFSuQ0/']/span");
	By clickcreate = By.xpath("//span[contains(text(),'Create')]");
	By SelectFromComputer = By.xpath("//button[normalize-space()='Select from computer']");
	By clickphotonext = By.xpath("//div[contains(text(),'Next')]");
	By nextfiletrs = By.xpath("//img[@alt='Filter: Clarendon']");
	By entertext = By.xpath("//div[@aria-label='Write a caption...']");
	By sharephoto = By.xpath("//div//h1//div[contains(text(),'Post shared')]"); 
	By clickdisLike = By.xpath("//span[@class='xp7jhwk']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']");
	By accessibilty = By.xpath("//div[@role='textbox']");
	By clickcrossbutton = By.xpath("//div[@class='x160vmok x10l6tqk x1eu8d0j x1vjfegm']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']//*[text()='Close']");
    By delete = By.xpath("//div//button[text()='Delete']");
    By share = By.xpath("//div[contains(text(),'Share')]");
    By Messagelink =By.xpath("//span[contains(text(),'Messages')]");
    By sendmessage = By.xpath("//div[contains(text(),'Send message')]");
    By searchname = By.xpath("//input[@placeholder='Search...']");
    By searchnameclick = By.xpath("//span[contains(text(),'ritusasmita')]");
    By clickchat = By.xpath("//div[contains(text(),'Chat')]");
    By message = By.xpath("//p[@class='xat24cr xdj266r']");
    By unsendpath = By.xpath("//div[@aria-expanded='false']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']");
    By unsendmessage = By.xpath("//div[contains(text(),'Unsend')] ");
    By unsendclick = By.xpath("//button[@class='xjbqb8w x1qhh985 xcfux6l xm0m39n x1yvgwvq x13fuv20 x178xt8z x1ypdohk xvs91rp x1evy7pa xdj266r x11i5rnm xat24cr x1mh8g0r x1wxaq2x x1iorvi4 x1sxyh0 xjkvuk6 xurb0ha x2b8uid x87ps6o xxymvpz xh8yej3 x52vrxo x4gyw5p xkmlbd1 x1xlr1w8']");
    By forminput = By.xpath("//form//input[@type='file']");
    By clickoutside = By.xpath("//main[@class='xvbhtw8 x78zum5 xdt5ytf x1iyjqo2 x182iqb8']");
    By searchphotodelete = By.xpath("//a[@href='/p/C2Hn1TmyR9dasS7r_Xj1oADA1qzwYsCUyRgTeE0/']");
    By deleteelipses = By.xpath("//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x6s0dn4 x1oa3qoh xl56j7k']//*[name()='svg']");
	
	public LoginInspire_angular(WebDriver driver) {
		this.driver = driver;
		waitCM = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		executor = (JavascriptExecutor) driver;
	}

	public void loginToInstagram(String uname, String password) throws IOException, InterruptedException
	{
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(username));
			driver.findElement(username).sendKeys(uname);
			driver.findElement(pwd).sendKeys(password);
			driver.findElement(login).click();
			Thread.sleep(10000);
			ExtentTestManager.getTest().log(Status.PASS,
					"Logged in to Instagram.com with the username : " + uname );
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured ");
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
		}
	}
	
	public void clickOnSearch() throws IOException, InterruptedException
	{
		try {

			
			 WebElement clicknotNow = driver.findElement(notNow); 
			 clicknotNow.click();
		     Thread.sleep(10000);
			
	        WebElement searchIcon = driver.findElement(search); 
	        searchIcon.click();
	        Thread.sleep(30000);

	      
	        WebElement searchBar = driver.findElement(searchtext); 
	        searchBar.sendKeys("monikacreate");
	        Thread.sleep(3000);
	        
	        
	        WebElement clicksearchbar = driver.findElement(searchclick); 
	        clicksearchbar.click();
	        Thread.sleep(3000);
	        
			ExtentTestManager.getTest().log(Status.PASS,"Searched profile to Instagram.com");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured ");
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
		}
	}
	
	
	
	public void likePost() throws IOException, InterruptedException
	{
		try {
	 
			 WebElement clickonpost = driver.findElement(postphoto); 
			 clickonpost.click();
		     Thread.sleep(1000);
			
	        WebElement clickelepses = driver.findElement(elipses); 
	        clickelepses.click();
	        Thread.sleep(3000);

	        
	        WebElement goToPost = driver.findElement(clickGotopost); 
	        goToPost.click();
	        Thread.sleep(3000);
	        
	        
	        String getCount = driver.findElement(likeCountes).getAttribute("innerText"); 
	        System.out.println("like count :" +getCount);
	        Thread.sleep(3000);
	        

	        WebElement clickLike1 = driver.findElement(clickLike); 
	        clickLike1.click();
	        Thread.sleep(30000);
	        
	        String getCount1 = driver.findElement(likeCountes).getAttribute("innerText"); 
	        System.out.println("like count :" +getCount1);
	        Thread.sleep(3000);
	       
            
	        WebElement clickdislike = driver.findElement(clickdisLike); 
	        clickdislike.click();
	        Thread.sleep(30000);
	        
	        String getCount2 = driver.findElement(likeCountes).getAttribute("innerText"); 
	        System.out.println("dislike count :" +getCount2);
	        Thread.sleep(3000);
	        
			ExtentTestManager.getTest().log(Status.PASS,"Searched photo in the profile and like and dislike is performed");
		
	}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured ");
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));

			ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
		}
	}
		    
		    public void fileUploadTest() {

try 
{
	
    
                WebElement clickcreateicon = driver.findElement(clickcreate); 
                clickcreateicon.click();
                Thread.sleep(30000);
    
		        WebElement fileInput = driver.findElement(SelectFromComputer);
		        fileInput.click();
		        System.out.println("click on SelectFromComputer");
                Thread.sleep(30000);     

		        
                Runtime.getRuntime().exec("C:\\Users\\monika.attri\\Documents\\fileupload.exe");
                System.out.println("forminputimage");
		        Thread.sleep(10000); 
                
		   
		        WebElement clickphotonext1 = driver.findElement(clickphotonext); 
		        clickphotonext1.click();
		        
		        Thread.sleep(10000);
		        
		        WebElement clicknextfilter = driver.findElement(nextfiletrs); 
		        clicknextfilter.click();
		        Thread.sleep(10000);
		        
		        WebElement clickphotonext2 = driver.findElement(clickphotonext); 
		        clickphotonext2.click();
		        Thread.sleep(10000);
		       
		        WebElement searchBar = driver.findElement(entertext); 
		        searchBar.sendKeys("monikaphoto");
		        Thread.sleep(30000);
		       
		       
		        WebElement sharephotoclick = driver.findElement(share); 
		        sharephotoclick.click();
		        System.out.println("Photo is shared");
		        Thread.sleep(10000);
		        
				ExtentTestManager.getTest().log(Status.PASS,"Photo is shared");

		        
		    }
		    
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured ");
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
		}
}
		    
		    public void fileDeleteTest() {

		    	try 
		    	{
		    		       
		    		          
		    			        WebElement photodelete = driver.findElement(searchphotodelete); 
		    			        photodelete.click();
		    					 Thread.sleep(1000);
		    			        
		    			         // Find the search icon and click on it
		    			        WebElement deleteclickelepses = driver.findElement(deleteelipses); 
		    			        deleteclickelepses.click();
		    			        Thread.sleep(1000);
		    			        
		    			        WebElement clickdelete = driver.findElement(delete);
		    			        clickdelete.click();
		    			        Thread.sleep(1000);
		    			        
		    			        WebElement clickdelete2 = driver.findElement(delete);
		    			        clickdelete2.click();
		    			        Thread.sleep(1000);
		    			        System.out.println("Photo is deleted");
		    			        
		    					ExtentTestManager.getTest().log(Status.PASS,"Photo is deleted");
		    			     
		    			    }
		    			    
		    			catch (Exception e) {
		    				// TODO: handle exception
		    				System.out.println("Exception occured ");
		    				e.printStackTrace();
		    				StringWriter errors = new StringWriter();
		    				e.printStackTrace(new PrintWriter(errors));
		    				ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
		    			}
		    	}
		    
		    public void clickOnMessagelink() throws IOException, InterruptedException
			{
				try {
		
					 WebElement Messagelink1 = driver.findElement(Messagelink); 
					 Messagelink1.click();
				     Thread.sleep(10000);
					
			        WebElement sendmessagetext = driver.findElement(sendmessage); 
			        sendmessagetext.click();
			        Thread.sleep(30000);

			        WebElement searchnameinbar = driver.findElement(searchname); 
			        searchnameinbar.sendKeys("Sasmita Ritu");
				//	wait.until(ExpectedConditions.presenceOfElementLocated(salesforceSearch));
			        Thread.sleep(3000);
			        
			        
			        WebElement searchbarclick = driver.findElement(searchnameclick); 
			        searchbarclick.click();
			        Thread.sleep(3000);
			        
			        WebElement clickchattext  = driver.findElement(clickchat); 
			        clickchattext.click();
			        Thread.sleep(3000);
			        
			        // Find the search bar and enter text
			        WebElement messageenter = driver.findElement(message); 
			        messageenter.sendKeys("Hi,how are you ?",Keys.ENTER);
			        System.out.println("Hi,how are you ?");
			        Thread.sleep(3000);
			        
			        WebElement unsendpathclick = driver.findElement(unsendpath);
			        unsendpathclick.click();
			        System.out.println("unsendpathclick");
			        Thread.sleep(3000);
			        
			        // Find the search bar and enter text
			        WebElement unsendmessageclick = driver.findElement(unsendmessage); 
			        unsendmessageclick.click();
			        System.out.println("unsend message");
			        Thread.sleep(3000);
			        
			        // Find the search bar and enter text
			        WebElement unsendclickdone = driver.findElement(unsendclick); 
			        unsendclickdone.click();
			        System.out.println("unsendclickdone");
			        Thread.sleep(3000);
			 
			      
					ExtentTestManager.getTest().log(Status.PASS,"Message is sent and unsent");
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception occured ");
					e.printStackTrace();
					StringWriter errors = new StringWriter();
					e.printStackTrace(new PrintWriter(errors));
					ExtentTestManager.getTest().log(Status.INFO, "Exception occurred - loginToSalesforce " + errors.toString());		
				}
			}
			
			

	}			 


