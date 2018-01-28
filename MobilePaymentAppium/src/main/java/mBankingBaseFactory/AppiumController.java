package mBankingBaseFactory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mBankingUtility.ExtentManager;
import mBankingUtility.MConstants;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AppiumController {

	public static AppiumDriver driver;
	public static URL serverAddress;
	private static WebDriverWait driverWait;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	Properties CONFIG = null;
	
	
//=====================================================================================

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
    @BeforeSuite
    public static void extentReportSetUp() throws MalformedURLException
    {
    	log.info("@BeforeSuite");
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	    extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	    instantiateDriver();	    
	}

    
    @BeforeMethod
    public static void extentbeforeMethod(Method method)
    {
    	
    	log.info("@BeforeMethod : " + 
            "ThreadName: " + Thread.currentThread().getName() + Thread.currentThread()
                .getStackTrace()[1].getClassName());
		extentLogger = extent.startTest((MethodHandles.lookup().lookupClass().getSimpleName() +" :: "+ method.getName()), method.getName() );
		extentLogger.assignAuthor("Brantansp");
		extentLogger.assignCategory("Appium Automation Testing");
		extentLogger.log(LogStatus.PASS, " : Test started Successfully");
		
    }
    
    @AfterMethod
    public static void extentGetResult(ITestResult result)
    {
    	log.info("@AfterMethod");
		if(result.getStatus() == ITestResult.FAILURE){
			String screenShotPath = AppiumController.takeScreenShot();
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			extentLogger.log(LogStatus.FAIL, "Snapshot below: " + extentLogger.addScreenCapture(screenShotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
			extent.endTest(extentLogger);
	}
     
    @AfterSuite
    public static void tearDown()
    {
    	log.info("@AfterSuite");
        extent.flush();
       // destroyingDriver();
    }	
//=====================================================================================
	static DesiredCapabilities caps = new DesiredCapabilities();
	
	public static void instantiateDriver() throws MalformedURLException
	{
		//Set the Desired Capabilities
		caps.setCapability("deviceName", "Lenovo K8 Plus");
		caps.setCapability("udid", "HKE7YGUA"); //Give Device ID of your mobile phone
		//caps.setCapability("udid", "emulator-5554");
		caps.setCapability("androidDeviceReadyTimeout", 10);
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("orientation", "PORTRAIT");
		caps.setCapability("appPackage", "com.fss.united");
		caps.setCapability("appActivity", "SplashScreen");
		caps.setCapability("noReset", "true");		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	public static void destroyingDriver()
	{
			driver.quit();
	}
//======================================================================	
	
	public MobileElement findElement(String loginBox)
	{
		MobileElement element = (MobileElement) driver.findElementByXPath(loginBox);
		return element;
	}
	
	public void waitForScreenToLoad(AppiumDriver lDriver, WebElement element, int seconds){

        WebDriverWait wait = new WebDriverWait(lDriver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
}
	
	/** Run before each test **/	
	public void setUp() throws Exception {
		// Initialize CONFIG
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(
				"src/test/java/com/tesco/config/env.properties");
		CONFIG.load(fs);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version",
				CONFIG.getProperty("appiumVersionEnv"));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "4.4");

		String userDir = System.getProperty("user.dir");

		String localApp = "Android_Phone_12th_Nov_7_4.apk";

		String appPath = Paths.get(userDir, localApp).toAbsolutePath()
				.toString();
		capabilities.setCapability("app", appPath);
		serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(serverAddress, capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		init(driver, serverAddress);
	}

	/** Run after each test **/

	public void tearDown2() throws Exception {
		if (driver != null)
			driver.quit();
	}

	/**
	 * Initialize the webdriver. Must be called before using any helper methods.
	 * *
	 */
	public static void init(AppiumDriver webDriver, URL driverServerAddress) {
		driver = webDriver;
		serverAddress = driverServerAddress;
		int timeoutInSeconds = 60;
		// must wait at least 60 seconds for running on Sauce.
		// waiting for 30 seconds works locally however it fails on Sauce.
		driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
	}

	/**
	 * Wrap WebElement in MobileElement *
	 */
	private static MobileElement w(WebElement element) {
		return (MobileElement) element;
		}

	/**
	 * Wrap WebElement in MobileElement *
	 */
	private static List<MobileElement> w(List<WebElement> elements) {
		List list = new ArrayList(elements.size());
		for (WebElement element : elements) {
			list.add(w(element));
		}

		return list;
	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Return an element by locator *
	 */
	public static MobileElement element(By locator) {
		return w(driver.findElement(locator));
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<MobileElement> elements(By locator) {
		return w(driver.findElements(locator));
	}

	/**
	 * Press the back button *
	 */
	public static void back() {
		driver.navigate().back();
	}

	/**
	 * Return a list of elements by tag name *
	 */
	public static List<MobileElement> tags(String tagName) {
		return elements(for_tags(tagName));
	}

	/**
	 * Return a tag name locator *
	 */
	public static By for_tags(String tagName) {
		return By.className(tagName);
	}

	/**
	 * Return a static text element by xpath index *
	 */
	public static MobileElement s_text(int xpathIndex) {
		return element(for_text(xpathIndex));
	}

	/**
	 * Return a static text locator by xpath index *
	 */
	public static By for_text(int xpathIndex) {
		return By.xpath("//android.widget.TextView[" + xpathIndex + "]");
	}

	/**
	 * Return a static text element that contains text *
	 */
	public static MobileElement text(String text) {
		return element(for_text(text));
	}

	/**
	 * Return a static text locator that contains text *
	 */
	public static By for_text(String text) {
		return By.xpath("//*[contains(@text, '" + text + "')]");
	}

	/**
	 * Return a static text element by exact text *
	 */
	public static MobileElement text_exact(String text) {
		return element(for_text_exact(text));
	}

	/**
	 * Return a static text locator by exact text *
	 */
	public static By for_text_exact(String text) {
		return By.xpath("//*[@text='" + text + "']");
	}

	public static String takeScreenShot(){
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
		log.info("Snapshot below: ("+screenshotFile+")"+
				 extentLogger.addScreenCapture(path));
		return path;
	}
	
	public static By for_find(String value) {
		return By.xpath("//*[@content-desc=\"" + value
				+ "\" or @resource-id=\"" + value + "\" or @text=\"" + value
				+ "\"] | //*[contains(translate(@content-desc,\"" + value
				+ "\",\"" + value + "\"), \"" + value
				+ "\") or contains(translate(@text,\"" + value + "\",\""
				+ value + "\"), \"" + value + "\") or @resource-id=\"" + value
				+ "\"]");
	}

	public static MobileElement find(String value) {
		return element(for_find(value));
	}

	/**
	 * Wait 30 seconds for locator to find an element *
	 */
	public static MobileElement wait(By locator) {
		return w(driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(locator)));
	}

	/**
	 * Wait 60 seconds for locator to find all elements *
	 */
	public static List<MobileElement> waitAll(By locator) {
		return w(driverWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(locator)));
	}

	/**
	 * Wait 60 seconds for locator to not find a visible element *
	 */
	public static boolean waitInvisible(By locator) {
		return driverWait.until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

	/**
	 * Return an element that contains name or text *
	 */
	/*
	public static MobileElement scroll_to(String value) {
		return driver.scrollTo(value);
	}

	public void scrollTo(String selector) {
	    String selectorString = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ selector +")");

	 driver.findElement(MobileBy.AndroidUIAutomator(selectorString));
	}
	
	/**
	 * Return an element that exactly matches name or text *
	 */
	/*
	public static MobileElement scroll_to_exact(String value) {
		return driver.scrollToExact(value);
	}

	*/
	/**
	 * Returns True if element is present
	 */
	public static boolean isElementPresent(final By by)
			throws InterruptedException {
		boolean isPresent = true;
		wait(by);
		// search for elements and check if list is empty
		if (driver.findElements(by).isEmpty()) {
			isPresent = false;
		}
		// rise back implicitly wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return isPresent;
	}

	/**
	 * 
	 */
	public static WebElement touchElement(String value) {
		return driver.findElement(for_find(value));
	}


	//click
	public void click(String xpathKey) {
		try {
		log.info("Click on element"+xpathKey);	
		driver.findElement(By.xpath((xpathKey))).click();
		}catch(Exception e) {
			//report an error 
			//e.printStackTrace();
		}
	}
	
	/*
	 * Click by MobileElement
	 */
	public void click(MobileElement element)
	{
		element.click();
	}
	
	/*
	 * Send keys via MobileElement
	 */
	public void sendText(MobileElement element,String text)
	{
		element.sendKeys(text);
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
			log.info("Swipe");
		}

		for(int i=0;i<10;i++) {
            swipeRight();
			try{
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
				return true;
			}catch(Exception e){
				log.info("Swipe");
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
            log.info("Swipe");
        }

        for(int i=0;i<10;i++) {
            if(direction.equalsIgnoreCase("right")){
                swipeRight();
            }else if(direction.equalsIgnoreCase("left")){
                swipeLeft();
            } else{
                log.info("swipe direction not specified");
                break;
            }
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(Exception e){
                log.info("Swipe");
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
            log.info("Scroll to element");
        }

        if(direction.equalsIgnoreCase("down")){
            for(int i=0;i<10;i++){
                verticalScrollDown();
                log.info("Scroll DOWN");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    log.info("Scroll");
                }
            }
        }else if(direction.equalsIgnoreCase("up")){
            for(int i=0;i<10;i++){
                verticalScrollUp();
                log.info("Scroll UP");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    log.info("Scroll");
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
            log.info("Scroll to element");
        }
        for(int i=0;i<10;i++){
                verticalScrollDown();
                log.info("Scroll DOWN");
                try{
                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                    return true;
                }catch(NoSuchElementException e){
                    log.info("Scroll");
                }
        }
        for(int j=0;j<10;j++){
            verticalScrollUp();
            log.info("Scroll UP");
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(NoSuchElementException e){
                log.info("Scroll");
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
            log.info("Scroll to element");
        }
        for(int i=0;i<10;i++){
            verticalScrollDown();
            log.info("Scroll DOWN");
            try{
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                return true;
            }catch(NoSuchElementException e){
                log.info("Scroll");
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
            log.info("Scroll to element");
        }
        for(int j=0;j<10;j++){
            verticalScrollUp();
            log.info("Scroll UP");
            try{
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
                return true;
            }catch(NoSuchElementException e){
                log.info("Scroll");
            }
        }
        return false;
    }

    public void allowAppPermission(){

        try{

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Button'][2]")));
            driver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
            log.info("App permissions popup displayed");

        }catch(Exception e){
            log.info("App permissions popup did not occur");
        }
    }

    
}