package com.QAFox.qa.TestCases;


import java.util.Date;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.QAFox.qa.Base.BaseTest;
import com.QAFox.qa.Pages.RegisterPage;

public class RegisterTest extends BaseTest {

	 @Test(priority = 1)
	public void verifyRegiterPageTtile() {
		 System.out.println("i am register page");
		 page.getInstance(RegisterPage.class).openRegisterPage();
		String ActualTitle = "Register Account";
		String title = page.getInstance(RegisterPage.class).getRegisterPageTitlle();
		Assert.assertEquals(title, ActualTitle, "Register Page Title is not match");
		System.out.println("Register Page title is :" + title);
	}
	@Test(priority = 2)
	public void verifyRegiterPageHeader() {
		page.getInstance(RegisterPage.class).openRegisterPage();
		String ActualHeader = "Register Account";
		String header = page.getInstance(RegisterPage.class).getRegisterPageHeader();
		Assert.assertEquals(header, ActualHeader, "Register Page Header is not match");
		System.out.println("Register Page Header is :" + header);
	}
	@Test(priority = 3)
	public void veriyRegistration() throws InterruptedException {
		Date date=new Date();
		String fname;
		String lname;
		String email=OrProp.getProperty("email")+date.getTime()+"@gmail.com";
		String telephone;
		String pass;
		String conf_pass;
		
		page.getInstance(RegisterPage.class).doRegister(fname = OrProp.getProperty("firstname"),
				lname = OrProp.getProperty("lastname"), 
						email,
				telephone = OrProp.getProperty("telephone"), 
				pass = OrProp.getProperty("password"),
				conf_pass = OrProp.getProperty("conf_pass"));
	}
}
