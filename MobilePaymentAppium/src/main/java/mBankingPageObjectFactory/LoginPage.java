package mBankingPageObjectFactory;


import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;
import mBankingBaseFactory.Driver;
import mBankingBaseFactory.ObjectRepository;

public class LoginPage extends ObjectRepository {
	
	public static AppiumDriver <MobileElement> driver ;
	
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
		
	//android.widget.TextView
	
	public LoginPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	public void loginApp (String pin) throws InterruptedException
	{
	    try {
			waitForElement (loginBox, 10);
		} catch (Exception e) {
			log.info(e);
		}
		click(loginBox);
		sendText(loginBox, pin);
		click(loginOkBtn);
	}
	
	public ReferPage clickReferPage()
	{
		waitForElement (referLink, 3000);
		click(referLink);
		ReferPage referObj= new ReferPage(driver);
		return referObj;
	}
}
