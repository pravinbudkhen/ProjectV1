package com.QAFox.qa.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{
	 
	public BasePage(WebDriver driver) {
		super(driver);	
	}
	//Generic util methods

	public void doSendKeys(By locator,String text)
	{
		waitForElementPresent(locator);
		driver.findElement(locator).sendKeys(text);
	}
	
	public String doGetText(By locator)
	{	waitForElementPresent(locator);
		return driver.findElement(locator).getText();
	}


	public void doClickOn(By locator)
	{	waitForElementPresent(locator);
		driver.findElement(locator).click();
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		
		return getElement(locator).getText();
	}
	
	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			waitForElementPresent(locator);
			element=driver.findElement(locator);
		}
		catch(Exception e){
			System.out.println("SOME error occured while creating element :"+locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("SOME Exception occured while waiting for the element "+locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("SOME Exception occured while waiting for the element "+title.toString());
			e.printStackTrace();
		}		
	}

	
	
	
}
