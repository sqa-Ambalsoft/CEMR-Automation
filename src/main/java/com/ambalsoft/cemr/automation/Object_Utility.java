package com.ambalsoft.cemr.automation;

/**
 * @author ASITEMP128
 */
public class Object_Utility {

	/**
	 * This method is used to return the PropertyUtility Object
	 * @return
	 */
	public static Property_Utility getProperty_Utility_Instance() {
		
		Property_Utility instance = new Property_Utility();
		return instance;
	}
	
	/**
	 * This method is used to return the ExcelUtility object
	 * @return
	 */
	public static Excel_Utility excel_Utility_Instance() {
		Excel_Utility instance = new Excel_Utility();
		return instance;
	}
	
	/**
	 * This Method is used to return the ScreenShotUtility object
	 * @return
	 */
	public static TakeScreenShot_Utility TakeScreenShot_Utility_Instance() {
		TakeScreenShot_Utility instance = new TakeScreenShot_Utility();
		return instance;
	}
	
	/**
	 * This Method is used to return the javaScript Utility Instance
	 * @return
	 */
	public static JavaScript_Utlity javaScript_Utility_Instance() {
		JavaScript_Utlity instance = new JavaScript_Utlity();
		return instance;
	}
	/**
	 * This method is used to return the webDriver Utility Instance
	 * @return
	 */
    public static WebDriver_Utility webDriver_Utility_Instance() {
    	WebDriver_Utility instance = new WebDriver_Utility();
    	return instance;
    }
    
    public static Mouse_Keyboard_Utility  action_Utility_Instance() {
       Mouse_Keyboard_Utility instance = new Mouse_Keyboard_Utility(BaseClass.driver);
       return instance;
    }
    
    public static DataProvider_Utility dataProvider_Instance() {
    	DataProvider_Utility instance = new DataProvider_Utility();
    	return instance;
    }
    
    public static Java_Utility java_Utility() {
    	Java_Utility instance = new Java_Utility();
    	return instance;
    }
}
