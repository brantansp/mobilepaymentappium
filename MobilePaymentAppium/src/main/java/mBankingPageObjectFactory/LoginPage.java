package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.BaseTestMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.BasePage;
import mBankingBaseFactory.ObjectRepository;

public class LoginPage {

	public static AppiumDriver<MobileElement> driver;
	
	public static BasePage ui;

	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	public MobileElement loginBox;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='QUEUED']")
	public MobileElement queued;
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		ui = new BasePage();
	}
	
	public void clickOnQueued() {
		try {
			ui.click(queued);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginApp(String pin) throws InterruptedException {
		try {
			ui.waitForElement(loginBox, 10);
		} catch (Exception e) {
			log.info(e);
		}
		ui.click(loginBox);
		log.info("Clicked on login box");
		ui.sendText(loginBox, pin);
		log.info("Login Pin send  : " + pin);
		//click(okBtnLogin);
		log.info("Clicked on ok button");
		// .Fragment_Activity
	}
}
