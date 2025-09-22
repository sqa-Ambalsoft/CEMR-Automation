package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_Patient_Page extends BasePage {

	public Add_Patient_Page(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(xpath = "//input[@id='apptProfile']/following-sibling::label/following-sibling::span")
	private WebElement AppoitmentType;
	
	@FindBy(xpath = "//li[@id='apptProfile_0']")
	private WebElement NewPatient;
	
	@FindBy(xpath = "//li[@id='apptProfile_1']")
	private WebElement FollowUp;
	
	@FindBy(xpath = "//input[@id='title']/following-sibling::label/following-sibling::span")
	private WebElement Title;
	
	public WebElement getTitle() {
		return Title;
	}

	@FindBy(xpath = "//li[@id='title_0']")
	private WebElement Mrs;
	
	@FindBy(xpath = "//li[@id='title_1']")
	private WebElement Mr;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='dob']")
	private WebElement DOB;
	
	@FindBy(xpath = "//input[@id='gender']/following-sibling::label/following-sibling::span")
	private WebElement Gender;
	
	@FindBy(xpath = "//li[@id='gender_0']")
	private WebElement Male;
	
	@FindBy(xpath = "//li[@id='gender_1']")
	private WebElement female;
	
	@FindBy(xpath = "//li[@id='gender_2']")
	private WebElement other;
	
	@FindBy(xpath = "//input[@id='bloodGroup']/following-sibling::label/following-sibling::span")
	private WebElement BloodGroup;
	

	@FindBy(xpath = "//li[@id='bloodGroup_0']")
	private WebElement Blood_o;
	
	@FindBy(xpath = "//li[@id='bloodGroup_1']")
	private WebElement Blood_A_Post;
	
	@FindBy(xpath = "//li[@id='bloodGroup_2']")
	private WebElement Blood_A_Negat;
	
	@FindBy(xpath = "//li[@id='bloodGroup_3']")
	private WebElement Blood_AB;
	
	@FindBy(xpath = "//li[@id='bloodGroup_4']")
	private WebElement Blood_B;
	
	@FindBy(xpath = "//input[@id='mobileNumber']")
	private WebElement MobileNumber;
	
	@FindBy(xpath = "//input[@id='whatsappNumber']")
	private WebElement WhatsUppNumber;
	
	@FindBy(xpath = "//input[@id='emailID']")
	private WebElement emailid;
	
	@FindBy(xpath = "//input[@id='modeofcommn']/following-sibling::label/following-sibling::span")
	private WebElement communicationMode;
	
	@FindBy(xpath = "//li[@id='modeofcommn_0']")
	private WebElement smsMode;
	
	@FindBy(xpath = "//li[@id='modeofcommn_1']")
	private WebElement whatsuppMode;
	
	@FindBy(xpath = "//li[@id='modeofcommn_2']")
	private WebElement emailMode;
	
	@FindBy(xpath = "//input[@id='patientFlag']/following-sibling::label/following-sibling::span")
	private WebElement patient_Flag;
	
	@FindBy(xpath = "//li[@id='patientFlag_0']")
	private WebElement flag_HeardOfHearing;
	
	@FindBy(xpath = "//li[@id='patientFlag_1']")
	private WebElement flag_chronicallyLate;
	
	@FindBy(xpath = "//li[@id='patientFlag_2']")
	private WebElement flag_NeedAssistance;
	
	@FindBy(xpath = "//li[@id='patientFlag_3']")
	private WebElement flag_RiskToPatient;
	
	@FindBy(xpath = "//li[@id='patientFlag_4']")
	private WebElement flag_pregnant;
	
	@FindBy(xpath = "//li[@id='patientFlag_5']")
	private WebElement flag_Allergic;
	
	@FindBy(xpath = "//input[@id='DoctorName']/following-sibling::label/following-sibling::span")
	private WebElement Doctor_Name;
	
	@FindBy(xpath = "//li[@id='DoctorName_1']")
	private WebElement Administrator;	
	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getArunkumar() {
		return Arunkumar;
	}

	public WebElement getVicky() {
		return Vicky;
	}

	@FindBy(xpath = "//li[@id='DoctorName_2']")
	private WebElement Arunkumar;
	@FindBy(xpath = "//li[@id='DoctorName_4']")
	private WebElement Vicky;
	@FindBy(xpath = "//li[@id='DoctorName_3']")
	private WebElement DoctorKayal;
	@FindBy(xpath = "//li[@id='DoctorName_0']")
	private WebElement DoctorKarthick;

	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savePatient;

	public WebElement getAppoitmentType() {
		return AppoitmentType;
	}

	public WebElement getNewPatient() {
		return NewPatient;
	}

	public WebElement getFollowUp() {
		return FollowUp;
	}

	public WebElement getMrs() {
		return Mrs;
	}

	public WebElement getMr() {
		return Mr;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getMale() {
		return Male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getBloodGroup() {
		return BloodGroup;
	}

	public WebElement getBlood_o() {
		return Blood_o;
	}

	public WebElement getBlood_A_Post() {
		return Blood_A_Post;
	}

	public WebElement getBlood_A_Negat() {
		return Blood_A_Negat;
	}

	public WebElement getBlood_AB() {
		return Blood_AB;
	}

	public WebElement getBlood_B() {
		return Blood_B;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getWhatsUppNumber() {
		return WhatsUppNumber;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getCommunicationMode() {
		return communicationMode;
	}

	public WebElement getSmsMode() {
		return smsMode;
	}

	public WebElement getWhatsuppMode() {
		return whatsuppMode;
	}

	public WebElement getEmailMode() {
		return emailMode;
	}

	public WebElement getPatient_Flag() {
		return patient_Flag;
	}

	public WebElement getFlag_HeardOfHearing() {
		return flag_HeardOfHearing;
	}

	public WebElement getFlag_chronicallyLate() {
		return flag_chronicallyLate;
	}

	public WebElement getFlag_NeedAssistance() {
		return flag_NeedAssistance;
	}

	public WebElement getFlag_RiskToPatient() {
		return flag_RiskToPatient;
	}

	public WebElement getFlag_pregnant() {
		return flag_pregnant;
	}

	public WebElement getFlag_Allergic() {
		return flag_Allergic;
	}

	public WebElement getDoctor_Name() {
		return Doctor_Name;
	}

	public WebElement getDoctorKarthick() {
		return DoctorKarthick;
	}

	public WebElement getDoctorKayal() {
		return DoctorKayal;
	}

	public WebElement getSavePatient() {
		return savePatient;
	}
	
	@FindBy(xpath = "//button[@title='Close']")
	private WebElement closeMessage;
	
	@FindBy(xpath = "//div[@class='e-toast-message']")
	private WebElement PatientAddedMessage;

	public WebElement getCloseMessage() {
		return closeMessage;
	}

	public WebElement getPatientAddedMessage() {
		return PatientAddedMessage;
	}
	
}
