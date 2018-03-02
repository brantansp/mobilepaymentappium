package mBankingPageObjectFactory;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

	@Test
	public class ActivationPage {
	 private String reportDirectory = "reports";
	 private String reportFormat = "xml";
	 private String testName = "Untitled";
	 protected AndroidDriver<AndroidElement> driver = null;

	 DesiredCapabilities dc = new DesiredCapabilities();
	 
	 @BeforeMethod
	 public void setUp() throws MalformedURLException, InterruptedException {
	  dc.setCapability("reportDirectory", reportDirectory);
	  dc.setCapability("reportFormat", reportFormat);
	  dc.setCapability("testName", testName);
	  dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Lenovo K8 Plus");
	  dc.setCapability(MobileCapabilityType.UDID, "HKE7YGUA");
	  dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fss.united");
	  dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashScreen");
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	 Thread.sleep(5000);
	 }
	 
	 public void testUntitled() {
	  driver.findElement(By.xpath("//*[@text='Proceed']")).click();
	  driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("8778602561");
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@text='Click here to regenerate OTP']")).click();
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
	  driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("391681");
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@text='Login']")).click();
	  driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).click();
	  driver.findElement(By.xpath("//*[@text='United Mobile']")).click();
	  driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("8778602561");
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
	  driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("901351");
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@text='Login']")).click();
	  driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("111");
	  driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("1111");
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")));
	  driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("1");
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@id='gridiconll' and ./*[@text='My Setup']]")).click();
	  driver.findElement(By.xpath("//*[@text='Account Fetch']")).click();
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.findElement(By.xpath("//*[@text='Home']")).click();
	  driver.findElement(By.xpath("//*[@text='Logout']")).click();
	  driver.findElement(By.xpath("//*[@text='Yes']")).click();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
	     driver.quit();
	 }
}
