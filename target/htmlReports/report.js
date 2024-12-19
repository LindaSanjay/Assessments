$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/eBayCart.feature");
formatter.feature({
  "name": "Verify Ebay Cart Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User launches the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.user_launches_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigates to the ebay website",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.navigate_to_ebay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies eBay homepage is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.verify_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify user can search required book and add to cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "user enters the keyword \"book\" in Search box",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.user_enters_input(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on search button",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.click_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on the \"1\" displayed book",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.click_fisrt_displayed_book(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on add to cart in Item listing page",
  "keyword": "When "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.add_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the number of items is displayed in cart is \"1\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.verify_cart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logout from application",
  "keyword": "And "
});
formatter.match({
  "location": "ebayCart_stepdefinitions.close_browsera()"
});
formatter.result({
  "status": "passed"
});
});