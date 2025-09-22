package com.ambalsoft.cemr.Patient;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.AllPatientPage;
import Pom_Scripts.HomePage;

public class Retrive_Patient_Test extends BaseClass {

	@Test
	public void searchPatient() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);
		String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"SearchPatient_Detial");
      
		System.out.println(Arrays.deepToString(MrnData));
		for(int i=0;i<MrnData.length;i++) {
			for(int j=0;j<MrnData[0].length;j++) {
				String MRN_Value = MrnData[i][j];
				allpp.getMRN_Filter().sendKeys(MRN_Value);
				try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+MRN_Value+"']")));
				Reporter.log(MRN_Value+"----->Record Found",true);
				allpp.getMRN_Filter().clear();
				}catch(Exception e) {
					String Actual = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td/span")).getText();
					Assert.assertEquals(Actual, "No records to display");
					Reporter.log("*******"+MRN_Value+" "+Actual+"*******",true);
					allpp.getMRN_Filter().clear();
				}
			}
		}

	}

	
	
	

	
}
