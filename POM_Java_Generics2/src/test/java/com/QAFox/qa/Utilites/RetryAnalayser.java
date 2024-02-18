package com.QAFox.qa.Utilites;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalayser implements IRetryAnalyzer {

	int counter=0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
		if(counter<retryCount) {
			counter++;
			return true;	
		}
		return false;
	}
	

}
