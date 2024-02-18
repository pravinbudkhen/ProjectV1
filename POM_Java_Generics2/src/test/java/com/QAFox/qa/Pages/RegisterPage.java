package com.QAFox.qa.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.QAFox.qa.Base.BasePage;

public class RegisterPage extends BasePage {

	public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	// locators of Landing page
	
	private By MyAccountLink = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	private By RegisterLink = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a");
	
	// locators of Register page

	private By registerPageHeaderElement = By.xpath("//*[@id=\"content\"]/h1");

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmp_ass = By.id("input-confirm");
	private By YesRadio = By.cssSelector(" label.radio-inline input:first-child[value='1']");
	private By checked_newsletter = By.cssSelector("div.pull-right input[name='agree']");
	private By btnContinue = By.cssSelector("div.pull-right input[type='submit']");

	

	/**
	 * @return the myAccount_Drop
	 */
	public WebElement getMyAccountLink() {
		return getElement(MyAccountLink);
	}

	/**
	 * @return the register_DropDounOption
	 */
	public WebElement getRegisterLink() {
		return getElement(RegisterLink);
	}

	/**
	 * @return the firstname
	 */
	public WebElement getFirstname() {
		return getElement(firstname);
	}

	/**
	 * @return the lastname
	 */
	public WebElement getLastname() {
		return getElement(lastname);
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return getElement(email);
	}

	/**
	 * @return the telephone
	 */
	public WebElement getTelephone() {
		return getElement(telephone);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the confirmp_ass
	 */
	public WebElement getConfirmp_ass() {
		return getElement(confirmp_ass);
	}

	/**
	 * @return the yesRadio
	 */
	public WebElement getYesRadio() {
		return getElement(YesRadio);
	}

	/**
	 * @return the checked_newsletter
	 */
	public WebElement getChecked_newsletter() {
		return getElement(checked_newsletter);
	}

	/**
	 * @return the btnContinue
	 */
	public WebElement getBtnContinue() {
		return getElement(btnContinue);
	}

	public WebElement getRegisterPageHeaderElement() {
		return getElement(registerPageHeaderElement);
	}

	// Actions of Register Page

	public void openRegisterPage() {
		clickOnMyAccountLink();
		clickOnRegisterLink();
	}

	public String getRegisterPageTitlle() {
	
		return driver.getTitle();
	}

	public String getRegisterPageHeader() {
		
		return getPageHeader(registerPageHeaderElement);
	}
	public void clickOnMyAccountLink() {
		doClickOn(MyAccountLink);
	}

	public void clickOnRegisterLink() {
		doClickOn(RegisterLink);
	}

	public SuccessPage doRegister(String firstname, String lastname, String email, String telephone, String password,
			String confirmp_ass)
	{
		openRegisterPage();
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getEmail().sendKeys(email);
		getTelephone().sendKeys(telephone);
		getPassword().sendKeys(password);
		getConfirmp_ass().sendKeys(confirmp_ass);
		getYesRadio().click();
		getChecked_newsletter().click();
		getBtnContinue().click();
		return getInstance(SuccessPage.class);
	}

}
