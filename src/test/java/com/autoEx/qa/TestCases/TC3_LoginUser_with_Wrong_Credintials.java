package com.autoEx.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;

public class TC3_LoginUser_with_Wrong_Credintials extends TestBase
{
		
	@Test
	//@Parameters({"link"})
	public void loginWithWrongCredintials(String link) throws InterruptedException, IOException
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
		
		//6. Enter incorrect email address and password
		//7. Click 'login' button
		login();
		Thread.sleep(2000);
		//8. Verify error 'Your email or password is incorrect!' is visible
		String ActualErrorMsg="Your email or password is incorrect!";
		String ExpectedErrorMsg=driver.findElement(By.xpath("//div[@class='login-form']/form/p")).getText();
		Assert.assertEquals(ActualErrorMsg,ExpectedErrorMsg,ActualErrorMsg);
		
	
	}
	

}
