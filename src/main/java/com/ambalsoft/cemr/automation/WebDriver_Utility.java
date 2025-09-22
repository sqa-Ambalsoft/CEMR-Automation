package com.ambalsoft.cemr.automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author ASITEMP128
 */
public class WebDriver_Utility extends BaseClass {

	/**
	 * This method is used to navigate to the respective webPage
	 * @param url
	 */
	public void navigateBrowser(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to return the Url of the webPage
	 * @return
	 */
	public String fetchTitle() {
		String data = driver.getTitle();
		return data ;
	}
	/**
	 * This method is used to return the current url of the webPage
	 * @return
	 */
	public String fetchUrl() {
		String data = driver.getCurrentUrl();
		return data;
	}
	/**
	 * This method is used to return source code of an webApplication
	 * @return
	 */
	public String fetchSourceCode() {
		String data = driver.getPageSource();
		return data;
	}
	/**
	 * This method is used to return the current address of the webpage
	 * @return
	 */
	public String fetchCurrentAdress() {
		String data = driver.getWindowHandle();
		return data;
	}
	/**
	 * This method is used to fetch all the window adress
	 * @return
	 */
	public Set<String> fetchAllAdress() {
		 Set<String> data = driver.getWindowHandles();
		 return data;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximize() {
	 driver.manage().window().maximize();	
	}
	/**
	 * This method is used to minimize the browser
	 */
	public void minimize() {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used for FullScreen
	 */
	public void fullScreen() {
		driver.manage().window().fullscreen();
	}
	/**
	 * This method is used to move backward
	 */
	public void backward() {
		driver.navigate().back();
	}
	/**
	 * This method is used to move forward
	 */
	public void forward() {
		driver.navigate().forward();
	}
	/**
	 * This method is used to do refresh
	 */
	public void refresh() {
		driver.navigate().refresh();
	}
	/**
	 * This method is used to close the browser
	 */
	public void closeAll() {
		driver.quit();
	}
	public void close() {
		driver.close();
	}
	/**
	 * it is an implicitly wait always wait for element in DOM 
	 * document & release the control if element available
	 */
	public void waitForElementInDOM(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/**
	 * it is an explicit wait always wait for page to be loaded & available in GUI
	 * @param url
	 */
	public void waitForPage(String url) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * it is an explicit wait always wait for  Webelement to be loaded and available in GUI
	 * @param element
	 * @param seconds.
	 */
	public void waitForElement(WebElement element,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to new Tab in the same brower
	 */
	public void newTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	/**
	 * This method is used to switch the control to respecting window
	 * @param url
	 */
	public void switchWindow(String window_url) {
		 Set<String> adress = driver.getWindowHandles();
		 for(String s:adress) {
			 driver.switchTo().window(s);
			 if(driver.getCurrentUrl().contains(window_url)) {
				 break;
			 }
		 }
	}
	/**
	 * This method is used to switch the control to the alert popup
	 * and it will click accept button
	 */
	public void switchAlertWindowAndAccept() {
		 Alert a = driver.switchTo().alert();
		 a.accept();
	}
	/**
	 * This method is used to switch the control to the alert popup
	 * and it will click dismiss button
	 */
	public void switchAlertWindowAndCancel() {
		 Alert a = driver.switchTo().alert();
		 a.dismiss();
	}
	/**
	 * This method is used to switch the control to the Iframe/Embeded webpage
	 * base on the index value
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the control to the IFrame/Embeded webpage
	 * based on the attribute value(id / name)
	 * @param attribute
	 */
	public void switchToFrame(String attribute) {
		driver.switchTo().frame(attribute);
	}
	/**
	 * This method is used to switch the control to the Iframe/Embeded webpage
	 * based on the webElement value
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
}
