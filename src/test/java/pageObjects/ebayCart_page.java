package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.CommonUtilities;

public class ebayCart_page {

	WebDriver ldriver;
	CommonUtilities utilities;

	public ebayCart_page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		utilities = new CommonUtilities(ldriver);
	}

	// Ebay HomePage objects

	@FindBy(xpath = "//*[@id='gh-logo']")
	WebElement ebayHomePage;

	@FindBy(xpath = "//*[@aria-label='Search for anything']")
	WebElement txtSearch;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement btnSearch;

	@FindBy(xpath = "//*[@id='srp-river-results']//li[contains(@id,'item')]")
	List<WebElement> listSearchResults;

	// Item Page Objects

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement btnAddCart;

	@FindBy(xpath = "//a[contains(@aria-label, 'Your shopping cart contains')]")
	WebElement iconCart;

	// ***Methods***//

	// verify home page displayed
	public void verifyHomePage() {
		utilities.verifyDisplay(ebayHomePage, "ebay Home Page");
	}

	// search for book
	public void searchFortext(String text) {
		utilities.enterText(txtSearch, text, "Search Text Box");
	}

	// click Search
	public void clickSearch() {
		utilities.click(btnSearch, "Search button");
	}

	// click on first book link
	public void clickResults(int num) {

		// get parnent tab
		String parentTab = ldriver.getWindowHandle();

		// click on the result
		utilities.waitForElementtobeVisble(listSearchResults.get(1),20,"Search Results");
		ldriver.findElement(By.xpath("(//*[@id='srp-river-results']//li[contains(@id,'item')]["+num+"]//a)[3]")).click();
		
		// switch tab
		Set<String> listofTabs = ldriver.getWindowHandles();
		Iterator<String> iterator = listofTabs.iterator();
		while (iterator.hasNext()) {
			String childTab = iterator.next();

			if (!parentTab.equals(childTab)) {
				ldriver.switchTo().window(childTab);
			}
		}
	}

	// add to cart
	public void clickAddtoCart() {
		utilities.click(btnAddCart, "Add to Cart");
	}
	
	//verify cart items
	public void verifyCartItems(String num) {
		try {
			String requiredText = iconCart.getText().toString();
			if(requiredText.contains(num)) {
				Assert.assertTrue(true);
			}
		}catch (AssertionError e) {
			ldriver.quit();
			Assert.fail("Number of items is not matching : " +num);
		}
	}
}
