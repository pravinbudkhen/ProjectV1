package com.autoEx.qa.Listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.autoEx.qa.Base.TestBase;
import com.autoEx.qa.Utilites.UtilTest;


public class ListenersDemo extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+ "this  test case has started...");
		Reporter.log("Test cas Stetus is "+result.getStatus());
	}
	public void onTestSuccess(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onTestSkipped(ITestResult result) {
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed - screen shot capture");
		try {
			UtilTest.getScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(result.getName()+ "this  test case has falied...");
		Reporter.log("this failed Test cas Stetus is "+result.getStatus());
		
	  }
}
