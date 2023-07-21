package com.facebook.common;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverbaseclass implements ObjectLocatorRepository {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	public WebDriver launchbrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		driver.get(Loginpage_url);

		return driver;
	}

	public WebDriverWait waitfor(int time, String xpthloactor) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpthloactor)));

		return wait;
	}
}
