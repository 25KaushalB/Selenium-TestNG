
@tag
	Feature: Purchase the order from the Ecomerce Website
	I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page
	
	@Regression
	Scenario Outline: Positive test of Submitting the order
	
		Given Logged in with username <username> and password <password>
		When I add product <requiredProduct> to cart
		And Checkout <requiredProduct> and submit the order
		Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
		
		Examples:
		| username				| password  | requiredProduct |
		| kaushal@yopmail.com | Abcd@12345 | ZARA COAT 3	   |
			