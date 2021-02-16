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
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.citi.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"creditcards\"]")).click();
	driver.quit();
	}
}
