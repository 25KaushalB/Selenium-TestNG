package kaushalBhalgamiaAcademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class ProductCatelogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatelogue(WebDriver driver) {
		// Initilazation

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators Creation : Instead of Writing this : driver.findElement(By.Xpath("Abd")) we can write using PageFactory Concept. as below.
	
	@FindBy(css = ".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-Of-Type");
	By ProductToastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String requiredProduct) {
		WebElement Prod = getProductList().stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equals(requiredProduct)).findFirst()
				.orElse(null);
		return Prod;
	}
	
	public void addProductToCart(String requiredProduct) {
		WebElement prod = getProductByName(requiredProduct);
		prod.findElement(addToCart).click();
		waitForElementToAppear(ProductToastMessage);
		waitForElementToDisappear(spinner);
	}
	

}
