package com.autoEx.qa.TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;
import com.autoEx.qa.Utilites.UtilTest;



public class TC1_Register_User extends TestBase {

	@Test()
	public void TC1_User_Registration() throws InterruptedException, IOException {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'	  	  

//3. Verify that home page is visible successfully	  
		//homepageVisible();

//4. Click on 'Signup / Login' link  
		UtilTest.clickOn_SignInLink();

// 5. Verify 'New User Signup!' is visible
		visible_SignUp_YourAccount();

//  6. Enter name and email address

		WebElement name = driver.findElement(By.name(locatorsProp.getProperty("Reg_name")));
		UtilTest.sendKeys(driver, name, OrProp.getProperty("name"), 10);
		WebElement email = driver.findElement(By.xpath(locatorsProp.getProperty("Reg_email")));
		UtilTest.sendKeys(driver, email, OrProp.getProperty("email"), 10);

//	  7. Click 'Signup' button
		WebElement clickonSignUpBTN = driver.findElement(By.xpath(locatorsProp.getProperty("clickOnSignUp_Button")));
		UtilTest.clickOn(driver, clickonSignUpBTN, 20);

// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		String Expected_EAI_Msg = "ENTER ACCOUNT INFORMATION";
		WebElement ActualEAI_Msg = driver
				.findElement(By.xpath(locatorsProp.getProperty("enterAccountInformation_VisibleText")));
		String actString = UtilTest.getText(driver, ActualEAI_Msg, 25);
		Assert.assertEquals(actString, Expected_EAI_Msg, "ENTER ACCOUNT INFORMATION is not visible");
		System.out.println("'ENTER ACCOUNT INFORMATION' is visible");

//	  9. Fill details: Title, Name, Email, Password, Date of birth
		WebElement Mr_radio = driver.findElement(By.xpath(locatorsProp.getProperty("maleRadio_CheckBox")));
		UtilTest.clickOn(driver, Mr_radio, 10);
		Assert.assertTrue(Mr_radio.isEnabled());
		WebElement password = driver.findElement(By.xpath(locatorsProp.getProperty("Reg_password")));
		UtilTest.sendKeys(driver, password, OrProp.getProperty("password"), 10);

		/*
		 * WebElement
		 * day=driver.findElement(By.id(locatorsProp.getProperty("Reg_day"))); Select
		 * select=new Select(day); select.selectByValue(OrProp.getProperty("day"));
		 * WebElement
		 * month=driver.findElement(By.id(locatorsProp.getProperty("Reg_month")));
		 * select=new Select(month); select.selectByValue(OrProp.getProperty("month"));
		 * WebElement
		 * year=driver.findElement(By.id(locatorsProp.getProperty("Reg_year")));
		 * select=new Select(year); select.selectByValue(OrProp.getProperty("year"));
		 */

//  10. Select checkbox 'Sign up for our newsletter!'
//  11. Select checkbox 'Receive special offers from our partners!' 
		WebElement First_selectBox = driver.findElement(By.xpath(locatorsProp.getProperty("firstChecklBox")));
		First_selectBox.click();
		WebElement Second_selectBox = driver.findElement(By.xpath(locatorsProp.getProperty("secondCheckBox")));
		Second_selectBox.click();

//	  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		WebElement fname = driver.findElement(By.id(locatorsProp.getProperty("first_name")));
		WebElement lname = driver.findElement(By.id(locatorsProp.getProperty("last_name")));
		WebElement company = driver.findElement(By.id(locatorsProp.getProperty("company")));
		WebElement address1 = driver.findElement(By.id(locatorsProp.getProperty("address1")));
		WebElement address2 = driver.findElement(By.id(locatorsProp.getProperty("address2")));
		WebElement country = driver.findElement(By.id(locatorsProp.getProperty("country")));

		Select select = new Select(country);

		WebElement state = driver.findElement(By.id(locatorsProp.getProperty("state")));
		WebElement city = driver.findElement(By.id(locatorsProp.getProperty("city")));
		WebElement zip = driver.findElement(By.id(locatorsProp.getProperty("zipcode")));
		WebElement mobile = driver.findElement(By.id(locatorsProp.getProperty("mobilenumber")));

		UtilTest.sendKeys(driver, fname, OrProp.getProperty("first_name"), 10);
		UtilTest.sendKeys(driver, lname, OrProp.getProperty("last_name"), 10);
		UtilTest.sendKeys(driver, company, OrProp.getProperty("company"), 10);
		UtilTest.sendKeys(driver, address1, OrProp.getProperty("address1"), 10);
		UtilTest.sendKeys(driver, address2, OrProp.getProperty("address2"), 10);
		select.selectByVisibleText(OrProp.getProperty("country"));

		UtilTest.sendKeys(driver, state, OrProp.getProperty("state"), 10);
		UtilTest.sendKeys(driver, city, OrProp.getProperty("city"), 10);
		UtilTest.sendKeys(driver, zip, OrProp.getProperty("zip_code"), 10);
		UtilTest.sendKeys(driver, mobile, OrProp.getProperty("mobile_number"), 10);

//  13. Click 'Create Account button'		
		WebElement clickoncreateAccBTN = driver
				.findElement(By.xpath(locatorsProp.getProperty("clickOncreateAccount_Button")));
		UtilTest.clickOn(driver, clickoncreateAccBTN, 10);

//14.	Verify that 'ACCOUNT CREATED!' is visible
		String Expected_ACCOUNT_CREATED = "ACCOUNT CREATED!";
		WebElement Actual_ACCOUNT_CREATED = driver
				.findElement(By.xpath(locatorsProp.getProperty("visibledAccountCreated_text")));
		UtilTest.getText(driver, Actual_ACCOUNT_CREATED, 10);
		Assert.assertEquals(Actual_ACCOUNT_CREATED.getText(), Expected_ACCOUNT_CREATED, "Account is not created");
		System.out.println(Expected_ACCOUNT_CREATED);

// 15. Click 'Continue' button
		WebElement clickonContBTN = driver.findElement(By.xpath(locatorsProp.getProperty("clickOnContune_Button")));
		UtilTest.clickOn(driver, clickonContBTN, 20);
				
		
		
		
//16. Verify that 'Logged in as username' is visible

		String Expected_logged_uame = "Logged in as " + OrProp.getProperty("name");
		WebElement Actual_logged_uame1 = driver
				.findElement(By.xpath(locatorsProp.getProperty("visibledLoginAsUsername_Msg")));
		UtilTest.getText(driver, Actual_logged_uame1, 10);
		Assert.assertEquals(Actual_logged_uame1.getText(), Expected_logged_uame, "Logged in as username is not found");
		System.out.println(Expected_logged_uame);

//17. Click 'Delete Account' button
		WebElement clickonDelete = driver.findElement(By.xpath(locatorsProp.getProperty("clickOnDelete_Button")));
		UtilTest.clickOn(driver, clickonDelete, 15);
//	  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button	  
		String Expacted_Delete_Msg = "ACCOUNT DELETED!";

		WebElement Actual_Delete_msg = driver
				.findElement(By.xpath(locatorsProp.getProperty("visibledAccountDelete_Text")));
		UtilTest.getText(driver, Actual_Delete_msg, 25);
		Assert.assertEquals(Actual_Delete_msg.getText(), Expacted_Delete_Msg, "Account is not delete");

		driver.findElement(By.xpath(locatorsProp.getProperty("clickOnContune_Button_AfterDeleteAccount"))).click();

		String ActualTtile = "Automation Exercise";
		String title = driver.getTitle();
		Assert.assertEquals(title, ActualTtile, "Not naviagted on Home page");
		System.out.println("Account is deleted successfully..........");
		System.out.println("You are on Home page...");

	}

}
