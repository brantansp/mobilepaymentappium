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


public class Driver extends AppiumController{

	protected AppiumDriver<MobileElement> driver;
	
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	private String hostIp = "";
	
	private String hostPort = "";
	
	private String deviceName = "";

	private String platformName = "";

	private String platformVersion = "";
	
	private String mobileUDID = "";
	
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

	public String getMobileUDID() {
		return mobileUDID;
	}

	public void setMobileUDID(String mobileUDID) {
		this.mobileUDID = mobileUDID;
	}

	public String getHost() {
		return hostIp;
	}

	public void setHost(String host) {
		this.hostIp = host;
	}

	public String getPort() {
		return hostPort;
	}

	public void setPort(String port) {
		this.hostPort = port;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public Driver(String platform) {

		try {
			init();
			String remoteUrl = "http://" + getHost() + ":" + getPort()
					+ "/wd/hub";
			if ("Android".equalsIgnoreCase(platform)) {
				driver = new AndroidDriver<MobileElement>(new URL(remoteUrl),
						this.generateDesiredCapabilities());

			} else if ("IOS".equalsIgnoreCase(platform)) {
				driver = new IOSDriver<MobileElement>(new URL(remoteUrl),
						this.generateDesiredCapabilities());
			} else {
				throw new Exception("Given platform is not implemented.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		log.info("Start");
		Driver obj = new Driver ("android");
		log.info("object created");
		obj.init();
		log.info("object initialized");
	}
	
	private void init() {
		String path = System.getProperty("user.dir")+"\\property\\driver.properties";
		PropertyFileReader handler = new PropertyFileReader(path);
		log.info("here :"+handler.getProperty("orientation"));
/*		setHost(handler.getProperty("HOST_IP"));
		setPort(handler.getProperty("HOST_PORT"));
		setDeviceName(handler.getProperty("DEVICE_NAME"));
		setPlatformName(handler.getProperty("PLATFORM_NAME"));
		setPlatformVersion(handler.getProperty("PLATFORM_VERSION"));
		setMobileUDID(handler.getProperty("UDID"));*/
	}

	public DesiredCapabilities generateDesiredCapabilities() throws Exception {

		DesiredCapabilities capabilities = generateCommonDesiredCapabilities();

		return capabilities;

	}

	protected DesiredCapabilities generateCommonDesiredCapabilities()
			throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapability.DEVICE_NAME,
				getDeviceName());
		capabilities.setCapability(MobileCapability.PLATFORM_NAME,
				getPlatformName());
		capabilities.setCapability(MobileCapability.PLATFORM_VERSION,
				getPlatformVersion());
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
