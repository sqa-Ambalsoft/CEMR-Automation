package com.ambalsoft.cemr.automation;

import java.io.File;
import java.io.IOException;

import javax.swing.Icon;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

/**
 * @author ASITEMP128
 */
public class TakeScreenShot_Utility {

	/**
	 * Thus Method is used to take a screen shot of webPage
	 * @throws IOException
	 */
	public void getErrorShotWebPage() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File(Iconstant.ErrorShot_Path+"\\image.png");
		 System.out.println(destination.getAbsolutePath());
		 Files.copy(source, destination);
	}
	
	/**
	 * This Method is used to take Screen Shot of an webElement 
	 * @param element
	 * @throws IOException
	 */
	public void getErrorShotWebElement(WebElement element) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		File destination = new File(Iconstant.ErrorShot_Path);
		Files.copy(source, destination);
	}
}
