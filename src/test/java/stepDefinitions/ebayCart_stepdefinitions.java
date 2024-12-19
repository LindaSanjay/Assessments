package stepDefinitions;

import java.io.IOException;

import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ebayCart_page;

public class ebayCart_stepdefinitions extends BaseClass {

	
	@Given("^User launches the browser$")
	public void user_launches_browser() throws IOException {
		setUp();
		ebayPage = new ebayCart_page(ldriver);
	}
	
	
	@Given("^Navigates to the ebay website$")
	public void navigate_to_ebay() throws IOException {
		launchApplication();
	}

	@Given("^user verifies eBay homepage is displayed$")
	public void verify_homepage() throws IOException {
		ebayPage.verifyHomePage();
	}

	// Scenario steps
	@And("^user enters the keyword \"([^\"]*)\" in Search box$")
	public void user_enters_input(String text) throws IOException {
		ebayPage.searchFortext(text);
	}

	@And("^clicks on search button$")
	public void click_search() throws IOException {
		ebayPage.clickSearch();
	}

	@And("^clicks on the \"([^\"]*)\" displayed book$")
	public void click_fisrt_displayed_book(int num) throws IOException {
		ebayPage.clickResults(num);
	}

	@When("^user clicks on add to cart in Item listing page$")
	public void add_to_cart() throws IOException {
		ebayPage.clickAddtoCart();
	}

	@Then("^verify the number of items is displayed in cart is \"([^\"]*)\"$")
	public void verify_cart(String num) throws IOException {
		ebayPage.verifyCartItems(num);
	}

	@And("^Logout from application$")
	public void close_browsera() throws IOException {
		closeBrowser();
	}

}
