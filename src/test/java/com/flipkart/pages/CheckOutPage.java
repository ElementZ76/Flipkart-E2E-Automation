package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class CheckOutPage extends TestBase {
	@FindBy(xpath = "//span[text()='Login or Signup']")
	WebElement loginOrSignUpTitle;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkOutPageValidation() {
		try {
			return loginOrSignUpTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
