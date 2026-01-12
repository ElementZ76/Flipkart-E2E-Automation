package com.flipkart.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	
	//1. constructor: load the file
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//2. setup browser
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		switch(browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("put correct browser name!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForClickability(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void clickOn(WebElement element) {
		int attempts = 0;
		while(attempts<3) {
			try {
				waitForClickability(element);
				element.click();
				break;
			} catch(StaleElementReferenceException e) {
				attempts++;
				System.out.println("element was stale. retrying....");
			} catch(Exception e) {
				System.out.println("element was stale. max attempts reachced.");
				throw e;
			}
		}
	}
	
	public static void enterText(WebElement element, String text) {
		int attempts = 0;
		while (attempts<3) {
			try {
				waitForVisibility(element);
				element.click();
	            element.sendKeys(Keys.CONTROL + "a");
	            element.sendKeys(Keys.BACK_SPACE);
	            element.sendKeys(text);
	            break;
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("element stale while typing. retrying....");
			} catch (Exception e) {
				System.out.println("stale element. max attempts breached.");
				throw e;
			}
		}
	}
	
	//3. close browser
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
