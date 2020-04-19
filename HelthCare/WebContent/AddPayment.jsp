<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Payment</title>
</head>
<body>

	
    <header class="templatemo-site-header">
	<h1>HOSPITAL MANAGEMENT SYSTEM</h1>
	</header>
            

<form method="post" action="CustomerPaymentsNewServlet" style="border:1px solid #ccc">
  <div class="container">

    <hr>

    <h1>Payment</h1>
    <br>
    
    <label for="inputAddress"><b>PaymentId</b></label>
    <input type="number" placeholder="Enter Customer Id" name="customerId" id="pid" required>
    <br><br>
    
    <label for="inputAddress"><b>Payment Method</b></label>
    <select name = "payment_method"  id = ptype>
    
    		<option>----Payment Method---</option>
  			<option value="cash">Cash</option>
  			<option value="credit card">Credit Card</option>
 
	</select>

  	<h3>Credit Card</h3>

  	<label for="inputAddress"><b>Card Name</b></label>
    <input type="text" placeholder="Enter card name" name="card_name" id="pcname" required>

    <label for="inputAddress"><b>Card Number</b></label>
    <input type="number" placeholder="Enter Card Number" name="card_no" id="pcno" required>
    
    <br><br>
    
    <label for="Date"><b>Expire Date</b></label>
    <input type="date" name="date" id="pdt" required>

    <br><br>

    <label for="inputAddress"><b>Country</b></label>
    <input type="text" placeholder="Enter the Country" name="country" id="pcountry" required>

    <label for="inputAddress"><b>Zip</b></label>
    <input type="number" placeholder="Enter the Zip" name="zip" id="pzip" required>
    
    <br><br>

    <label for="inputAddress"><b>Total Bill</b></label>
    <input type="number"placeholder="Rs." name="bill" id="pbill" required>

    <div class="clearfix">
      <button type="submit" class="submitbtn" >Submit</button>
  </div>

	</div>
	</form>					

</body>
</html>
