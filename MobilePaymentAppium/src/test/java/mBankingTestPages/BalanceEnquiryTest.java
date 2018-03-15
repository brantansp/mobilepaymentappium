package mBankingTestPages;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.time.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.ObjectRepository;
import mBankingPageObjectFactory.BankingPage;
import mBankingPageObjectFactory.FeedbackPage;
import mBankingPageObjectFactory.HomePage;
import mBankingPageObjectFactory.LoginPage;

public class BalanceEnquiryTest extends ObjectRepository {
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static BankingPage bankingObj;
	protected FeedbackPage obj;
    static AppiumDriver<MobileElement> driver;// = getDriver(); ;
    
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	   
	//@Test(priority = 0)
	public void checkForLogin() throws InterruptedException
	{   
		log.info("**********Check for login**********");
		loginPage = new LoginPage(driver);
			log.info("true");
			loginPage.loginApp(prop.getProperty("apin"));
			waitForElement(Banking, 10);
		log.info("***************End***************");
	}
	
	@Test(priority=1)
	public void balanceEnq() throws InterruptedException
	{
		log.info("**********Balance Enquiry**********");
		homePage = new HomePage(driver);
		try {
			waitForElement(Banking, 30);
			click(Banking);
			bankingObj = new BankingPage (driver);
			//waitForElement(Balance_Enquiry, 30);
			clickView("Balance Enquiry");
			waitForElement(homePage.selectAcPage, 30);
			String[] accNo = listOfAc();
			bankingObj.balanceEnq(accNo);
		} catch (Exception e) {
			e.printStackTrace();
			click(homeBtn);
		}
		click(homeBtn);
		log.info("***************End***************");
	}
	
	@Test(priority=2)
	public void miniStatement() throws InterruptedException
	{
		log.info("**********Mini Statement**********");
		homePage = new HomePage(driver);
		waitForElement(Banking, 3);
		click(Banking);
		bankingObj = new BankingPage (driver);
		waitForElement(bankingObj.ms, 3);
		click(bankingObj.ms);
		waitForElement(bankingObj.headerText, 3);
		String[] accNo = listOfAc();
		bankingObj.miniStatement(accNo);
		log.info("***************End***************");
	}

}
