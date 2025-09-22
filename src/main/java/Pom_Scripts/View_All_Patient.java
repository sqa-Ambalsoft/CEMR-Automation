package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class View_All_Patient extends BasePage{

	public View_All_Patient(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath = "//a[text()='View All Appointments']")
	private WebElement ViewAllPatient;
	
	@FindBy(xpath = "//tr[@class='e-row e-altrow']")
	private WebElement PatientList; 
	
	@FindBy(xpath = "//li[@aria-label='In Time']")
	private WebElement InTime;
	
	@FindBy(xpath = "//button[text()='Save Changes']")
	private WebElement SaveChanges;
	
	@FindBy(xpath = "//li[@id='ActualStartTime']")
	private WebElement ActualStartTime;

	public WebElement getViewAllPatient() {
		return ViewAllPatient;
	}

	public WebElement getPatientList() {
		return PatientList;
	}

	public WebElement getInTime() {
		return InTime;
	}

	public WebElement getSaveChanges() {
		return SaveChanges;
	}

	public WebElement getActualStartTime() {
		return ActualStartTime;
	}
	
	

}
