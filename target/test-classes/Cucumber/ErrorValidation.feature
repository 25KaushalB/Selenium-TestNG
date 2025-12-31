
@tag
	Feature: Error Validation of the Ecomerce Website
	I want to use this template for my feature file
	
	@ErrorValidation
	Scenario Outline: Negative test of Login Functionality
	
		Given I landed on Ecommerce Page
		When Logged in with username <username> and password <password>
		Then "Incorrect email or password." error message is displayed.
		
		Examples:
		| username				| password  |
		| kaushal@yopmail.com	| Abcd@1234 |
			