package com.ambalsoft.cemr.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScript_Utlity {

	public JavascriptExecutor js;
	
	public JavaScript_Utlity() {
		js = (JavascriptExecutor) BaseClass.driver;
	}
	
	public void scrollUp(int x,int y) {
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public void scrollDown(int x,int y) {
		js.executeScript("window.scrollBy("+x+","+-y+");");
	}
	
	public void scrollElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void extremeTop() {
		js.executeScript("window.scrollTo(0,document.body.scrollTop);");
	}
	
	public void extremeBottum() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
}
