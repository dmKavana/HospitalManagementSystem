<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="dto.Patient"%>
<%@page import="java.util.List"%>
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
        background-image:linear-gradient(aqua 25%,white);
        background-repeat: no-repeat;
        background-size: cover;
    }

    table{
        width: 700px;
        height: 50px;
        border: 3px groove black;
        position: relative;
        left: 350px;
        top: 200px;
        
    }

    th,td
    {
        height: 40px;
        width: 500px;
        text-align: center;
        font-size: 20px;
    }

    td
    {
        font-size: 20px;
        font-family: 'Times New Roman', Times, serif;
    }

    
    #back{
        width: 200px;
        height: 35px;
        border-radius: 5%;
        font-size: 20px;
        font-weight: bold;
        font-family: 'Gill Sans', 'Gill Sans MT', 'Trebuchet MS', sans-serif;
        position: absolute;
        left: 350px;
        top: 400px;
    }
    
    #ba
    {
    	color:black;
    	font-size: 20px;
    }

    #bp
    {
        color: white;
        background-color: black;
        font-size: 20px;
        
    }
    
    h2
    {
    	position: relative;
    	left: 350px;
    	top:180px;
    	color:navy;
    	font-size: 35px;
    	font-family:'Gill Sans', 'Gill Sans MT';
    
    }
</style>
</head>
<body>
	<%List<Patient> lst=(List<Patient>)request.getAttribute("lst"); %>
	
	<h2>Patient Details</h2>
	<table border='1'>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Mobile</th>
	<th>Age</th>
	<th>Picture</th>
	<th>Book</th>
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
		<td><a href="AppointmentForm.jsp?id=<%=p.getId() %>"><button id="ba">Book Appointment</button></a></td>
	</tr>
	<%} %>
	
	</table>
	<br>
	<a href="BookAppointment.jsp"><button id="back">Back</button></a>
</body>
</html>