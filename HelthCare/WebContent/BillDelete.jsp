<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
	String Bno = request.getParameter("Bno");
	int no = Integer.parseInt(Bno);
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "hasindu");
	Statement stat = conn.createStatement();
	stat.executeUpdate("delete from billtable where Bno ='" + Bno + "'");
	response.sendRedirect("BillDetails.jsp");
%>