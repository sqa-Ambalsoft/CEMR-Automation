package com.ambalsoft.cemr.Appoitment;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Java_Utility;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.Appoitment_Page;
import Pom_Scripts.ConsultationPage;
import Pom_Scripts.View_All_Patient;

public class BookAppoitmentTest extends BaseClass {


	@Test
	public void bookAppoitment() throws InterruptedException {
		Appoitment_Page ap = new Appoitment_Page(driver);
		ap.getAppointment().click();
		ap.getBookAppoitment().click();
		ap.getCurrentDay().click();
		Thread.sleep(2000);
		Object_Utility.javaScript_Utility_Instance().extremeBottum();
		Object_Utility.action_Utility_Instance().doubleClick(driver.findElement(By.xpath("//td[contains(@aria-label,'"+Java_Utility.currentLocalDateTime()+"')]")));
		Thread.sleep(2000);
		Object_Utility.javaScript_Utility_Instance().extremeTop();
		Thread.sleep(2000);
		ap.getNewPatientCheckBox().click();
		ap.getPatientName().sendKeys("Sanjay");
		ap.getMobileNumber().sendKeys("984563782");
		ap.getDoctorList().click();
		ap.getDrKayal().click();
		ap.getAppoitmentStatus().click();
		ap.getNewStatus().click();
		Object_Utility.javaScript_Utility_Instance().extremeBottum();
		Thread.sleep(2000);
		ap.getAppoitmentType().click();
		ap.getFollowUp().click();
		ap.getInvestigation().click();
		ap.getLaproscopy().click();
		ap.getLocation().sendKeys("Chennai");
		ap.getCommentText().sendKeys("Hii Your Appoitment is on the way");
		ap.getSave().click();
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "bookAppoitment")
	public void ViewAllAppoitment() throws InterruptedException {
		View_All_Patient vap = new View_All_Patient(driver);
		vap.getViewAllPatient().click();
		vap.getPatientList().click();
		Object_Utility.action_Utility_Instance().rightClick(vap.getPatientList());
		vap.getInTime().click();
		Thread.sleep(5000);
		Object_Utility.javaScript_Utility_Instance().extremeBottum();
		Thread.sleep(5000);
		vap.getSaveChanges().click();
		Thread.sleep(10000);
		Object_Utility.action_Utility_Instance().moveCursor(vap.getPatientList()).pause(5).leftClick();
		Thread.sleep(1000);
		Object_Utility.action_Utility_Instance().pause(5).rightClick(vap.getPatientList());
		vap.getActualStartTime().click();
		Object_Utility.javaScript_Utility_Instance().extremeTop();


		ConsultationPage cp = new ConsultationPage(driver);

		System.out.println("1)   LAB");
		System.out.println("2)   Imaging");
		System.out.println("3)   Dashboard");
		System.out.println("4)   Compliants");
		System.out.println("5)   Pre-Consultation");
		System.out.println("6)   Examination");
		System.out.println("7)   Diagnosis");
		System.out.println("8)   Medication");
		Scanner sc = new Scanner(System.in);

		int option = sc.nextInt();

		switch(option) {

		case 1:{
			cp.getLab().click();

		}
		break;
		case 2:{
			cp.getImaging().click();

		}
		break;
		case 3:{
			cp.getDashBoard().click();

		}
		break;
		case 4:{
			cp.getComplaints().click();

			boolean b = true;
			while(b){
				System.out.println("    Add");
				System.out.println("    Edit");
				System.out.println("    Delete");
				System.out.println("    Update");
				System.out.println("    Cancel");
				System.out.println("    Excel Export");
				System.out.println("    Csv Export");
				System.out.println("    Pdf EXport");
				System.out.println("    Exit");
				Scanner complaints = new Scanner(System.in);
				String CmpOption = complaints.next();
				Scanner detial = new Scanner(System.in);
				switch(CmpOption) {  

				case "Add" :{
					cp.getComplaint_Add().click();

					System.out.println("Enter The Complaint");

					System.out.println("Fever");
					System.out.println("Throat Pain");
					System.out.println("Diarrhea");
					Scanner CmpList = new Scanner(System.in);
					String cl = CmpList.next();
					switch(cl) {

					case "Fever" :{
						cp.getComplaint_DropDown().click();
						cp.getFeverComplaint().click();

					}
					break;
					case "Throat Pain":{
						cp.getComplaint_DropDown().click();
						cp.getThroatPainComplaint().click();

					}
					break;
					case "Diarrhea":{
						cp.getComplaint_DropDown().click();
						cp.getDiarrheaComplaint().click();

					}
					}

					System.out.println("Enter The Duration");
					cp.getComplaintDuration().sendKeys(detial.next());

					System.out.println("Enter The Comments");
					cp.getComplaintComments().sendKeys(detial.next());

				}
				break;

				case "Edit" :{
					cp.getComplaint_Edit().click();
				}
				break;
				case "Delete" :{
					driver.findElement(By.xpath("//tr[@data-rowindex='0']")).click();

					cp.getComplaint_Delete().click();
					driver.findElement(By.xpath("//span[text()='Delete']")).click();
					driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();
				}
				break;
				case "Update":{
					cp.getComplaint_Update().click();
				}
				break;
				case "Excel Export":{
					cp.getCompliant_ExcelExport().click();
				}
				break;
				case "Csv Export":{
					cp.getComplaint_CsvExport().click();	
				}
				break;
				case "Pdf EXport":{
					cp.getPdf_Export().click();	
				}
				break;
				case "Exit" :{
					b = false;
					break;
				}


				}

			}//while loop
		}
		break;
		case 5:{
			cp.getPre_consultation().click();
			driver.findElement(By.xpath("//div[text()='Pre-Consultation']")).click();
		}
		break;
		case 6:{
			cp.getExamination().click();
			driver.findElement(By.xpath("//div[text()='Examination']")).click();
		}
		break;
		case 7:{
			cp.getDiagnosis().click();
			driver.findElement(By.xpath("//div[text()='Diagnosis']")).click();
		}
		break;
		case 8:{
			cp.getMedication().click();
			driver.findElement(By.xpath("//div[text()='Medication']")).click();
		}
		break;
		default:{
			System.out.println("Invalid Option");
		}
		}

	}



}
