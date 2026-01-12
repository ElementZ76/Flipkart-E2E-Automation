package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flipkart.base.TestBase;

public class CartPage extends TestBase {
	
    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    WebElement placeOrderBtn;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isPlaceOrderDisplayed() {
        try {
            return placeOrderBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public CheckOutPage placeOrder() {
    	waitForClickability(placeOrderBtn);
    	placeOrderBtn.click();
    	return new CheckOutPage();
    }
}