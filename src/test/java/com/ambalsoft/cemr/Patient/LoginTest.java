package com.ambalsoft.cemr.Patient;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ambalsoft.cemr.automation.BaseClass;
import com.ambalsoft.cemr.automation.Object_Utility;

import Pom_Scripts.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTestCase() throws IOException {
		
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
}
