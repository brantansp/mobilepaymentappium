package mBankingBaseFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingUtility.MConstants;
import mBankingUtility.*;

public class BasePage {
	static DesiredCapabilities caps = new DesiredCapabilities();
	static AppiumDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@BeforeSuite
	public void BeforeSuite()
	{
	    log.info("Before Suite execution");	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		log.info("Before Method execution");		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		log.info("After Method execution");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		log.info("After Suite execution");
	}
	
	@Test
	public static void test(String t)
	{
		log.info("Test in Base class :" +t);
	}
	//@BeforeTest
	public static void BeforeMethod() throws MalformedURLException
	{
		//Set the Desired Capabilities
		caps.setCapability("deviceName", "Lenovo K8 Plus");
		caps.setCapability("udid", "HKE7YGUA"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("appPackage", "com.fss.united.agvb");
		caps.setCapability("appActivity", "SplashScreen");
		caps.setCapability("noReset", "true");		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	public void AfterMethod()
	{
			driver.quit();
	}

	public BasePage(AndroidDriver driver, ExtentTest test) {
		//PageFactory.initElements(new AppiumFieldDecorator(driver));
		this.driver = driver;
	}
	
	public Boolean isElementPresent(String locator) {
		test.log(LogStatus.INFO, "Finding presence of element"+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0)
			return false;
		else
			return true;
	}
	
	public Boolean verifyText(String locator,String expectedText) {
		test.log(LogStatus.INFO, "Finding presence of element"+locator);
		return false;
	}
	
	/********************reporting function********************/
	public void reportPass(String passMsg) {
		test.log(LogStatus.PASS, passMsg);
	}
	
	public void reportFail(String failMsg) {
		takeScreenShot();
		test.log(LogStatus.FAIL, failMsg);
		Assert.fail(failMsg);
	}
	
	public void takeScreenShot(){
		//decide the file name 
		Date d = new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		String path=MConstants.REPORT_PATH+""+screenshotFile;
		//take screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Add screenshot to report
		test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
				 test.addScreenCapture(path));
	}
	
	//click
	public void click(String xpathKey) {
		try {
		test.log(LogStatus.INFO, "Click on element"+xpathKey);	
		driver.findElement(By.xpath((xpathKey))).click();
		}catch(Exception e) {
			//report an error 
			//e.printStackTrace();
		}
	}
	
    public void swipeRight()
    {
            Dimension size = driver.manage().window().getSize();
            int startx = (int) (size.width * 0.90);
            int endx = (int) (size.width * 0.10);
            int starty = size.height / 2;
            driver.swipe(startx, starty, endx, starty, 2000);
    }

    public void swipeLeft()
    {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.10);
        int endx = (int) (size.width * 0.90);
        int starty = size.height / 2;
        driver.swipe(startx, starty, endx, starty, 2000);
    }

	public boolean swipeToElement(String elem) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
			return true;
		}catch(Exception e){
			test.log(LogStatus.INFO,"Swipe");
		}

		for(int i=0;i<10;i++) {
            swipeRight();
			try{
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
				return true;
			}catch(Exception e){
				test.log(LogStatus.INFO,"Swipe");
			}

		}
		return false;
	}

    public boolean swipeToElement(String elem, String direction) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
            return true;
        }catch(Exception e){
            test.log(LogStatus.INFO,"Swipe");
        }

        for(int i=0;i<10;i++) {
            if(direction.equalsIgnoreCase("right")){
                swipeRight();
            }else if(direction.equalsIgnoreCase("left")){
                swipeLeft();
            } else{
                test.log(LogStatus.INFO,"swipe direction not specified");
                break;
            }
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(Exception e){
                test.log(LogStatus.INFO,"Swipe");
            }

        }
        return false;
    }

    public void verticalScrollDown()
    {
        Dimension size = driver.manage().window().getSize();
        int y_start=(int)(size.height*0.70);
        int y_end=(int)(size.height*0.30);
        int x=size.width/2;
        driver.swipe(x,y_start,x,y_end,1000);
    }

    public void verticalScrollUp()
    {
        System.out.println("@ Vertical scroll up @ ");
        Dimension size = driver.manage().window().getSize();
        int y_start=(int)(size.height*0.70);
        int y_end=(int)(size.height*0.30);
        int x=size.width/2;
        driver.swipe(x,y_start,x,y_end,1000);
    }

    public boolean scrollToElement(String elem, String direction) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
            return true;
        }catch(NoSuchElementException e){
            test.log(LogStatus.INFO,"Scroll to element");
        }

        if(direction.equalsIgnoreCase("down")){
            for(int i=0;i<10;i++){
                verticalScrollDown();
                test.log(LogStatus.INFO,"Scroll DOWN");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    test.log(LogStatus.INFO,"Scroll");
                }
            }
        }else if(direction.equalsIgnoreCase("up")){
            for(int i=0;i<10;i++){
                verticalScrollUp();
                test.log(LogStatus.INFO,"Scroll UP");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    test.log(LogStatus.INFO,"Scroll");
                }
            }
        }
        return false;
    }

    public boolean scrollToElement(String elem) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
            return true;
        }catch(NoSuchElementException e){
            test.log(LogStatus.INFO,"Scroll to element");
        }
        for(int i=0;i<10;i++){
                verticalScrollDown();
                test.log(LogStatus.INFO,"Scroll DOWN");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    test.log(LogStatus.INFO,"Scroll");
                }
        }
        for(int j=0;j<10;j++){
            verticalScrollUp();
            test.log(LogStatus.INFO,"Scroll UP");
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(NoSuchElementException e){
                test.log(LogStatus.INFO,"Scroll");
            }
        }
        return false;
    }

    public boolean scrollDownToElement(String elem) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
            return true;
        }catch(NoSuchElementException e){
            test.log(LogStatus.INFO,"Scroll to element");
        }
        for(int i=0;i<10;i++){
            verticalScrollDown();
            test.log(LogStatus.INFO,"Scroll DOWN");
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(NoSuchElementException e){
                test.log(LogStatus.INFO,"Scroll");
            }
        }
        return false;
    }

    public boolean scrollUpToElement(String elem) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
            return true;
        }catch(NoSuchElementException e){
            test.log(LogStatus.INFO,"Scroll to element");
        }
        for(int j=0;j<10;j++){
            verticalScrollUp();
            test.log(LogStatus.INFO,"Scroll UP");
            try{
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
                return true;
            }catch(NoSuchElementException e){
                test.log(LogStatus.INFO,"Scroll");
            }
        }
        return false;
    }

    public void allowAppPermission(){

        try{

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Button'][2]")));
            driver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
            test.log(LogStatus.INFO, "App permissions popup displayed");

        }catch(Exception e){
            test.log(LogStatus.INFO, "App permissions popup did not occur");
        }
    }

}


