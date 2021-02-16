package com.citi.bank.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.citi.bank.PageObjects.ComparisonPage;
import com.citi.bank.PageObjects.CreditCardsPage;
import com.citi.bank.PageObjects.HomePage;
import com.citi.bank.Utilities.Constants;
import com.citi.bank.Utilities.DataProviders;
import com.citi.bank.Utilities.DataUtil;
import com.citi.bank.Utilities.ExcelReader;



public class CreditCardTest extends BaseTest
{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void creditCardTest(Hashtable<String, String> data) throws InterruptedException
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "CreditCardTest", data.get("Runmode"), excel);
		log.info("Inside CreditCardTest");
	
		openBrowser(data.get("browser"));
		logInfo("Browser Launched :"+data.get("browser"));
		HomePage home=new HomePage().open("https://www.citi.com/");
		CreditCardsPage credit=home.gotoViewAllCreditCards();
		ComparisonPage cmp=credit.gotTocardDetails();
//		cmp.validateText("Citi® Double Cash Card");
		cmp.validateText(data.get("expected"));
		
		
	}
	@AfterMethod
	public void teardown()
	{
		quit();
		logInfo("CreditCardTest Completed");
	}

}
