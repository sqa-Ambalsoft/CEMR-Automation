package com.ambalsoft.cemr.captureitpropatient;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.CaptureItProPage;
import Pom_Scripts.HomePage;

public class RetrivePatient_Test extends BaseClass{

	@Test
	public void searchMrnPatient() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		CaptureItProPage cp = new CaptureItProPage(driver);	
		cp.getCaptureItPro().click();
		String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"CaputreItPatient");
		cp.getListAll().click();
		for(int i=0;i<MrnData.length;i++) {
			for(int j=0;j<MrnData[0].length;j++) {		 
				String data = MrnData[i][j];
				cp.getMrnFilter().sendKeys(data);
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[@class='e-rowcell e-lastrowcell ' and text()='"+data+"']")));
					cp.getMrnFilter().clear();
				}catch(Exception e) {
					String Norecord = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr/td/span")).getText();
					Assert.assertEquals(Norecord,"No records to display");
					Reporter.log(MrnData+"----->"+Norecord);
					cp.getMrnFilter().clear();
				}
			}
		}

	}
}
