Feature: Extract popular car models

Scenario: Select all the used cars popular models in chennai location
	Given user navigates to used cars page
	When user selects chennai location
	Then all the car models should be displayed