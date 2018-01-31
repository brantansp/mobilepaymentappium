package mBankingTestPages;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;
import mBankingPageObjectFactory.LoginPage;
import mBankingUtility.ExtentManager;

public class LoginPageTest  extends AppiumController{

	protected LoginPage loginPage;
	static AppiumDriver<MobileElement> driver;

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
	
	
	@Test
	public void firstTest() throws InterruptedException
	{
		loginPage = new LoginPage();
		loginPage.loginApp();
	}
	

	
}
