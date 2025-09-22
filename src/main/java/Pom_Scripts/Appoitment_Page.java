package Pom_Scripts;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Appoitment_Page extends BasePage{

	public Appoitment_Page(WebDriver driver) {
		super(driver);
		
	}
    @FindBy(xpath = "//li[@data-uid='03']/div[@class='e-fullrow']")
	private WebElement Appoitment;
    
	@FindBy(xpath = "//a[text()='Book Appointment']")
	private WebElement BookAppoitment;
	
	@FindBy(xpath = "//td[@class='e-header-cells e-date-header e-current-day']/div[@class='e-header-date e-navigate']")
	private WebElement CurrentDay;
	
	@FindBy(xpath = "//div[@class='e-current-time']")
	private WebElement CurrentTime;
	
	@FindBy(xpath = "//span[@class='e-icons e-frame']")
	private WebElement NewPatientCheckBox;
	
	@FindBy(xpath = "//td[text()='Patient Name']/following-sibling::td/span/input")
	private WebElement PatientName;
	
	@FindBy(xpath = "//td[text()='Mobile Number']/following-sibling::td/span/input")
	private WebElement MobileNumber;
	
	@FindBy(xpath = "//input[@id='Doctor']/following-sibling::span[@class='e-input-group-icon e-ddl-icon e-icons e-ddl-disable-icon']")
	private WebElement DoctorList;
	
	@FindBy(xpath = "//li[@id='Doctor_0']")
	private WebElement DrKayal;
	
	@FindBy(xpath = "//input[@id='AppointmentStatus']/following-sibling::span[contains(@class,'e-input-group-icon e-ddl-icon')]")
	private WebElement AppoitmentStatus;
	
	@FindBy(xpath = "//li[@id='AppointmentStatus_0']")
	private WebElement NewStatus;
	
	@FindBy(xpath = "//input[@id='AppointmentType']/following-sibling::span[contains(@class,'e-input-group-icon')]")
	private WebElement AppoitmentType;
	
	@FindBy(xpath = "//li[@id='AppointmentType_1']")
	private WebElement FollowUp;
	
	@FindBy(xpath = "//input[@id='Investigation']/following-sibling::span[contains(@class,'e-input-group-icon')]")
	private WebElement Investigation;
	
	@FindBy(xpath = "//li[@data-value='laproscopy']")
	private WebElement laproscopy;
	
	public WebElement getLaproscopy() {
		return laproscopy;
	}

	@FindBy(xpath = "//td[text()='Location']/following-sibling::td/span/input")
	private WebElement Location;
	
	@FindBy(xpath = "//td[text()='Comments']/following-sibling::td/span/textarea")
	private WebElement commentText;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;

	public WebElement getBookAppoitment() {
		return BookAppoitment;
	}

	public WebElement getCurrentDay() {
		return CurrentDay;
	}

	public WebElement getCurrentTime() {
		return CurrentTime;
	}

	public WebElement getNewPatientCheckBox() {
		return NewPatientCheckBox;
	}

	public WebElement getPatientName() {
		return PatientName;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getDoctorList() {
		return DoctorList;
	}

	public WebElement getDrKayal() {
		return DrKayal;
	}

	public WebElement getAppoitmentStatus() {
		return AppoitmentStatus;
	}

	public WebElement getNewStatus() {
		return NewStatus;
	}

	public WebElement getAppoitmentType() {
		return AppoitmentType;
	}

	public WebElement getFollowUp() {
		return FollowUp;
	}

	public WebElement getInvestigation() {
		return Investigation;
	}

	public WebElement getLocation() {
		return Location;
	}

	public WebElement getCommentText() {
		return commentText;
	}

	public WebElement getSave() {
		return save;
	}
	
	public WebElement getAppointment() {
		return Appoitment;
	}
}
