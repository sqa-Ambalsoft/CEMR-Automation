package PracticeScript;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.Add_Patient_Page;
import Pom_Scripts.AllPatientPage;
import Pom_Scripts.HomePage;
import Pom_Scripts.LoginPage;

public class SampleTest extends BaseClass {

	@Test
	public void launch_TestCase() throws IOException, InterruptedException {

		String actual = Object_Utility.webDriver_Utility_Instance().fetchUrl();
		Reporter.log(actual,true);
		Thread.sleep(2000);
		String expected = Object_Utility.getProperty_Utility_Instance().fetchPropertyData("url");
		Assert.assertEquals(actual,expected);
		String title = Object_Utility.webDriver_Utility_Instance().fetchTitle();
		String currentadress = Object_Utility.webDriver_Utility_Instance().fetchCurrentAdress();
		Set<String> allAdress = Object_Utility.webDriver_Utility_Instance().fetchAllAdress();
		Reporter.log(title,true);
		Reporter.log(currentadress,true);
		Reporter.log(allAdress.toString(),true);
		Object_Utility.webDriver_Utility_Instance().newTab();
		Object_Utility.webDriver_Utility_Instance().navigateBrowser(actual);
		String adress = Object_Utility.webDriver_Utility_Instance().fetchCurrentAdress();
		Object_Utility.webDriver_Utility_Instance().switchWindow(adress);
		Object_Utility.webDriver_Utility_Instance().close();
		Object_Utility.webDriver_Utility_Instance().switchWindow(currentadress);
		Object_Utility.TakeScreenShot_Utility_Instance().getErrorShotWebPage();
		Object_Utility.action_Utility_Instance().leftClick(driver.findElement(By.xpath("//button[@class='login100-form-btn']")));
		Object_Utility.action_Utility_Instance().rightClick(driver.findElement(By.xpath("//button[@class='login100-form-btn']")));
	}		

//	@Test
//	public void excelTest() throws EncryptedDocumentException, IOException {
//		Object[][] data = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data("Sheet1");
//		System.out.println(Arrays.deepToString(data));
//	}
//
//	@Test
//	public void excel1Test() throws EncryptedDocumentException, IOException {
//		String data = Object_Utility.excel_Utility_Instance().fetchExcelSingle_Data(0, 0,"Sheet1");
//		System.out.println(data);
//	}

	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage ap = new HomePage(driver);
		lp.getUsername().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("username"));
		lp.getPassword().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("password"));
		lp.getLoginButton().click();
		try {
			lp.getContinueinstance().click();
		}catch(Exception e) {
			Reporter.log("Previous Instance is not logged out");
		}
		Assert.assertEquals(ap.getHome().isEnabled(),true);
		Assert.assertEquals(ap.getPatiens().isEnabled(),true);	  
		ap.getPatiens().click();
		ap.getAllPatients().click();
		ap.getAddPatients().click();
	}

	@Test(dataProvider = "PatientDetial")
	public void testExcel(String AppoitmentType,String Title,String FirstName,String LastName,
			String Dob,String Gender,String BloodGroup,
			String MobileNumber,String whatsuppNumber,String Email,
			String ModeOfCommunication,String PatientFlag,String ConsultingDoctorName) throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		Add_Patient_Page ap = new Add_Patient_Page(driver);
		ap.getAppoitmentType().click();
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

		ap.getFirstName().sendKeys(FirstName);
		ap.getLastName().sendKeys(LastName);
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

		ap.getMobileNumber().sendKeys(MobileNumber);
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
		case "Hard Of Hearing":
        ap.getFlag_HeardOfHearing().click();
			break;
		case "Chronically Late":
      ap.getFlag_chronicallyLate().click();
			break;
		case "Needs Assistance":
    ap.getFlag_NeedAssistance().click();
			break;
		case "Risks to patient":
    ap.getFlag_RiskToPatient().click();
			break;
		case "Pregnant":
          ap.getFlag_pregnant().click();
			break;
		case "Allergic to Something":
        ap.getFlag_Allergic().click();
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
		
	//	Object_Utility.webDriver_Utility_Instance().refresh();
	}


//	@DataProvider(name = "PatientDetial")
//	public Object[][] patientData() throws EncryptedDocumentException, IOException{

//		int RowSize = Object_Utility.excel_Utility_Instance().fetchRowSize("Sheet2",Iconstant.Excel_Path);
//		int CellSize = Object_Utility.excel_Utility_Instance().fetchRowSize("Sheet2",Iconstant.Excel_Path);
//		Object[][] obj = new Object[RowSize][CellSize];
//
//		obj = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data("Sheet2");

//		return obj;
//	}
	
	@Test
	public void test2() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);
		allpp.getMRN_Filter().sendKeys("MRN-1171");
		Object_Utility.webDriver_Utility_Instance().waitForElement(allpp.getFilterRow(), 15);
		Thread.sleep(2000);
		allpp.getFilterRow().click();
		allpp.getEdit().click();   
		Add_Patient_Page app= new Add_Patient_Page(driver);
		app.getAppoitmentType().click();
	    try {
	    	app.getFollowUp().isDisplayed();
	    }catch(Exception e) {
	    	app.getAppoitmentType().click();
	    }
//		app.getGender().click();
//		Thread.sleep(2000);
//		app.getGender().click();
//		app.getFemale().click();
//		Thread.sleep(1000);
//		Object_Utility.javaScript_Utility_Instance().scrollElement(app.getSavePatient());
//		Thread.sleep(2000);
//	    Object_Utility.webDriver_Utility_Instance().waitForElement(app.getSavePatient(), 15);
//		Assert.assertTrue(app.getSavePatient().isEnabled());
//		app.getSavePatient().click();
		
//		app.getMobileNumber().sendKeys("856987686");
		
	}
	
	@Test
	public void data() throws EncryptedDocumentException, IOException {
	//	System.out.println(Object_Utility.excel_Utility_Instance().fetchExcelSingle_Data(0, 13, "EditPatient_Detial"));
//		String[][] data = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data_MRN("MRN");
//		System.out.println(Arrays.deepToString(data));
	}
}  