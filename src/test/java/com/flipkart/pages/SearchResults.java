package com.flipkart.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class SearchResults extends TestBase {
	//1. locators
	@FindBy(xpath = "(//div[@data-id])[1]//a")
    WebElement firstProduct;
	
	@FindBy(xpath = "//span[normalize-space()='Cart'] | //a[normalize-space()='Cart']")
    WebElement cartBtn;
	//2. constructor
	
	public SearchResults() {
		PageFactory.initElements(driver, this);
	}
	
	//3. methods
	public ProductPage clickFirstProduct() {
		String parentWindowHandle = driver.getWindowHandle();
		waitForClickability(firstProduct);
		firstProduct.click();
		
		//switching driver handle
		Set <String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if(!h.equals(parentWindowHandle)) {
				driver.switchTo().window(h);
			}
		}
		
		return new ProductPage();
	}
}
