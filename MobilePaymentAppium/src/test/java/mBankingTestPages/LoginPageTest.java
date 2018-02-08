package mBankingTestPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mBankingBaseFactory.*;
import mBankingPageObjectFactory.*;
import mBankingUtility.*;

public class LoginPageTest extends AppiumController{

	protected LoginPage loginPage;
    AppiumDriver<MobileElement> driver;// = getDriver(); ;
    
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	}
	
	@Test(priority = 0)
	public void appLogin() throws InterruptedException
	{
		log.info("**********Login to Application**********");
		loginPage = new LoginPage(driver);
		loginPage.loginApp("1111");
		Assert.assertEquals(true, true);
	Thread.sleep(5000);
		//	getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	}
	
	@Test(priority = 10)
	public void appExit() throws InterruptedException
	{
		log.info("**********Exit Application**********");
		loginPage = new LoginPage(driver);
		loginPage.logoutApp();
		Thread.sleep(5000);
		//getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	}
	
	@Test(priority = 20)
	public void referFriendValid() throws InterruptedException
	{
		log.info("**********Refer Friend**********");
		loginPage = new LoginPage(driver);
		ReferPage obj =loginPage.clickReferPage();
		obj.referFriend("brantan", "brantan@fss.co.in", "9894060407");
		String acknowledgment =  obj.referFriendTxnStatus();
        Assert.assertEquals(acknowledgment, "Your request for refer a friend accepted");
        
        Thread.sleep(5000);
//        getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        log.info("Test Passed");
	}

	
}
