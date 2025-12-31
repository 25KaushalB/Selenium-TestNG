package kaushalBhalgamiaAcademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kaushalBhalgamiaAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// Initilazation
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators Creation : Instead of Writing this :
	// driver.findElement(By.Xpath("Abd")) we can write using PageFactory Concept.
	// as below.
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement UserPassword;

	@FindBy(id = "login")
	WebElement LoginButton;

	@FindBy(css = "[class*='flyInOut']")
	WebElement error;



	public ProductCatelogue loginApplication(String email, String Password) {
		userEmail.sendKeys(email);
		UserPassword.sendKeys(Password);
		LoginButton.click();
		ProductCatelogue productCatelogue = new ProductCatelogue(driver);
		return productCatelogue;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	// .ng-tns-c4-19.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	public String getErrorMessage() {
		waitForWebElementToAppear(error);
		return error.getText();
	}


}
