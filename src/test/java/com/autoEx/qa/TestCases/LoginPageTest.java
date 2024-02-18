package com.autoEx.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;
import com.autoEx.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;

	LoginPageTest() {
		super();
	
	}

	@BeforeClass
	public void StartUp() {
		setUp();
		lp = new LoginPage();
	}
	
	@AfterClass
	public void tearDoun1() {
		tearDoun();
	}
	
	
	@Test(priority = 1)
	public void loginTest() {
		Assert.assertEquals(lp.clickOnSignInLink(), true, "Not clicked on sign In link");
		System.out.println("Clicked on Signin link");
		Assert.assertEquals(lp.visibledLoginYourAccountText(),"Login to your account","Not visibled Login to your account");
		System.out.println("Login to your account is visibled");
		lp.loginUser();
	}
	@Test(priority = 2)
	public void visibledLoginAsUserNameTest()
	{
		String ExpStr="Logged in as " + OrProp.getProperty("name");
		Assert.assertEquals(lp.visibledLoginAsUserNameText(),ExpStr,"Not visibled "); 
		System.out.println(ExpStr);
	}

}
