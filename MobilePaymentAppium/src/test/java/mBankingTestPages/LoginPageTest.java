package mBankingTestPages;

import static org.testng.Assert.assertTrue;
import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;
import mBankingPageObjectFactory.LoginPage;
import mBankingUtility.ExtentManager;

public class LoginPageTest extends LoginPage{

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) {
		log.info("Main Log test one");

	}
	
	@Test
	public void firstTest()
	{
		log.info("test log");
		assertTrue(true);
	}
	
	@Test
	public void secondTest()
	{
		log.info("2nd log");
		assertTrue(true);
	}
	
}
