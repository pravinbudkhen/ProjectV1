package com.QAFox.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QAFox.qa.Base.BaseTest;
import com.QAFox.qa.Pages.RegisterPage;
import com.QAFox.qa.Pages.SuccessPage;


public class SuccessPageTest extends BaseTest {
	@Test(priority = 1)
	public void veryfiSuccessPageTitleTest() {
		
		String ActualTitle = "Your Account Has Been Created!";
		SuccessPage seccessPage = page.getInstance(RegisterPage.class).doRegister("dsdsdf","sfdfsf","sk55ss55fd@gmail.com", "32132131","11111","11111");
		String title=seccessPage.getPageTitle();
		Assert.assertEquals(title, ActualTitle, "Sucess Page Title is not found");
		System.out.println("Success Page Title is :"+title);
	}

	@Test(priority = 2)
	public void verifyRegiterPageHeaderTest() {
		String ActualHeader = "Your Account Has Been Created!";
		SuccessPage seccessPage = page.getInstance(RegisterPage.class).doRegister("dsdsdf","sfdfsf","krjs5s5fd@gmail.com", "32132131","11111","11111");
		String header = seccessPage.getSuccessPageHeader();
		Assert.assertEquals(ActualHeader, header, "Success Page Header is not match");
		System.out.println("Sucess Page Header is :" + header);
	}
	
}
