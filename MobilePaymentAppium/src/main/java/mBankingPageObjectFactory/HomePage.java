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
import mBankingBaseFactory.Driver;

public class HomePage extends AppiumController {
	
	public static AppiumDriver <MobileElement> driver ;
	
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@AndroidFindBy(id="android:id/button1")
	//@AndroidFindBy(id="xpath=//*[@text='Yes']")
	public MobileElement exitYesBtn;
	
	@AndroidFindBy(id="xpath=//*[@text='No']")
	public MobileElement exitNoBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Change mPIN']")
	public MobileElement changemPINBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Help']")
	public MobileElement helpBtn;
	
	//@AndroidFindBy(xpath="//*[@text='Logout']")
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Logout']")
	public MobileElement logoutBtn;
	
	@AndroidFindBy(className= "android.widget.EditText[1]")
	public MobileElement oldmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	public MobileElement newmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	public MobileElement reEntermPIN;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='OK']")
	public static MobileElement okBtn;

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	public MobileElement homeBtn;

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Exit']")
	public static MobileElement exitBtn;
	
	//com.fss.united:id/Gridtext
	//@AndroidFindBy(id = "com.fss.united:id/Gridtext")
	@AndroidFindBy (xpath="//android.widget.TextView[@index='0']")
	public MobileElement welcomeText;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@index='1']")
	public MobileElement helpTextView;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Banking']")
	public MobileElement bankingBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='24X7Fund Transfer']")
	public MobileElement impsBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Payment']")
	public MobileElement paymentBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Other Services']")
	public MobileElement otherServicesbtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='My Setup']")
	public MobileElement mySetupBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Inbox']")
	public MobileElement inboxBtn;
	
	public HomePage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	public void clickBanking()
	{
		waitForElement(bankingBtn,3000);
		click(bankingBtn);
	}
	
	public String custName ()
	{
		waitForElement(helpBtn, 3000);
	    String name =welcomeText.getAttribute("text");
	    name = name.substring(name.lastIndexOf("Welcome")+8, name.length());
	    log.info("Name of customer in welcome page : " +name);
		return name;
	}
	
	public void help()
	{
	  waitForElement(helpBtn, 3000);
	  click(helpBtn);
      log.info(helpTextView.getAttribute("text"));
      click(homeBtn);
	}
	
	public void changePin(String oldmpin, String newmpin, String reentermpin)
	{
		click(changemPINBtn);
		click(oldmPIN);
		sendText(oldmPIN, oldmpin);
		sendText(newmPIN, newmpin);
		sendText(reEntermPIN,reentermpin);
		click(okBtn);
	}
	
	public void logoutApp()
	{
		waitForElement (logoutBtn, 3000);
		click(logoutBtn);
		log.info("Clicked on Exit button");
		click(exitYesBtn);
		log.info("Clicked on Yes button");
	}

	
}

/*
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("1111");
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.widget.TableLayout' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='frag_main']]]/*[@class='android.widget.TableRow'])[1]/*[@class='android.widget.Button'])[2]")));
driver.findElement(By.xpath("((//*[@class='android.widget.TableLayout' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='frag_main']]]/*[@class='android.widget.TableRow'])[1]/*[@class='android.widget.Button'])[2]")).click();
driver.findElement(By.xpath("//*[@text='Change mPIN']")).click();
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("2222");
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("1234");
driver.findElement(By.xpath("((//*[@class='android.widget.LinearLayout' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.LinearLayout'])[2]/*[@class='android.widget.EditText'])[3]")).sendKeys("1234");
new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
driver.findElement(By.xpath("//*[@text='OK']")).click();
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")));
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Help']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Help']")).click();
driver.findElement(By.xpath("//*[@text='Logout']")).click();
driver.findElement(By.xpath("//*[@text='Yes']")).click();
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("1111");
driver.findElement(By.xpath("((//*[@class='android.widget.TableLayout' and ./parent::*[@class='android.widget.LinearLayout' and ./parent::*[@id='frag_main']]]/*[@class='android.widget.TableRow'])[1]/*[@class='android.widget.Button'])[2]")).click();
new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='icon_image' and ./following-sibling::*[@text='Banking']]")));
driver.findElement(By.xpath("//*[@id='icon_image' and ./following-sibling::*[@text='Banking']]")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Banking']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='icon_image' and ./following-sibling::*[@text='24X7
Fund Transfer']]")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='24X7
Fund Transfer']")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='gridiconll' and ./*[@text='Banking']]")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@id='gridiconll' and ./*[@text='24X7
Fund Transfer']]")).click();
driver.findElement(By.xpath("//*[@text='Home']")).click();
driver.findElement(By.xpath("//*[@text='Logout']")).click();
driver.findElement(By.xpath("//*[@text='Yes']")).click();
*/


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
 

