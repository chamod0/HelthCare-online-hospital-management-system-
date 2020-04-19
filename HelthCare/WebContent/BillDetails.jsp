<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "hms";
	String userid = "root";
	String password = "hasindu";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<html>
<head>
<style>
h1 {
	text-align: center;
	text-transform: uppercase;
	color: #4CAF50;
}
</style>

<title>Bill Details</title>
</head>
<body>

	<header class="templatemo-site-header">
		<h1>HOSPITAL MANAGEMENT SYSTEM</h1>
	</header>


	<h2 class="margin-bottom-10">Bill Details</h2>

	<form class="form-inline" action="BillSearch.jsp">
		<input class="form-control mr-sm-2" type="search"
			placeholder="Search..." aria-label="Search" name="search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>


	<h3>Bill Details</h3>

	<div class="table">
		<table id="mytable" class="table table-bordred table-striped">

			<thead>
				<tr>
					<th scope="col">Bill No</th>
					<th scope="col">Billing Date</th>
					<th scope="col">Hospital Chargers</th>
					<th scope="col">Doctor Chargers</th>
					<th scope="col">Other Chargers</th>
					<th scope="col">Total Bill</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>


			<%
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					String sql = "select * from billtable";
					resultSet = statement.executeQuery(sql);
					int i = 0;
					while (resultSet.next()) {
			%>

			<tbody>

				<tr>
					<td><%=resultSet.getInt("Bno")%></td>
					<td><%=resultSet.getDate("date")%></td>
					<td><%=resultSet.getDouble("HCid")%></td>
					<td><%=resultSet.getDouble("DCid")%></td>
					<td><%=resultSet.getDouble("OCid")%></td>
					<td><%=resultSet.getDouble("TBid")%></td>

					<td><a href="BillUpdate.jsp?Bno=<%=resultSet.getInt("Bno")%>"><button
								class="btn btn-danger btn-xs" data-title="Edit"
								data-toggle="modal" data-target="#edit">
								<span class="fas fa-trash-alt"></span>
							</button> </a></td>

					<td><a href="BillDelete.jsp?Bno=<%=resultSet.getInt("Bno")%>"><button
								class="btn btn-danger btn-xs" data-title="Delete"
								data-toggle="modal" data-target="#delete">
								<span class="fas fa-trash-alt"></span>
							</button> </a></td>

				</tr>

				<%
					i++;
						}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>

			</tbody>

		</table>


	</div>

</body>
</html>