package com.citi.bank.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.citi.bank.PageObjects.HomePage;
import com.citi.bank.Utilities.Constants;
import com.citi.bank.Utilities.DataProviders;
import com.citi.bank.Utilities.DataUtil;
import com.citi.bank.Utilities.ExcelReader;


public class LoginTest extends BaseTest
{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String, String> data)
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside LoginTest");
		openBrowser(data.get("browser"));
		logInfo("Browser Launched :"+data.get("browser"));
		HomePage home=new HomePage().open("https://www.citi.com/");
		home.doLoginAsInvalidUser(data.get("username"),data.get("password"));
		logInfo("Username entered as"+data.get("username")+"Password entered as"+data.get("password"));
		
	}
	@AfterMethod
	public void teardown()
	{
		quit();
		logInfo("Login Test Completed");
	}

}
