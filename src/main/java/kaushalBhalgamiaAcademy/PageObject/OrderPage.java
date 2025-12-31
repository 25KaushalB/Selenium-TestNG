package kaushalBhalgamiaAcademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutbutton;

	//@FindBy(css = ".ng-star-inserted")
	//WebElement yourOrderPage;
	By yourOrderPage = By.cssSelector("td:nth-child(3)");
	
	@FindBy(css = "td:nth-child(3)")
	List<WebElement> productsName;

	@FindBy(xpath = "//button[contains(text(),' ORDERS')]")
	WebElement orderButton;
	
	public boolean verifyOrderDisplay(String requiredProduct) {
		waitForElementToAppear(yourOrderPage);
		boolean match = productsName.stream().anyMatch(product ->product.getText().equalsIgnoreCase(requiredProduct));
		return match;
	}
	


}
