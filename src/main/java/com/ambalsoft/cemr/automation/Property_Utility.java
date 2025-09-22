package com.ambalsoft.cemr.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ASITEMP128
 */
public class Property_Utility {

 /**
  * This method is used to fetch the data present in property file
  * @param key
  * @return
  * @throws IOException
  */
	public String fetchPropertyData(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(Iconstant.Property_Path);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
