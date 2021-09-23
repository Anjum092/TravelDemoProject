package Travel.test.config.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public static WebDriver driver;
	public String baseUrl;
	public long sleepTime=500;
	public TestDataGenerator proUtil= new TestDataGenerator();

	static ExtentTest test;
	static ExtentReports report;
	
	/**
	 * Method Name: setUp
	 * Description: Initiate the respective browser which is set at
	 * "data.properties" file.
	 */
	
	@BeforeTest
	public void setUp() throws Exception {
		
		  proUtil.load(new FileInputStream(new File("src/test/java/data.properties")));
		  String Browser = proUtil.getProperty("BROWSER");
		
		  report = new ExtentReports(System.getProperty("TravelDemoProject/Reports")+"ExtentReportResults.html");
		  test = report.startTest("ExtentDemo");
		  
		if (Browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		
		else if (Browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "jar\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} 
		
		else
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	/**
	 * Method Name: tearDown
	 * Description: Quit the browser instance once the test case/test scenario
	 * has finished.
	 */
	@AfterTest
	public void tearDown() throws Exception {
	
		// Quit the initiated browser.
		driver.quit();
	}
}
