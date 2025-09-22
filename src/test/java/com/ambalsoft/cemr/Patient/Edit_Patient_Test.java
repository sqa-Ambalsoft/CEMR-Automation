package com.ambalsoft.cemr.Patient;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.Add_Patient_Page;
import Pom_Scripts.AllPatientPage;
import Pom_Scripts.HomePage;

public class Edit_Patient_Test extends BaseClass {

	@Test(dataProvider = "EditPatientDetial")
	public void editTest(String AppoitmentType,String Title,String FirstName,String LastName,
			String Dob,String Gender,String BloodGroup,
			String MobileNumber,String whatsuppNumber,String Email,
			String ModeOfCommunication,String PatientFlag,String ConsultingDoctorName) throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);

		allpp.getMRN_Filter().sendKeys(Object_Utility.excel_Utility_Instance().fetchExcelSingle_Data(Iconstant.CommanData,"EditPatient",0,0));
		String MRN = Object_Utility.excel_Utility_Instance().fetchExcelSingle_Data(Iconstant.CommanData,"EditPatient",0,0);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[text()='"+MRN+"']")));
		Object_Utility.action_Utility_Instance().moveCursor(driver.findElement(By.xpath("//td[text()='"+MRN+"']"))).leftClick();
		try {
			boolean b = driver.findElement(By.xpath("//td[contains(@class,'e-selectionbackground')] ")).isSelected();
			//Assert.assertTrue(b);
		}catch(Exception e) {
			Object_Utility.action_Utility_Instance().moveCursor(driver.findElement(By.xpath("//td[text()='"+MRN+"']"))).leftClick();
		}
		allpp.getEdit().click();   
				Add_Patient_Page ap= new Add_Patient_Page(driver);
				Thread.sleep(3000);
			    wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='apptProfile']/following-sibling::label/following-sibling::span")));
				ap.getAppoitmentType().click();
				 try {
				    	ap.getFollowUp().isDisplayed();
				    }catch(Exception e) {
				    	ap.getAppoitmentType().click();
				    }
				if(AppoitmentType.contains("New Patient")) {
					ap.getNewPatient().click();
				}else {
					ap.getFollowUp().click();
				}
		        
				ap.getTitle().click();
				if(Title.contains("Mr")) {
					ap.getMr().click();
				}else {
					ap.getMrs().click();
				}
		
				ap.getFirstName().clear();
				ap.getFirstName().sendKeys(FirstName);
				ap.getLastName().clear();
				ap.getLastName().sendKeys(LastName);
				
				System.out.println(Dob);
				Object_Utility.action_Utility_Instance().leftClick(driver.findElement(By.xpath("//label[@id='label_dob']")));
				ap.getDOB().clear();
				ap.getDOB().sendKeys(Dob);
				ap.getGender().click();
				if(Gender.contains("Male")) {
					ap.getMale().click();
				}else {
					ap.getFemale().click();
				}
				ap.getBloodGroup().click();
				switch(BloodGroup) {
				case "A+":{
					ap.getBlood_A_Post().click();
				}break;
				case "AB+":{
					ap.getBlood_AB().click();
				}
				break;
				case "O+":{
					ap.getBlood_o().click();
				}break;
				case "A-" :{
					ap.getBlood_A_Negat().click();
				}
				break;
				default : {
					System.out.println("Invalid Blood Group");
				}
				}
				ap.getMobileNumber().clear();
				ap.getMobileNumber().sendKeys(MobileNumber);
				Thread.sleep(1000);
				Object_Utility.javaScript_Utility_Instance().scrollUp(0, 500);
				
				ap.getEmailid().clear();
				ap.getEmailid().sendKeys(Email);
				
				
				ap.getCommunicationMode().click();
				if(ModeOfCommunication.contains("SMS")) {
					ap.getSmsMode().click();
				}else if(ModeOfCommunication.contains("Whatsapp")) {
					ap.getWhatsuppMode().click();
				}else {
					ap.getEmailMode().click();
				}
		
				ap.getPatient_Flag().click();
				switch (PatientFlag) {
				case "Hard Of Hearing":{
		        ap.getFlag_HeardOfHearing().click();
		        }
					break;
				case "Chronically Late":{
		      ap.getFlag_chronicallyLate().click();
				}
					break;
				case "Needs Assistance":{
		    ap.getFlag_NeedAssistance().click();
				}
					break;
				case "Risks to Patients":{
		    ap.getFlag_RiskToPatient().click();
				}
					break;
				case "Pregnant":{
		          ap.getFlag_pregnant().click();
				}
					break;
				case "Allergic to Something":{
		        ap.getFlag_Allergic().click();
				}
					break;
		
				default:{
					System.out.println("Invalid Symptom");
				}
					break;
				}
				
				ap.getDoctor_Name().click();
				if(ConsultingDoctorName.contains("Dr.Kayal")) {
					ap.getDoctorKayal().click();
				}else {
					ap.getDoctorKarthick().click();
				}
			    Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getSavePatient(), 15);
				Assert.assertTrue(ap.getSavePatient().isEnabled());
				ap.getSavePatient().click();
	}

	@DataProvider(name = "EditPatientDetial")
	public Object[][] patientData() throws EncryptedDocumentException, IOException{

		int RowSize = Object_Utility.excel_Utility_Instance().fetchRowSize(Iconstant.CommanData,"EditPatient");
		int CellSize = Object_Utility.excel_Utility_Instance().fetchRowSize(Iconstant.CommanData,"EditPatient");
		Object[][] obj = new Object[RowSize][CellSize];

		obj = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"EditPatient");

		return obj;
	}
}
