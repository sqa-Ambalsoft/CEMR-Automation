package com.ambalsoft.cemr.Patient;

import java.io.IOException;
import java.time.Duration;

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

import Pom_Scripts.Add_Patient_Page;
import Pom_Scripts.AllPatientPage;
import Pom_Scripts.HomePage;

public class Delete_Patient_Test extends BaseClass {

	@Test
	public void DeleteTest() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);
		Add_Patient_Page ap = new Add_Patient_Page(driver);
		String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"DeletePatient_Detial");
	
		for(int i=0;i<MrnData.length;i++) {
			for(int j=0;j<MrnData[0].length;j++) {
				String MRN_Value = MrnData[i][j];
				allpp.getMRN_Filter().sendKeys(MRN_Value);
				wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				try {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[text()='"+MRN_Value+"']")));
				}catch(Exception e) {
					allpp.getMRN_Filter().clear();
					Reporter.log(MRN_Value+"---> Record Not Found/Already Deleted",true);
					continue;
				}
				Object_Utility.action_Utility_Instance().moveCursor(driver.findElement(By.xpath("//td[text()='"+MRN_Value+"']"))).leftClick();
				try {
					boolean b = driver.findElement(By.xpath("//td[contains(@class,'e-selectionbackground')] ")).isSelected();
					//Assert.assertTrue(b);
				}catch(Exception e) {
					Object_Utility.action_Utility_Instance().moveCursor(driver.findElement(By.xpath("//td[text()='"+MRN_Value+"']"))).leftClick();
				}
				allpp.getDelete().click();
				allpp.getDeletConfirm().click();
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='e-toast-message']")));
				ap.getPatientAddedMessage().isDisplayed();
				ap.getCloseMessage().click();
				String Actual = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td/span")).getText();
			//	Reporter.log(Actual+" No records to display",true);
				Reporter.log(MRN_Value+"--->Deleted Succesfully",true);
				Assert.assertEquals(Actual, "No records to display");
				//System.out.println("*******"+MRN_Value+" "+"Deleted Succesfully"+"*******");
				allpp.getMRN_Filter().clear();
			}
		}
	}
}
