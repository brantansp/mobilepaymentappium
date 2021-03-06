package mBankingPageObjectFactory;

import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
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
	
	public void m2mQuick(String mobNo, String amount, String remark)
	{
		prop.setProperty("ftMobNo", mobNo);
		prop.setProperty("ftAmnt", amount);
		prop.setProperty("ftRemark", remark);
		clickView("Fund Transfer - Within Bank");
		clickView("Mobile-to-Mobile");
		clickView("Quick Fund Transfer");
		waitForTextView("Select A/C",30);
		String[] accNo = listOfAc();
		if (prop.getProperty("multiaccflag").equals("Y")) //if multiacc txn enable
		{
			log.info("Multi Account transaction");
			for (int i=0; i< accNo.length;i++)
			{
				click("//android.widget.TextView[@text='"+accNo[i]+"']");
				ArrayList<AndroidElement> test;
		    	test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
		    	String [] editBox = new String [test.size()];
		    	for(int k =0 ; k<test.size(); k++)
		    	{
		    		editBox[k]= test.get(k).getText();
		    	}
		    	if(Arrays.asList(editBox).contains("mPIN"))   //mpin page exists
				{
		    		log.info("mpin box");
					sendText(mPINBox, prop.getProperty("mpin"));
					click(okBtn);
				}
				waitForElement(benMobNo,30);
				sendText(benMobNo,"8778602561");
				sendText(amnt,"10");
				sendText(remarks,"test");
				click(okBtn);
				waitForElement(qFt,60);
				click(confirmBtn);
				waitForElement(AcknPage,60);
				String txn = processAcknowledgment();
				if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
				{
					try {
					WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
					} catch (SQLException e) {
						System.out.println(e);
					}catch (FileNotFoundException e) {
						 System.out.println(e);
						}
				 }
				clickBtn("Home");
			}
			clickBtn("Home");
		} 
		else
		{
			log.info("Single Account transaction");
			clickView(accNo[0]);
			String [] editBox =loadEditText();
			processEditBox(editBox);
			clickBtn("OK");
	    	editBox =loadEditText();
	    	processEditBox(editBox);
	    	clickBtn("OK");
			waitForTextView("Quick Fund Transfer",30);
			clickBtn("Confirm");
			waitForElement(AcknPage,30);
			//waitForTextView("Transaction ID",30);
			String txn = processAcknowledgment();
			if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
			{
				try {
				WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
				} catch (SQLException e) {
					System.out.println(e);
				}catch (FileNotFoundException e) {
					 System.out.println(e);
					}
			 }
			clickBtn("Home");
		}
	
	}

	public void BenReg(String mobNumber, String nickName)
	{
		prop.setProperty("ftMobNo", mobNumber);
		prop.setProperty("ftAmnt", nickName);
		click(Banking);
		click(ftWb);
		click(m2mBtn);
		click(BenReg);
		ArrayList<AndroidElement> test;
		test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
    	String [] editBox = new String [test.size()];
    	for(int k =0 ; k<test.size(); k++)
    	{
    		editBox[k]= test.get(k).getText();
    	}
    	if(Arrays.asList(editBox).contains("mPIN"))   //mpin page exists
		{
    		log.info("mpin box");
			sendText(mPINBox, prop.getProperty("mpin"));
			click(okBtn);
		}
    	sendText(mobNo, prop.getProperty("ftMobNo"));
    	sendText(nickname, prop.getProperty("ftAmnt"));
    	click(okBtn);
    	waitForElement(benACList,30);
    	String[] accNo = benListOfAc();
    	click("//android.widget.TextView[@text='"+accNo[1]+"']");
		click(confirmBtn);
		waitForElement(AcknPage, 30);
		String txn = processAcknowledgment();
		if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
		{
			try {
			WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
			} catch (SQLException e) {
				System.out.println(e);
			}catch (FileNotFoundException e) {
				 System.out.println(e);
				}
		 }
		click(homeBtn);
	}

}



















