package com.ambalsoft.DataBase;

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
import com.ambalsoft.cemr.automation.DataBase_Utility;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.AllPatientPage;
import Pom_Scripts.CaptureItProPage;
import Pom_Scripts.HomePage;

public class Api_Testing extends BaseClass{

	/**
	 * This method is used to caputre the data from CP DataBase and it will verify
	 *the data is reflecting in CEMR  CEMR_DB--->CEMR--->CP_Patient
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void CEMR_DB_To_CEMR_CP() throws EncryptedDocumentException, IOException, InterruptedException {

		DataBase_Utility.AIGCEMR_DataFetch("Select TOP(10) MRN from dbo.patientinfo order by MRN desc","MRN");
		String[][] MRN_Data = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CEMR_DB, "Sheet1");
		System.out.println(Arrays.deepToString(MRN_Data));
		HomePage h = new HomePage(driver);
		h.getPatiens().click();
		CaptureItProPage cpp = new CaptureItProPage(driver);
		cpp.getCaptureItPro().click();
		Thread.sleep(2000);
		cpp.getListAll().click();
		for(int i=0;i<MRN_Data.length;i++) {
			for(int j=0;j<MRN_Data[1].length;j++) {
				cpp.getMrnFilter().sendKeys(MRN_Data[i][j]);		
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(25));
				w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[@class='e-row e-altrow']/td[text()='"+MRN_Data[i][j]+"']")));
				String MRN = driver.findElement(By.xpath("//tr[@class='e-row e-altrow']/td[text()='"+MRN_Data[i][j]+"']")).getText();
				Assert.assertEquals(MRN, MRN_Data[i][j]);
				Reporter.log("MRN :"+MRN+" Found",true);
				cpp.getMrnFilter().clear();

			}
		}
	}

	/**
	 * This method is used to retrive the data fro CaptureITPro dataBase and check
	 * in CEMR WebPage CP_DB--->CEMR--->All Patient
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void CP_DB_To_CEMR_ALL_Patient() throws EncryptedDocumentException, IOException, InterruptedException {
		DataBase_Utility.CaptureITPro_DataFetch("select TOP(10) HospitalID from dbo.Patient","HospitalID");
		String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CaptureITPro_DB, "Sheet1");
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		hp.getAllPatients().click();	
		AllPatientPage allpp = new AllPatientPage(driver);
		

		System.out.println(Arrays.deepToString(MrnData));
        System.out.println("Go and Delete The record in CP Manually within 20Seconds");
		Thread.sleep(20000);
		for(int i=0;i<MrnData.length;i++) {
			for(int j=0;j<MrnData[1].length;j++) {
				String MRN_Value = MrnData[i][j];
				allpp.getMRN_Filter().sendKeys(MRN_Value);
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+MRN_Value+"']")));
					String MRN_Actual = driver.findElement(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+MRN_Value+"']")).getText();
					Assert.assertEquals(MRN_Actual, MRN_Value);
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
	
	@Test
	public void testData() throws EncryptedDocumentException, IOException, InterruptedException {
		DataBase_Utility.AIGCEMR_DataFetch("SELECT TOP (10) ConsultingDoctor from dbo.PatientInfo","ConsultingDoctor");
		Thread.sleep(2000);
	    String[][] data = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CEMR_DB, "Sheet1");
	    System.out.println(Arrays.deepToString(data));
	}

}
