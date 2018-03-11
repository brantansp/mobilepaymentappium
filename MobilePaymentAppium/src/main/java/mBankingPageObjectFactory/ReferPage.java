package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.*;

public class ReferPage extends AppiumController {

	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Refer a Friend']")
	protected MobileElement referFriendHeader;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Friend Name']")
	protected MobileElement friendNameBox;
	
	@AndroidFindBy (xpath="//android.widget.EditText[@text='Friends E-mail ID']")
	protected MobileElement friendEMailIdBox;
	
	@AndroidFindBy (xpath="//android.widget.EditText[@text='Friends Mobile No']")
	protected MobileElement friendMobileNoBox;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='Home']")
	protected MobileElement homeBtn;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='OK']")
	protected MobileElement okBtn;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='Exit']")
	protected MobileElement exitBtn;
	
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView")
	protected MobileElement referFriendAcknowledgment;
	
	
	public ReferPage (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}
	
	@SuppressWarnings("unchecked")
	public String referFriend(String friendName , String friendEmailId , String friendMobileNo) throws InterruptedException
	{
		waitForElement (friendNameBox, 3000);
		friendNameBox.click();
		friendNameBox.sendKeys(friendName);
		friendEMailIdBox.click();
		friendEMailIdBox.sendKeys(friendEmailId);
		friendMobileNoBox.click();
		friendMobileNoBox.sendKeys(friendMobileNo);
		okBtn.click();
		Thread.sleep(5000);
		String txn = processAcknowledgment();
		homeBtn.click();
		return txn;
	}
	
}
