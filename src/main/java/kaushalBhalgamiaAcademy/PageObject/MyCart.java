package kaushalBhalgamiaAcademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class MyCart extends AbstractComponent {
	WebDriver driver;

	public MyCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(css = "div[class='cartSection'] h3")
	List<WebElement> cartItems;

	private @FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutbutton;
	

	
	public boolean verifyProductDisplay(String requiredProduct) {
		boolean match = cartItems.stream().anyMatch(item -> item.getText().equalsIgnoreCase(requiredProduct));
		return match;
	}
	
	public PaymentScreen proceedToCheckout() {
		checkOutbutton.click();
		PaymentScreen paymentScreen = new PaymentScreen(driver);
		return paymentScreen;
	}

}
