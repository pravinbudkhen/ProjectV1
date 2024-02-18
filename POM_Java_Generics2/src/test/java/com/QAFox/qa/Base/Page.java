package com.QAFox.qa.Base;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	 public  WebDriver driver;
	public WebDriverWait wait;

	public Page(WebDriver driver)
	{
		this.driver=driver;
	
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	}
	
	//abstract methods
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void  waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	
	//create a method with java Generics  and  return a new Page
	public <tPage extends BasePage>  tPage getInstance(Class<tPage> pageClass)
	{
		try {
			  return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch (Exception e)
		{
			e.getCause().printStackTrace();
		}
		return null;
	}

	
	
	
	
}
