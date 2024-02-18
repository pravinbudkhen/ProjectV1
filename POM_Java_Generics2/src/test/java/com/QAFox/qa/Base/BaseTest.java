package com.QAFox.qa.Base;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
/*
	public static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}
*/
	public FileInputStream fisOfConfig;
	public Properties configProp;

	public FileInputStream fisOfLocators;
	public Properties locatorsProp;

	public FileInputStream fisOfOr;
	public Properties OrProp;

	public WebDriverWait wait;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })

	public void setupLounch(@Optional("chrome") String browser) {

		if (browser != null) {
			configProp = new Properties();
			locatorsProp = new Properties();
			OrProp = new Properties();
			try {
				fisOfConfig = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
				fisOfLocators = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\locators.properties");
				fisOfOr = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Properties\\objectRepository.properties");

				configProp.load(fisOfConfig);
				locatorsProp.load(fisOfLocators);
				OrProp.load(fisOfOr);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				//driver.set(new ChromeDriver());
			} else if (browser.equals("ff")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				//driver.set(new FirefoxDriver());
			}
			else {
				System.out.println(browser+" is not install on your system");
			}

		}

		/*
		 * if (configProp.getProperty("browser").equals("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (configProp.getProperty("browser").equals("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else if (configProp.getProperty("browser").equals("edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); }
		 */
		
		/*
		page = new BasePage(getDriver());
		getDriver().manage().window().maximize();
		 getDriver().get(configProp.getProperty("link"));
		System.out.println(Thread.currentThread().getId());
		*/
		
		page = new BasePage(driver);
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("link"));
		System.out.println(Thread.currentThread().getId());
	}

	@AfterMethod
	public void tearDoun() {
		//getDriver().quit();
		driver.quit();
	}

}
