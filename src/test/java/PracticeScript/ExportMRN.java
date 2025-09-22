package PracticeScript;

import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ambalsoft.cemr.automation.Iconstant;

public class ExportMRN {

//	 public static void main(String[] args) {
//		 String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;"
//                 + "databaseName=AIGCEMR;encrypt=true;trustServerCertificate=true;";
//      String user = "sa";
//      String pass = "ambalsoft@2010";
//
//      // 1) Sanity checks
//      String checkSql =
//          "SELECT DB_NAME() AS CurrentDB, " +
//          "       OBJECT_SCHEMA_NAME(OBJECT_ID('dbo.PatientInfo')) AS TblSchema, " +
//          "       OBJECT_ID('dbo.PatientInfo') AS TblId, " +
//          "       (SELECT COUNT(*) FROM dbo.PatientInfo) AS TotalRows, " +
//          "       (SELECT COUNT(*) FROM dbo.PatientInfo WHERE MRN IS NOT NULL) AS NonNullMRN";
//
//      // 2) Data query (TOP to keep it light)
//      String dataSql = "SELECT TOP(10) MRN FROM dbo.PatientInfo order by MRN desc"; // no WHERE so you see all rows
//      // If you only want non-null MRNs, use:
//      // String dataSql = "SELECT MRN FROM dbo.PatientInfo WHERE MRN IS NOT NULL";
//
//      try {
//          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//          try (Connection con = DriverManager.getConnection(url, user, pass)) {
//              // --- Sanity log ---
//              try (Statement s = con.createStatement();
//                   ResultSet r = s.executeQuery(checkSql)) {
//                  if (r.next()) {
//                      System.out.println("CurrentDB     : " + r.getString("CurrentDB"));
//                      System.out.println("Table schema  : " + r.getString("TblSchema"));
//                      System.out.println("Table exists? : " + (r.getObject("TblId") != null));
//                      System.out.println("Total rows    : " + r.getInt("TotalRows"));
//                      System.out.println("Non-null MRNs : " + r.getInt("NonNullMRN"));
//                  }
//              }
//
//              // --- Fetch + write Excel ---
//              try (PreparedStatement ps = con.prepareStatement(dataSql);
//                   ResultSet rs = ps.executeQuery();
//                   Workbook wb = new XSSFWorkbook()) {
//
//                  Sheet sheet = wb.createSheet("MRN");
//                  Row header = sheet.createRow(0);
//                  header.createCell(0).setCellValue("MRN");
//
//                  int r = 1;
//                  int seen = 0, written = 0;
//
//                  while (rs.next()) {
//                      seen++;
//                      // Try NVARCHAR-safe first; fall back if driver/version doesn’t support it
//                      String mrn;
//                      try {
//                          mrn = rs.getNString("MRN");
//                      } catch (SQLFeatureNotSupportedException nf) {
//                          mrn = rs.getString("MRN");
//                      }
//
//                      if (mrn != null) {
//                          Row row = sheet.createRow(r++);
//                          row.createCell(0).setCellValue(mrn);
//                          written++;
//                      }
//                  }
//
//                  sheet.autoSizeColumn(0);
//
//                  String outPath = Paths.get(Iconstant.Excel_MRNPath).toString();
//                  try (FileOutputStream fos = new FileOutputStream(outPath)) {
//                      wb.write(fos);
//                  }
//
//                  System.out.println("Rows seen     : " + seen);
//                  System.out.println("Rows written  : " + written);
//                  System.out.println("Excel saved to: " + outPath);
//
//                  if (seen == 0) {
//                      System.out.println("NOTE: Query returned 0 rows. Check table/data or schema.");
//                  } else if (written == 0) {
//                      System.out.println("NOTE: All MRN values were NULL (or filtered out).");
//                  }
//              }
//          }
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//	    }
}
