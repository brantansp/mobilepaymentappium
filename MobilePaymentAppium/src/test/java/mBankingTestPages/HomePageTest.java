package mBankingTestPages;

import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mBankingPageObjectFactory.LoginPage;

public class HomePageTest extends LoginPage {
	public HomePageTest(AppiumDriver<MobileElement> driver) {
		//super(driver);
		// TODO Auto-generated constructor stub
	}

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@Test
	public void thirdTest()
	{
		log.info("test log");
		assertTrue(true);
	}
	
}
