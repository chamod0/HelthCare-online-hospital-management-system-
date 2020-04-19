<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%!String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/hms";%>
<%!String user = "root";%>
<%!String psw = "hasindu";%>
<%
	String Bno = request.getParameter("Bno");

	String date = request.getParameter("date");

	double HCid = Double.parseDouble(request.getParameter("HCid"));

	double DCid = Double.parseDouble(request.getParameter("DCid"));

	double OCid = Double.parseDouble(request.getParameter("OCid"));

	double TBid = Double.parseDouble(request.getParameter("TBid"));

	if (Bno != null) {
		Connection con = null;
		PreparedStatement ps = null;
		int personID = Integer.parseInt(Bno);
		try {
			Class.forName(driverName);

			con = DriverManager.getConnection(url, user, psw);
			String sql = "Update billtable set Bno=?,date=?,HCid=?,DCid=?,OCid=?,TBid=?  where Bno=" + personID;
			ps = con.prepareStatement(sql);

			ps.setInt(1, personID);

			ps.setString(2, date);

			ps.setDouble(3, HCid);

			ps.setDouble(4, DCid);

			ps.setDouble(5, OCid);

			ps.setDouble(6, TBid);

			int i = ps.executeUpdate();
			if (i > 0) {

				out.println(
						"<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println(
						"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Bill Details Update Successfull' ,  '' ,  'success' );");
				out.println("});");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/BillDetails.jsp");
				rd.include(request, response);
			} else {
				out.print("There is a problem in updating Record.");

			}
		} catch (SQLException sql) {
			request.setAttribute("error", sql);
			out.println(sql);
		}
	}
%>
