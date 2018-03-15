package mBankingTestPages;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mBankingBaseFactory.AppiumController;
import mBankingPageObjectFactory.HomePage;
import mBankingPageObjectFactory.LoginPage;

public class HomePageTest extends AppiumController {
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	AppiumDriver<MobileElement> driver;// = getDriver(); ;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@Test(priority =1)
	public void checkHelp()
	{
		log.info("**********Help Text**********");
		homePage = new HomePage(driver);
		homePage.help();
		click(homePage.logoutBtn);
		click(homePage.exitYesBtn);
		log.info("***************End***************\n");
	}
	
	@Test(priority =0)
	public void custName() throws InterruptedException
	{
		log.info("**********Welcome page Name**********");
		loginPage = new LoginPage(driver);
		loginPage.loginApp(prop.getProperty("apin"));
		homePage = new HomePage(driver);
		homePage.custName();
		log.info("***************End***************\n");
	}
	
	//@Test
	public void changePinValid() throws InterruptedException
	{
		log.info("**********Exit Application**********");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.loginApp(prop.getProperty("apin"));
		Thread.sleep(5000);
		homePage.changePin("2222","1234","1234");
		log.info("***************End***************\n");
		//getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	}
}
