<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "java.sql.*" %>
 
 

 <%
 String firstname = request.getParameter("fname");
 String lastname = request.getParameter("lname"); 
 String email = request.getParameter("email");
 String nic = request.getParameter("nic");
 String phone = request.getParameter("phone");
 String pass = request.getParameter("pass");
 String confirmpass = request.getParameter("confirmpass");
 
 try{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/users?useSSL=false", "paf", "");
	 PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO user(fName,lName,email,nic, phone, password, confirmPass)" + " values (? ,?, ?, ?, ?, ?, ?)");
	    preparedStmt.setString(1, firstname);
		preparedStmt.setString(2, lastname);
		preparedStmt.setString(3, email);
		preparedStmt.setString(4, nic);
		preparedStmt.setString(5, phone);
		preparedStmt.setString(6, pass);
		preparedStmt.setString(7, confirmpass);
		
		int x = preparedStmt.executeUpdate();
		if(x > 0 ){
			out.print("User Registered Successfully");
		}
		
		
 }
 catch (Exception e) {
		// TODO: handle exception
		 //output = "Error while inserting";
		 System.err.println(e.getMessage()); 
	}
 %>