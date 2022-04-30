package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.ObjectRepository;

public class LoginPage extends ObjectRepository {

	public static AppiumDriver<MobileElement> driver;

	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	public MobileElement loginBox;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and text()='QUEUED']")
	public MobileElement queued;
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnQueued() {
		click(queued);
	}

	public void loginApp(String pin) throws InterruptedException {
		try {
			waitForElement(loginBox, 10);
		} catch (Exception e) {
			log.info(e);
		}
		click(loginBox);
		log.info("Clicked on login box");
		sendText(loginBox, pin);
		log.info("Login Pin send  : " + pin);
		click(okBtnLogin);
		log.info("Clicked on ok button");
		// .Fragment_Activity
	}
}
