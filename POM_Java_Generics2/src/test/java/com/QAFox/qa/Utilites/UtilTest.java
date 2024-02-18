package com.QAFox.qa.Utilites;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QAFox.qa.Base.BaseTest;
import com.google.common.io.Files;

public class UtilTest extends BaseTest{
public static WebDriver driver;
public static String screenShotName;

	public UtilTest() {
		this.driver=driver;
	}
	public static void doSendKeys(WebDriver driver, WebElement element, String value, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void doClickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public static String doGetText(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		String ActualText = element.getText();
		return ActualText;
		}
	
public static void getScreenShot() throws IOException
{
	Date date=new Date();
	screenShotName=date.toString().replace(" ", "_").replace(":","_")+".png";
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShots\\"+"Error"+screenShotName);
	Files.copy(srcFile, destFile);
	
		
	
	
	}
	
	


}
