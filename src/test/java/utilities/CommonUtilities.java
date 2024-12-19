package utilities;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonUtilities {

	WebDriver ldriver;

	public CommonUtilities(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// wait for particular element to be visible
	public void waitForElementtobeVisble(WebElement element, long timeOutInSecs, String nameofElement) {
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, timeOutInSecs);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			ldriver.quit();
			Assert.fail("Element:" + element + " is not displayed even after waiting for : " + timeOutInSecs + "");
		}
	}

	// click
	public void click(WebElement element, String nameofElement) {
		try {
			if (element.isDisplayed()) {
				element.click();
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} catch (AssertionError e) {
			ldriver.quit();
			Assert.fail("Unable to click on: " +nameofElement+ "");
		} catch (Exception e) {
			ldriver.quit();
			Assert.fail("Unable to click on: " +nameofElement+ " due to :" +e);

		}
	}
	
	// enter data
		public void enterText(WebElement element, String text, String nameofElement) {
			try {
				if (element.isDisplayed()) {
					element.sendKeys(text);
					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			} catch (AssertionError e) {
				ldriver.quit();
				Assert.fail("Unable to enter data: "+text+ " in: " +nameofElement+ "");
			} catch (Exception e) {
				ldriver.quit();
				Assert.fail("Unable to enter data in: " +nameofElement+" due to :" +e);

			}
		}
		
		//verify display
		
		public void verifyDisplay(WebElement element, String nameofElement) {
			try {
				if (element.isDisplayed()) {
					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			} catch (AssertionError e) {
				ldriver.quit();
				Assert.fail("Element : " +nameofElement+ " is not displayed as expected");
			} catch (Exception e) {
				ldriver.quit();
				Assert.fail("Unable to verify element: " +nameofElement+ " displayed due to :" +e);

			}
		}
		

		// click list
		public void clickElementinList(List<WebElement> element, String nameofElement, int i) {
			try {
				waitForElementtobeVisble(element.get(i), 15, "Search Results");
				if (element.get(i).isDisplayed()){
					element.get(i).click();
					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			} catch (AssertionError e) {
				ldriver.quit();
				Assert.fail("Unable to click on: " +nameofElement+ "");
			} catch (Exception e) {
				ldriver.quit();
				Assert.fail("Unable to click on: " +nameofElement+ " due to :" +e);

			}
		}
		



}