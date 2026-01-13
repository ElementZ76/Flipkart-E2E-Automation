package com.flipkart.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.flipkart.base.TestBase;
import com.flipkart.pages.CartPage;
import com.flipkart.pages.CheckOutPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.ProductPage;
import com.flipkart.pages.SearchResults;
import com.flipkart.utils.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSteps extends TestBase {
	//1. page objects initialization 
	HomePage homePage;
	SearchResults searchResults;
	ProductPage productPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	
	//2. methods 
	@Given("I launch the Flipkart application")
	public void i_launch_the_flipkart_application() {
		homePage = new HomePage();
		homePage.closePopup();
	}
	
	@When("I add products from excel {string} sheet {string}")
	public void i_add_products_from_excel_sheet(String fileName, String sheetName) throws IOException {
		
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
		List <Map<String, String>> excelData = ExcelReader.getData(filePath, sheetName);
		for(Map<String,String> row : excelData) {
			String product = row.get("Product name");
			System.out.println("fetching from excel: " + product);
			try {Thread.sleep(1500); } catch(InterruptedException e) {};
			homePage = new HomePage();
			searchResults = homePage.searchProduct(product);
			productPage = searchResults.clickFirstProduct();
			productPage.addToCart();
		}
//		List<String> productList = dataTable.asList();
//		for(String product : productList) {
//			homePage = new HomePage();
//			try { Thread.sleep(1500); } catch (InterruptedException e) {}
//			searchResults = homePage.searchProduct(product);
//			productPage = searchResults.clickFirstProduct();
//			productPage.addToCart();
//		}
		
	}
	
	@And("I go to the cart and proceed to checkout")
	public void i_go_to_the_cart_and_proceed_to_checkout() {
		cartPage = productPage.goingToCart();
		boolean isVisible = cartPage.isPlaceOrderDisplayed();
		Assert.assertEquals(isVisible, true);
	}
	
	@Then("I should be presented with the login or checkout options")
	public void i_should_be_presented_with_the_login_or_checkout_options() {
		checkoutPage = cartPage.placeOrder();
		boolean isVisible = checkoutPage.checkOutPageValidation();
		Assert.assertEquals(isVisible, true);
	}
}
