package kaushalBhalgamiaAcademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class PaymentScreen extends AbstractComponent {

	WebDriver driver;

	public PaymentScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement insertCountryName;

	By countryList = By.cssSelector(".ta-results");

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement countryIndia;

	@FindBy(xpath = "//a[contains(text(),'Order')]")
	WebElement placeOrder;

	public void insertCountryName(String countryName) {
		Actions action = new Actions(driver);
		action.sendKeys(insertCountryName, countryName).build().perform();
		waitForElementToAppear(countryList);
		countryIndia.click();
	}

	public ConfirmationScreen placeOrder() {
		placeOrder.click();
		ConfirmationScreen confirmationScreen = new ConfirmationScreen(driver);
		return confirmationScreen;
	}
}
