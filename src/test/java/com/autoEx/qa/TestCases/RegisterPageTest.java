package com.autoEx.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;
import com.autoEx.qa.Pages.RegisterPage;

public class RegisterPageTest extends TestBase {
	RegisterPage pg;

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void StartSeturp() {
		setUp();
		pg = new RegisterPage();
		// Initialzing page Object and call the initElements()
	}
	@AfterMethod
	public void tearDoun1()
	{
		tearDoun();
	}

	/*
	 * 1. Launch browser 2.Navigate to url 'http://automationexercise.com' SetUp():
	 * Before class will exicute
	 */
	// 3. Verify that home page is visible successfully
	@Test(priority = 1)
	public void homePageVisibleTest() {
		boolean res = pg.homePageVisible();
		Assert.assertEquals(res, true, "Home page is not visible");
		System.out.println("Home page is visibled");

	}

	// 4. Click on 'Signup / Login' link
	@Test(priority = 2)
	public void clickOnSignOrLoginLink() throws Exception {
		boolean clicked = pg.clickOnSignInLink();
		Assert.assertEquals(clicked, true, "Not clicked on Sign In link");
		System.out.println("clicked on singin link");
	}

	// 5. Verify 'New User Signup!' is visible
	@Test(priority = 3)
	public void visibleSignUpYourAccountTextTest() throws InterruptedException {
		String Expected_text = "New User Signup!";
		Assert.assertEquals(pg.visibleSignUpYourAccountText(), Expected_text, "New User Signin is not visibled");
		System.out.println("New User Signup!' is visible");
	}

	// 6. Enter name and email address and click on sighn in button for signup
	@Test(priority = 4)
	public void signUp() {
		pg.signUp();
		// Assert.assertEquals(true, true,"Not clicked on sign in buttion");
		System.out.println(" Signed Up and clicked on sign in button");
	}
	
	// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible 
	@Test(priority = 5)
	public void visibleEnterAccountInformationTextTest() throws Exception {
		String text = pg.visibleEnterAccountInformationText();
		Assert.assertEquals(text, "ENTER ACCOUNT INFORMATION", "Enter Account Information is not visibled");
		System.out.println("Enter Account Information is visibled");
	}

//	  9. Fill details: Title, Name, Email, Password, Date of birth
	@Test(priority = 6)
	public void enterDetailsTest() {
	pg.enterAccountDetails();
	}
	//10 click on create account btn
	@Test(priority = 7)
	public void clickOnCreateAccountBTNTest() {
		pg.clickOnCreateAccountBtn();
	}
	
	// 11 Verify that 'ACCOUNT CREATED!' is visible
	@Test(priority = 8)
	public void visibleAccounCreatedTest(){
		String text=pg.visibleAccounCreated();
		Assert.assertEquals(text, "ACCOUNT CREATED!","Not visible ACCOUNT CREATED!");
		System.out.println(text);
	}
	//12. Click 'Continue' button after account craeted
	@Test(priority = 9)
	public void clickOnContinueBtnTest() throws InterruptedException
	{
		pg.clickOnContinueBtn();
		System.out.println("click on continue");

	}
	
	//13. Verify that 'Logged in as username' is visible
	@Test(priority = 10)
	public void visibleLoggedInAsUsernameTest() throws InterruptedException
	{	String ExpectedMsg="Logged in as "+OrProp.getProperty("name");
		String ActualMsg=pg.visibleLoggedInAsUsername();
		Assert.assertEquals(ActualMsg, ExpectedMsg,"'Logged in as username' is not visible");
		System.out.println(ExpectedMsg);
	
	}
	//14.. Click 'Delete Account' link
	
	//@Test(priority = 11)
	public void clickOnDeleteAccountLinkTest() throws InterruptedException
	{
		pg.clickOnDeleteAccountLink();
		//Assert.assertEquals(value, true,"Not clicked on delete account link");
		//System.out.println("Clicked on Delete Account Link");
	
		
	}
	//15 . Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button	  
		//@Test(priority = 12)
		public void visibledAccountDeletedTest()
		{
			String AcutalMsg=pg.visibledAccountDeleted();
			Assert.assertEquals(AcutalMsg, "ACCOUNT DELETED!","Not visibled ACCOUNT DELETED!");
			System.out.println(AcutalMsg);
		}
	
	
	
	
}