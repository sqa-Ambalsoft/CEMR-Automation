package com.ambalsoft.cemr.captureitpropatient;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;

import Pom_Scripts.CaptureItProPage;
import Pom_Scripts.HomePage;

public class DownloadPatientRecordTest extends BaseClass {

	@Test(priority = -1)
	public void preSteps() throws AWTException {
		
		HomePage hp = new HomePage(driver);
		hp.getPatiens().click();
		CaptureItProPage cp = new CaptureItProPage(driver);	
		cp.getCaptureItPro().click();
	}
	@Test
	public void excelExport() {
		CaptureItProPage cp = new CaptureItProPage(driver);
		cp.getExcelExport().click();
	}
	@Test
	public void csvExport() {
		CaptureItProPage cp = new CaptureItProPage(driver);
		cp.getCsvExport().click();
	}
	@Test
	public void pdfExport() throws AWTException, InterruptedException {
		CaptureItProPage cp = new CaptureItProPage(driver);
		cp.getPdfExport().click();
		Thread.sleep(2000);
		Robot r = new Robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
