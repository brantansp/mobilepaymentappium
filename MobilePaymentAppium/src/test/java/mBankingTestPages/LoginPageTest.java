package mBankingTestPages;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
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
    AppiumDriver<MobileElement> driver ;
    
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
/*
String line = "null";
String cmd = "adb devices";

Runtime run = Runtime.getRuntime();
Process pr = run.exec(cmd);

pr.waitFor();

BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
while ((line=buf.readLine())!=null) {
System.out.println(line);
}
*/
	}
	
	@Test(priority = 0)
	public void firstTest() throws InterruptedException
	{
		log.info("Inside Test");
		loginPage = new LoginPage(driver);
		loginPage.loginApp("1111");
		Assert.assertEquals(true, true);
		Thread.sleep(4000);
		//loginPage.logoutApp();
	}
	//@Test(priority = 1)
	public void exit() throws InterruptedException
	{
		loginPage = new LoginPage(driver);
		loginPage.logoutApp();
		Thread.sleep(4000);
		
	}
	
	//@Test(priority = 2)
	public void referFriendValid()
	{
		loginPage = new LoginPage(driver);
		ReferPage obj =loginPage.clickReferPage();
		obj.referFriend("brantan", "brantan@fss.co.in", "9894060407");
		String acknowledgment =  obj.referFriendTxnStatus();
        Assert.assertEquals(acknowledgment, "Your request for refer a friend accepted");
	}

	
}
