package com.autoEx.qa.Pages;

import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.webaudio.WebAudio;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autoEx.qa.Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[4]/a")
	WebElement clickOnSignInLink;

	@FindBy(xpath = "//div[@class='login-form']/h2")
	WebElement visibledLoginYourAccount_Text;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement Login_email;

	@FindBy(name = "password")
	WebElement Login_password;

	@FindBy(xpath = "//div[@class='login-form']/form/button")
	WebElement clickOn_LoginButton;

	@FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a")
	WebElement visibledLoginAsUserName_Text;

	WebDriverWait wait;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean clickOnSignInLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(clickOnSignInLink));
		clickOnSignInLink.click();
		return clickOnSignInLink.isEnabled();

	}

	public String visibledLoginYourAccountText() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(visibledLoginYourAccount_Text));
		String msg = visibledLoginYourAccount_Text.getText();
		return msg;

	}
	public void loginUser()
	{
		Login_email.sendKeys(OrProp.getProperty("email"));
		Login_password.sendKeys(OrProp.getProperty("password"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickOn_LoginButton));
		clickOn_LoginButton.click();
		
		
	}
	public String visibledLoginAsUserNameText()
	{		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(visibledLoginAsUserName_Text));
		String msg=visibledLoginAsUserName_Text.getText();
		return msg;
	}
}
