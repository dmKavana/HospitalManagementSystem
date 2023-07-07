<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Alignment.css">
<style>
h2
{
	color:navy;
	font-size:35px;
	position: relative;
	top:150px;
	left:350px;
	font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS';
}


</style>
</head>
<body>
	<%List<Patient> lst=(List<Patient>)request.getAttribute("lst"); %>
	<h2>Patients Details</h2>
	<table border='1'>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Mobile</th>
	<th>Age</th>
	<th>Picture</th>
	<th>view Appointment Details</th>
	</tr>
	
	<%for(Patient p:lst){ %>
	<tr>
		<td><%=p.getId() %></td>
		<td><%=p.getName() %></td>
		<td><%=p.getMobile() %></td>
		<td><%=p.getAge() %></td>
		<td>
		<%String base64=Base64.encodeBase64String(p.getPicture()); %>
		<img src="data:image/jpeg;base64,<%=base64 %>" alt="unknown" width='40px' height='30px'>
		</td>
		<td><a href="FetchAppointmentDetails.jsp?id=<%=p.getId()%>"><button id="cl">Click</button></a></td>
	</tr>
	<%} %>
	
	</table>
	
	<br><br>
	<%if(request.getSession().getAttribute("admin")!=null) { %>
		<a href="AdminHome.html" ><button id="back">Back</button></a>
	<%}else{ %>
		<a href="StaffHome.html"><button id="back">Back</button></a>
	<%} %>
	
	
</body>
</html>