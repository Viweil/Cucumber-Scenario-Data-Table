Feature: Submit a valid contact form 

Scenario: Submit form using valid data 
	Given I am on the zoo website 
	When I navigate to contact 
	And I submit the form with valid data 
		|Fields|Value|
		|Name|Jack Joe|
		|Address|Happy Land|
		|Postcode|1023|
		|Email|test@123.com|
	Then I check that the form has been submitted