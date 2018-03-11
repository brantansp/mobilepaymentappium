package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.AppiumController;

public class BalanceEnquiry extends AppiumController {

	protected static AppiumDriver <MobileElement> driver ;
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public BalanceEnquiry (AppiumDriver <MobileElement> driver) 
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()) , this);
	}

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	protected static MobileElement homeBtn;

	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Logout']")
	protected MobileElement logoutBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	protected static MobileElement headerText;
	
	
	public static void disp()
	{
		headerText.getAttribute("text");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
