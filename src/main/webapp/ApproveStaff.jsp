<%@page import="dto.Staff"%>
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
    <%List<Staff> lst=(List<Staff>)request.getAttribute("list");%>
    
    <h3>Staff Details</h3>
    <table border='1'>
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Age</th>
    <th>Status</th>
    <th>Change Status</th>
	<%for(Staff s:lst) { %>
    <tr>
    <td><%=s.getId() %></td>
    <td><%=s.getName() %></td>
    <td><%=s.getMobile() %></td>
    <td><%=s.getAge() %></td>
    <td><%=s.isStatus() %></td>
    <td><a href="changestaffstatus?id=<%=s.getId() %>"><button id="ch">Change</button></a></td>
    </tr>
    <%} %>
    
    </table>
    <br><br>
    <a href="AdminHome.html"><button id="back">Back</button></a>
    
        
</body>
</html>