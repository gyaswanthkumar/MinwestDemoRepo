package com.minnwest.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.minnwest.pages.LoginPage;
import com.minnwest.utilities.TestUtil;

public class Minnwest_Login extends LoginPage{

	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void minnwest_Login(Hashtable<String,String> data) throws InterruptedException {

		if(!(TestUtil.isTestRunnable("Minnwest_Login", excel))){
			
			throw new SkipException("Skipping the test "+"Minnwest_Login".toUpperCase()+ "as the Run mode is NO");
		}
		Thread.sleep(5000);
		setusername("username_XPATH",data.get("username"));
		Thread.sleep(3000);
		setpassword("password_XPATH",data.get("password"));
		Thread.sleep(3000);
		clicklogin("login_button_XPATH");
		Thread.sleep(3000);
		clicksinout("sinout_CLASS_XPATH");
		Thread.sleep(6000);
		clickYES("YES_XPATH");
		Thread.sleep(3000);
		clicktackservey("tackservey_XPATH");
		Thread.sleep(3000);
		clickrate("rate_XPATH");
		Thread.sleep(3000);
		clicksubmit("submit_XPATH");
		Thread.sleep(3000);
		clickservey("servey_XPATH");
		Thread.sleep(3000);
		clickYes("Yes_XPATH");
		Thread.sleep(3000);
		clickTRANSFER("TRANSFER_XPATH");
		Thread.sleep(3000);
		clickSUBMIT("SUBMIT_XPATH");
		Thread.sleep(3000);
		clickDONE("DONE_XPATH");
		Thread.sleep(3000);
		
		
		
//		clicklogin("signOut_XPATH");
//		Thread.sleep(3000);
//		clicklogin("approve_XPATH");
//		Thread.sleep(3000);
//		clicktake("take-XPATH");
//		Thread.sleep(4000);
		

	}
	
}
