package com.flipkart.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class ProductPage extends TestBase {
	@FindBy(xpath = "//div[contains(@style,'height: 44px') and contains(@style,'width: 44px') and contains(@style,'z-index: 2') and contains(@style,'rgb(214, 214, 214)')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//span[normalize-space()='Cart'] | //a[normalize-space()='Cart']")
    WebElement cartBtn;


	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void addToCart() {

		String childWindowHandle = driver.getWindowHandle();
		waitForVisibility(addToCartBtn);
		waitForClickability(addToCartBtn);
		clickOn(addToCartBtn);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		driver.close();
		Set <String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if(!h.equals(childWindowHandle)) {
				driver.switchTo().window(h);
			}
		}

	}

	public CartPage goingToCart() {
		waitForClickability(cartBtn);
		cartBtn.click();
		return new CartPage();
	}
}
