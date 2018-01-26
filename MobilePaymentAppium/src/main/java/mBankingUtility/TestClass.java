package mBankingUtility;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestClass {
	
	@BeforeSuite
	public void call()
	{
		System.out.println("I am called");
	}
    
	@Test
	public void test()
	{
		System.out.println("This is called");
	}
	
}
