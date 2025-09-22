package PracticeScript;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.DataBase_Utility;
import com.ambalsoft.cemr.automation.Iconstant;
import com.ambalsoft.cemr.automation.Object_Utility;

public class Program {

	@Test(enabled = false)
	public void testCase() throws InterruptedException {
		
//		driver.findElement(By.xpath("//li[@data-uid='03']/div[@class='e-fullrow']")).click();
//		driver.findElement(By.xpath("//a[text()='Book Appointment']")).click();
//		driver.findElement(By.xpath("//td[@class='e-header-cells e-date-header e-current-day']")).click();
//		 String currentTime = driver.findElement(By.xpath("//div[@class='e-current-time']")).getText();
//		 Object_Utility.javaScript_Utility_Instance().scrollElement(driver.findElement(By.xpath("//div[@class='e-current-time']")));
//		 Object_Utility.action_Utility_Instance().doubleClick(driver.findElement(By.xpath("Tuesday, 16 September 2025 11:15:00 Ends At Tuesday, 16 September 2025 11:30:00")));
//		 Object_Utility.javaScript_Utility_Instance().extremeTop();
//		 Thread.sleep(2000);
//		 
//		 driver.findElement(By.xpath("//span[@class='e-icons e-frame']")).click();
//		 
//		 driver.findElement(By.xpath("//td[text()='Patient Name']/following-sibling::td/span/input")).sendKeys("JaiSai");
//		 
//		 driver.findElement(By.xpath("//td[text()='Mobile Number']/following-sibling::td/span/input")).sendKeys("987684656");
//		 
//		 driver.findElement(By.xpath("//input[@id='Doctor']/following-sibling::span[@class='e-input-group-icon e-ddl-icon e-icons e-ddl-disable-icon']")).click();
//		 
//		 driver.findElement(By.xpath("//li[@id='Doctor_0']")).click();
//		 
//		 driver.findElement(By.xpath("//input[@id='AppointmentStatus']/following-sibling::span[contains(@class,'e-input-group-icon e-ddl-icon')]")).click();
//		 
//		 driver.findElement(By.xpath("//li[@id='AppointmentStatus_0']")).click();
//		 
//		 driver.findElement(By.xpath("//input[@id='AppointmentType']/following-sibling::span[contains(@class,'e-input-group-icon')]")).click();
//		 
//		 driver.findElement(By.xpath("//li[@id='AppointmentType_1']")).click();
//		 
//		 Object_Utility.javaScript_Utility_Instance().extremeBottum();
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@id='Investigation']/following-sibling::span[contains(@class,'e-input-group-icon')]")).click();
//		 driver.findElement(By.xpath("//li[text()='laproscopy']")).click();
//		 
//		 driver.findElement(By.xpath("//td[text()='Location']/following-sibling::td/span/input")).sendKeys("Chennai");
//		 
//		 driver.findElement(By.xpath("//td[text()='Comments']/following-sibling::td/span/textarea")).sendKeys("Hi How Are u ?");
//		 
//		 Reporter.log(currentTime,true); 
//		 
	}
	
//	@Test
//	public void m1() throws EncryptedDocumentException, IOException {
//		String[][] MrnData = Object_Utility.excel_Utility_Instance().fetchExcelCP_Data_MRN("HospitalID",Iconstant.CaptureITPro_DB);
//		System.out.println(Arrays.deepToString(MrnData));
//		 Object_Utility.excel_Utility_Instance().fetchRowSize("HospitalID",Iconstant.CaptureITPro_DB);
//		DataBase_Utility.CaptureITPro_DataFetch();
//	}
	
}
