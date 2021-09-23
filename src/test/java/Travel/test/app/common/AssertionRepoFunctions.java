package Travel.test.app.common;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Travel.test.config.utils.BaseTest;
import Travel.test.config.utils.TestDataGenerator;


/**
 * Class Name: AssertionRepoFunctions 
 * Description: This class is to have all assertion functions.
 **/

public class AssertionRepoFunctions extends BaseTest{
	
	TestDataGenerator dataGenerator=new TestDataGenerator();
	
	/**
     * Method Name: assertHomescreenDetails
     * Description: This method is to ensure Home is Active page.
	 * @throws InterruptedException 
     */
	public void assertHomescreenDetails() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='jumbotron']/div/h1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(2000);
		String WelcomeMessage = driver.findElement(By.xpath("//div[@class='jumbotron']/div/h1")).getText();
		String ExpectedMessage = "Welcome to the Simple Travel Agency!";
		Assert.assertEquals(ExpectedMessage, WelcomeMessage);
	}
	
		/**
	     * Method Name: assertRegistrtionDetails
	     * Description: This method is to ensure Flight Details screen is Active page.
		 * @throws InterruptedException 
	     */
		public void assertFlightDetails() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[2]/h3"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(2000);
		String FightDetailsScreenTitileMessage = driver.findElement(By.xpath("//div[2]/h3")).getText();
		String FlightDetailsTitle = "Flights from Boston to London:";
		Assert.assertEquals(FlightDetailsTitle, FightDetailsScreenTitileMessage);
		}
	
	/**
     * Method Name: assertRegistrtionDetails
     * Description: This method is to ensure Flight Confirmation screen is Active page.
	 * @throws InterruptedException 
     */
	public void assertRegistrtionDetails() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[2]/h2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(2000);
		String FightRegistrationDetails = driver.findElement(By.xpath("//div[2]/h2")).getText();
		String FlightRegDetailsTitle = "Your flight from TLV to SFO has been reserved.";
		Assert.assertEquals(FlightRegDetailsTitle, FightRegistrationDetails);
	}
	
	/**
     * Method Name: assertBookingConfirmation
     * Description: This is method is to ensure Booking Confirmations.
	 * @throws InterruptedException 
     */
	public void assertBookingConfirmation() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[2]/div/h1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(2000);
		String VerifySuccessMessage = driver.findElement(By.xpath("//div[2]/div/h1")).getText();
		String ExpectedTitle = "Thank you for your purchase today!";
		Assert.assertEquals(ExpectedTitle, VerifySuccessMessage);
		Thread.sleep(3000);
	}
	
	public void highlightWithColor(WebElement element) {
		
	}
	
	public void assertConfirmationID() {
		String verifyConfirmationID = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		if(verifyConfirmationID!=null)
			assertEquals(true, true);
		else 
			assertEquals(false, false);
		
		assertTrue(verifyConfirmationID.contains(verifyConfirmationID));
		assertFalse(verifyConfirmationID.isBlank());
	}
	
}

