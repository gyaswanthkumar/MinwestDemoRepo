package com.minnwest.utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {
	
static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			Date d = new Date();
			String reportFolder = d.toString().replaceAll(":", "-");
			String screenshotpath = System.getProperty("user.dir")+"\\target\\reports\\screenshots\\"+reportFolder;
			String reportsFolderPath = System.getProperty("user.dir")+"\\target\\reports\\"+reportFolder;
			//System.out.println(screenshotpath);//for screenshot
			File f = new File(screenshotpath); //for screenshot
			//f.mkdirs(); //create dynamic report folder name + screenshot
			
			extent = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportsFolderPath);
			sparkReporter.config().setReportName("Production");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setEncoding("utf-8");
			
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Automation Tester", "Usha");
			
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			//extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

}
