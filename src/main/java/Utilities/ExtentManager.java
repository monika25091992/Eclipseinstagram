package main.java.Utilities;

import java.io.File;
import java.util.Date;
import java.util.Random;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	 private static ExtentReports extent;
	 	static double randomnumber= Math.random();
	    public static String reportFileName = "SeleniumRegression"+ Double.toString(randomnumber)+".html";
	    private static String fileSeperator = System.getProperty("file.separator");
	    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport"+fileSeperator+"RunReports";
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	    
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	        //String fileName = getReportPath(reportFilepath);
	    
	        ExtentSparkReporter spark = new ExtentSparkReporter(reportFileLocation);
	        
	        
	        spark.config().setDocumentTitle("Selenium Regression");
	                        // Name of the report
	        spark.config().setReportName("Selenium Regression");
	                        // Dark Theme
	        spark.config().setTheme(Theme.STANDARD);
	 
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        return extent;
	    }
	     
	   
	 

		
	}

