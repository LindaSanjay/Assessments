#Author : Linda
# User story : Assessment
Feature: Verify Ebay Cart Functionality

Background:
	Given User launches the browser
	And Navigates to the ebay website
	And user verifies eBay homepage is displayed
	
#Scenario 1
@Smoke
Scenario: Verify user can search required book and add to cart
	And user enters the keyword "book" in Search box
	And clicks on search button
	And clicks on the "1" displayed book
	When user clicks on add to cart in Item listing page
	Then verify the number of items is displayed in cart is "1"
	And Logout from application