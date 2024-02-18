package com.autoEx.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autoEx.qa.Listeners.CusstomListener;
import com.autoEx.qa.Listeners.ListenersDemo;
import com.autoEx.qa.Pages.RegisterPage;
import com.autoEx.qa.Utilites.UtilTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static FileInputStream fisOfConfig;
	public static Properties configProp;
	
	public static FileInputStream fisOfLocators;
	public static Properties locatorsProp;
	
	public static FileInputStream fisOfOr;
	public static Properties OrProp;
	
	public WebDriverListener listener;
	//  CusstomListener listener;
	
	
	public   TestBase()  {
		
		if(driver==null) {
			configProp = new Properties();
			locatorsProp= new Properties();
			OrProp=new Properties();
			
				try {
					fisOfConfig = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\Properties\\config.properties");
					fisOfLocators= new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\Properties\\locators.properties");
					fisOfOr= new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\Properties\\objectRepository.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					configProp.load(fisOfConfig);
					locatorsProp.load(fisOfLocators);
					OrProp.load(fisOfOr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
	}
		
	public static void setUp() {
	
		if (configProp.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (configProp.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (configProp.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();			
		}
		  WebDriverListener listener = new CusstomListener();
		  driver= new EventFiringDecorator(listener).decorate(driver);
		   

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.get(configProp.getProperty("link"));
		String ActualTtitle = driver.getTitle();
		Assert.assertEquals(ActualTtitle, "Automation Exercise");
		//homepageVisible();

	}
	public static void tearDoun() {
		driver.quit();
	}

	public static void homepage_Visible() {
		WebElement validationf_for_homepage = driver.findElement(By.xpath(locatorsProp.getProperty("homePageVisible_Text")));
		Assert.assertTrue(validationf_for_homepage.isEnabled());
		System.out.println("Home page visible successfully");
	}

	public static void clickOn_SignInLink() {
		WebElement click_on_Sign_Login = driver.findElement(By.xpath(locatorsProp.getProperty("clickOnSignIn_Link")));
		click_on_Sign_Login.click();
	}

	public static void visible_LoginTo_YourAccount() {
		String Expected_LoginAccountMsg = "Login to your account";
		String Actual_LoginAccountMsg = driver.findElement(By.xpath(locatorsProp.getProperty("visibledLoginYourAccount_Text"))).getText();
		Assert.assertEquals(Actual_LoginAccountMsg, Expected_LoginAccountMsg, "'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible");
	}

	public static void visible_SignUp_YourAccount() {
		String Expected_LoginAccountMsg = "New User Signup!";
		String Actual_LoginAccountMsg = driver.findElement(By.xpath(locatorsProp.getProperty("visibledSignInYourAccount_Text"))).getText();
		Assert.assertEquals(Actual_LoginAccountMsg, Expected_LoginAccountMsg, "New User Signup! is not visibled");
		System.out.println("'New User Signup!' is visible");
	}

	public static void login() throws InterruptedException, IOException {
		
		WebElement email = driver.findElement(By.name(locatorsProp.getProperty("Login_email")));
		WebElement password = driver.findElement(By.name(locatorsProp.getProperty("Login_password")));
		UtilTest. sendKeys(driver, email, OrProp.getProperty("email"), 20);
		UtilTest.sendKeys(driver, password, OrProp.getProperty("password"), 20);
		WebElement btnlogin = driver.findElement(By.xpath("//div[@class='login-form']/form/button"));
		UtilTest.clickOn(driver, btnlogin, 10);
		String actualUrl="https://automationexercise.com/login";
		String ExpectedUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,ExpectedUrl,"Not Login successfully...");
		System.out.println("Login Successfully....");
	}

	public static void loginWithhDataProvider(String user_email,String user_pass) throws InterruptedException, IOException {
		
		WebElement email = driver.findElement(By.name(locatorsProp.getProperty("Login_email")));
		WebElement password = driver.findElement(By.name(locatorsProp.getProperty("Login_password")));
		UtilTest.sendKeys(driver, email, user_email, 20);
		UtilTest.sendKeys(driver, password, user_pass, 20);
		WebElement btnlogin = driver.findElement(By.xpath("//div[@class='login-form']/form/button"));
		UtilTest.clickOn(driver, btnlogin, 10);
		
		String actualUrl="https://automationexercise.com/login";
		String ExpectedUrl=driver.getCurrentUrl();
		Assert.assertNotEquals(actualUrl,ExpectedUrl,"Not Login successfully...");
		System.out.println(" Successfully successfully....");
				
	}

	public static void visble_Logged_in_as_Username() throws InterruptedException {
		String Expected_logged_uame = "Logged in as " + OrProp.getProperty("name");
		String Atual_logged_uame = driver.findElement(By.xpath(locatorsProp.getProperty("visibledLoginAsUserName_Text"))).getText();
		Assert.assertEquals(Atual_logged_uame, Expected_logged_uame," login as username msg is not visibled");
		System.out.println(Atual_logged_uame);
	}

	public void sign_Up() throws InterruptedException, IOException {
		WebElement name = driver.findElement(By.xpath(locatorsProp.getProperty("SignUp_name")));
		WebElement email = driver.findElement(By.xpath(locatorsProp.getProperty("SignUp_email")));
		UtilTest.sendKeys(driver, name, OrProp.getProperty("name"), 10);
		UtilTest.sendKeys(driver, email, OrProp.getProperty("email"), 10);
		WebElement clickobSignUpBTN = driver.findElement(By.xpath(locatorsProp.getProperty("clickOnSignUp_Button")));
		UtilTest.clickOn(driver, clickobSignUpBTN, 20);

	}

}
