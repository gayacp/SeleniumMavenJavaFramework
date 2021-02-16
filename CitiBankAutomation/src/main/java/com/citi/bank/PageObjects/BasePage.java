package com.citi.bank.PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.citi.bank.ExtentListeners.ExtentListeners;
import com.citi.bank.Utilities.DriverManager;


public abstract class BasePage<T> 
{
	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverManager.getDriver();
	}




	public T openPage(Class<T> clazz) {
		T page = null;
		//	        try {
		driver = DriverManager.getDriver();
		AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, 30);
		page = PageFactory.initElements(driver, clazz);
		PageFactory.initElements(ajaxElemFactory, page);
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		//	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(pageLoadCondition);
	}

	protected abstract ExpectedCondition getPageLoadCondition();


	public void click(WebElement element, String elementName) {

		element.click();
		ExtentListeners.testReport.get().info("Clicking on : "+elementName);

	}
	public void visible(WebElement element, String elementName) {

		element.isDisplayed();
		ExtentListeners.testReport.get().info("Clicking on : "+elementName);

	}
	public void validateText(WebElement element, String elementName, String expected) {

		Assert.assertEquals(element.getText(), expected);
		ExtentListeners.testReport.get().info("Validating the element : "+elementName);

	}
	
	public void validateTextNegative(WebElement element, String elementName, String expected) {
		
		Assert.assertNotEquals(element.getText(), expected);
		ExtentListeners.testReport.get().info("Validating the element : "+elementName +"is not matching with test data "+expected);

	}
	public void type(WebElement element, String value, String elementName) {

		element.sendKeys(value);
		ExtentListeners.testReport.get().info("Typing in : "+elementName+" entered the value as : "+value);

	}
}
