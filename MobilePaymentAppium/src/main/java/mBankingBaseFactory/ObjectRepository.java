package mBankingBaseFactory;

import java.lang.reflect.Field;

import testPackage.test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ObjectRepository extends AppiumController {
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	public static MobileElement homeBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Help']")
	public MobileElement helpBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Logout']")
	public MobileElement logoutBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Confirm']")
	public MobileElement confirmBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Cancel']")
	public MobileElement cancelBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Fund Transfer - Within Bank']")
	public MobileElement ftWb;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Fund Transfer - Other Bank']")
	public MobileElement ftOb;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Request to Bank']")
	public MobileElement reqBnk;

	@AndroidFindBy (xpath="//android.widget.EditText[@text='mPIN']")
	protected static MobileElement mPINBox;
	
	@AndroidFindBy (xpath="//android.widget.Button[@text='OK']")
	protected MobileElement okBtn;      //bottomband ok
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][2]")
	public static MobileElement loginOkBtn;  //login page ok
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Transaction ID']")
	public MobileElement AcknPage;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Fund Transfer - Within Bank']")
	public MobileElement ftHeader;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Mobile-to-Mobile']")
	public MobileElement m2mBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Mobile-to-Account']")
	public MobileElement m2aBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Quick Fund Transfer']")
	public MobileElement qFt;

	@AndroidFindBy (xpath="//android.widget.TextView[@text='Beneficiary Registration']")
	public MobileElement BenReg;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Beneficiary Payment']")
	public MobileElement BenPay;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Beneficiary Details']")
	public MobileElement BenDetl;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Beneficiary Deregistration']")
	public MobileElement BenDereg;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Select A/C']")
	public MobileElement selectAcPage;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Beneficiary Mobile No.']")
	protected MobileElement benMobNo;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Amount (Rs.)']")
	protected MobileElement amnt;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Remarks']")
	protected MobileElement remarks;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Mobile No.']")
	protected MobileElement mobNo;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Nickname']")
	protected MobileElement nickname;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Beneficiary A/C List']")
	public MobileElement benACList;
	
	@AndroidFindBy(xpath="//*[@text='Yes']")
	public MobileElement exitYesBtn;
	
	@AndroidFindBy(xpath="//*[@text='No']")
	public MobileElement exitNoBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Change mPIN']")
	public MobileElement changemPINBtn;
	
	@AndroidFindBy(className= "android.widget.EditText[1]")
	public MobileElement oldmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	public MobileElement newmPIN;
	
	@AndroidFindBy(className= "android.widget.EditText[2]")
	public MobileElement reEntermPIN;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Exit']")
	public static MobileElement exitBtn;
	
	//com.fss.united:id/Gridtext
	//@AndroidFindBy(id = "com.fss.united:id/Gridtext")
	@AndroidFindBy (xpath="//android.widget.TextView[@index='0']")
	public MobileElement welcomeText;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@index='1']")
	public MobileElement helpTextView;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Banking']")
	public MobileElement bankingBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='24X7Fund Transfer']")
	public MobileElement impsBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Payment']")
	public MobileElement paymentBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Other Services']")
	public MobileElement otherServicesbtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='My Setup']")
	public MobileElement mySetupBtn;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Inbox']")
	public MobileElement inboxBtn;
	
	@AndroidFindBy(id = "com.fss.united:id/header")
	public MobileElement logoHeader;
	
	@AndroidFindBy(className= "android.widget.ImageView")
	public MobileElement logoView;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
	public MobileElement loginBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='About Us']")
	public MobileElement aboutUsLink;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Forgot Password']")
	public MobileElement forgotPasswordLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Products']")
	public MobileElement productsLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Refer']")
	public MobileElement referLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='ePassbook']")
	public MobileElement ePassbookLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Feedback']")
	public MobileElement feedbackLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Locator']")
	public MobileElement locatorLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Wallet']")
	public MobileElement walletLink;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@index='0']")
	public MobileElement acList;

	
}
