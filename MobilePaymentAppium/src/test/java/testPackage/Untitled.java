package testPackage;


import mBankingBaseFactory.ObjectRepository;
import mBankingPageObjectFactory.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;

public class Untitled extends ObjectRepository{
private String reportDirectory = "reports";
private String reportFormat = "xml";
private String testName = "Untitled";
AppiumDriver<MobileElement> driver=getDriver();

private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

DesiredCapabilities dc = new DesiredCapabilities();

/*@BeforeMethod
public void setUp() throws MalformedURLException {
dc.setCapability("deviceName", "Android");
dc.setCapability("testName", testName);
dc.setCapability(MobileCapabilityType.UDID, "HKE7YGUA");
dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fss.united");
dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashScreen");
dc.setCapability("noReset", "true");		
driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
log.info("before closed");
}*/

public void waitFor(ExpectedCondition<WebElement> expectedCondition, Integer timeout)
{
	timeout = timeout != null ? timeout :5;
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(expectedCondition);	
}

public boolean waitForElement(By locator, Integer... timeout)
{
	log.info("entered wait");
	try {
		waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeout.length > 0 ?  timeout[0] : null));
	} catch (org.openqa.selenium.TimeoutException exception) {
		return false;
	}
	log.info("element found");
	return true;
}

@Test
public void testUntitled() throws InterruptedException {
//log.info(driver.currentActivity());
/*
waitForElement(By.xpath("//android.widget.Button[@text='Refer']"), 3000);
driver.findElement(By.xpath("//android.widget.Button[@text='Refer']")).click();
waitForElement (By.xpath("//android.widget.EditText[@text='Friend Name']"), 3000);
driver.findElement(By.xpath("//android.widget.EditText[@text='Friend Name']")).click();
driver.findElement(By.xpath("//android.widget.EditText[@text='Friend Name']")).sendKeys("test");
driver.findElement(By.xpath("//android.widget.EditText[@text='Friends E-mail ID']")).click();
driver.findElement(By.xpath("//android.widget.EditText[@text='Friends E-mail ID']")).sendKeys("brantansp@fss.co.in");
driver.findElement(By.xpath("//android.widget.EditText[@text='Friends Mobile No']")).click();
driver.findElement(By.xpath("//android.widget.EditText[@text='Friends Mobile No']")).sendKeys("8778602561");
driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
String text = "Date and Time";
waitForElement(By.xpath("//android.widget.TextView[@text='"+text+"']"),30);
log.info(driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).getText());
ArrayList<AndroidElement> test;// = new ArrayList <AndroidElement> (10);
test = (ArrayList<AndroidElement>) driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\")");
int n = test.size();
ArrayList <String> values = new ArrayList <String>();
for (AndroidElement value : test) {
  //System.out.println("Value = " + value.getAttribute("text"));
    values.add(value.getAttribute("text"));
 }  

Map<String, String> map = new HashMap<String, String>();

for ( int b = 0 ; b < n-1 ; )
{
	map.put(test.get(b+1).getAttribute("text"), test.get(b+2).getAttribute("text"));
	b = b+2;
}

log.info("Page Title is : "+test.get(0).getAttribute("text"));

for (String key : map.keySet())
{
	log.info(key +" : "+map.get(key));
}

log.info(map.get("Transaction ID"));
*/
	LoginPage	loginPage = new LoginPage(driver);
waitForEditText ("Application PIN", 30);
clickEditText("Application PIN");
sendText("Application PIN", "3333");
click(loginOkBtn);
waitForElement(By.xpath("//android.widget.Button[@text='Logout']"),30);

}

}