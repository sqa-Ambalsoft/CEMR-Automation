package Pom_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllPatientPage extends BasePage {

	public AllPatientPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement Add;
	
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement Edit;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement Delete;
	
	@FindBy(xpath = "//span[text()='Excel Export']")
	private WebElement ExcelExport;
	
	@FindBy(xpath = "//span[text()='CSV Export']")
	private WebElement CsvExport;
	
	@FindBy(xpath = "PDF Export")
	private WebElement PdfExport;
	
	@FindBy(xpath = "//span[text()='Columns']")
	private WebElement ColumnFilter;

	@FindBy(xpath = "//input[@id='MRN_filterBarcell']")
	private WebElement MRN_Filter;
	
	@FindBy(xpath = "//div[@class='e-gridcontent']/div/table/tbody/tr/td[@aria-colindex='3']")
	private WebElement FilterRow;
	
	@FindBy(xpath = "")
	private WebElement Fetch_Filter;
	public WebElement getFilterRow() {
		return FilterRow;
	}

	public WebElement getMRN_Filter() {
		return MRN_Filter;
	}

	public WebElement getAdd() {
		return Add;
	}

	public WebElement getEdit() {
		return Edit;
	}

	public WebElement getDelete() {
		return Delete;
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

	public WebElement getColumnFilter() {
		return ColumnFilter;
	}
	
	@FindBy(xpath = "//button[contains(@class,'e-control e-btn e-lib e-flat   e-primary')]")
	private WebElement deletConfirm;
	public WebElement getFetch_Filter() {
		return Fetch_Filter;
	}

	public WebElement getDeletConfirm() {
		return deletConfirm;
	}
	
}
