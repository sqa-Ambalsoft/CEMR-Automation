package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultationPage extends BasePage{

	public ConsultationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='Lab']")
	private WebElement Lab;
	@FindBy(xpath = "//div[text()='Imaging']")
	private WebElement Imaging;
	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement DashBoard;
	@FindBy(xpath = "//div[text()='Complaints']")
	private WebElement Complaints;
	@FindBy(xpath = "//div[text()='Pre-Consultation']")
	private WebElement pre_consultation;
	@FindBy(xpath = "//div[text()='Examination']")
	private WebElement Examination;
	@FindBy(xpath = "//div[text()='Diagnosis']")
	private WebElement Diagnosis;
	@FindBy(xpath = "//div[text()='Medication']")
	private WebElement Medication;

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement Complaint_Add;
	@FindBy(xpath = "//span[text()='Edit']") 
	private WebElement Complaint_Edit;
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement Complaint_Delete;
	@FindBy(xpath = "//span[text()='Update']")
	private WebElement Complaint_Update;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement Complaint_Cancel;
	@FindBy(xpath = "//span[text()='Excel Export']")
	private WebElement Compliant_ExcelExport;
	@FindBy(xpath = "//span[text()='CSV Export']")
	private WebElement Complaint_CsvExport;
	@FindBy(xpath = "//span[text()='PDF Export']")
	private WebElement Pdf_Export;
	
	@FindBy(xpath = "//span[contains(@class,'e-ddl-disable-icon')]")
	private WebElement Complaint_DropDown;
	@FindBy(xpath = "//li[@id='ChiefComplaintName_0']")
	private WebElement FeverComplaint;
	@FindBy(xpath = "//li[@id='ChiefComplaintName_1']")
	private WebElement ThroatPainComplaint;
	@FindBy(xpath = "//li[@id='ChiefComplaintName_2']")
	private WebElement DiarrheaComplaint;
	@FindBy(xpath = "//textarea[@id='Duration']")
	private WebElement ComplaintDuration;
	@FindBy(xpath = "//textarea[@id='Comments']")
	private WebElement ComplaintComments;
	public WebElement getLab() {
		return Lab;
	}
	public WebElement getImaging() {
		return Imaging;
	}
	public WebElement getDashBoard() {
		return DashBoard;
	}
	public WebElement getComplaints() {
		return Complaints;
	}
	public WebElement getPre_consultation() {
		return pre_consultation;
	}
	public WebElement getExamination() {
		return Examination;
	}
	public WebElement getDiagnosis() {
		return Diagnosis;
	}
	public WebElement getMedication() {
		return Medication;
	}
	public WebElement getComplaint_Add() {
		return Complaint_Add;
	}
	public WebElement getComplaint_Edit() {
		return Complaint_Edit;
	}
	public WebElement getComplaint_Delete() {
		return Complaint_Delete;
	}
	public WebElement getComplaint_Update() {
		return Complaint_Update;
	}
	public WebElement getComplaint_Cancel() {
		return Complaint_Cancel;
	}
	public WebElement getCompliant_ExcelExport() {
		return Compliant_ExcelExport;
	}
	public WebElement getComplaint_CsvExport() {
		return Complaint_CsvExport;
	}
	public WebElement getPdf_Export() {
		return Pdf_Export;
	}
	public WebElement getComplaint_DropDown() {
		return Complaint_DropDown;
	}
	public WebElement getFeverComplaint() {
		return FeverComplaint;
	}
	public WebElement getThroatPainComplaint() {
		return ThroatPainComplaint;
	}
	public WebElement getDiarrheaComplaint() {
		return DiarrheaComplaint;
	}
	public WebElement getComplaintDuration() {
		return ComplaintDuration;
	}
	public WebElement getComplaintComments() {
		return ComplaintComments;
	}
	
	
	
	
}
