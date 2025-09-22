package com.ambalsoft.cemr.automation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * @author ASITEMP128
 */
public class DropDown_Utility {

	public Select s;
	/**
	 * This constructor is used to create instance for select class 
	 * @param element
	 */
	public DropDown_Utility(WebElement element) {
	  	 s = new Select(element);
	}
	/**
	 * This method is used to select the drop down option based on the
	 * user index position in the list box
	 * @param index
	 */
	public void select_By_Index(int index) {
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select the drop down option based on the
	 * value attribute 
	 * @param value
	 */
	public void select_By_Value(String value) {
		s.selectByValue(value);
	}
	/**
	 * This method is used to select the drop down option based on
	 * the visible text of the webElement
	 * @param TextFuction
	 */
	public void select_By_VisibleText(String TextFuction) {
		s.selectByVisibleText(TextFuction);
	}
	/**
	 * This method is used to deselect all the option which present
	 * in the dropdown
	 */
	public void deselect_All() {
		s.deselectAll();
	}
	/**
	 * This method is used to deselect the drop down option based
	 * on the index position in the list box
	 * @param index
	 */
	public void deselect_By_Index(int index) {
		s.deselectByIndex(index);
	}
	/**
	 * This method is used to deselect the drop down option based
	 * on the attribute value
	 * @param value
	 */
	public void deselect_By_Value(String value) {
		s.deselectByValue(value);
	}
	/**
	 * This method is used to deselect the drop down option based
	 * on the visible text of the weblement
	 * @param TextFuction
	 */
	public void deselect_By_VisibleText(String TextFuction) {
		s.deselectByVisibleText(TextFuction);
	}
	/**
	 * This method is used to fetch all the selected option
	 * from the dropdown
	 * @return
	 */
	public List<WebElement> get_All_Option() {
		List<WebElement> data = s.getAllSelectedOptions();
		return data;
	}
	/**
	 * This method is used to fetch the first selected option
	 * from the drop down
	 * @return
	 */
	public WebElement get_First_Option() {
		WebElement data = s.getFirstSelectedOption();
		return data;
	}
	/**
	 * This method is used to validate wether which is single dropdown
	 * or multiselect drop down
	 * @return
	 */
	public boolean isSingle() {
		boolean data = s.isMultiple();
		return data;
	}
}
