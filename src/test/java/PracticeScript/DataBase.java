package PracticeScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {

	public static void main(String[] args) throws SQLException {
				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList al = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String url = "jdbc:sqlserver://DESKTOP-4RGFJ3E\\SQLEXPRESS;" + "databaseName=AIGCEMR;"+"encrypt=true;"+"trustServerCertificate=true;";
			
			String username = "sa";
			
			String Password = "ambalsoft@2010";
			con = DriverManager.getConnection(url,username,Password);
			System.out.println("Connected to Sql Server");
			stmt = con.createStatement();
			al = new ArrayList();
			rs = stmt.executeQuery("SELECT  [Id],[PatientID],[FirstName],[LastName],[DOB],[Gender],[MRN],[AadharNumber] FROM [AIGCEMR].[dbo].[PatientInfo]");
				while(rs.next()) {	
					int id = rs.getInt("id");
					String Firstname = rs.getString("FirstName");
					String lastName = rs.getString("LastName");
					String MRN = rs.getString("MRN");
					System.out.println(id + Firstname + lastName);
					al.add(MRN);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(al);
	}
}

