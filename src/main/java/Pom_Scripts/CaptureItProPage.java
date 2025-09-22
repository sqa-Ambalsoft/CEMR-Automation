package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaptureItProPage extends BasePage {

	public CaptureItProPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//a[text()='CaptureITPro Patients List']")
	private WebElement captureItPro;
	public WebElement getCaptureItPro() {
		return captureItPro;
	}
	@FindBy(xpath = "//span[text()='Synchronize']")
	private WebElement Synchronize;
	@FindBy(xpath = "//button[text()=' Import From USB']")
	private WebElement importFromUsb;
	@FindBy(xpath = "//button[contains(text(),'Today')]")
	private WebElement TodaysVisit;
	public WebElement getSynchronize() {
		return Synchronize;
	}
	public WebElement getImportFromUsb() {
		return importFromUsb;
	}
	public WebElement getTodaysVisit() {
		return TodaysVisit;
	}
	public WebElement getListAll() {
		return ListAll;
	}
	public WebElement getExcelExport() {
		return ExcelExport;
	}
	public WebElement getCsvExport() {
		return CsvExport;
	}
	public WebElement getPdfExport() {
		return PdfExport;
	}
	public WebElement getColumnsDrop() {
		return columnsDrop;
	}
	public WebElement getMrnFilter() {
		return MrnFilter;
	}

	@FindBy(xpath = "//button[text()='List all']")
	private WebElement ListAll;
	@FindBy(xpath = "//span[text()='Excel Export']")
	private WebElement ExcelExport;
	@FindBy(xpath = "//span[text()='CSV Export']")
	private WebElement CsvExport;
	@FindBy(xpath = "//span[text()='PDF Export']")
	private WebElement PdfExport;
	@FindBy(xpath = "//span[@class='e-columnchooser-btn e-icons e-btn-icon e-icon-right']")
	private WebElement columnsDrop;
	@FindBy(xpath = "//input[@id='MRN_filterBarcell']")
	private WebElement MrnFilter;
	
	
}
