package com.autoEx.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;


import io.github.bonigarcia.wdm.WebDriverManager;

public class  TC2_Login_with_correct_Email_Pass extends TestBase{

	@Test(dataProvider = "testdata")
	
  public void Login_with_correct_Email_Pass(String email,String password) throws InterruptedException, IOException {
  		 
	  /*
	  1. Launch browser
	  2. Navigate to url 'http://automationexercise.com'
	  3. Verify that home page is visible successfully
  		*/
		 //setupLounch();

	  //4. Click on 'Signup / Login' button
		  clickOn_SignInLink();
	  //5. Verify 'Login to your account' is visible
		visible_LoginTo_YourAccount();
		
		
		//6. Enter correct email address and password  
		//7. Click 'login' button
			//login();
			loginWithhDataProvider(email, password);
	
		
		//8. Verify that 'Logged in as username' is visible	
			
			//visble_Logged_in_as_Username();
			
		//9. Click 'Delete Account' button
	
		
	 //	  10. Verify that 'ACCOUNT DELETED!' is visible
			/*
			String Expacted_Delete_Msg="ACCOUNT DELETED!";
			String Actual_Delete_msg=driver.findElement(By.xpath("//section[@id='form']/div/div/div/h2/b")).getText();
			Assert.assertEquals(Actual_Delete_msg, Expacted_Delete_Msg);
			System.out.println("Account is deleted successfully..........");
			*/
  
  }
	@DataProvider(name="testdata")
	public  Object[][] testdata(){
		return new Object[][]
				{
					{"pravin12@gmail.com","pappu1123"},
					{"pravin123@gmail.com","pappu112345"},
					{"pravin1345@gmail.com","pappu1123456"},
					{"pp125@gmail.com","pappu21"},
				
					
				};
		
	}
	
}
