package com.autoEx.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;



public class TC4_Logout_User extends TestBase {
	@Test
	//@Parameters({"link"})
	public void logoutUser(String link) throws InterruptedException, IOException
	{
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Verify that home page is visible successfully
		4. Click on 'Signup / Login' button
		5. Verify 'Login to your account' is visible
		*/
		

		clickOn_SignInLink();
		Thread.sleep(2000);
		visible_LoginTo_YourAccount();
		
		//6. 6. Enter correct email address and password
		//7. Click 'login' button
		login();
		
		//8. Verify that 'Logged in as username' is visible
		visble_Logged_in_as_Username();
		Thread.sleep(2000);
		
		//9. Click 'Logout' link
		driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li[4]/a")).click();
		
		//10. Verify that user is navigated to login page
		String Actual_UrlOf_loginPage="https://automationexercise.com/login";
		String Expected_UrlOf_loginPage=driver.getCurrentUrl();
		Assert.assertEquals(Actual_UrlOf_loginPage, Expected_UrlOf_loginPage,"user is not navigated to login page sucessfully.....");		 
		System.out.println("user is  navigated to login page sucessfully.....");
	
	
	}

}
