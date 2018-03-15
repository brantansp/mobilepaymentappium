package mBankingTestPages;

import java.lang.invoke.MethodHandles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mBankingBaseFactory.*;
import mBankingPageObjectFactory.*;


public class FundTransferTest extends ObjectRepository {

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
		homePage = new HomePage(driver);
		try {
			waitForElement(homePage.Banking, 10);
			//waitForElement("Banking",30);
			clickView("Banking");
			ftObj = new FundTransferPage (driver);
			try {
				waitForElement(ftObj.ftWb, 10);
				ftObj.m2mQuick("8778602561","10","test");
			} catch (Exception e) {
				log.error(e, e);
				System.out.println(e);
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			click(homePage.homeBtn);
		}
	}
	
	@Test
	public void m2mBenReg() throws InterruptedException
	{
		log.info("**********FT M2M Ben Reg**********");
		homePage = new HomePage(driver);
		try {
			waitForElement(homePage.Banking, 10);
			click(homePage.Banking);
			ftObj = new FundTransferPage (driver);
			try {
				waitForElement(ftObj.ftWb, 10);
				ftObj.BenReg("9407556318","AKON");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			click(homePage.homeBtn);
		}
	}

	//@Test
    public void checktxn() throws InterruptedException
    {
		log.info("**********chk**********");
		loginPage = new LoginPage(driver);
        loginPage.loginApp(prop.getProperty("apin"));
		//homePage = new HomePage(driver);
		try {
			waitForElement(Banking, 50);
			//waitForTextView("Banking", 50);
			//sleep(5000);
			//waitForTextView("Logout1",50);
			clickView("Banking");
			clickView("Balance Enquiry");
            processEditBox(listOfAc());
			} catch (Exception e) {
				e.printStackTrace();
			}
    }



}











