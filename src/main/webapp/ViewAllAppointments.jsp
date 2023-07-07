<%@page import="java.util.List"%>
<%@page import="dto.Doctor"%>
<%@page import="dto.Appointment"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="appointment.css">
</head>
<body>
	<%
		Doctor doctor = (Doctor) session.getAttribute("doctor");
		if (doctor == null) {
			response.getWriter().print("<h1>Invalid Session </h1>");
			request.getRequestDispatcher("Login.html").include(request, response);
		} else {
			List<Appointment> list = doctor.getAppointment();
			if (list.isEmpty()) {
				response.getWriter().print("<h1>No Appointments Yet</h1>");
				request.getRequestDispatcher("DoctorHome.html").include(request, response);
			} else {
	%>
	
	<h2>View all Appointment Details</h2>
	<table border="1">
		<tr>
			<th>Appointment Id</th>
			<th>Patient Id</th>
			<th>Patient Name</th>
			<th>Patient Picture</th>
			<th>Patient Problem</th>
			<th>Check</th>
		</tr>
		<%
			for (Appointment appointment : list) {
		%>
		<%
			if (appointment.getDateTime() != null) {
		%>
		<tr>
			<th><%=appointment.getId()%></th>
			<th><%=appointment.getP().getId()%></th>
			<th><%=appointment.getP().getName()%></th>
			<th>
				<%
					String base64 = Base64.encodeBase64String(appointment.getP().getPicture());
				%> <img height="100px" width="100px" alt="unknown"
				src="data:image/jpeg;base64,<%=base64%>">
			</th>
			<th><%=appointment.getProblem()%></th>
			<th><a href="checkappointment?id=<%=appointment.getId()%>"><button id="ch">Check</button></a></th>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<br>
		<a href="DoctorHome.html"><button id="back1">Back</button></a>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>