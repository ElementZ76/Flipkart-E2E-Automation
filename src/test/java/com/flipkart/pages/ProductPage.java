package com.flipkart.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class ProductPage extends TestBase {
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Cart'] | //a[normalize-space()='Cart']")
    WebElement cartBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		
		String childWindowHandle = driver.getWindowHandle();
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
