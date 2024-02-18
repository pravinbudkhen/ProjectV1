package com.autoEx.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.autoEx.qa.Base.TestBase;

public class RegisterPage extends TestBase {

	// Page Factory --Object repository

	@FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[4]/a")
	WebElement clickOnSignInLink;

	@FindBy(xpath = "//div[@class='signup-form']/h2")
	WebElement visibledSignInYourAccountText;

	@FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[1]/a")
	WebElement homePageVisibleText;

	@FindBy(xpath = "//div[@class='signup-form']/form/input[2]")
	WebElement name1;

	@FindBy(xpath = "//div[@class='signup-form']/form/input[3]")
	WebElement email1;

	@FindBy(xpath = "//div[@class='login-form']/h2/b")
	WebElement enterAccountInformationVisibleText;

	@FindBy(xpath = "//div[@class='signup-form']/form/button")
	WebElement clickOnSignUpButton;

	@FindBy(xpath = "//div[@class='radio-inline'][1]")
	WebElement maleRadio;

	@FindBy(xpath = "//div[@class='login-form']/form/div[4]/input")
	WebElement password;

	@FindBy(xpath = "//div[@id='uniform-newsletter']/span/input")
	WebElement firstCheckBox;

	@FindBy(xpath = "//div[@id='uniform-optin']/span/input")
	WebElement secondCheckBox;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "zipcode")
	WebElement zipcode;
	@FindBy(id = "mobile_number")
	WebElement mobileNumber;

	@FindBy(xpath = "//div[@class='login-form']/form/button")
	WebElement clickOncreateAccountButton;

	@FindBy(xpath = "//section[@id='form']/div/div/div/h2/b")
	WebElement visibledAccountCreatedtext;

	@FindBy(xpath = "//div[@class='pull-right']/a")
	WebElement clickOnContuneButton;

	@FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[10]/a")
	WebElement visibledLoginAsUsernameMsg;

	@FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[5]/a")
	WebElement clickOnDeleteAccountLink1;

	@FindBy(xpath = "//section[@id='form']/div/div/div/h2/b")
	WebElement visibledAccountDeleteText;

	@FindBy(xpath = " //div[@class='pull-right']/a")
	WebElement clickOnContune_Button_AfterDeleteAccount;

	// Initialzing page Object
	// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean homePageVisible() {
		Assert.assertTrue(homePageVisibleText.isEnabled());
		return true;

	}

	public boolean clickOnSignInLink() throws Exception {
		clickOnSignInLink.click();
		return clickOnSignInLink.isEnabled();
	}

	public String visibleSignUpYourAccountText() {
		// new WebDriverWait(driver,
		// Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(visibledSignInYourAccountText));
		String Actual_text = visibledSignInYourAccountText.getText();
		return Actual_text;
	}

	public void signUp() {
		name1.sendKeys(OrProp.getProperty("name"));
		email1.sendKeys(OrProp.getProperty("email"));
		clickOnSignUpButton.click();
	}

	public String visibleEnterAccountInformationText() {
		String Actual_text = enterAccountInformationVisibleText.getText();
		return Actual_text;
	}

	public void enterAccountDetails() {
		// name1.sendKeys(OrProp.getProperty("name"));
		// email1.sendKeys(OrProp.getProperty("email"));
		maleRadio.click();

		password.sendKeys(OrProp.getProperty("password"));
		firstCheckBox.click();
		secondCheckBox.click();
		firstname.sendKeys(OrProp.getProperty("first_name"));
		lastname.sendKeys(OrProp.getProperty("last_name"));
		company.sendKeys(OrProp.getProperty("company"));
		address1.sendKeys(OrProp.getProperty("address1"));
		address2.sendKeys(OrProp.getProperty("address2"));
		state.sendKeys(OrProp.getProperty("state"));

		city.sendKeys(OrProp.getProperty("city"));
		zipcode.sendKeys(OrProp.getProperty("zip_code"));
		mobileNumber.sendKeys(OrProp.getProperty("mobile_number"));

	}

	public void clickOnCreateAccountBtn() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(clickOncreateAccountButton));

		clickOncreateAccountButton.click();
	}

	public String visibleAccounCreated() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(visibledAccountCreatedtext));

		String Actual_text = visibledAccountCreatedtext.getText();
		return Actual_text;
	}

	public void clickOnContinueBtn() {
		clickOnContuneButton.click();
	}

	public String visibleLoggedInAsUsername() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(visibledLoginAsUsernameMsg));
		String text = visibledLoginAsUsernameMsg.getText();
		return text;
	}

	public void clickOnDeleteAccountLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(clickOnDeleteAccountLink1));
		clickOnDeleteAccountLink1.click();
		// return clickOnDeleteButton.isEnabled();
	}

	public String visibledAccountDeleted() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(visibledAccountDeleteText));
		String msg = visibledAccountDeleteText.getText();
		return msg;
	}

}
