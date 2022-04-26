package mBankingUtility;


import static org.testng.Assert.assertTrue;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import mBankingBaseFactory.BasePage;

public class ExtentManager {

	private static Log log = LogFactory.getLog(ExtentManager.class);
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
    @BeforeSuite
    public static void extentReportSetUp()
    {
    	log.info("@BeforeSuite");
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	    extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

    
    @BeforeMethod
    public static void extentbeforeMethod(ITestResult result, Method method)
    {
        String screenShotPath = BasePage.takeScreenShot();
    	log.info("@BeforeMethod : " +screenShotPath );
    	log.info(result.getName());
		extentLogger = extent.startTest((MethodHandles.lookup().lookupClass().getSimpleName() +" :: "+ method.getName()), method.getName() );
		extentLogger.assignAuthor("Brantansp");
		extentLogger.assignCategory("Appium Automation Testing");
		extentLogger.log(LogStatus.PASS, "Test started Successfully");
		extentLogger.log(LogStatus.PASS, "Snapshot below: " + extentLogger.addScreenCapture(screenShotPath));
    }
	
    @AfterMethod
    public static void extentGetResult(ITestResult result)
    {
    	log.info("@AfterMethod");
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//extentLogger.log(LogStatus.FAIL, "Snapshot below: " + extentLogger.addScreenCapture(screenShotPath));
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
    }
}
