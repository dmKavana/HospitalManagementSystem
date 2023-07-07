<%@page import="dto.Staff"%>
<%@page import="dto.Patient"%>
<%@page import="dao.Hospitaldao"%>
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

body{
    height: 800px;
    background-image: radial-gradient(white 30%,aqua);
    background-repeat: no-repeat;
    background-size: cover;
}

table{
    width: 500px;
    height: 50px;
    border: 3px groove black;
    position: relative;
    left: 350px;
    top: 200px;
    
}

th,td
{
    height: 40px;
    width: 300px;
    text-align: center;
    font-size: 20px;
}

td
{
    font-size: 20px;
    font-family: 'Times New Roman', Times, serif;
}

input{
	width: 250px;
	height: 35px;
	font-size: 20px;
}

#btn,#btnn
{
    width: 200px;
    height: 35px;
    border-radius: 5%;
    font-size: 20px;
    font-weight: bold;
    font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
    position: absolute;
    left: 370px;
    top: 400px;
}
#btnn
{
	position: absolute;
    left: 620px;
}

</style>
</head>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		Hospitaldao h=new Hospitaldao();
		Patient p=h.fetchPatient(id);
		
		if(p==null)
		{
			response.getWriter().print("<h1>Enter Valid ID</h1>");
			request.getRequestDispatcher("EditPatientDetails.jsp").include(request, response);
		}
		else{

	%>
	<form action="updatepatient" method="post">
	<table border='1'>
		<tr>
			<th><label>Patient ID</label></th>
			<th><input type="text" name="id" value="<%=p.getId() %>" readonly="readonly"></th>
		</tr>
		<tr>
			<th><label>Patient Name</label></th>
			<th><input type="text" name="name" value="<%=p.getName() %>"></th>
		</tr>
		<tr>
			<th><label>Patient Mobile</label></th>
			<th><input type="text" name="mobile" value="<%=p.getMobile() %>" readonly="readonly"></th>
		</tr>
		<tr>
			<th><label>Patient DOB</label></th>
			<th><input type="date" name="dob" value="<%=p.getDOB() %>"></th>
		</tr>
	</table>
	<br>
	<%} %>
	<a><button id="btn">Update</button></a>
	<a href="StaffHome.html"><button type="reset" id="btnn">Cancel</button></a>
	</form>
</body>
</html>