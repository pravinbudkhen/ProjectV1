package com.autoEx.qa.TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;


public class TC6_ContactUs_form extends TestBase{

	@Test
	//@Parameters({"link"})
	public void contactUs_form(String link) throws InterruptedException, IOException {
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Verify that home page is visible successfully
		 */
		//loadConfigFile();
		
		
		//4. Click on 'Contact Us' button
		driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li[8]/a")).click();
		String Actualvisible_getintouch="GET IN TOUCH";
		String Expectedvisible_getintouch=driver.findElement(By.xpath("//div[@class='contact-form']/h2")).getText();
		Assert.assertEquals(Actualvisible_getintouch, Expectedvisible_getintouch,"Get In Touch is not Visible...");
		System.out.println(Actualvisible_getintouch);
		
		/*
		6. Enter name, email, subject and message
		7. Upload file
		*/
		driver.findElement(By.name("name")).sendKeys(OrProp.getProperty("name"));
		driver.findElement(By.name("email")).sendKeys(OrProp.getProperty("email"));
		driver.findElement(By.name("subject")).sendKeys("I am Happy with your asssigments....");
		driver.findElement(By.id("message")).sendKeys("very good assignment it will help to each ather studeent .best selenium work here....");
		Thread.sleep(2000);
		driver.findElement(By.name("upload_file")).sendKeys("C:\\Users\\Admin\\Desktop\\2023\\Pravin\\LOAN\\101.jpeg");
		
		//8. Click 'Submit' button
		driver.findElement(By.xpath("//form[@name='contact-form']/div[6]/input")).click();
		
		//9. Click OK button
		driver.switchTo().alert().accept();

		//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		String Actual_SuccessMsg="Success! Your details have been submitted successfully.";
		String Expected_SucccessMsg=driver.findElement(By.xpath("//div[@class='contact-form']/div[2]")).getText();
		Assert.assertEquals(Actual_SuccessMsg, Expected_SucccessMsg,"Your details have not been submitted successfull");
		System.out.println(Actual_SuccessMsg);
		
		//11. Click 'Home' button and verify that landed to home page successfully
		driver.findElement(By.xpath("//div[@class='contact-form']/div[3]/a")).click();
		String Actual_HomeUrl="https://automationexercise.com/";
		String Expected_HomeUrl=driver.getCurrentUrl();
		Assert.assertEquals(Actual_HomeUrl, Expected_HomeUrl,"Not naviagated to Home Page after Contact Us successfully..");
		System.out.println("Landed on Home Page....");
		
		
	
	}
}
