package com.amazone.login;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class Loginpage {
	WebDriver driver = null;
	WebDriverWait wait = null;

	@Test()
	public void run(String browser) {

	}

	@BeforeClass
	public void launchdriver() {

//		FirefoxOptions op = new FirefoxOptions();
//		op.addArguments("--remote-allow-origins=*");
//		WebDriverManager.firefoxdriver().setup();

//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "./Drivers/msedgedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");

		driver = new ChromeDriver();
//		driver = new EdgeDriver(); 
//		driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.in/");
		driver.get("https://tablepress.org/demo/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = false)
	public void singup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook" + Keys.ENTER);

	}

	@Test(priority = 2)
	public void singin() {

//		System.out.println(driver.getPageSource());
//		driver.getPageSource();
		// store the web element and use getAttribute() method

		// select
		Select sel = new Select(driver.findElement(By.xpath("webelement")));
		sel.selectByVisibleText("phyton");

		// pop up or altert

		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.getText();
		alert.dismiss();

		// iframe
		driver.switchTo().frame(1);

		// window handles
		driver.getWindowHandle();
		driver.switchTo().window("window address");

		// actions

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("webelement"))).build().perform();

	}

	@Test(timeOut = 2000)
	public void closewin() {
//		driver.quit();
	}

	public void testartifact() throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./driver/1"));
		
	}

}
