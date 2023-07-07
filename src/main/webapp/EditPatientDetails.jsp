<%@page import="dao.Hospitaldao"%>
<%@page import="dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	*{
		margin: 0;
		padding: 0;
	}

	body
	{
		width:100%;
		height:800px;
		overflow: hidden;
		background-image: linear-gradient(skyblue,aqua 40%,white);
		background-repeat: no-repeat;
		background-size: cover;
	}

	#nav
	{
		width: 100%;
		height: 50px;
		background-color: skyblue;
	}

	#edit1
	{
		position: absolute;
		left: 200px;
		font-size: 20px;
	}

	label
	{
		font-size: 20px;
		font-weight: bold;
		position: relative;
		top: 10px;
	}
	input
	{
		width: 300px;
		height: 30px;
		position: relative;
		top: 10px;
	}

	#edit2
	{
		width: 150px;
		height: 30px;
		font-size: 20px;
		position: relative;
		top: 13px;
	}
	
	#back
	{
		width: 150px;
		height: 30px;
		font-size: 20px;
		position: relative;
		top: 13px;
	}

</style>
</head>
<body>
	<%Hospitaldao h=new Hospitaldao(); %>
<nav id="nav">
	<form action="updatePatientDetails.jsp">
	<tabel border='1'>
	<tr id="edit1">
		<td ><label for="Pid">Enter Patient ID:</label></td>
		<td><input type="text" name="id" id="Pid"></td>
		<td><a><button id="edit2">Edit</button></a></td>
		
	</tr>
	</table>
	</form>
	
</nav>
	
</body>
</html>