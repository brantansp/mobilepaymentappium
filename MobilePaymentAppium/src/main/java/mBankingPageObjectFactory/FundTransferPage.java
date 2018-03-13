package mBankingPageObjectFactory;

import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;
import mBankingBaseFactory.ObjectRepository;
import mBankingUtility.WriteToCSVFile;
import mBankingUtility.dbTransactionlog;

public class FundTransferPage  extends ObjectRepository {

	
	public static AppiumDriver <MobileElement> driver ;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public FundTransferPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(AppiumController.getDriver()) , this);
	}
	
	public void m2mQuick()
	{
		click(ftWb);
		click(m2mBtn);
		click(qFt);
	}

	public void miniStatement(String [] accNo)
	{}





}
