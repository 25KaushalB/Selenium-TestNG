package kaushalBhalgamiaAcademy.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import kaushalBhalgamiaAcademy.PageObject.ConfirmationScreen;
import kaushalBhalgamiaAcademy.PageObject.LandingPage;
import kaushalBhalgamiaAcademy.PageObject.MyCart;
import kaushalBhalgamiaAcademy.PageObject.OrderPage;
import kaushalBhalgamiaAcademy.PageObject.PaymentScreen;
import kaushalBhalgamiaAcademy.PageObject.ProductCatelogue;
import kaushalBhalgamiaAcademy.TestComponents.BaseTest;

public class standAloneTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "purchases", "smoke" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String countryName = "India";

		ProductCatelogue productCatelogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		// Selecting Product
		List<WebElement> products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(input.get("requiredProduct"));
		MyCart myCart = productCatelogue.goToCartPage();

		// Navigating Cart Screen
		Boolean match = myCart.verifyProductDisplay(input.get("requiredProduct"));
		Assert.assertTrue(match);
		PaymentScreen paymentScreen = myCart.proceedToCheckout();

		// Navigating to Payment Screen
		paymentScreen.insertCountryName(countryName);
		ConfirmationScreen confirmationScreen = paymentScreen.placeOrder();

		// Navigation on Confirmation Screen.
		String CM = confirmationScreen.getConfirmationMessage();
		Assert.assertTrue(CM.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		confirmationScreen.getOrderID();
	}

	@Test(dataProvider = "getData", dependsOnMethods = { "submitOrder" })
	public void verifyOrderPlaced(HashMap<String, String> input) {
		ProductCatelogue productCatelogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		OrderPage orderPage = productCatelogue.goToOrderPage();
		orderPage.verifyOrderDisplay(input.get("requiredProduct"));
		Assert.assertTrue(true);
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDatatoMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\kaushalBhalgamiaAcademy\\Data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	/*
	 * public Object[] getData() { return new Object[][]
	 * {{"kaushal@yopmail.com","Abcd@12345","ZARA COAT 3"},{"hemali@yopmail.com",
	 * "Abcd@12345","IPHONE 13 PRO"}}; }
	 * 
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "kaushal@yopmail.com"); map.put("password", "Abcd@12345");
	 * map.put("requiredProduct", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "hemali@yopmail.com"); map1.put("password", "Abcd@12345");
	 * map1.put("requiredProduct", "IPHONE 13 PRO");
	 */

}
