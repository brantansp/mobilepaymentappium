package mBankingTestPages;

import java.lang.invoke.MethodHandles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mBankingBaseFactory.*;
import mBankingPageObjectFactory.*;


public class FundTransfer extends AppiumController {

	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static BankingPage bankingObj;
	protected static FundTransferPage ftObj;
	protected FeedbackPage obj;
    static AppiumDriver<MobileElement> driver;// = getDriver(); ;
    
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	   
	@Test
	public void m2mQFtSuccess() throws InterruptedException
	{
		log.info("**********FT M2M QFT**********");
		loginPage = new LoginPage(driver);
		loginPage.loginApp("1111");
		homePage = new HomePage(driver);
		try {
			waitForElement(homePage.bankingBtn, 10);
			click(homePage.bankingBtn);
			ftObj = new FundTransferPage (driver);
			try {
				waitForElement(ftObj.ftWb, 10);
				ftObj.m2mQuick();
			} catch (Exception e) {
				log.info(e);
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			click(homePage.homeBtn);
		}
	}
	
}
