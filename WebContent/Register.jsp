<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
table, td, tr {  
  	border: 1px solid #ddd;
  	text-align: left;
  	font-family: roboto;
}

table {
	margin-left: auto;
	margin-right: auto;
  	width: 50%;
}

tr, td {
	padding: 10px;
	border: none;
}

.bncd {
	width: 100%;
	height: 35px;
	background-color: white; 
  	color: black; 
  	border: 2px solid #f44336;
  	box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.dec {
	width: 100%;
	height: 150px;
	background-color: white; 
  	color: black; 
  	border: 2px solid #f44336;
  	box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.sub {
	margin-left: 200px;
	width: 100px;
	height: 40px;
	font-family: roboto;
	font-size: 20px;
	background-color: white; 
  	color: black; 
  	border: 2px solid #f44336;
  	box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.sub:hover {
	background-color: #4CAF50; /* Green */
  	color: white;
}

.types {
	font-size: 25px;
}

h3 {
	font-size: 25px;
	font-family: roboto;
	text-align: center;
}

input[type=text], textarea {
  width: 100%;
  box-sizing: border-box;
  font-family: roboto;
  font-size: 19px;
}
</style>
</head>
<body>
<h3>Put some products here.</h3>
<form action="<%= request.getContextPath() %>/RegisterConnection" method="post">
	<table>
		<tr>
			<td class="types">Barcode</td>
			<td><input type="text" name="barcode" class="bncd"></td>
		</tr>
		
		<tr>
			<td class="types">Name</td>
			<td><input type="text" name="name" class="bncd"></td>
		</tr>
		
		<tr>
			<td class="types">Color</td>
			<td><input type="text" name="color" class="bncd"></td>
		</tr>
		
		<tr>
			<td class="types">Description</td>
			<td><textarea name="description" rows=5 class="dec"></textarea></td>
		</tr>
	</table><br>
	
	<table>
		<tr>
			<td><input type="submit" name="submit" value="Submit" class="sub"></td>
		</tr>
	</table>
</form>
</body>
</html>