package PracticeScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.Add_Patient_Page;
import Pom_Scripts.HomePage;


public class PatientTest extends BaseClass {

	
	@Test
	public void addPatient() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
	    Add_Patient_Page ap = new Add_Patient_Page(driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(hp.getPatiens().isEnabled());
		hp.getPatiens().click();
		
		
		Assert.assertTrue(hp.getAddPatients().isEnabled());
		hp.getAddPatients().click();
		
	    ap.getAppoitmentType().click();
	    ap.getNewPatient().click();
	    
		Thread.sleep(1000);
		Assert.assertTrue(ap.getTitle().isEnabled());
		ap.getTitle().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getMr(), 15);
		Assert.assertTrue(ap.getMr().isEnabled());
		ap.getMr().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getFirstName(), 15);
		Assert.assertTrue(ap.getFirstName().isEnabled());
		ap.getFirstName().sendKeys("paul");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getLastName(), 15);
		Assert.assertTrue(ap.getLastName().isEnabled());
		ap.getLastName().sendKeys("Sheela");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getDOB(), 15);
		Assert.assertTrue(ap.getDOB().isEnabled());
		ap.getDOB().sendKeys("01/02/1990");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getGender(), 15);
		Assert.assertTrue(ap.getGender().isEnabled());
		ap.getGender().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getMale(), 15);
		Assert.assertTrue(ap.getMale().isEnabled());
		ap.getMale().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getBloodGroup(), 15);
		Assert.assertTrue(ap.getBloodGroup().isEnabled());
		ap.getBloodGroup().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(hp.getAddPatients(), 15);
		Assert.assertTrue(hp.getAddPatients().isEnabled());
		ap.getBlood_A_Post().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getMobileNumber(), 15);
		Assert.assertTrue(ap.getMobileNumber().isEnabled());
		ap.getMobileNumber().sendKeys("987654321");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getWhatsUppNumber(), 15);
		Assert.assertTrue(ap.getWhatsUppNumber().isEnabled());
		ap.getWhatsUppNumber().sendKeys("987654321");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getEmailid(), 15);
		Assert.assertTrue(ap.getEmailid().isEnabled());
		ap.getEmailid().sendKeys("Paul@gmail.com");
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getCommunicationMode(), 15);
		Assert.assertTrue(ap.getCommunicationMode().isEnabled());
		ap.getCommunicationMode().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getEmailMode(), 15);
		Assert.assertTrue(ap.getEmailMode().isEnabled());
		ap.getEmailMode().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getPatient_Flag(), 15);
		Assert.assertTrue(ap.getPatient_Flag().isEnabled());
		ap.getPatient_Flag().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getFlag_Allergic(), 15);
		Assert.assertTrue(ap.getFlag_Allergic().isEnabled());
		ap.getFlag_Allergic().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getDoctor_Name(), 15);
		Assert.assertTrue(ap.getDoctor_Name().isEnabled());
		ap.getDoctor_Name().click();
		
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getDoctorKarthick(), 15);
		Assert.assertTrue(ap.getDoctorKarthick().isEnabled());
		ap.getDoctorKarthick().click();
		
		Thread.sleep(1000);
		Object_Utility.javaScript_Utility_Instance().scrollElement(ap.getSavePatient());
		Thread.sleep(2000);
		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getSavePatient(), 15);
		Assert.assertTrue(ap.getSavePatient().isEnabled());
		ap.getSavePatient().click();
		
	//	hp.getAllPatients().click();
	}
}
