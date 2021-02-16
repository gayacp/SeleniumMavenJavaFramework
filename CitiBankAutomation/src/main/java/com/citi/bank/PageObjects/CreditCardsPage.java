package com.citi.bank.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreditCardsPage extends BasePage
{
	@FindBy(xpath="//*[@id='ca-DD-mppTitle']/h1")
	public WebElement viewAlltext;
	
	@FindBy(xpath="//button[@aria-label='Citi® Double Cash Card Learn More & Apply']")
	public WebElement firstCard;
	


	public ComparisonPage gotTocardDetails()
	{

		click(firstCard, "Double Cash Credit Card");
		return (ComparisonPage) openPage(ComparisonPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(viewAlltext);
	}
}
