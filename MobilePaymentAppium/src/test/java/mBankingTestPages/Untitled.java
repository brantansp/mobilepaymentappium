package mBankingTestPages;


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
import java.util.concurrent.TimeUnit;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;

public class Untitled {
private String reportDirectory = "reports";
private String reportFormat = "xml";
private String testName = "Untitled";
protected AndroidDriver<AndroidElement> driver = null;

private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

DesiredCapabilities dc = new DesiredCapabilities();

@BeforeMethod
public void setUp() throws MalformedURLException {
dc.setCapability("deviceName", "Android");
dc.setCapability("testName", testName);
dc.setCapability(MobileCapabilityType.UDID, "HKE7YGUA");
dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fss.united");
dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashScreen");
dc.setCapability("noReset", "true");		
driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
log.info("before closed");
}

public void waitFor(ExpectedCondition<WebElement> expectedCondition, Integer timeout)
{
	timeout = timeout != null ? timeout :5;
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(expectedCondition);	
}

public boolean waitForElement(By locator, Integer... timeout)
{
	try {
		waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeout.length > 0 ?  timeout[0] : null));
	} catch (org.openqa.selenium.TimeoutException exception) {
		return false;
	}
	return true;
}

@Test
public void testUntitled() throws InterruptedException {
log.info(driver.currentActivity());
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
//waitForElement(By.className("//android.widget.TextView"), 3000);
Thread.sleep(5000);
//AndroidElement test =driver.findElement(By.className("//android.widget.TextView"));
ArrayList<AndroidElement> test = new ArrayList <AndroidElement> (10);
test = (ArrayList<AndroidElement>) driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\")");
int n = test.size();
Iterator list = test.iterator();
System.out.println("Number of tabs " +n);
log.info("txn id : "+test.lastIndexOf("Transaction ID"));
log.info("txn id : "+test.indexOf("Date and Time"));
log.info("txn id : "+test.indexOf("Acknowledgement"));
log.info("Transaction is : "+test.get(6).getAttribute("text"));
log.info("Transaction is : "+test.get(5).getAttribute("text"));
log.info("Transaction is : "+test.get(4).getAttribute("text"));
log.info("Transaction is : "+test.get(3).getAttribute("text"));
for (int i=0; i<n; i++)
{
    log.info(i +" : I is : "+test.get(i).getAttribute("text"));
}  
}

public void test(){/*
driver.findElement(By.xpath("//*[@text='Banking']")).click();
driver.findElement(By.xpath("//*[@text='Mini Statement']")).click();
driver.findElement(By.xpath("//*[@text='0720XXX303862']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Banking']")).click();
driver.findElement(By.xpath("//*[@text='Fund Transfer - Within Bank']")).click();
driver.findElement(By.xpath("//*[@text='Mobile-to-Mobile']")).click();
driver.findElement(By.xpath("//*[@text='Quick Fund Transfer']")).click();
driver.findElement(By.xpath("//*[@text='0720XXX303862']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("1234321234");
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")));
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("100");
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[3]")).sendKeys("test");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='Confirm']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='gridiconll' and ./*[@text='Banking']]")).click();
driver.findElement(By.xpath("//*[@text='Fund Transfer - Within Bank']")).click();
driver.findElement(By.xpath("//*[@text='Mobile-to-Mobile']")).click();
driver.findElement(By.xpath("//*[@text='Beneficiary Registration']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("8778602561");
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")));
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("newuserreg");
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='8764XXX411111']")).click();
driver.findElement(By.xpath("//*[@text='Confirm']")).click();
driver.pressKeyCode(AndroidKeyCode.BACK);
new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")));
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Banking']")).click();
driver.findElement(By.xpath("//*[@text='Fund Transfer - Within Bank']")).click();
driver.findElement(By.xpath("//*[@text='Mobile-to-Mobile']")).click();
driver.findElement(By.xpath("//*[@text='Beneficiary Payment']")).click();
driver.findElement(By.xpath("//*[@text='0720XXX303862']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='gridiconll' and ./*[@text='Banking']]")).click();
driver.findElement(By.xpath("//*[@text='Fund Transfer - Within Bank']")).click();
driver.findElement(By.xpath("//*[@text='Mobile-to-Mobile']")).click();
driver.findElement(By.xpath("//*[@text='Beneficiary Details']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='icon_image' and ./following-sibling::*[@text='Banking']]")).click();
driver.findElement(By.xpath("//*[@text='Balance Enquiry']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Banking']")).click();
driver.findElement(By.xpath("//*[@text='Fund Transfer - Within Bank']")).click();
driver.findElement(By.xpath("//*[@text='Mobile-to-Mobile']")).click();
driver.findElement(By.xpath("//*[@text='Beneficiary Deregistration']")).click();
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("2222");
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='OK']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Logout']")).click();
driver.findElement(By.xpath("//*[@text='Yes']")).click();
*/}

@AfterMethod
public void tearDown() {
   //driver.quit();
}
}