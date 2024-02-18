package com.autoEx.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;



public class TC5_Register_With_ExistingEmail extends TestBase {

	@Test
	//@Parameters({"link"})
	public void register_WithExistingEmail(String link) throws InterruptedException, IOException
	{
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Verify that home page is visible successfully
		4. Click on 'Signup / Login' button
		5. Verify 'New User Signup!' is visible
		*/
		
			
		clickOn_SignInLink();
		Thread.sleep(2000);
		visible_SignUp_YourAccount();
		
		//6. Enter name and already registered email address
		//7. Click 'Signup' button
		signUp(); //sign up with existing credintials
		
		//8. Verify error 'Email Address already exist!' is visible
		String ActulErrorMsg="Email Address already exist!";
		String ExpectedErrorMsg=driver.findElement(By.xpath("//div[@class='signup-form']/form/p")).getText();
		Assert.assertEquals(ActulErrorMsg,ExpectedErrorMsg,"Email Address is not already exist so Sigup sucessfuly....");
		System.out.println(ActulErrorMsg);
		
	}
}
