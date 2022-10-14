Feature: Automated End2End Tests
Description: The purpose of this feature is to test End 2 End integration.
 
Scenario Outline: Customer place an order by purchasing an item from search	
	Given user is on Home Page
	When he search for "dress"
	Then verify the order details
Examples:
	|customer|
	|Lakshay|