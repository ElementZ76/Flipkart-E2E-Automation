package com.flipkart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.flipkart.base.TestBase;

public class HomePage extends TestBase {
	//1. locators 
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[@role='button']")
	WebElement closePopupBtn;
	
	//2. constructor to initialize the driver object and pass it to webelements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//3. methods (functions)
	public void closePopup() {
		try {
			if(closePopupBtn.isDisplayed()) {
				closePopupBtn.click();
			}
		} catch (Exception e) {
			//dont do anything if u didnt find a popup
		}
	}
	
	public SearchResults searchProduct(String productName) {
		
		try {
			searchBox.clear();
		} catch (Exception e) {
			//dont do anything if its already clear
		}
		
		enterText(searchBox, productName);
		searchBox.sendKeys(Keys.ENTER);
		try { Thread.sleep(1500);} catch(Exception e) {};
		return new SearchResults();
	}
	
}
