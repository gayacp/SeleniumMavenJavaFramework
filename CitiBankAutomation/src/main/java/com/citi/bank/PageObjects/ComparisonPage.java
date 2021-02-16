package com.citi.bank.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ComparisonPage extends BasePage
{
	@FindBy(xpath="//div[@class='content-inner']/../h2")
	public WebElement compareText;
	public ComparisonPage validateText(String expectedText)
	{
		validateText(compareText, "Citi® Double Cash Card",expectedText);
		return this;
	}
	public ComparisonPage validateTextNegative(String expectedText)
	{
		validateTextNegative(compareText, "Citi® Double Cash Card",expectedText);
		return this;
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(compareText);
	}
}
