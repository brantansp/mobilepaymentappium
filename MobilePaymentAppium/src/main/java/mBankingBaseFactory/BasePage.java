package mBankingBaseFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePage {

	protected static AppiumDriver<MobileElement> driver;
	public static URL serverAddress;
	private static WebDriverWait driverWait;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	protected static Properties loc;
	protected static Properties prop;
	protected static Wait<WebDriver> wait;

	public static ExtentReports extent;
	public static ExtentTest extentLogger;

	@BeforeSuite
	public static void extentReportSetUp() throws InterruptedException, FileNotFoundException, IOException {
		log.info("@BeforeSuite");
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		setDriver(Driver.instantiateDriver("android"));
		prop = loadProp();
		wait = new FluentWait<WebDriver>(getDriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public static void extentbeforeMethod(Method method) {
		log.info("@BeforeMethod : " + "ThreadName: " + Thread.currentThread().getName()
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		extentLogger = extent.startTest(
				(MethodHandles.lookup().lookupClass().getSimpleName() + " :: " + method.getName()), method.getName());
		extentLogger.assignAuthor("Brantansp");
		extentLogger.assignCategory("Appium Automation Testing");
		extentLogger.log(LogStatus.PASS, " : Test started Successfully");

	}

	@AfterMethod
	public static void extentGetResult(ITestResult result) {
		log.info("@AfterMethod\n");
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = BasePage.takeScreenShot();
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			extentLogger.log(LogStatus.FAIL, "Snapshot below: " + extentLogger.addScreenCapture(screenShotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(extentLogger);
	}

	@AfterSuite
	public static void tearDown() {
		log.info("@AfterSuite");
		extent.flush();
	}

	public static void waitUntil(MobileElement locator) {
		log.info("entered wait until");
		wait.until(ExpectedConditions.visibilityOf(locator));
		log.info("entered wait until exit");
	}

	public static Properties loadProp() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\property\\conf.properties")));
		return prop;
	}

	public void loadObjects() throws FileNotFoundException, IOException {
		loc = new Properties();
		loc.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\property\\locators.properties")));
	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForCondition(ExpectedCondition<WebElement> expectedCondition, Integer timeout) {
		timeout = timeout != null ? timeout : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(expectedCondition);
	}

	public boolean waitForElement(MobileElement locator, Integer... timeout) {
		log.info("Entered Wait for locator");
		try {
			waitForCondition(ExpectedConditions.visibilityOf((WebElement) locator),
					(timeout.length > 0 ? timeout[0] : null));
		} catch (org.openqa.selenium.TimeoutException exception) {
			log.info("Element not found");
			return false;
		}
		log.info("Element found : " + locator.getAttribute("text"));
		return true;
	}

	public boolean waitForTextView(String text, Integer... timeout) {
		MobileElement locator = getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
		log.info("Entered Wait : " + text);
		try {
			waitForCondition(ExpectedConditions.visibilityOf((WebElement) locator),
					(timeout.length > 0 ? timeout[0] : null));
		} catch (org.openqa.selenium.TimeoutException exception) {
			log.info("Element not found");
			return false;
		}
		log.info("Element found : " + text);
		return true;
	}

	public boolean waitForEditText(String text, Integer... timeout) {
		log.info("Entered Wait : " + text);
		try {
			waitForCondition(
					ExpectedConditions.visibilityOf((WebElement) getDriver()
							.findElement(By.xpath(("//*[@class='android.widget.EditText'][@text='" + text + "']")))),
					(timeout.length > 0 ? timeout[0] : null));
		} catch (org.openqa.selenium.TimeoutException exception) {
			log.info("Element not found");
			return false;
		}
		log.info("Element found : " + text);
		return true;
	}

	public static void waitForActivity(String desiredActivity, int wait) throws InterruptedException {
		AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) getDriver();
		int counter = 0;
		do {
			Thread.sleep(1000);
			counter++;
		} while (driver.currentActivity().contains(desiredActivity) && (counter <= wait));

		log.info("Activity appeared :" + driver.currentActivity());
	}

	public boolean isDisplayed(MobileElement element) {
		boolean state = element.isDisplayed();
		return state;
	}

	public MobileElement findElement(String xpath) {
		MobileElement element = (MobileElement) getDriver().findElementByXPath(xpath);
		return element;
	}

	public void waitForScreenToLoad(AppiumDriver<MobileElement> lDriver, WebElement element, int seconds) {

		WebDriverWait wait = new WebDriverWait(lDriver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void tearDown2() throws Exception {
		if (getDriver() != null)
			getDriver().quit();
	}

	/**
	 * Initialize the webdriver. Must be called before using any helper methods. *
	 */
	public static void init(AppiumDriver<MobileElement> webDriver, URL driverServerAddress) {
		setDriver(webDriver);
		serverAddress = driverServerAddress;
		int timeoutInSeconds = 60;
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
		List<MobileElement> list = new ArrayList<MobileElement>(elements.size());
		for (WebElement element : elements) {
			list.add(w(element));
		}

		return list;
	}

	/**
	 * Set implicit wait in seconds *
	 */
	public static void setWait(int seconds) {
		getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Return an element by locator *
	 */
	public static MobileElement element(By locator) {
		return w(getDriver().findElement(locator));
	}

	/**
	 * Return a list of elements by locator *
	 */
	public static List<MobileElement> elements(By locator) {
		List<MobileElement> w = (List<MobileElement>) w((WebElement) getDriver().findElements(locator));
		return w;
	}

	/**
	 * Press the back button *
	 */
	public static void back() {
		getDriver().navigate().back();
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

	public static String takeScreenShot() {
		// decide the file name
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Add screenshot to report
		/*
		 * log.info("Snapshot below: ("+screenshotFile+")"+
		 * extentLogger.addScreenCapture(path));
		 */
		log.info("Failed Screenshot captured : " + screenshotFile);
		return path;
	}

	public static By for_find(String value) {
		return By.xpath("//*[@content-desc=\"" + value + "\" or @resource-id=\"" + value + "\" or @text=\"" + value
				+ "\"] | //*[contains(translate(@content-desc,\"" + value + "\",\"" + value + "\"), \"" + value
				+ "\") or contains(translate(@text,\"" + value + "\",\"" + value + "\"), \"" + value
				+ "\") or @resource-id=\"" + value + "\"]");
	}

	public static MobileElement find(String value) {
		return element(for_find(value));
	}

	/**
	 * Wait 30 seconds for locator to find an element *
	 */
	public static MobileElement wait(By locator) {
		return w(driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}

	/**
	 * Wait 60 seconds for locator to find all elements *
	 */
	public static List<MobileElement> waitAll(By locator) {
		return w(driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
	}

	/**
	 * Wait 60 seconds for locator to not find a visible element *
	 */
	public static boolean waitInvisible(By locator) {
		return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * Returns True if element is present
	 */
	public static boolean isElementPresent(final By by) throws InterruptedException {
		boolean isPresent = true;
		wait(by);
		// search for elements and check if list is empty
		if (getDriver().findElements(by).isEmpty()) {
			isPresent = false;
		}
		// rise back implicitly wait time
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return isPresent;
	}

	/**
	 * 
	 */
	public static WebElement touchElement(String value) {
		return getDriver().findElement(for_find(value));
	}

	// click
	public void click(String xpathKey) {
		try {
			getDriver().findElement(By.xpath((xpathKey))).click();
			log.info("Click on element : " + xpathKey);
		} catch (Exception e) {
			// report an error
			System.out.println(e);
		}
	}

	// clickText
	public void clickBtn(String text) {
		try {
			getDriver().findElement(By.xpath(("//*[@class='android.widget.Button'][@text='" + text + "']"))).click();
			log.info("Click on element : " + text);
		} catch (Exception e) {
			// report an error
			System.out.println(e);
		}
	}

	// clickText
	public void clickView(String text) {
		try {
			log.info("Click on element : " + text);
			getDriver().findElement(By.xpath(("//*[@class='android.widget.TextView'][@text='" + text + "']"))).click();
		} catch (Exception e) {
			// report an error
			System.out.println(e);
		}
	}

	public void clickEditText(String text) {
		try {
			log.info("Click on element : " + text);
			getDriver().findElement(By.xpath(("//*[@class='android.widget.EditText'][@text='" + text + "']"))).click();
		} catch (Exception e) {
			// report an error
			System.out.println(e);
		}
	}

	/*
	 * Click by MobileElement
	 */
	public void click(MobileElement element) {
		element.click();
		log.info("clicked element");
	}

	/*
	 * Send keys via MobileElement
	 */
	public void sendText(MobileElement element, String text) {
		element.sendKeys(text);
		log.info("Send Text : " + text);
	}

	public static void sendText(String element, String text) {
		getDriver().findElement(By.xpath(("//android.widget.EditText[@text='" + element + "']"))).sendKeys(text);
		;
		log.info("Send Text : " + text);
	}

	public void swipeRight() {
		Dimension size = getDriver().manage().window().getSize();
		int startx = (int) (size.width * 0.90);
		int endx = (int) (size.width * 0.10);
		int starty = size.height / 2;
		getDriver().swipe(startx, starty, endx, starty, 2000);
	}

	public void swipeLeft() {
		Dimension size = getDriver().manage().window().getSize();
		int startx = (int) (size.width * 0.10);
		int endx = (int) (size.width * 0.90);
		int starty = size.height / 2;
		getDriver().swipe(startx, starty, endx, starty, 2000);
	}

	public boolean swipeToElement(String elem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
			return true;
		} catch (Exception e) {
			log.info("Swipe");
		}

		for (int i = 0; i < 10; i++) {
			swipeRight();
			try {
				wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
				return true;
			} catch (Exception e) {
				log.info("Swipe");
			}

		}
		return false;
	}

	public boolean swipeToElement(String elem, String direction) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
			return true;
		} catch (Exception e) {
			log.info("Swipe");
		}

		for (int i = 0; i < 10; i++) {
			if (direction.equalsIgnoreCase("right")) {
				swipeRight();
			} else if (direction.equalsIgnoreCase("left")) {
				swipeLeft();
			} else {
				log.info("swipe direction not specified");
				break;
			}
			try {
				wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
				return true;
			} catch (Exception e) {
				log.info("Swipe");
			}

		}
		return false;
	}

	public void verticalScrollDown() {
		Dimension size = getDriver().manage().window().getSize();
		int y_start = (int) (size.height * 0.70);
		int y_end = (int) (size.height * 0.30);
		int x = size.width / 2;
		getDriver().swipe(x, y_start, x, y_end, 1000);
	}

	public void verticalScrollUp() {
		log.info("@ Vertical scroll up @ ");
		Dimension size = getDriver().manage().window().getSize();
		int y_start = (int) (size.height * 0.70);
		int y_end = (int) (size.height * 0.30);
		int x = size.width / 2;
		getDriver().swipe(x, y_start, x, y_end, 1000);
	}

	public boolean scrollToElement(String elem, String direction) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
			return true;
		} catch (NoSuchElementException e) {
			log.info("Scroll to element");
		}

		if (direction.equalsIgnoreCase("down")) {
			for (int i = 0; i < 10; i++) {
				verticalScrollDown();
				log.info("Scroll DOWN");
				try {
					wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
					return true;
				} catch (NoSuchElementException e) {
					log.info("Scroll");
				}
			}
		} else if (direction.equalsIgnoreCase("up")) {
			for (int i = 0; i < 10; i++) {
				verticalScrollUp();
				log.info("Scroll UP");
				try {
					wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
					return true;
				} catch (NoSuchElementException e) {
					log.info("Scroll");
				}
			}
		}
		return false;
	}

	public boolean scrollToElement(String elem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
			return true;
		} catch (NoSuchElementException e) {
			log.info("Scroll to element");
		}
		for (int i = 0; i < 10; i++) {
			verticalScrollDown();
			log.info("Scroll DOWN");
			try {
				wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
				return true;
			} catch (NoSuchElementException e) {
				log.info("Scroll");
			}
		}
		for (int j = 0; j < 10; j++) {
			verticalScrollUp();
			log.info("Scroll UP");
			try {
				wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
				return true;
			} catch (NoSuchElementException e) {
				log.info("Scroll");
			}
		}
		return false;
	}

	public boolean scrollDownToElement(String elem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
			return true;
		} catch (NoSuchElementException e) {
			log.info("Scroll to element");
		}
		for (int i = 0; i < 10; i++) {
			verticalScrollDown();
			log.info("Scroll DOWN");
			try {
				wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elem))));
				return true;
			} catch (NoSuchElementException e) {
				log.info("Scroll");
			}
		}
		return false;
	}

	public boolean scrollUpToElement(String elem) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 1);
		try {
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
			return true;
		} catch (NoSuchElementException e) {
			log.info("Scroll to element");
		}
		for (int j = 0; j < 10; j++) {
			verticalScrollUp();
			log.info("Scroll UP");
			try {
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elem))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
				return true;
			} catch (NoSuchElementException e) {
				log.info("Scroll");
			}
		}
		return false;
	}

	public void allowAppPermission() {

		try {

			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Button'][2]")));
			getDriver().findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
			log.info("App permissions popup displayed");

		} catch (Exception e) {
			log.info("App permissions popup did not occur");
		}
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public static void setDriver(AppiumDriver<MobileElement> driver) {
		BasePage.driver = driver;
	}

}