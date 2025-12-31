package kaushalBhalgamiaAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kaushalBhalgamiaAcademy.PageObject.ConfirmationScreen;
import kaushalBhalgamiaAcademy.PageObject.LandingPage;
import kaushalBhalgamiaAcademy.PageObject.MyCart;
import kaushalBhalgamiaAcademy.PageObject.PaymentScreen;
import kaushalBhalgamiaAcademy.PageObject.ProductCatelogue;
import kaushalBhalgamiaAcademy.TestComponents.BaseTest;

public class StepDefinitionImplementation extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatelogue productCatelogue;
	public MyCart myCart;
	public PaymentScreen paymentScreen;
	public ConfirmationScreen confirmationScreen;
	
	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatelogue = landingPage.loginApplication(username,password);
	}
	
	@When ("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String requiredProduct) throws InterruptedException{
		List<WebElement> products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(requiredProduct);
		
	}
	
	@And ("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String requiredProduct) {
		MyCart myCart = productCatelogue.goToCartPage();
		Boolean match = myCart.verifyProductDisplay(requiredProduct);
		Assert.assertTrue(match);
		PaymentScreen paymentScreen = myCart.proceedToCheckout();
		paymentScreen.insertCountryName("India");
		confirmationScreen = paymentScreen.placeOrder();
	}
	
	@Then ("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
		String CM = confirmationScreen.getConfirmationMessage();
		Assert.assertTrue(CM.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then ("{string} error message is displayed.")
	public void error_message_is_displayed(String string) {
		Assert.assertEquals(landingPage.getErrorMessage(), string);
		driver.close();
	}
}
