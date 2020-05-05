<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="Stylesheet" href="jquery.datetimepicker.min.css">

<script src="calculate.js">
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
					<input type="text" id="Bno" name="Bno" class="form-control" >
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Billing Date :</label>
					<input type="text" id="date" name="date" class="form-control" >
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Hospital Chargers :</label>
					<input type="text" id="HCid" name="HCid" class="form-control" >
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Doctor Chargers :</label>
					<input type="text" id="DCid" name="DCid" class="form-control" >
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Other Chargers :</label>
					<input type="text" id="OCid" name="OCid" class="form-control" >
				</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Total Bill :</label>
					<input type="text" id="TBid" name="TBid" class="form-control" >
				</div>

<br>
			<div class="form-group">
				<input type="button" id="btncal" name="btncal" class="form-control" value ="calculate" onclick="calculate()">
				
<script type="text/javascript">
	function calculate () {
    var cost1 = document.getElementById ("HCid").value;
    cost1 = parseFloat (cost1);
    var cost2 = document.getElementById("DCid").value;
    cost2 = parceFloat (cost2);
    var cost3 = document.getElementById("OCid").value;
    cost3 = parceFloat (cost3);
    var totalcost = cost1 + cost2 + cost3;
    alert('Total Cost is :' +totalcost);
    document.getElementById("btncal").value = totalcost;
}
</script>
				
			</div>
<br>			
			<div class="form-group">
				<input type="button" id="btnsave" name="btnsave" class="form-control" value ="save">
			</div>

			
		</form>
	</div>
	

	

</body>
</html>

