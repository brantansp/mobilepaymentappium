package mBankingBaseFactory;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import mBankingUtility.*;


public class Driver {

	protected static AppiumDriver<MobileElement> driver;
	
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	private static String hostIp = "";
	
	private static String hostPort = "";
	
	private static String deviceName = "";

	private static String platformName = "";

	private static String platformVersion = "";
	
	private static String mobileUDID = "";

	private static String appPackageName = "";
	
	private static String appActivity = "";

	private static String noReset;

	private static String orientation;
	
/*	public AppiumDriver getDriver() {
		return driver;
	}
	*/
	
	/*
	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}*/

	public void quit() {
		if (!"NATIVE_APP".equalsIgnoreCase(driver.getContext())) {
			driver.close();
		}
		driver.quit();
	}

	public static String getMobileUDID() {
		return mobileUDID;
	}

	public static void setMobileUDID(String mobileUDID) {
		Driver.mobileUDID = mobileUDID;
	}

	public static String getHost() {
		return hostIp;
	}

	public static void setHost(String host) {
		Driver.hostIp = host;
	}

	public static String getPort() {
		return hostPort;
	}

	public static void setPort(String port) {
		Driver.hostPort = port;
	}

	public static String getDeviceName() {
		return deviceName;
	}

	public static void setDeviceName(String deviceName) {
		Driver.deviceName = deviceName;
	}

	public static void setAppPackageName(String appPackageName) {
		Driver.appPackageName  = appPackageName;
	}
	public static String getPlatformName() {
		return platformName;
	}

	public static void setPlatformName(String platformName) {
		Driver.platformName = platformName;
	}

	public static String getPlatformVersion() {
		return platformVersion;
	}

	public static String getAppPackageName () {
		return appPackageName;
	}
	
	public static String getAppActivity () {
		return appActivity;
	}
	
	public static String getNoReset () {
		return noReset;
	}
	
	public static String getOrientation () {
		return orientation;
	}
	
	public static void setPlatformVersion(String platformVersion) {
		Driver.platformVersion = platformVersion;
	}
	
	public static void setAppActivity(String appActivity) {
		Driver.appActivity = appActivity;
	}

	public static void setNoReset (String noReset) {
		Driver.noReset = noReset;
	}
	
	public static void setOrientation (String orientation) {
		Driver.orientation = orientation;
	}
	
	public static AppiumDriver<MobileElement> instantiateDriver(String platform) {

		try {
			init();
			String remoteUrl = "http://" + getHost() + ":" + getPort()
					+ "/wd/hub";
			if ("Android".equalsIgnoreCase(platform)) {
				log.info("This is an android platform");
				driver = new AndroidDriver<MobileElement>(new URL(remoteUrl),
						Driver.generateDesiredCapabilities());
                return driver;
			} else if ("IOS".equalsIgnoreCase(platform)) {
				log.info("This is an iPhone platform");
				driver = new IOSDriver<MobileElement>(new URL(remoteUrl),
						Driver.generateDesiredCapabilities());
				return driver;
			} else {
				log.info("This is an exception");
				throw new Exception("Given platform is not implemented.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void main(String[] args) {
		log.info("Start");
		//Driver driver = new Driver ("android");

	}
	
	private static void init() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String path = System.getProperty("user.dir")+"\\property\\driver.properties";
		PropertyFileReader handler = new PropertyFileReader(path);
		log.info("here :"+handler.getProperty("appPackage"));
    	setHost(handler.getProperty("host_ip"));
		setPort(handler.getProperty("host_port"));
		setDeviceName(handler.getProperty("deviceName"));
		setPlatformName(handler.getProperty("platformName"));
		setPlatformVersion(handler.getProperty("platformVersion"));
		setMobileUDID(handler.getProperty("udid"));
		setAppPackageName(handler.getProperty("appPackage"));
		setAppActivity(handler.getProperty("appActivity"));
		setNoReset(handler.getProperty("noReset"));
		//setOrientation(handler.getProperty("orientation"));
	}

	public static DesiredCapabilities generateDesiredCapabilities() throws Exception {

		DesiredCapabilities capabilities = generateCommonDesiredCapabilities();

		return capabilities;

	}

	protected static DesiredCapabilities generateCommonDesiredCapabilities()
			throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapability.DEVICE_NAME,
				getDeviceName());
		capabilities.setCapability(MobileCapability.PLATFORM_NAME,
				getPlatformName());
		capabilities.setCapability(MobileCapability.PLATFORM_VERSION,
				getPlatformVersion());
		capabilities.setCapability(MobileCapability.UDID, getMobileUDID());
		capabilities.setCapability(MobileCapability.APP_PACKAGE, getAppPackageName());
		capabilities.setCapability(MobileCapability.APP_ACTIVITY, getAppActivity());
		capabilities.setCapability(MobileCapability.NO_RESET, getNoReset());
		capabilities.setCapability(MobileCapability.ORIENTATION, getOrientation());
		capabilities.setCapability(MobileCapability.NEW_COMMAND_TIMEOUT, 9000);
		
		if (getPlatformName().equalsIgnoreCase("IOS")) {
			if (!getMobileUDID().equals("")) {
				capabilities.setCapability(MobileCapability.UDID,
						getMobileUDID());
			}
			capabilities.setCapability(MobileCapability.SHOW_IOS_LOG, true);
		}

		return capabilities;
	}
}
