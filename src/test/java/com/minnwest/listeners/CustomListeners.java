package com.minnwest.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.minnwest.base.TestBase;
import com.minnwest.utilities.ExtentManager;
import com.minnwest.utilities.MonitoringMail;
import com.minnwest.utilities.TestConfig;
import com.minnwest.utilities.TestUtil;



public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	static String messageBody;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onFinish(ITestContext iTestResult) {
		if (extent != null) {

            extent.flush();
        }
		
	}

	public void onStart(ITestContext context) {
	
		
				
	}
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult iTestResult) {

		String excepionMessage= Arrays.toString(iTestResult.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		try {
            String path = TestUtil.captureScreenshot();
            //test.addScreenCaptureFromPath(path);
            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(path)
                            .build());
        }catch (IOException e) {

        }
		String failureLogg="TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
      //  logg.info("Failed because of  -"+iTestResult.getThrowable());
	
		
	}

	public void onTestSkipped(ITestResult iTestResult) {
		//System.out.println("Test case is skipped");
		String methodName=iTestResult.getMethod().getMethodName();
        String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";
        Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(m);
        
	}


	public void onTestStart(ITestResult iTestResult) {
		System.out.println("Test case is started");
		ExtentTest test = extent.createTest(iTestResult.getTestClass().getName()+"     @TestCase : "+iTestResult.getMethod().getMethodName());
        testReport.set(test);
       
		//test = extent.startTest(arg0.getName().toUpperCase());
	
	}

	public void onTestSuccess(ITestResult iTestResult) {
		//System.out.println("Test case is successfull");
		String methodName=iTestResult.getMethod().getMethodName();
        String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
        Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
      
		//test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		//rep.endTest(test);
		//extent.flush();
		
	}

	public void onFinish(ISuite arg0) {
		
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}
