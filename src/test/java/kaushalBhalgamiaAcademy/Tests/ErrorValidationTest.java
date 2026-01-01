package kaushalBhalgamiaAcademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import kaushalBhalgamiaAcademy.PageObject.MyCart;
import kaushalBhalgamiaAcademy.PageObject.ProductCatelogue;
import kaushalBhalgamiaAcademy.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void loginInvalidPasswordValidation() throws IOException, InterruptedException {
		landingPage.loginApplication("kaushal@yopmail.com", "Abcd@123456");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}

	@Test(groups= {"ErrorHandling"})
	public void invalidProductValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String requiredProduct = "ZARA COAT 3";

		ProductCatelogue productCatelogue = landingPage.loginApplication("kaushal@yopmail.com", "Abcd@12345");

		// Selecting Product
		List<WebElement>products =productCatelogue.getProductList(); 
		productCatelogue.addProductToCart(requiredProduct);
		MyCart myCart = productCatelogue.goToCartPage();

		// Navigating Cart Screen to Verify Product.
		Boolean match = myCart.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
