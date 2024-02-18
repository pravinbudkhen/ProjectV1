package com.autoEx.qa.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autoEx.qa.Base.TestBase;



public class TC7_VerifyAllProduct extends TestBase{
	@Test
	//@Parameters({"link"})
	public void verify_AllProduct_ProdDetails(String link) throws InterruptedException, IOException
	{
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Verify that home page is visible successfully
		 */

		//4. Click on 'Products' button
		//5. Verify user is navigated to ALL PRODUCTS page successfully
		driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		String ActualUrl="https://automationexercise.com/products";
		String ExpectedUrl=driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl," Not navigated to ALL PRODUCTS page successfully.");
		System.out.println("navigated to ALL PRODUCTS page successfully");
		
		//7. Click on 'View Product' of first product
		driver.findElement(By.xpath("//div[@class='features_items']/div[2]/div/div/ul/li/a")).click();
		Thread.sleep(2000);
		//8. User is landed to product detail page
		String Actual_title="Automation Exercise - All Products";
		String Expected_title=driver.getTitle();
		Assert.assertEquals(Actual_title, Expected_title,"User Is not landed on Product details page");
		System.out.println("User is landed to product detail page");
		
		//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		
		List<WebElement> details=driver.findElements(By.xpath("//div[@class='product-information']/p"));
		for(int i=0;i<details.size();i++)
		{
			System.out.println(details.get(i).getText());
		}
		
		
		
		
		
	}

}

