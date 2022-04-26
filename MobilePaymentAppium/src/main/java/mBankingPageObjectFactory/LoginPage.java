package mBankingPageObjectFactory;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mBankingBaseFactory.ObjectRepository;

public class LoginPage extends ObjectRepository {

	public static AppiumDriver<MobileElement> driver;

	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	public LoginPage(AppiumDriver<MobileElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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

	public MobileElement place() {
		MobileElement element = getDriver()
				.findElement(By.xpath("//*[@class='android.widget.Button'][@text='Logout']"));
		return element;
	}

}
