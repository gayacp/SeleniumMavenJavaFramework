package com.citi.bank.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.configuration.Config;

public class Rough extends BaseTest
{
	WebDriver driver;
	@Test
	public void citipagetest() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\gayap\\eclipse-workspace\\CitiBankAutomation\\src\\test\\resources\\executables\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.citi.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"creditcards\"]")).click();
////	Thread.sleep(3000);
//	driver.findElement(By.xpath("//*[@id='viewAllCards_Link']")).click();
//	driver.findElement(By.xpath("//*[@id='card_0']/div/div/div[2]/div/ui-card-button/button")).click();
////	System.out.println(driver.findElement(By.xpath("//div[@class='content-inner']/../h2")).getAttribute("sup"));
////	System.out.println(driver.findElement(By.xpath("//div[@class='content-inner']/../h2")).getText());
//	System.out.println(config.getProperty("defaultUserName"));
//	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("efvefvwc");
//	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("shdjfsf");
//	driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
	driver.quit();
	}
}
