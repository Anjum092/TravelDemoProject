package Travel.test.config.utils;

import java.util.ResourceBundle;

public class DataServiceProperties {

	// PreConfiguration Properties.
	public static final String BROWSER;
	public static final String APPURL;
	
	// User Details Properties
	public static final String _DIP_CITY;
	public static final String _DES_CITY;
	public static final String _USER_NAME;
	public static final String _ADDRESS;
	public static final String _CITY;
	public static final String _STATE;
	public static final String _ZIP;
	
	//Credit Card Details
	public static final String _CARDTYPE;
	public static final String _CREDIT_CARD_NO;
	public static final String _MONTH;
	public static final String _YEAR;
	public static final String _NAMEONCARD;
	
	static {
		ResourceBundle rsbundle = ResourceBundle.getBundle("data");

		// GET Configuration Properties Values.
		BROWSER = rsbundle.getString("BROWSER");
		APPURL = rsbundle.getString("APPURL");

		// GET User Details Properties Values.
		_DIP_CITY=rsbundle.getString("DIP_CITY");
		_DES_CITY=rsbundle.getString("DES_CITY");
		_USER_NAME = rsbundle.getString("USER_NAME");
		_ADDRESS = rsbundle.getString("ADDRESS");
		_CITY = rsbundle.getString("CITY");
		_STATE = rsbundle.getString("STATE");
		_ZIP = rsbundle.getString("ZIP");
		
		//Get Credit Card Details
		_CARDTYPE=rsbundle.getString("CARDTYPE");
		_CREDIT_CARD_NO=rsbundle.getString("CREDIT_CARD_NO");
		_MONTH=rsbundle.getString("MONTH");
		_YEAR=rsbundle.getString("YEAR");
		_NAMEONCARD=rsbundle.getString("NAMEONCARD");
	}
}
