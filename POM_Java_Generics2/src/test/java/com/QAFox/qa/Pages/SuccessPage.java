package com.QAFox.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QAFox.qa.Base.BasePage;

public class SuccessPage extends BasePage {


	public SuccessPage(WebDriver driver) {
		super(driver);

	
	}
	
	//locators of successPage
	
	public By sucessPageHeaderElement=By.cssSelector("div.col-sm-9 h1:first-child");
	/**
	 * @return the header
	 */
	public WebElement getsucessPageHeaderElement() {
		return getElement(sucessPageHeaderElement);
	}
	
	//Actions of Seccesss page
	
	
	@Override
	public String getPageTitle() {
		return super.getPageTitle();
	}
	 public String getSuccessPageHeader()
	 {
		return getPageHeader(sucessPageHeaderElement);
		 
	 }
	
	
}
