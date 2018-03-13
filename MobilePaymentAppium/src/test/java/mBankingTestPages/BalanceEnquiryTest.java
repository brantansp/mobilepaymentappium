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
import mBankingPageObjectFactory.BankingPage;
import mBankingPageObjectFactory.FeedbackPage;
import mBankingPageObjectFactory.HomePage;
import mBankingPageObjectFactory.LoginPage;

public class BalanceEnquiryTest extends AppiumController {
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static BankingPage bankingObj;
	protected FeedbackPage obj;
    static AppiumDriver<MobileElement> driver;// = getDriver(); ;
    
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	   
	@Test
	public void balanceEnq() throws InterruptedException
	{
		log.info("**********Balance Enquiry**********");
		loginPage = new LoginPage(driver);
		loginPage.loginApp("1111");
		homePage = new HomePage(driver);
		try {
			waitForElement(homePage.bankingBtn, 10);
			click(homePage.bankingBtn);
			bankingObj = new BankingPage (driver);
			try {
				waitForElement(bankingObj.be, 10);
				click(bankingObj.be);
				try {
					waitForElement(bankingObj.headerText, 10);
					String[] accNo = listOfAc();
					bankingObj.balanceEnq(accNo);
					homePage.logoutApp();
				} catch (Exception e) {
					log.info(e);
				}
			} catch (Exception e) {
				log.info(e);
			}
		} catch (Exception e) {
			log.info(e);
			click(homePage.homeBtn);
		}
	}
	
	@Test
	public void miniStatement() throws InterruptedException
	{
		log.info("**********Mini Statement**********");
        loginPage = new LoginPage(driver);
		loginPage.loginApp("1111");
		homePage = new HomePage(driver);
		waitForElement(homePage.bankingBtn, 3);
		click(homePage.bankingBtn);
		bankingObj = new BankingPage (driver);
		waitForElement(bankingObj.ms, 3);
		click(bankingObj.ms);
		waitForElement(bankingObj.headerText, 3);
		String[] accNo = listOfAc();
		bankingObj.miniStatement(accNo);
		homePage.logoutApp();
	}

}
