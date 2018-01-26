package mBankingUtility;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {


	public static ExtentReports extent;
	public static ExtentTest extentLogger;
     
    @BeforeSuite
    public void setUp()
    {
    	System.out.println("I am callled");
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	    extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
    
    @Test
    public void test()
    {
    	assertTrue(true);
    }
    
    @BeforeMethod
    public void beforeMethod(Method method)
    {
		extentLogger = extent.startTest((this.getClass().getSimpleName() +" :: "+ method.getName()), method.getName() );
		extentLogger.assignAuthor("Brantansp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log(LogStatus.PASS, "Test started Successfully");
    }
    
    @AfterMethod
    public void getResult(ITestResult result)
    {
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
			extent.endTest(extentLogger);
	}
     
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }



}
