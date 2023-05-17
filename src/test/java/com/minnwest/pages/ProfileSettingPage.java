package com.minnwest.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.minnwest.base.TestBase;


public class ProfileSettingPage extends TestBase{
	
	public void clickSettings(String loc) {
		click(loc);
	}
	
	public void clickProfileSetting(String loc) {
		click(loc);
	}
	
	public void clickProfile(String loc) {
		click(loc);
	}
	
	public void add_deletePhoto() throws InterruptedException, AWTException {
		WebElement addphoto = driver.findElement(By.xpath("//label[@title=\"Add Photo\"]"));
//        JavaScriptExecutor.ElementHightlight(driver, addphoto);
        addphoto.click();
        Thread.sleep(5000);
        Robot rb1 = new Robot();
        String image1 = System.getProperty("user.dir")+"\\Minnwest_Photos\\MicrosoftTeams-image (1) (1).png";
        StringSelection ss1 = new StringSelection(image1);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
        rb1.keyPress(KeyEvent.VK_ENTER);
        rb1.keyPress(KeyEvent.VK_CONTROL);
        rb1.keyPress(KeyEvent.VK_V);
        rb1.keyRelease(KeyEvent.VK_CONTROL);
        rb1.keyRelease(KeyEvent.VK_V);
        rb1.keyPress(KeyEvent.VK_ENTER);
        rb1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        WebElement editphoto = driver.findElement(By.xpath("//label[@title=\"Edit\"]"));
        editphoto.click();
        Thread.sleep(5000);
        Robot rb2 = new Robot();
        String text= System.getProperty("user.dir")+"\\Minnwest_Photos\\MicrosoftTeams-image (1) (1).png";
        StringSelection ss2 = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
        rb2.keyPress(KeyEvent.VK_CONTROL);
        rb2.keyPress(KeyEvent.VK_V);
        rb2.keyRelease(KeyEvent.VK_CONTROL);
        rb2.keyRelease(KeyEvent.VK_V);
        rb2.keyPress(KeyEvent.VK_ENTER);
        rb2.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        WebElement deletephoto = driver.findElement(By.xpath("//label[@title=\"Delete\"]"));
        deletephoto.click();
        Thread.sleep(5000);
        WebElement yespopup = driver.findElement(By.xpath("//label[@title=\"Yes\"]"));
        yespopup.click();
        Thread.sleep(5000);
        System.out.println("End of add and delete photo");
	}
	public void Add_Del_PhoneNumber() throws InterruptedException {
		try {
			System.out.println("in add del phone number ");
			click("phone_XPATH");
			Thread.sleep(3000);
			click("add_phone_XPATH");
			Thread.sleep(3000);
			select("type_drop_XPATH","Work");
			Thread.sleep(3000);
			type("add_numner_XPATH","1234567890");
			Thread.sleep(3000);
			click("save_button_XPATH");
			Thread.sleep(3000);
			click("edit_number_XPATH");
			Thread.sleep(3000);
			select("type_drop_XPATH","Mobile");
			Thread.sleep(3000);
			type("add_numner_XPATH","1234567899");
			Thread.sleep(3000);
			click("save_button_XPATH");
			Thread.sleep(3000);
			click("delete_number_XPATH");
			Thread.sleep(3000);
			click("alert_delete_XPATH");
			Thread.sleep(3000);
			click("email_click_XPATH");
			Thread.sleep(3000);
			click("edilt_email_XPATH");
			Thread.sleep(3000);
			select("type_drp_XPATH","Home");
			Thread.sleep(3000);
			clear("email_passing_XPATH");
			type("email_passing_XPATH","srinivasarayudu.k@kairostech.com");
			Thread.sleep(3000);
			click("saving_email_XPATH");
			Thread.sleep(8000);
		
		}catch(Exception e) {
			System.out.println("Exception handling Failed");
		}
		}
	

}
