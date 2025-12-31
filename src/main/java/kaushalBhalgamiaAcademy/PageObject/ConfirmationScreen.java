package kaushalBhalgamiaAcademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class ConfirmationScreen extends AbstractComponent {

	WebDriver driver;

	public ConfirmationScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By thanksMessage = By.cssSelector(".hero-primary");
	@FindBy(css=".hero-primary")
	WebElement ConfirmMessage;
	
	@FindBy(css = ".ng-star-inserted label[class='ng-star-inserted']")
	WebElement orderID;

	public String getConfirmationMessage() {
		waitForElementToAppear(thanksMessage);
		return ConfirmMessage.getText();
	}
	
	public void getOrderID() {
		System.out.println("Your OrderID is: " + orderID.getText().split(" ")[1]);

	}

}
