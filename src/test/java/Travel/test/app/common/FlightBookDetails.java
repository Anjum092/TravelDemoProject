package Travel.test.app.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Travel.test.config.utils.TestDataGenerator;

public class FlightBookDetails {

	TestDataGenerator proUtil=new TestDataGenerator();
	
	/**
	* Method: FlightBookingDetails
	* Description: This method is used to enter all Flight Booking Details 
	**/
	public void FlightBookingDetails(WebDriver driver,String userName,String address, String city, String state, String zipcode) throws FileNotFoundException, IOException, InterruptedException
	{
		proUtil.load(new FileInputStream(new File("src/test/java/data.properties")));
		
		//NOTE : Add explicit wait just to enter data slowly 
		
		driver.findElement(By.id("inputName")).clear();
		driver.findElement(By.id("inputName")).sendKeys(userName);
		Thread.sleep(2000);
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys(address);
		Thread.sleep(2000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(city);
		Thread.sleep(2000);
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys(state);
		Thread.sleep(2000);
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(zipcode);
		Thread.sleep(2000);		
	}
	
	public void selectFromPort(WebDriver driver,String depCity) {
		Select depcountry = new Select(driver.findElement(By.name("fromPort")));
		//depcountry.selectByVisibleText(depCity); 
		depcountry.selectByIndex(2);
	}
	
	public void selectToPort(WebDriver driver,String desCity) {
		Select desCounty = new Select(driver.findElement(By.name("toPort")));
		//desCounty.selectByVisibleText(desCity); 
		desCounty.selectByIndex(2);
	}
	
	public void selectCardDetails(WebDriver driver, String cartType, String CardNo, String Month, String Year, String CardName) throws InterruptedException {
		
		Select CardType = new Select(driver.findElement(By.name("cardType")));
		 //CardType.selectByVisibleText("Visa"); 
		 CardType.selectByIndex(2);
		 
		//NOTE : Add explicit wait just to enter data slowly 
		 
		Thread.sleep(2000);
		driver.findElement(By.id("creditCardNumber")).clear();
		driver.findElement(By.id("creditCardNumber")).sendKeys(CardNo);
		//driver.findElement(By.id("creditCardNumber")).sendKeys(TestDataGenerator.createRandomInteger());
		Thread.sleep(2000);
		driver.findElement(By.id("creditCardMonth")).clear();
		driver.findElement(By.id("creditCardMonth")).sendKeys(Month);
		Thread.sleep(2000);
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys(Year);
		Thread.sleep(2000);
		driver.findElement(By.id("nameOnCard")).clear();
		driver.findElement(By.id("nameOnCard")).sendKeys(CardName);
	}
	
	public void submitButton(WebDriver driver) {
		WebElement submit = driver.findElement(By.xpath("//form[@action='reserve.php']/div/input"));
		submit.click();
		
	}
	
	public void chooseFlight(WebDriver driver) {
	WebElement ChooseFlight = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input"));
	ChooseFlight.click();
	}
	
	public void PurchageFlightTicket(WebDriver driver) throws InterruptedException {
	Thread.sleep(10000);
	WebElement PurchaseFlight = driver.findElement(By.xpath("//div/input[@class='btn btn-primary']"));
	
	PurchaseFlight.click();
	}
	
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
}
