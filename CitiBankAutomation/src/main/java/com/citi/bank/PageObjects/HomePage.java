package com.citi.bank.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.citi.bank.Utilities.DriverManager;




public class HomePage extends BasePage
{
	@FindBy(xpath="//a[@id='creditcards']")
	public WebElement creditCard;
	
	@FindBy(xpath="//*[@id='viewAllCards_Link']")
	public WebElement viewAllCreditCard;
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement passWordTextBox;
	
	@FindBy(xpath="//input[@id='signInBtn']")
	public WebElement signInButton;
	
	

	@FindBy(xpath="//div[@id='credentialsRow']/div/span[contains(text(),'Trouble signing on? Select')]")
	public WebElement errorMessage;
	
//	public HomePage doLoginAsInvalidUser(String user, String password)
//	{
//		type(userNameTextBox, user, "UserName Textbox");
//		type(passWordTextBox, password, "Password Textbox");
//		click(signInButton, "Signin-button");
//		return this;
//	}
	public HomePage doLoginAsInvalidUser(String user, String password)
	{
		type(userNameTextBox, user, "UserName Textbox");
		type(passWordTextBox, password, "Password Textbox");
		click(signInButton, "Signin-button");
//		validateText(errorMessage, "Error message", "Trouble signing on? Select \"Forgot User ID\" or \"Forgot Password\".");
		return this;
	}
	
	public HomePage open(String url)
	{
		DriverManager.getDriver().navigate().to(url);
		return (HomePage)openPage(HomePage.class);
	}
	
	public CreditCardsPage gotoViewAllCreditCards() throws InterruptedException
	{
		click(creditCard, "CreditCardLink");
		click(viewAllCreditCard, "ViewAllCreditCardLink");
		return (CreditCardsPage) openPage(CreditCardsPage.class);
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(creditCard);
	}
}
