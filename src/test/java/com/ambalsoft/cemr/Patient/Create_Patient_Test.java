package com.ambalsoft.cemr.Patient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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
import Pom_Scripts.HomePage;

public class Create_Patient_Test extends BaseClass {

	@Test(priority = 0)
	public void patientModule() {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
	}


	@Test(dataProvider = "PatientDetial",priority = 1)
	public void AddPatient(String AppoitmentType,String Title,String FirstName,String LastName,
			String Dob,String Gender,String BloodGroup,
			String MobileNumber,String Email,
			String ModeOfCommunication,String PatientFlag,String ConsultingDoctorName) throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Add_Patient_Page ap = new Add_Patient_Page(driver);

		Assert.assertTrue(hp.getAddPatients().isDisplayed());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Patient']")));
		hp.getAddPatients().click();
		System.out.println(driver.getCurrentUrl());

		wait.until(ExpectedConditions.urlToBe("http://localhost:1010/AddPatient"));
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
		System.out.println(Dob);
		Object_Utility.action_Utility_Instance().leftClick(driver.findElement(By.xpath("//label[@id='label_dob']")));
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
		switch (PatientFlag.trim()) {
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
		}

		ap.getDoctor_Name().click();
		Thread.sleep(2000);
		switch(ConsultingDoctorName) {
		case "Dr.kayal":{
            ap.getDoctorKayal().click();
		}break;
		case "Administator":{
            ap.getAdministrator().click();
		}break;
		case "Dr.Karthick":{
           ap.getDoctorKarthick().click();
		}break;
		case "Arunkumar":{
           ap.getArunkumar().click();
		}break;
		case "Vicky":{
          ap.getVicky().click();
		}break;
		case "Invalid":{
          Reporter.log("Doctor Not Available");
		}
		}
		Thread.sleep(1000);
		Object_Utility.javaScript_Utility_Instance().scrollElement(ap.getSavePatient());
		Thread.sleep(2000);

		Object_Utility.webDriver_Utility_Instance().waitForElement(ap.getSavePatient(), 15);
		Assert.assertTrue(ap.getSavePatient().isEnabled());
		ap.getSavePatient().click();
		//	Object_Utility.webDriver_Utility_Instance().refresh();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='e-toast-message']")));
		ap.getPatientAddedMessage().isDisplayed();
		ap.getCloseMessage().click();
	}


	@DataProvider(name = "PatientDetial")
	public Object[][] patientData() throws EncryptedDocumentException, IOException{

		int RowSize = Object_Utility.excel_Utility_Instance().fetchRowSize(Iconstant.CommanData,"AddPatient_Detial");
		int CellSize = Object_Utility.excel_Utility_Instance().fetchRowSize(Iconstant.CommanData,"AddPatient_Detial");
		Object[][] obj = new Object[RowSize][CellSize];

		obj = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"AddPatient_Detial");

		return obj;
	}
	
//	@Test(dependsOnMethods = "AddPatient")
//	public void exportMrn() {
//		 String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;"
//                 + "databaseName=AIGCEMR;encrypt=true;trustServerCertificate=true;";
//      String user = "sa";
//      String pass = "ambalsoft@2010";
//
//      // 1) Sanity checks
//      String checkSql =
//          "SELECT DB_NAME() AS CurrentDB, " +
//          "       OBJECT_SCHEMA_NAME(OBJECT_ID('dbo.PatientInfo')) AS TblSchema, " +
//          "       OBJECT_ID('dbo.PatientInfo') AS TblId, " +
//          "       (SELECT COUNT(*) FROM dbo.PatientInfo) AS TotalRows, " +
//          "       (SELECT COUNT(*) FROM dbo.PatientInfo WHERE MRN IS NOT NULL) AS NonNullMRN";
//
//      // 2) Data query (TOP to keep it light)
//      String dataSql = "SELECT TOP(10) MRN FROM dbo.PatientInfo order by id desc"; // no WHERE so you see all rows
//      // If you only want non-null MRNs, use:
//      // String dataSql = "SELECT MRN FROM dbo.PatientInfo WHERE MRN IS NOT NULL";
//
//      try {
//          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//          try (Connection con = DriverManager.getConnection(url, user, pass)) {
//              // --- Sanity log ---
//              try (Statement s = con.createStatement();
//                   ResultSet r = s.executeQuery(checkSql)) {
//                  if (r.next()) {
//                      System.out.println("CurrentDB     : " + r.getString("CurrentDB"));
//                      System.out.println("Table schema  : " + r.getString("TblSchema"));
//                      System.out.println("Table exists? : " + (r.getObject("TblId") != null));
//                      System.out.println("Total rows    : " + r.getInt("TotalRows"));
//                      System.out.println("Non-null MRNs : " + r.getInt("NonNullMRN"));
//                  }
//              }
//
//              // --- Fetch + write Excel ---
//              try (PreparedStatement ps = con.prepareStatement(dataSql);
//                   ResultSet rs = ps.executeQuery();
//                   Workbook wb = new XSSFWorkbook()) {
//
//                  Sheet sheet = wb.createSheet("MRN");
//                  Row header = sheet.createRow(0);
//                  header.createCell(0).setCellValue("MRN");
//
//                  int r = 1;
//                  int seen = 0, written = 0;
//
//                  while (rs.next()) {
//                      seen++;
//                      // Try NVARCHAR-safe first; fall back if driver/version doesn’t support it
//                      String mrn;
//                      try {
//                          mrn = rs.getNString("MRN");
//                      } catch (SQLFeatureNotSupportedException nf) {
//                          mrn = rs.getString("MRN");
//                      }
//
//                      if (mrn != null) {
//                          Row row = sheet.createRow(r++);
//                          row.createCell(0).setCellValue(mrn);
//                          written++;
//                      }
//                  }
//
//                  sheet.autoSizeColumn(0);
//
//                  String outPath = Paths.get(Iconstant.Excel_MRNPath).toString();
//                  try (FileOutputStream fos = new FileOutputStream(outPath)) {
//                      wb.write(fos);
//                  }
//
//                  System.out.println("Rows seen     : " + seen);
//                  System.out.println("Rows written  : " + written);
//                  System.out.println("Excel saved to: " + outPath);
//
//                  if (seen == 0) {
//                      System.out.println("NOTE: Query returned 0 rows. Check table/data or schema.");
//                  } else if (written == 0) {
//                      System.out.println("NOTE: All MRN values were NULL (or filtered out).");
//                  }
//              }
//          }
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//	}
}
