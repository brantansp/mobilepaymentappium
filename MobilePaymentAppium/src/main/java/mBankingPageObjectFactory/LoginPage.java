package mBankingPageObjectFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {
	AppiumDriver driver;
	
	@FindBy(how = How.ID , using = "com.fss.united:id/header")
	private MobileElement logoHeader;
	
	@FindBy(how = How.CLASS_NAME , using = "android.widget.ImageView")
	private MobileElement logoView;
	
	@FindBy(how = How.XPATH , using = "//*[@class='android.widget.EditText']")
	private MobileElement loginBox;
	
	@FindBy(how = How.XPATH , using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.Button[2]")
	private MobileElement okButton;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='About Us']")
	private MobileElement aboutUs;

	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Forgot Password']")
	private MobileElement forgotPassword;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Products']")
	private MobileElement products;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Refer']")
	private MobileElement Refer;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='ePassbook']")
	private MobileElement ePassbook;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Feedback']")
	private MobileElement feedback;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Locator']")
	private WebElement locator;
	
	@FindBy(how = How.XPATH , using="//android.widget.Button[@text='Wallet']")
	private MobileElement wallet;

 public void driver(AppiumDriver driver)
 {
	 this.driver = driver;
 }
 
 public void click(AppiumDriver driver)
 {
	 this.driver = driver;
	 locator.click();
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
}
