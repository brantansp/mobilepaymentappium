package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

public class FeedbackPage extends AppiumController {

	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	public FeedbackPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	//android.widget.TextView[contains(@text,'Data usage')]
	
	@AndroidFindBy (xpath="//android.widget.TextView[@index='0']")
	protected MobileElement feedbackPageHeader;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Feedback']")
	protected MobileElement feedbackPageHeader2;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='OK']")
	protected static MobileElement okBtn;

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	protected static MobileElement homeBtn;

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Exit']")
	protected static MobileElement exitBtn;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Would you recommend this App 1 to 5']")
	protected MobileElement recommendApp;
	
	@AndroidFindBy (xpath="//android.widget.EditText[@text='Would you like Mobile Recharge 1 to 5']")
	protected MobileElement mobRecharge;
	
	@AndroidFindBy (xpath="//android.widget.EditText[@text='Ease of Use 1 to 5']")
	protected MobileElement easeOfUse;
	
	@AndroidFindBy (xpath="//android.widget.EditText[@text='Feedback']")
	protected MobileElement feedback;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Feedback']")
	protected MobileElement feedbackLink;
	
	public String feedbackTxn(String recmndApp, String mobrec, String ease, String feedbackText ) throws InterruptedException
	{
		waitForElement (feedbackLink, 3000);
		feedbackLink.click();
		waitForElement(okBtn, 3000);
		recommendApp.sendKeys(recmndApp);
		mobRecharge.sendKeys(mobrec);
		easeOfUse.sendKeys(ease);
		feedback.sendKeys(feedbackText);
		okBtn.click();
		Thread.sleep(5000);
		String txn = processAcknowledgment();
		homeBtn.click();
		return txn;
	}
}
