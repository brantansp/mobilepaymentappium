package mBankingBaseFactory;

import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import mBankingUtility.*;


public class Driver extends AppiumController{

	protected AppiumDriver<MobileElement> driver;
	
	private String hostIp = "";
	
	private String hostPort = "";
	
	private String deviceName = "";

	private String platformName = "";

	private String platformVersion = "";
	
	private String mobileUDID = "";
	
	/**
	 * Gets the driver.
	 * 
	 * @return the driver
	 */
/*	public AppiumDriver getDriver() {
		return driver;
	}

	*//**
	 * Sets the driver.
	 * 
	 * @param driver
	 *            the new web driver
	 *//*
	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}*/

	/**
	 * Quit the browser instance.
	 */
	public void quit() {
		if (!"NATIVE_APP".equalsIgnoreCase(driver.getContext())) {
			driver.close();
		}
		driver.quit();
	}

	/**
	 * Gets the mobile udid.
	 *
	 * @return the mobile udid
	 */
	public String getMobileUDID() {
		return mobileUDID;
	}

	/**
	 * Sets the mobile udid.
	 *
	 * @param mobileUDID the new mobile udid
	 */
	public void setMobileUDID(String mobileUDID) {
		this.mobileUDID = mobileUDID;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return hostIp;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.hostIp = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return hostPort;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.hostPort = port;
	}

	/**
	 * Gets the device name.
	 *
	 * @return the device name
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * Sets the device name.
	 *
	 * @param deviceName the new device name
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * Gets the platform name.
	 *
	 * @return the platform name
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * Sets the platform name.
	 *
	 * @param platformName the new platform name
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * Gets the platform version.
	 *
	 * @return the platform version
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}

	/**
	 * Sets the platform version.
	 *
	 * @param platformVersion the new platform version
	 */
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	/**
	 * Instantiates a new web browser.
	 *
	 * @param platform the device type
	 */
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

	/**
	 * Initializes the execution parameters.
	 */
	
	public static void main(String[] args) {
		Driver obj = new Driver ("android");
		obj.init();
	}
	
	private void init() {

		PropertyFileReader handler = new PropertyFileReader("/driver.properties");
		System.out.println("here :"+handler.getProperty("UDID"));
		setHost(handler.getProperty("HOST_IP"));
		setPort(handler.getProperty("HOST_PORT"));
		setDeviceName(handler.getProperty("DEVICE_NAME"));
		setPlatformName(handler.getProperty("PLATFORM_NAME"));
		setPlatformVersion(handler.getProperty("PLATFORM_VERSION"));
		setMobileUDID(handler.getProperty("UDID"));
	}

	/**
	 * Generate desired capabilities.
	 *
	 * @return the desired capabilities
	 * @throws Exception the exception
	 */
	public DesiredCapabilities generateDesiredCapabilities() throws Exception {

		DesiredCapabilities capabilities = generateCommonDesiredCapabilities();

		return capabilities;

	}

	/**
	 * Generate desired capabilities.
	 *
	 * @return the desired capabilities
	 * @throws Exception the exception
	 */
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
