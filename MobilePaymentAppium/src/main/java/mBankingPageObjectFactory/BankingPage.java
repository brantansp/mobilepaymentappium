package mBankingPageObjectFactory;

import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import mBankingUtility.WriteToCSVFile;
import mBankingUtility.dbTransactionlog;

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
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Mini Statement']")
	public MobileElement msAcknPage;
	
	@SuppressWarnings("unchecked")
	public void balanceEnq(String [] accNo)
	{
		if (prop.getProperty("multiaccflag").equals("Y")) //if multiacc txn enable
		{
			log.info("Multi Account transaction");
			for (int i=0; i< accNo.length;i++)
			{
				click("//android.widget.TextView[@text='"+accNo[i]+"']");
				ArrayList<AndroidElement> test;
		    	test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
		    	if(test.size()>=1)   //mpin page exists
				{
					sendText(mPINBox, prop.getProperty("mpin"));
					click(okBtn);
				}
				waitForElement(beAcknPage,30);
				//sleep(5000);
				String txn = processAcknowledgment();
				if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
				{
					try {
					WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
					} catch (SQLException e) {
						log.info(e);
					}catch (FileNotFoundException e) {
						 log.info(e);
						}
				 }
				/* back();
				 click(be);*/
				click(homeBtn);
			}
			click(homeBtn);
		} 
		else
		{
			log.info("Single Account transaction");
			click("//android.widget.TextView[@text='"+accNo[0]+"']");
			ArrayList<AndroidElement> test;
	    	test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
	    	if(test.size()>=1)   //mpin page exists
			{
				sendText(mPINBox, prop.getProperty("mpin"));
				click(okBtn);
			}
			waitForElement(beAcknPage,30);
			//sleep(5000);
			String txn = processAcknowledgment();
			if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
			{
				try {
				WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
				} catch (SQLException e) {
					log.info(e);
				}catch (FileNotFoundException e) {
					 log.info(e);
					}
			 }
			click(homeBtn);
		}
	}

	@SuppressWarnings("unchecked")
	public void miniStatement(String [] accNo)
	{
		if (prop.getProperty("multiaccflag").equals("Y")) //if multiacc txn enable
		{
			log.info("Multi Account transaction");
			for (int i=0; i< accNo.length;i++)
			{
				click("//android.widget.TextView[@text='"+accNo[i]+"']");
				ArrayList<AndroidElement> test;
		    	test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
		    	if(test.size()>=1)   //mpin page exists
				{
					sendText(mPINBox, prop.getProperty("mpin"));
					click(okBtn);
				}
				waitForElement(logoutBtn,30);
				//sleep(5000);
				String txn = processMsAcknowledgment();
				if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
				{
					try {
					WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
					} catch (SQLException e) {
						log.info(e);
					}catch (FileNotFoundException e) {
						 log.info(e);
						}
				 }
			/*	back();
				click(ms);*/
				click(homeBtn);
			}
			click(homeBtn);
		} 
		else
		{
			log.info("Single Account transaction");
			click("//android.widget.TextView[@text='"+accNo[0]+"']");
			ArrayList<AndroidElement> test;
	    	test =(ArrayList<AndroidElement>) ((FindsByAndroidUIAutomator<AndroidElement>) getDriver()).findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\")");
	    	if(test.size()>=1)   //mpin page exists
			{
				sendText(mPINBox, prop.getProperty("mpin"));
				click(okBtn);
			}
			waitForElement(logoutBtn,30);
			String txn = processAcknowledgment();
			if (prop.getProperty("dbresultflag").equals("Y")) // for DB fetch and write to CSV
			{
				try {
				WriteToCSVFile.reportGeneration(dbTransactionlog.fetchRecord(txn));
				} catch (SQLException e) {
					log.info(e);
				}catch (FileNotFoundException e) {
					 log.info(e);
					}
			 }
			click(homeBtn);
		}
	}




























}




















