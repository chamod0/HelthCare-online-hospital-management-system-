<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="Stylesheet" href="jquery.datetimepicker.min.css">

<script src="jquery.js"></script>
<script src="jquery.datetimepicker.full.js"></script>

<script>
	function validateForm() {

		var a = document.forms["CreateBill"]["Bno"].value;
		if (a == "") {
			alert("Bill No cannot be Empty!!");
			return false;
		}

		var b = document.forms["CreateBill"]["date"].value;
		if (b == "") {
			alert("date cannot be Empty!!");
			return false;
		}

		var c = document.forms["CreateBill"]["HCid"].value;
		if (c == "") {
			alert("Hospital Chargers cannot be Empty!!");
			return false;
		}

		var d = document.forms["CreateBill"]["DCid"].value;
		if (d == "") {
			alert("Doctor Chargers cannot be Empty!!");
			return false;
		}
		var e = document.forms["CreateBill"]["TBid"].value;
		if (e == "") {
			alert("Total Bill cannot be Empty!!");
			return false;
		}

	}
</script>

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

	<h1 class="templatemo-site-header">HOSPITAL MANAGEMENT SYSTEM</h1>
	

	<h2>Create Bills</h2>
	<br>

	<!--add form-->

	<div class="addform">
		<form name="CreateBill" onsubmit="return validateForm()" class="form-horizontal" action="BillServlet" method="post">
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Bill No :</label>
				<div class="col-sm-10">
					<input type="text" id="Bno" name="Bno" class="form-control" >
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Billing Date :</label>
				<div class="col-sm-10">
					<input type="text" id="date" name="date" class="form-control" >
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Hospital Chargers :</label>
				<div class="col-sm-10">
					<input type="text" id="HCid" name="HCid" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Doctor Chargers :</label>
				<div class="col-sm-10">
					<input type="text" id="DCid" name="DCid" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Other Chargers :</label>
				<div class="col-sm-10">
					<input type="text" id="OCid" name="OCid" class="form-control" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Total Bill :</label>
				<div class="col-sm-10">
					<input type="text" id="TBid" name="TBid" class="form-control" >
				</div>
			</div>

<br>
			<div class="form-group">
				<input type="button" id="btnsave" name="btnsave" class="form-control" value ="save">

			</div>


		</form>
	</div>


</body>


</html>
