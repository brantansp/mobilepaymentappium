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
	
	//@Test
	public void thirdTest()
	{

	}
	
	@Test
	public void appExit() throws InterruptedException
	{
		log.info("**********Exit Application**********");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		LoginPage.loginApp("1111");
		Thread.sleep(5000);
		homePage.changePin();
		Thread.sleep(5000);
		//getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	}
}
