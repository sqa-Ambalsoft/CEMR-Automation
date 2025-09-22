package PracticeScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Object_Utility;
import com.google.common.io.Files;

import Pom_Scripts.Add_Patient_Page;
import Pom_Scripts.HomePage;

public class Program1 extends BaseClass {
	
	@Test(priority = 0)
	public void testCase() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://equery.irctc.co.in/irctc_equery/login");
		Thread.sleep(3000);
		Object_Utility.webDriver_Utility_Instance().waitForElement(driver.findElement(By.xpath("//img[@alt='CAPTCHA']")), 20);
		WebElement captcha = driver.findElement(By.xpath("//img[@alt='CAPTCHA']"));
		 File source = captcha.getScreenshotAs(OutputType.FILE);
		 File destination = new File("C:\\Users\\SQA_TESTING_PC\\eclipse-workspace\\cemr.automation\\ErrorShot\\Captch.png");
		 Files.copy(source, destination);
	}
	
	@Test
	public void test() throws InterruptedException {
		//HomePage ap = new HomePage(driver);
		driver.findElement(By.xpath("//div[@role='combobox']/label[@id='label_title']/following-sibling::span")).click();
		driver.findElement(By.xpath("//li[@id='title_0']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("babu");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("rajan");
		Thread.sleep(1000);
		Object_Utility.action_Utility_Instance().leftClick(driver.findElement(By.xpath("//label[@id='label_dob']")));

		//driver.findElement(By.xpath("//label[@id='label_dob']")).sendKeys("12/04/2013");

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("30071993");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='gender']/following-sibling::label/following-sibling::span")).click();
		driver.findElement(By.xpath("//li[@id='gender_0']")).click();
	//	driver.findElement(By.xpath("//label[@id='label_dob']")).sendKeys("12/04/2013");
		Object_Utility.javaScript_Utility_Instance().scrollUp(0, 1000);
	}
	
	@Test
	public void testData() throws EncryptedDocumentException, IOException {
//		String data = Object_Utility.excel_Utility_Instance().fetchExcelSingle_Data(0, 4,"Sheet2");
//		System.out.println(data);
	}
	
	@Test
	public void allPatient() throws InterruptedException {
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//li[@data-uid='02']/div[@class='e-fullrow']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//a[text()='All Patients']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[text()='Add']")).click();
	   
		Thread.sleep(1000);
		HomePage hp = new HomePage(driver);
		Add_Patient_Page ap = new Add_Patient_Page(driver);
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
		
	}
	
}
