package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mBankingBaseFactory.AppiumController;

public class BankingPage extends AppiumController  {
	
	public static AppiumDriver <MobileElement> driver ;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public BankingPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public MobileElement headerText;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	public static MobileElement homeBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Help']")
	public MobileElement helpBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Logout']")
	public MobileElement logoutBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Balance Enquiry']")
	public MobileElement be;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Select A/C']")
	public MobileElement selectAcPage;

	@AndroidFindBy (xpath="//android.widget.TextView[@text='Mini Statement']")
	public MobileElement ms;

	@AndroidFindBy (xpath="//android.widget.TextView[@text='Fund Transfer - Within Bank']")
	public MobileElement ftWb;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Fund Transfer - Other Bank']")
	public MobileElement ftOb;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Request to Bank']")
	public MobileElement reqBnk;

	@AndroidFindBy (xpath="//android.widget.EditText[@text='mPIN']")
	protected static MobileElement mPINBox;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='OK']")
	protected MobileElement okBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Transaction ID']")
	public MobileElement beAcknPage;
	
	public void balanceEnq(String [] accNo)
	{
		if (true) //if multiacc txn enable
		{
			for (int i=0; i< accNo.length;i++)
			{
				click("//android.widget.TextView[@text='"+accNo[i]+"']");
				waitForElement(mPINBox, 3000);
				if(true)   //mpin page exists
				{
					sendText(mPINBox,"2222");
					click(okBtn);
				}
				waitForElement(beAcknPage,30000);
				//sleep(5000);
				String txn = processAcknowledgment();
				back();
				be.click();
			}
		} 
		else
		{
			click("//android.widget.TextView[@text='"+accNo[1]+"']");
			waitForElement(mPINBox, 3000);
			if(true)   //mpin page exists
			{
				sendText(mPINBox,"2222");
				click(okBtn);
			}
			waitForElement(beAcknPage,5000);
			//sleep(8000);
			String txn = processAcknowledgment();
			back();
		}
	}





























}




















