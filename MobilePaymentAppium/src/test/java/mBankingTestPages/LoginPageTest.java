package mBankingTestPages;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mBankingBaseFactory.*;
import mBankingPageObjectFactory.*;

public class LoginPageTest {

	protected LoginPage loginPage;
	protected HomePage homePage;

	AppiumDriver<MobileElement> driver;

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test(priority = 0)
	public void appLogin() throws InterruptedException {
		
		driver = Driver.getDriver();
		loginPage = new LoginPage(driver);
		
		
		log.info("**********Login to Application**********");
		loginPage.loginApp("2222");
		log.info("***************End***************");
	}

	@Test(priority = 1)
	public void appExit() throws InterruptedException {
		log.info("**********Exit Application**********");
		homePage = new HomePage(driver);
		homePage.logoutApp();
		log.info("***************End***************");
	}
}
