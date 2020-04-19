package model;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Appointment {

	private Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hms", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

//Inserting the appointment details
	public String insertAppointment(String app_no, String app_type, String Doc_Id, String Doc_name,
			String hospital_name, String des) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into appointment(app_Id,app_no,app_type,Doc_Id,Doc_name,hospital_name,des)" + " values(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, app_no);
			preparedStmt.setString(3, app_type);
			preparedStmt.setString(4, Doc_Id);
			preparedStmt.setString(5, Doc_name);
			preparedStmt.setString(6, hospital_name);
			preparedStmt.setString(7, des);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully. Have a nice day !";
		} catch (Exception e) {
			output = "Error while inserting the item. Please Enter the details again";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readItems() {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Appointment Number</th><th>Appointment Type</th><th>Doctor Id</th><th>Doctor Name</th><th>Hospital Name</th><th>Item Description</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String app_Id = Integer.toString(rs.getInt("app_Id"));
				String app_no = rs.getString("app_no");
				String app_type = rs.getString("app_type");
				String doc_Id = rs.getString("doc_Id");
				String doc_name = rs.getString("doc_name");
				String hospital_name = rs.getString("hospital_name");
				String des = rs.getString("des");

				// Add into the html table
				output += "<tr><td>" + app_no + "</td>";
				output += "<td>" + app_type + "</td>";
				output += "<td>" + doc_Id + "</td>";
				output += "<td>" + doc_name + "</td>";
				output += "<td>" + hospital_name + "</td>";
				output += "<td>" + des + "</td>";

				// buttons
				
			}

			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Update Appointment

	public String updateAppointment(String app_Id,String app_no, String app_type, String Doc_Id, String Doc_name,
			String hospital_name, String des) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE appointment SET app_no=?,app_type=?,doc_Id=?,doc_name=?,hospital_name=?,des=? WHERE app_Id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, app_no);
			preparedStmt.setString(2, app_type);
			preparedStmt.setString(3, Doc_Id);
			preparedStmt.setString(4, Doc_name);
			preparedStmt.setString(5, hospital_name);
			preparedStmt.setString(6, des);
			preparedStmt.setString(7, app_Id);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the appointment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Deleting the appointment

	public String deleteAppointment(String app_Id) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from appointment where app_Id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(app_Id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
