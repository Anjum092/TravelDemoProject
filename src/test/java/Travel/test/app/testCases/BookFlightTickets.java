package Travel.test.app.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Travel.test.app.common.AssertionRepoFunctions;
import Travel.test.app.common.FlightBookDetails;
import Travel.test.config.utils.BaseTest;
import Travel.test.config.utils.DataServiceProperties;

public class BookFlightTickets extends BaseTest{
	
	AssertionRepoFunctions assertionFunction=new AssertionRepoFunctions();
	FlightBookDetails fbd = new FlightBookDetails();
	
	@Test
	public void BookFlightTicket() throws IOException, InterruptedException{
		
		driver.get(DataServiceProperties.APPURL);
		
		try{	
						
			//This method is to ensure Home is Active page when Login into Application.
			assertionFunction.assertHomescreenDetails();
			
			//Select From Port Details
			fbd.selectFromPort(driver,proUtil.getProperty("DIP_CITY"));
			
			//Select To Port Details
			fbd.selectToPort(driver,proUtil.getProperty("DES_CITY"));
			 
			//Submit button
			fbd.submitButton(driver);
						
			//This method is to ensure Home is Active page when Login into Application.
			assertionFunction.assertFlightDetails();
			
			Thread.sleep(5000);
			
			//This method is to ensure Home is Active page when Login into Application.
			fbd.chooseFlight(driver);
			
			//This method is to ensure Home is Active page when Login into Application.
			assertionFunction.assertRegistrtionDetails();
			
			//Add Flight Booking Details			
			fbd.FlightBookingDetails(driver, proUtil.getProperty("USER_NAME"), proUtil.getProperty("ADDRESS"), proUtil.getProperty("CITY"), proUtil.getProperty("STATE"),proUtil.getProperty("ZIP"));
			
			//Select Credit Card Details
			fbd.selectCardDetails(driver, proUtil.getProperty("CARD_TYPE"), proUtil.getProperty("CREDIT_CARD_NO"), proUtil.getProperty("MONTH"), proUtil.getProperty("YEAR"), proUtil.getProperty("NAMEONCARD"));
			
			//Scroll down
			fbd.scrollDown(driver);
			
			//Purchase Flight Ticket 
			fbd.PurchageFlightTicket(driver);
			
			Thread.sleep(5000);
	
			//This method is to ensure Home is Active page when Login into Application.
			assertionFunction.assertBookingConfirmation();
			
			//This method is to assert Confirmation ID
			assertionFunction.assertConfirmationID();
						
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
}
