package model;

import java.sql.*;

public class Payment { // A common method to connect to the DB
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost/hms", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertPayments(String PayDate, String CustomerName, String Amount, String Description) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into payment (`PaymentID`, `PayDate`, `CustomerName`, `Amount`, `Description`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, PayDate);
			preparedStmt.setString(3, CustomerName);
			preparedStmt.setDouble(4, Double.parseDouble(Amount));
			preparedStmt.setString(5, Description);
			//execute the statement
			preparedStmt.execute();
			con.close();
			String newPayment = readPayment();
			output = "{\"status\":\"success\", \"data\": \"" + newPayment + "\"}";
		} catch (Exception e) {
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the Payments.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readPayment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>PayDate</th><th>CustomerName</th><th>Amount</th><th>Description</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
// iterate through the rows in the result set
			while (rs.next()) {
				String PaymentID = Integer.toString(rs.getInt("PaymentID"));
				String PayDate = rs.getString("PayDate");
				String CustomerName = rs.getString("CustomerName");
				String Amount = Double.toString(rs.getDouble("Amount"));
				String Description = rs.getString("Description");
// Add into the html table
				output += "<tr><td><input id='hidPaymentIDupdate' name='hidPaymentIDupdate' type='hidden' value='"+ PaymentID +"'>" + PaymentID + "</td>";
				output += "<td>" + PayDate + "</td>";
				output += "<td>" + CustomerName + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + Description + "</td>";

// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button'value='Remove'class='btnRemove btn btn-danger' data-paymentid='"+ PaymentID + "'>" + "</td></tr>"; 
				
				
			}
			con.close();
// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayments(String PaymentID, String PayDate, String CustomerName, String Amount,
			String Description) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
// create a prepared statement
			String query = "UPDATE payment SET PayDate=?, CustomerName=?, Amount=?, Description=? WHERE PaymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setString(1, PayDate);
			preparedStmt.setString(2, CustomerName);
			preparedStmt.setDouble(3, Double.parseDouble(Amount));
			preparedStmt.setString(4, Description);
			preparedStmt.setInt(5, Integer.parseInt(PaymentID));

// execute the statement
			preparedStmt.execute();
			con.close();
			String newPayment = readPayment();
			output = "{\"status\":\"success\", \"data\": \"" +newPayment + "\"}"; 
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Payments.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletePayments(String PaymentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from payment where PaymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, Integer.parseInt(PaymentID));
// execute the statement
			preparedStmt.execute();
			con.close();
			String newPayment = readPayment();
			 output = "{\"status\":\"success\", \"data\": \"" +newPayment + "\"}"; 
		} catch (Exception e) {
			output =  "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}

