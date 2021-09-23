package Travel.test.config.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class TestDataGenerator extends java.util.Properties {

	public static long CreditCardNumber;

	/**
	 * Method Name: ChangeBrowser Description: Update the desired data properties
	 * file with auto generated dynamic value of browser.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void ChangeBrowser() throws FileNotFoundException, IOException, InterruptedException {
		TestDataGenerator proUtil = new TestDataGenerator();

		proUtil.load(new FileInputStream(new File("src/test/java/data.properties")));
		if (proUtil.getProperty("BROWSER").equalsIgnoreCase("firefox"))
			proUtil.setProperty("BROWSER", "chrome");
		else if (proUtil.getProperty("BROWSER").equalsIgnoreCase("chrome"))
			proUtil.setProperty("BROWSER", "chrome");
		proUtil.store(new FileOutputStream(new File("src/test/java/data.properties")), null);
	}
	
	/**
	 * Generate the random integer value.
	 * 
	 * @return
	 *         return the random int value.
	 */
	public static long createRandomCardNumber() {
		long aStart = 9980000000L;
		long aEnd = 9999999999L;
		Random aRandom = new Random();
		long range = aEnd - (long) aStart + 1;
		long fraction = (long) (range * aRandom.nextDouble());
		long randomNumber = fraction + (long) aStart;
		System.out.println(" : " + randomNumber);
		CreditCardNumber = randomNumber;
		return randomNumber;

	}
}
