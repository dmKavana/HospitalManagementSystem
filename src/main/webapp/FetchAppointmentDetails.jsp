<%@page import="dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dto.Patient"%>
<%@page import="dao.Hospitaldao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Alignment1.css">
</head>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		Hospitaldao h= new Hospitaldao();
		Patient p=h.fetchPatient(id);
		List<Appointment> lst=p.getAppointment();
		
		if(lst.isEmpty())
		{
			response.getWriter().print("<h1>No Appointments yet</h1>");
			request.setAttribute("list", h.fetchAllPatient());
			request.getRequestDispatcher("AdminHome.html").include(request, response);
		}
		else
		{
	%>
	<h1>Appointment List</h1>
	
	<table border='1'>
	<tr>
		<th id="ww">Appointment ID</th>
		<th id="ww">Patient</th>
		<th id="ww">Problem</th>
		<th id="ww">Doctor</th>
		<th id="ww">Appointment Date</th>
	</tr>
	
	<%for(Appointment app:lst) { %>
	<tr>
		<th><%=app.getId() %></th>
		<th><%=app.getP().getName() %></th>
		<th><%=app.getProblem() %></th>
		<th><%=app.getDoctor().getName() %></th>
		<th>
		<%if(app.getDateTime()==null){%>
			Not yet visited doctors	
		<%}else{%>
			<%=app.getDateTime()%>
		<%}%>
		</th>
	</tr>
	<%} %>
	</table>
	<%if(request.getSession().getAttribute("admin")!=null) { %>
		<a href="fetchallpatient" ><button id="back">Back</button></a>
	<%}else{ %>
		<a href="fetchallpatientStaff"><button id="back">Back</button></a>		
	<%} }%>
</body>
</html>