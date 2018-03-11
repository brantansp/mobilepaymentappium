package mBankingTestPages;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
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
		waitForElement(homePage.bankingBtn, 3000);
		click(homePage.bankingBtn);
		bankingObj = new BankingPage (driver);
		waitForElement(bankingObj.be, 3000);
		click(bankingObj.be);
		waitForElement(bankingObj.headerText, 3000);
		String[] accNo = listOfAc();
		bankingObj.balanceEnq(accNo);
	}

}
