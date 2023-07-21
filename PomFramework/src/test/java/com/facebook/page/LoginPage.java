package com.facebook.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.facebook.common.ObjectLocatorRepository;
import com.facebook.common.Webdriverbaseclass;

public class LoginPage extends Webdriverbaseclass implements ObjectLocatorRepository {

	WebDriver driver = null;
	WebDriverWait wait = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void filllogin(String email, String password) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginpage_email)));
		driver.findElement(By.xpath(loginpage_email)).sendKeys(email);
		driver.findElement(By.xpath(Loginpage_password)).sendKeys(password);
		driver.findElement(By.xpath(Loginpage_loginbtn)).click();

	}
}
