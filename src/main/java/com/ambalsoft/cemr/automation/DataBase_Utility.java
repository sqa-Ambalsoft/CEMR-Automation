package com.ambalsoft.cemr.automation;

import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataBase_Utility {
/**
 * This Method is used to fetch the data from AIGCEMR_DB and store inside CEMR_DB.xlsx
 * @param Sql_Qurey
 * @param coloumnName
 */
	public static void AIGCEMR_DataFetch(String Sql_Qurey,String coloumnName) {
		 String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;"
                + "databaseName=AIGCEMR;encrypt=true;trustServerCertificate=true;";
     String user = "sa";
     String pass = "ambalsoft@2010";

     // 1) Sanity checks
     String checkSql =
         "SELECT DB_NAME() AS CurrentDB, " +
         "       OBJECT_SCHEMA_NAME(OBJECT_ID('dbo.PatientInfo')) AS TblSchema, " +
         "       OBJECT_ID('dbo.PatientInfo') AS TblId, " +
         "       (SELECT COUNT(*) FROM dbo.PatientInfo) AS TotalRows, " +
         "       (SELECT COUNT(*) FROM dbo.PatientInfo WHERE MRN IS NOT NULL) AS NonNullMRN";

     // 2) Data query (TOP to keep it light)
     String dataSql = ""+Sql_Qurey+""; // no WHERE so you see all rows
     // If you only want non-null MRNs, use:
     // String dataSql = "SELECT MRN FROM dbo.PatientInfo WHERE MRN IS NOT NULL";

     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

         try (Connection con = DriverManager.getConnection(url, user, pass)) {
             // --- Sanity log ---
             try (Statement s = con.createStatement();
                  ResultSet r = s.executeQuery(checkSql)) {
                 if (r.next()) {
                     System.out.println("CurrentDB     : " + r.getString("CurrentDB"));
                     System.out.println("Table schema  : " + r.getString("TblSchema"));
                     System.out.println("Table exists? : " + (r.getObject("TblId") != null));
                     System.out.println("Total rows    : " + r.getInt("TotalRows"));
                     System.out.println("Non-null MRNs : " + r.getInt("NonNullMRN"));
                 }
             }

             // --- Fetch + write Excel ---
             try (PreparedStatement ps = con.prepareStatement(dataSql);
                  ResultSet rs = ps.executeQuery();
                  Workbook wb = new XSSFWorkbook()) {

                 Sheet sheet = wb.createSheet("Sheet1");
                 
                 /*
                  * if u want header to create in excel sheet then use this steps
                  * 
                  * Row header = sheet.createRow(0);
                    header.createCell(0).setCellValue(coloumnName);
                    
                    int r = 1;
                  */
               

                 int r = 0;  // start at first row; no header
                 int seen = 0, written = 0;

                 while (rs.next()) {
                     seen++;
                     // Try NVARCHAR-safe first; fall back if driver/version doesn’t support it
                     String mrn;
                     try {
                         mrn = rs.getNString(coloumnName);
                     } catch (SQLFeatureNotSupportedException nf) {
                         mrn = rs.getString(coloumnName);
                     }

                     if (mrn != null) {
                         Row row = sheet.createRow(r++);
                         row.createCell(0).setCellValue(mrn);
                         written++;
                     }
                 }

                 sheet.autoSizeColumn(0);

                 String outPath = Paths.get(Iconstant.CEMR_DB).toString();
                 try (FileOutputStream fos = new FileOutputStream(outPath)) {
                     wb.write(fos);
                 }

                 System.out.println("Rows seen     : " + seen);
                 System.out.println("Rows written  : " + written);
                 System.out.println("Excel saved to: " + outPath);

                 if (seen == 0) {
                     System.out.println("NOTE: Query returned 0 rows. Check table/data or schema.");
                 } else if (written == 0) {
                     System.out.println("NOTE: All MRN values were NULL (or filtered out).");
                 }
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
	    }
	
	/**
	 * This method is used to fetch the data from CP_DB and store in CaptureITPro_DB.xlsx
	 * @param sqlQuery
	 * @param ColumnName
	 */
	public static void CaptureITPro_DataFetch(String sqlQuery,String ColumnName) {
		 String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;"
               + "databaseName=CaptureITProDB;encrypt=true;trustServerCertificate=true;";
    String user = "sa";
    String pass = "ambalsoft@2010";

    // 1) Sanity checks
    String checkSql =
        "SELECT DB_NAME() AS CurrentDB, " +
        "       OBJECT_SCHEMA_NAME(OBJECT_ID('dbo.Patient')) AS TblSchema, " +
        "       OBJECT_ID('dbo.Patient') AS TblId, " +
        "       (SELECT COUNT(*) FROM dbo.Patient) AS TotalRows, " +
        "       (SELECT COUNT(*) FROM dbo.Patient WHERE HospitalID IS NOT NULL) AS NonNullMRN";

    // 2) Data query (TOP to keep it light)
    String dataSql = sqlQuery; // no WHERE so you see all rows
    // If you only want non-null MRNs, use:
    // String dataSql = "SELECT MRN FROM dbo.PatientInfo WHERE MRN IS NOT NULL";

    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            // --- Sanity log ---
            try (Statement s = con.createStatement();
                 ResultSet r = s.executeQuery(checkSql)) {
                if (r.next()) {
                    System.out.println("CurrentDB     : " + r.getString("CurrentDB"));
                    System.out.println("Table schema  : " + r.getString("TblSchema"));
                    System.out.println("Table exists? : " + (r.getObject("TblId") != null));
                    System.out.println("Total rows    : " + r.getInt("TotalRows"));
                    System.out.println("Non-null MRNs : " + r.getInt("NonNullMRN"));
                }
            }

            // --- Fetch + write Excel ---
            try (PreparedStatement ps = con.prepareStatement(dataSql);
                 ResultSet rs = ps.executeQuery();
                 Workbook wb = new XSSFWorkbook()) {

                Sheet sheet = wb.createSheet("Sheet1");
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Sheet1");

                int r = 1;
                int seen = 0, written = 0;

                while (rs.next()) {
                    seen++;
                    // Try NVARCHAR-safe first; fall back if driver/version doesn’t support it
                    String mrn;
                    try {
                        mrn = rs.getNString(ColumnName);
                    } catch (SQLFeatureNotSupportedException nf) {
                        mrn = rs.getString(ColumnName);
                    }

                    if (mrn != null) {
                        Row row = sheet.createRow(r++);
                        row.createCell(0).setCellValue(mrn);
                        written++;
                    }
                }

                sheet.autoSizeColumn(0);

                String outPath = Paths.get(Iconstant.CaptureITPro_DB).toString();
                try (FileOutputStream fos = new FileOutputStream(outPath)) {
                    wb.write(fos);
                }

                System.out.println("Rows seen     : " + seen);
                System.out.println("Rows written  : " + written);
                System.out.println("Excel saved to: " + outPath);

                if (seen == 0) {
                    System.out.println("NOTE: Query returned 0 rows. Check table/data or schema.");
                } else if (written == 0) {
                    System.out.println("NOTE: All MRN values were NULL (or filtered out).");
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	    }
}
