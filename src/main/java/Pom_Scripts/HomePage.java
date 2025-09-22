package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@data-uid='02']/div[@class='e-fullrow']")
	private WebElement Patiens;
	
	@FindBy(xpath = "//a[@class='parent-item']/i")
	private WebElement home;

	@FindBy(xpath = "//a[text()='All Patients']")
	private WebElement AllPatients;
	
	@FindBy(xpath = "//a[text()='Add Patient']")
	private WebElement AddPatients;
	
		public WebElement getAllPatients() {
		return AllPatients;
	}

	public WebElement getAddPatients() {
		return AddPatients;
	}

	public WebElement getPatiens() {
		return Patiens;
	}

	public WebElement getHome() {
		return home;
	}
	
	
}
