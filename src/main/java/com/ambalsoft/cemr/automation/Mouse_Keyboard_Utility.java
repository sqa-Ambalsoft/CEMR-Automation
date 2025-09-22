package com.ambalsoft.cemr.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * @author ASITEMP128
 */
public class Mouse_Keyboard_Utility {

	public Actions action;
	
	public Mouse_Keyboard_Utility(WebDriver driver) {
		action = new Actions(driver);
	}
	/**
	 * This method is used to perform click action on
	 * the targeted webElement
	 * @param element
	 */
	public void leftClick(WebElement element) {
		action.click(element).perform();
	}
	
	public void leftClick() {
		action.click().perform();
	}
	/**
	 * This method is used to perform right click action on
	 * the targeted webElement
	 * @param element
	 */
	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to perform double click action on
	 * the targeted webelement
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to move the cursor to the targeted
	 * webElement
	 * @param element
	 * @return 
	 */
	public Mouse_Keyboard_Utility moveCursor(WebElement element) {
		action.moveToElement(element).perform();
		return Object_Utility.action_Utility_Instance();
	}
	/**
	 * This method is used to perform drag and drop action on the 
	 * targeted webElement
	 * @param source
	 * @param destination
	 */
	public void dragAndDrop(WebElement source,WebElement destination) {
		action.dragAndDrop(source, destination).perform();
	}
	/**
	 * This method is used to pause for some time 
	 * @param seconds
	 * @return 
	 */
	public Mouse_Keyboard_Utility pause(int seconds) {
		action.pause(Duration.ofSeconds(seconds)).perform();
		return Object_Utility.action_Utility_Instance();
	}
}
