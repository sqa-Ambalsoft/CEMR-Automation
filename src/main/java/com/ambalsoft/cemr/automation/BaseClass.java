package com.ambalsoft.cemr.automation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Pom_Scripts.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public Connection con;
	public Statement stmt;
	public ResultSet rs;

	@BeforeSuite
	public void connectServer() {
		Reporter.log("Connection to the server",true);
	}

	@BeforeTest
	public void connectDB() {
		Reporter.log("Connection to the Data Base",true);
		 con = null;
	     stmt = null;
		 rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;" + "databaseName=AIGCEMR;"+"encrypt=true;"+"trustServerCertificate=true;";

			String username = "sa";

			String Password = "ambalsoft@2010";
			con = DriverManager.getConnection(url,username,Password);
			System.out.println("Connected to Sql Server");
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		Object_Utility.webDriver_Utility_Instance().maximize();
		Object_Utility.webDriver_Utility_Instance().waitForElementInDOM(15);
		String url = Object_Utility.getProperty_Utility_Instance().fetchPropertyData("url");
		Object_Utility.webDriver_Utility_Instance().navigateBrowser(url);
		Object_Utility.webDriver_Utility_Instance().waitForPage(url);
		LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("username"));
		lp.getPassword().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("password"));
		lp.getLoginButton().click();
		try {
			lp.getContinueinstance().click();
		}catch(Exception e) {
			Reporter.log("Instance Not Logout");
		}
	}
	@BeforeMethod
	public void login() throws IOException {
		//		LoginPage lp = new LoginPage(driver);
		//
		//		lp.getUsername().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("username"));
		//		lp.getPassword().sendKeys(Object_Utility.getProperty_Utility_Instance().fetchPropertyData("password"));
		//		lp.getLoginButton().click();
		//		try {
		//			lp.getContinueinstance().click();
		//		}catch(Exception e) {
		//			Reporter.log("Instance Not Logout");
		//		}
	}


	@AfterMethod
	public void logOut() {

	}
	@AfterClass
	public void closeBrowser() {
		//  Object_Utility.webDriver_Utility_Instance().close();
	}

	@AfterTest
	public void disconnectDB() {
		Reporter.log("Disconnection from the Data Base",true);
		try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
		try { if (stmt != null) stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		try { if (con != null) con.close(); } catch (Exception e) { e.printStackTrace(); }
		System.out.println("DB Connection Closed");
	}


	@AfterSuite
	public void disconnectServer() {
		Reporter.log("Disconnection from the server",true);
	}
}
