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
	
	protected static AppiumDriver <MobileElement> driver ;
	
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	
	
		
	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.Button[3]")
	@AndroidFindBy(xpath="//*[@text='Logout']")
	protected MobileElement logoutBtn;

	@AndroidFindBy(id="android:id/button1")
	//@AndroidFindBy(id="xpath=//*[@text='Yes']")
	protected MobileElement exitYesBtn;
	
	@AndroidFindBy(id="xpath=//*[@text='No']")
	protected MobileElement exitNoBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][0]")
	protected MobileElement changemPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[1]")
	protected MobileElement oldmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	protected MobileElement newmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	protected MobileElement reEntermPIN;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][2]")
	protected static MobileElement okBtn;
	//*[@text='OK']")
	
	public HomePage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	public void help()
	{
		
	}
	
	public void changePin()
	{
		changemPIN.click();
		oldmPIN.click();
		oldmPIN.sendKeys("2222");
		newmPIN.sendKeys("1234");
		reEntermPIN.sendKeys("1234");
		okBtn.click();
	}
	
	@Test
	public void logoutApp()
	{
		logoutBtn.click();
		log.info("Clicked on Exit button");
		exitYesBtn.click();
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
 

