package mBankingPageObjectFactory;


import static org.testng.Assert.assertTrue;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.BasePage;
import mBankingBaseFactory.Driver;

public class LoginPage extends AppiumController {
	
	public static AppiumDriver <MobileElement> driver ;
	
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@AndroidFindBy(id = "com.fss.united:id/header")
	public MobileElement logoHeader;
	
	@AndroidFindBy(className= "android.widget.ImageView")
	public MobileElement logoView;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	public static MobileElement loginBox;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][2]")
	public static MobileElement okBtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='About Us']")
	public MobileElement aboutUsLink;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Forgot Password']")
	public MobileElement forgotPasswordLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Products']")
	public MobileElement productsLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Refer']")
	public MobileElement referLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='ePassbook']")
	public MobileElement ePassbookLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Feedback']")
	public MobileElement feedbackLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Locator']")
	public MobileElement locatorLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Wallet']")
	public MobileElement walletLink;
	
	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.Button[3]")
	@AndroidFindBy(xpath="//*[@text='Logout']")
	public MobileElement logoutBtn;

	@AndroidFindBy(id="android:id/button1")
	//@AndroidFindBy(id="xpath=//*[@text='Yes']")
	public MobileElement exitYesBtn;
	
	@AndroidFindBy(id="xpath=//*[@text='No']")
	public MobileElement exitNoBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@index='0']")
	public MobileElement acList;
	
	//android.widget.TextView
	
	public LoginPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	public void loginApp (String pin) throws InterruptedException
	{
	    waitForElement (loginBox, 5000);
		loginBox.click();
		log.info("Clicked on login box");
		loginBox.sendKeys(pin);
		log.info("Login Pin send  : "+pin);
		okBtn.click();
		log.info("Clicked on ok button");
		//.Fragment_Activity
	}
	
	public ReferPage clickReferPage()
	{
		waitForElement (referLink, 3000);
		referLink.click();
		ReferPage referObj= new ReferPage(driver);
		return referObj;
	}
	
	
}


        /*
	   // waitForScreenToLoad(driver, loginBox, 30);
		click(loginBox);
        sendText(loginBox, pin);
        click(okButton);
        loginPage.loginBox.click();
        loginBox.sendKeys("1111");
        okButton.click();
      */
        
        //driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).click();
/*		findElement(loginBox).click();
		findElement(loginBox).sendKeys(pin);
		findElement(okButton).click();*/
     //   driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys(pin);
	 // 	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]")).click();

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

MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.Button[3]");
el3.click();
MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
el4.click();


    }  */
 
/* let el1 = driver.element("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.EditText");
 el1.click();
 el1.setValue("1111");
 let el2 = driver.element("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]");
 el2.click();*/
 

