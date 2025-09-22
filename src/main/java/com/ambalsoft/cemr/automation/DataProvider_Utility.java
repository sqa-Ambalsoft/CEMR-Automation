package com.ambalsoft.cemr.automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class DataProvider_Utility {

	@DataProvider(name = "PatientDetial")
	public Object[][] patientData() throws EncryptedDocumentException, IOException{
		
		int RowSize = Object_Utility.excel_Utility_Instance().fetchRowSize("Sheet2",Iconstant.CommanData);
		 int CellSize = Object_Utility.excel_Utility_Instance().fetchRowSize("Sheet2",Iconstant.CommanData);
		Object[][] obj = new Object[RowSize][CellSize];
		
		obj = Object_Utility.excel_Utility_Instance().fetchExcelAll_Data(Iconstant.CommanData,"Sheet2");
		
		return obj;
	}
}
