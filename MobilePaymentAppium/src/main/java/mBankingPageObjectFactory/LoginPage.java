package mBankingPageObjectFactory;


import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;

public class LoginPage extends AppiumController {
	
	private LoginPage loginPage;
	
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@AndroidFindBy(id = "com.fss.united:id/header")
	private MobileElement logoHeader;
	
	@AndroidFindBy(className= "android.widget.ImageView")
	private MobileElement logoView;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	private MobileElement loginBox;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]")
	private MobileElement okButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='About Us']")
	private MobileElement aboutUs;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Forgot Password']")
	private MobileElement forgotPassword;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Products']")
	private MobileElement products;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Refer']")
	private MobileElement Refer;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='ePassbook']")
	private MobileElement ePassbook;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Feedback']")
	private MobileElement feedback;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Locator']")
	private WebElement locator;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Wallet']")
	private By wallet;

	public void loginApp(String pin)
	{
/*	log.info("check");
	   // waitForScreenToLoad(driver, loginBox, 30);
		click(loginBox);
        sendText(loginBox, pin);
        click(okButton);
        loginPage.loginBox.click();
        loginBox.sendKeys("1111");
        okButton.click();
      */
        
        driver.findElementByXPath("//*[@class='android.widget.EditText']").click();
        driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys(pin);
	  	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]")).click();
	}

/*    
    {
    	  driver.findElement(By.xpath("//*[@text='Products']")).click();
    	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")));
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();
    	  driver.findElement(By.xpath("//*[@text='Refer']")).click();
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();
    	  driver.findElement(By.xpath("//*[@text='ePassbook']")).click();
    	  driver.pressKeyCode(AndroidKeyCode.BACK);
    	  driver.findElement(By.xpath("//*[@text='Feedback']")).click();
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();
    	  driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("1111111");
    	  driver.findElement(By.xpath("((//*[@class='android.widget.TableLayout' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='frag_main']]]/*[@class='android.widget.TableRow'])[1]/*[@class='android.widget.Button'])[2]")).click();
    	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Logout']")));
    	  driver.findElement(By.xpath("//*[@text='Logout']")).click();
    	  driver.findElement(By.xpath("//*[@text='Yes']")).click();
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();
    	  driver.findElement(By.xpath("//*[@text='Locator']")).click();
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();
    	  driver.findElement(By.xpath("//*[@text='Wallet']")).click();
    	  driver.pressKeyCode(AndroidKeyCode.BACK);
    	  driver.findElement(By.xpath("//*[@text='Help']")).click();
    	  driver.findElement(By.xpath("//*[@text='Home']")).click();

    }  */
 
/* let el1 = driver.element("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.EditText");
 el1.click();
 el1.setValue("1111");
 let el2 = driver.element("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]");
 el2.click();*/
 
 
 
}
