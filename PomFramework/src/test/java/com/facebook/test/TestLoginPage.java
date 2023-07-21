package com.facebook.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.facebook.common.Webdriverbaseclass;
import com.facebook.page.LoginPage;

public class TestLoginPage extends Webdriverbaseclass {

	WebDriver driver = null;
	LoginPage loginPage = null;

	@Parameters("browser")
	@BeforeClass
	public void beforeclass(@Optional("edge") String browser) {
		driver = launchbrowser(browser);
		loginPage = new LoginPage(driver);
	}

	@BeforeMethod
	public void beforemethod() {
		driver.get(Loginpage_url);
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws InterruptedException {
		Thread.sleep(2000);
		
		// take screenshot if test fail
		if (ITestResult.FAILURE == result.getStatus()) {
			File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(ss, new File("./screenshots/" + result.getName() + ".png"));
				System.out.println("Screenshot taken");
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot" + e.getMessage());
				e.printStackTrace();
			}

		}

	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

	@Test(priority = 1, groups = { "smoke", "sanity" })
	public void validcreadlogin() {
		loginPage.filllogin("akash@gmail.com", "12345");

	}

	@Test(priority = 2, groups = { "smoke", "sanity" })
	public void invalidcreadlogin() {
		loginPage.filllogin("akash", "as");

	}

	@Test(priority = 3, groups = { "regression" })
	public void loginempty() throws Exception {
		loginPage.filllogin(" ", " ");

		Assert.assertEquals("name", "ram");
//		throw new Exception("retry");

	}

}
