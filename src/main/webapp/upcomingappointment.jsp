<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel=stylesheet href="appointment.css">
</head>
<body>
	
	<%Doctor d=(Doctor)request.getSession().getAttribute("doctor");
	if(d==null)
	{
		response.getWriter().print("<h1>Invalid Session</h1>");
		request.getRequestDispatcher("LogIn.html").include(request, response);
	}
	else
	{
		List<Appointment> la=d.getAppointment();
		if(la.isEmpty())
		{
			response.getWriter().print("<h1>No Appointment yet</h1>");
			request.getRequestDispatcher("DoctorHome.html").include(request, response);
		}
		else {%>
		
		<h2>Appointment Details of Patients</h2>
		<table border='1'>		<tr> 
			<th>Appointment ID</th>
			<th>Patient ID</th>
			<th>Patient Name</th>
			<th>Patient Picture</th>
			<th>Patient Problem</th>
			<th>Time</th>
		</tr>
		<% for(Appointment a:la) {
		%>
			<%if(a.getDateTime()==null) {
			%>
			<tr>
				<th><%=a.getId() %></th>
				<th><%=a.getP().getId() %></th>
				<th><%=a.getP().getName() %></th>
				<th>
				<%String base64=Base64.encodeBase64String(a.getP().getPicture());%>
					<img src="data:image/jpeg;base64,<%=base64 %>" alt="unknown" width='40px' height='30px'></th>
				<th><%=a.getProblem() %></th>
				<th><%=a.getDateTime() %></th>
			</tr>
	<%} %>
	<%} %>
	</table>
	<br>
	<a href="DoctorHome.html"><button id="back">Back</button></a>
	<%} %>
	<%} %>
</body>
</html>