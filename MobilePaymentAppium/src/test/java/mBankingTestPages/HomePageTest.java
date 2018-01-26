package mBankingTestPages;

import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import mBankingPageObjectFactory.LoginPage;

public class HomePageTest extends LoginPage {
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@Test
	public void thirdTest()
	{
		log.info("test log");
		assertTrue(true);
	}
	
}
