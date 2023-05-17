package com.minnwest.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.minnwest.pages.ProfileSettingPage;
import com.minnwest.utilities.TestUtil;

public class Add_Delete_Profile extends ProfileSettingPage{

	@Test
	public void addDeleteProfile() throws InterruptedException, AWTException {
		clickSettings("setting_XPATH");
		Thread.sleep(3000);
		clickProfileSetting("profileSetting_XPATH");
		Thread.sleep(3000);
		Assert.fail();
		clickProfile("profile_XPATH");
		Thread.sleep(3000);
		add_deletePhoto();
		Thread.sleep(6000);
		Add_Del_PhoneNumber();
		Thread.sleep(3000);
	}
}
