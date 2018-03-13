package mBankingBaseFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ObjectRepository extends AppiumController {
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Home']")
	public static MobileElement homeBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Help']")
	public MobileElement helpBtn;
	
	@AndroidFindBy(xpath ="//*[@class='android.widget.Button'][@text='Logout']")
	public MobileElement logoutBtn;
	
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
}
