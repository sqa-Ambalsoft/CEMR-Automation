package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='exampleInputEmail']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='exampleInputPassword']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueinstance;
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	private WebElement logOutDropDown;
	
	@FindBy(xpath = "//a[@class='bg-info text-white']")
	private WebElement Logout;
	
	public WebElement getLogOutDropDown() {
		return logOutDropDown;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public WebElement getContinueinstance() {
		return continueinstance;
	}

	public void setContinueinstance(WebElement continueinstance) {
		this.continueinstance = continueinstance;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
