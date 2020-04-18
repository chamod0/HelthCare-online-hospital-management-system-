package model;

import java.sql.*;

//import com.mysql.jdbc.PreparedStatement.*;
//import com.mysql.jdbc.Statement;

public class Users {
	
	public Connection connect(){
	 Connection con = null;

		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 //I used 3308 Port for SQL in Phpmyadmin
			 con= DriverManager.getConnection("jdbc:mysql://localhost/hms", "root", "");
			 
			 System.out.print("Successfully connected to the Database!");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println("There is an Error Connecting to the Database!");
		 }

	 		return con;
	
	 }
	public String insertUser(String firstname, String lastname, String usremail, String usrnic, String usrphone, String usrpassword, String usrconfirmPass) {
		
		String output = "";
		
		try
		 {
				Connection con = connect();
				if (con == null)
				{
						return "Error while connecting to the database";
				}
			 
				 String query = " INSERT INTO user(fName,lName,email,nic, phone, password, confirmPass)" + " values (? ,?, ?, ?, ?, ?, ?)";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				//preparedStmt.setInt(1, 0);
				preparedStmt.setString(1, firstname);
				preparedStmt.setString(2, lastname);
				preparedStmt.setString(3, usremail);
				preparedStmt.setString(4, usrnic);
				preparedStmt.setString(5, usrphone);
				preparedStmt.setString(6, usrpassword);
				preparedStmt.setString(7, usrconfirmPass);
				 
				//execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Inserted successfully";
				 
				 System.out.println("\nData Inserted Successfully!");
		 }
		
		catch (Exception e) {
			// TODO: handle exception
			 output = "Error while inserting";
			 System.err.println(e.getMessage()); 
		}
		return output;
	}
	
	public String readUser(){
		String output = ""; 
		
		try
		 { 
			Connection con = connect();
			 if (con == null)
			 {
			 return "Error while connecting to the database for reading.";
			 } 
			 
			 output = "<table border=\"1\">"
			 		 + "<tr>"
			 		 + "<th>User ID</th>"
					 + "<th> First Name</th>"
					 + "<th>Last Name</th>"
					 + "<th> Email</th>"
					 + "<th> NIC</th>"
					 + "<th> Phone Number</th>"
					 + "<th> Password</th>"
					 //+ "<th>User Confirm Password</th>"
					 //+ "<th>Update</th><th>Remove</th>"
					 + "</tr>"; 
			 
			 String query = "SELECT * FROM user";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query); 
			
			 while (rs.next())
			 { 
				 String userID = Integer.toString(rs.getInt("userID"));
				 String firstName = rs.getString("fName");
				 String lastName = rs.getString("lname");
				 String usremail =  rs.getString("email");
				 String usrnic = rs.getString("nic");
				 String usrphone = rs.getString("phone");
				 String usrpass = rs.getString("password");
				// String confirmpass = rs.getString("confirmPass");
				 
				 
				 output += "<tr>" + "<td>" + userID + "</td>";
				 output += "<td>" + firstName + "</td>"; 
				 output += "<td>" + lastName + "</td>"; 
				 output += "<td>" + usremail + "</td>"; 
				 output += "<td>" + usrnic + "</td>"; 
				 output += "<td>" + usrphone + "</td>"; 
				 output += "<td>" + usrpass + "</td>"; 
				 
				
			 }
			 
			 con.close();
			 // Complete the html table
			 output += "</table>";
		 }
		catch (Exception e) {
			// TODO: handle exception
				output = "Error while reading the items.";
				System.err.println(e.getMessage());
		}
		
		return output; 
		
	}
	
	public String deleteUser(String userID)
	{
		String output = "";
		try
		 {
				Connection con = connect();
				if (con == null)
				{
						return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "DELETE FROM user WHERE userID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(userID));
	
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 System.out.println("Successfully Deleted! ");
					 output = "Successfully Deleted! ";
		 }
		catch (Exception e)
		{
				 output = "\nError while deleting the item.";
				 System.err.println(output);
		}
			return output;
	}
	
	public String UpdateUser(String userID, String firstname, String lastname, String usremail, String usrnic, String usrphone, String usrpassword, String usrconfirmPass)
	{	
		String output = ""; 
		
		PreparedStatement preparedStmt1 = null;
		try
		 {
				Connection con = connect();
				
				// create a prepared statement
				//String query = "update user set fName = ?, lName = ?,email = ?, nic = ? , phone = ?, password = ? , confirmPass = ?  where userID=?";
				preparedStmt1 = con.prepareStatement("UPDATE user SET fName=?, lName=?,email=?, nic=? , phone=?, password=? , confirmPass=?  WHERE userID=?");
				// binding values
				
				preparedStmt1.setString(1, firstname);
				preparedStmt1.setString(2, lastname);
				preparedStmt1.setString(3, usremail);
				preparedStmt1.setString(4, usrnic);
				preparedStmt1.setString(5, usrphone);
				preparedStmt1.setString(6, usrpassword);
				preparedStmt1.setString(7, usrconfirmPass);
				preparedStmt1.setString(8, userID);
	
					 // execute the statement
					 preparedStmt1.execute();
					 //con.close();
					 //System.out.println("\n Successfully Updated Data! ");
					 output = "Updated successfully";
		 }
		catch (Exception e)
		{
				 output = "Error while deleting the item.";
				 System.err.println(output);
		}
			return output;
	}
	
	
	
	
	public static void main(String args []) {
		Users ins = new Users();
		//conn.connect();
		
		//ins.insertUser("bb", "nnn", "kkk", "sss", "aaa", "sss", "sss");
		//ins.readUser();
		//ins.deleteUser("8");
		ins.UpdateUser( "2", "ppaass", "111", "sss", "sssdw", "ff", "sss", "ccc");
		
	
	}
    
   
}
