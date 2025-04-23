Feature: Extract all the bikes

Scenario: Extract all the upcoming bikes whose manufacturer is Honda and price of bikes is below 4 lakhs
	Given Navigate to the home page
	And Click on new bikes option
	And Click on advanced search option
	When Set filters of model and price
	Then all the bikes should be displayed 