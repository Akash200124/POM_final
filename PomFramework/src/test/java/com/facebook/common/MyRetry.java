package com.facebook.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

	int counter = 0;
	int maxtry = 3;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		if (counter < maxtry) {
			counter++;
			return true;
		}

		return false;
	}

}
