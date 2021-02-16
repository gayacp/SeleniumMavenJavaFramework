package com.citi.bank.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.citi.bank.ExtentListeners.ExtentListeners;
import com.citi.bank.Utilities.DriverFactory;
import com.citi.bank.Utilities.DriverManager;



public class BaseTest 
{

	private String url;
	
	private WebDriver driver;
	private Properties config=new Properties();
	private FileInputStream fis;
	public Logger log=Logger.getLogger(BaseTest.class);
	private String defaultUsername;
	public String getDefaultUsername() {
		return defaultUsername;
	}

	public String getURL() {
		return url;
	}
	public void setURL(String url) {
		this.url = url;
	}
	public void setDefaultUsername(String defaultUsername) {
		this.defaultUsername = defaultUsername;
	}
	

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}
	private String defaultPassword;
	@BeforeSuite
	public void setUpFramework()
	{
		configureLogging();
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");

		if (System.getProperty("os.name").equalsIgnoreCase("mac")) 
		{

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");

		}else 
		{
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");

			try {
				fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config properties file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

		public void logInfo(String message) {
			
			ExtentListeners.testReport.get().info(message);
		}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties" + File.separator
				+ "log4j.properties";
		//		String log4jConfigFile = System.getProperty("user.dir") + "src/test/resources/properties/log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void destroyFramework() {

	}
	public void openBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.out.println("Launching from TC1"+browser);
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
			driver = new ChromeDriver();
			log.info("Chrome browser launched !!!");
		}
		else if(browser.equals("firefox"))
		{
			System.out.println("Launching from TC1"+browser);
			System.setProperty("webdriver.gecko.driver",DriverFactory.getGeckoDriverExePath());		
			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");
		}
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().window().maximize();	
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		setDefaultUsername(config.getProperty("defaultUserName"));
		setDefaultPassword(config.getProperty("defaultPassword"));
	}
	public void quit()
	{
		DriverManager.getDriver().quit();
	}
}


