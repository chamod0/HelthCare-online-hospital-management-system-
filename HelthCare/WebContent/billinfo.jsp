<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="Stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

<style>
h1 {
	text-align: left;
	text-transform: uppercase;
	color: #4CAF50;
}
</style>

<title>Bills</title>
</head>
<body>

	<h1>HOSPITAL MANAGEMENT SYSTEM</h1>
	

	<h2>Create Bills</h2>
	<br>

	<!--add form-->

	<div class="addform">
		<form name="formBillinfo" id="formBillinfo" class="form-horizontal" action="BillInfo.jsp" method="post">
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Payment ID :</label>
				<div class="col-sm-10">
					<input type="text" id="PaymentID" name="PaymentID" class="form-control" >
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Date :</label>
				<div class="col-sm-10">
					<input type="text" id="PayDate" name="PayDate" class="form-control" >
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Customer Name :</label>
				<div class="col-sm-10">
					<input type="text" id="CustomerName" name="CustomerName" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Total Amount :</label>
				<div class="col-sm-10">
					<input type="text" id="Amount" name="Amount" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Description :</label>
				<div class="col-sm-10">
					<input type="text" id="Description" name="Description" class="form-control" >
				</div>
			</div>
			
<br>			
			<div class="form-group">
				<input type="button" id="btnSave" name="btnSave" class="btn btn-primary " value ="save">
				<input type="hidden" id="hiddenPaymentIDsave" name="hiddenPaymentIDsave" value="">
			</div>
	
		</form>
		
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divPaymentGrid">
 <%
 Payment PaymentObj = new Payment();
 out.print(PaymentObj.readPayment());
 %>
</div>
		
	</div>
	

</body>
</html>

