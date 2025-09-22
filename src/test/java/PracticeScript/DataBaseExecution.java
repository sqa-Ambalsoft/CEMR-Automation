package PracticeScript;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.AllPatientPage;
import Pom_Scripts.HomePage;

public class DataBaseExecution extends BaseClass{

	ArrayList<String> al = new ArrayList<String>();
	@Test
	public void searchPatient() throws EncryptedDocumentException, IOException {

	
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);
	//	String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data("SearchPatient_Detial");
        
		try {
			rs = stmt.executeQuery("SELECT  [MRN] FROM [AIGCEMR].[dbo].[PatientInfo] order by "+"MRN"+" desc");
			while(rs.next()) {	
			//	int id = rs.getInt("id");
//				String Firstname = rs.getString("FirstName");
//				String lastName = rs.getString("LastName");
				String mrn = rs.getNString("MRN");
				if (mrn != null) {
				    System.out.println("MRN: " + mrn);
				    al.add(mrn);
				} else {
				    System.out.println("MRN is NULL");
				}
			//	System.out.println(id + Firstname + lastName);
			//	al.add(MRN);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(String s:al) {
			allpp.getMRN_Filter().sendKeys(s);
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+s+"']")));
				allpp.getMRN_Filter().clear();
				}catch(Exception e) {
					String Actual = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td/span")).getText();
					Assert.assertEquals(Actual, "No records to display");
					System.out.println("*******"+s+" "+Actual+"*******");
					allpp.getMRN_Filter().clear();
				}
		
		}
//		for(int i=0;i<MrnData.length;i++) {
//			for(int j=0;j<MrnData[0].length;j++) {
//				String MRN_Value = MrnData[i][j];
//				allpp.getMRN_Filter().sendKeys(MRN_Value);
//				try {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+MRN_Value+"']")));
//				allpp.getMRN_Filter().clear();
//				}catch(Exception e) {
//					String Actual = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td/span")).getText();
//					Assert.assertEquals(Actual, "No records to display");
//					System.out.println("*******"+MRN_Value+" "+Actual+"*******");
//					allpp.getMRN_Filter().clear();
//				}
//			}
		}

	}

