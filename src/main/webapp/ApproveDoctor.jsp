<%@page import="dto.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Alignment.css">
<style>
h3
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
	
	<%List<Doctor> lst=(List<Doctor>)request.getAttribute("list");%>
    <h3>Doctor Details</h3>
    <table border='2'>
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Age</th>
    <th>Spec</th>
    <th>Qualification</th>
    <th>Status</th>
    <th>Change Status</th>
    </tr>
    
	<%for(Doctor d:lst) { %>
    <tr>
    <td><%=d.getId() %></td>
    <td><%=d.getName() %></td>
    <td><%=d.getMobile() %></td>
    <td><%=d.getAge() %></td>
    <td><%=d.getSpecailization() %>
    <td><%=d.getQualification() %>
    <td><%=d.isStatus() %></td>
    <td><a href="changeDoctorstatus?id=<%=d.getId() %>"><button id="ch">Change</button></a></td>
    </tr>
    <%} %>
    
    </table>
    <br><br>
    <a href="AdminHome.html" ><button id="back">Back</button></a>
</body>
</html>