package mBankingPageObjectFactory;


import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;

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
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;
import mBankingBaseFactory.Driver;
import mBankingBaseFactory.ObjectRepository;

public class HomePage extends ObjectRepository {
	
	public static AppiumDriver <MobileElement> driver ;
	
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	//@AndroidFindBy(id="android:id/button1")
	//("//*[@text='Yes']")).click();

	public HomePage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	public void clickBanking()
	{
		waitForElement(Banking,3000);
		click(Banking);
	}
	
	public String custName ()
	{
		waitForElement(helpBtn, 3000);
	    String name =welcomeText.getAttribute("text");
	    name = name.substring(name.lastIndexOf("Welcome")+8, name.length());
	    log.info("Name of customer in welcome page : " +name);
		return name;
	}
	
	public void help()
	{
	  waitForElement(helpBtn, 3000);
	  click(helpBtn);
      log.info("Text displayed is : \n"+helpTextView.getAttribute("text"));
      click(homeBtn);
	}
	public void changePin(String oldmpin, String newmpin, String reentermpin)
	{
		click(changemPINBtn);
		click(oldmPIN);
		sendText(oldmPIN, oldmpin);
		sendText(newmPIN, newmpin);
		sendText(reEntermPIN,reentermpin);
		click(okBtn);
	}
	
	public void logoutApp()
	{
		waitForElement (logoutBtn, 3000);
		click(logoutBtn);
		log.info("Clicked on Exit button");
		click(exitYesBtn);
		log.info("Clicked on Yes button");
	}

	
}

