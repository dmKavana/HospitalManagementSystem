<%@page import="java.util.List"%>
<%@page import="dto.Doctor"%>
<%@page import="dto.Staff"%>
<%@page import="dto.Patient"%>
<%@page import="dao.Hospitaldao"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Form</title>
<style>
    *{
		margin: 0;
		padding: 0;
	}
	body
	{
		overflow: hidden;
		height: 800px;
		background-image: linear-gradient(white,skyblue);
		background-repeat: no-repeat;
		background-size: cover;
	}

    h2
    {
        position: relative;
        left: 550px;
        top: 160px;
    }

    #form
    {
        width: 400px;
        height: 400px;
        border: 5px groove skyblue;
        position: relative;
        left: 560px;
        top: 180px;
    }
    form
    {
        position: relative;
        left: 30px;
        top: 30px;
        font-size: 20px;
		font-weight: bold;
        line-height: 50px;
    }

    input,option
    {
        width: 200px;
        height: 24px;
        border: 2px solid black;

    }

	button
	{
		width: 150px;
		height: 35px;
		border-radius: 5%;
		font-size: 20px;
		font-weight: bold;
	}

	button[type=submit]
	{
		position: relative;
		left: 50px;
	}

	#back
	{
		position: relative;
		left: 500px;
		top: 200px;
	}
	
</style>
</head>
<body>

	<% 	Staff s=(Staff)session.getAttribute("staff");
		int Pid=Integer.parseInt(request.getParameter("id"));
		Hospitaldao h= new Hospitaldao();
		Patient p=h.fetchPatient(Pid);
		
		if(p==null)
		{
			response.getWriter().print("<h1>Wrong ID,Enter</h1>");
			request.getRequestDispatcher("FetchById.html").include(request, response);
		}
		
		else 
		{
			List<Doctor> d=h.fetchAvailableDoctor();
			if(d.isEmpty())
			{
				response.getWriter().print("<h1>Doctor is not availbale</h1>");
				request.getRequestDispatcher("StaffHome.html").include(request, response);
			}
			else
			{
			

		%>
		<div id="form">
		<form action="bookappointment" method="post">
		<table>
			<tr>
				<td><label>Patient ID</label></td>
				<td><input type="text"  name="Pid" value="<%=Pid %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><label >Patient Name</label></td>
				<td><input type="text" name="Pname" value="<%=p.getName() %>" readonly="readonly" ></td>
			</tr>
			<tr>
				<td><label >Satff Name</label></td>
				<td><input type="text" name="Sname" value="<%=s.getName()%>"></td>
			</tr>
			<tr>
				<td><label>Problem</label></td>
				<td><input type="text" name="problem"></td>
			</tr>
			<tr>
				<td><label>Select Doctor</label></td>
				<td>
					<select name="doctor">
					<%for(Doctor dct:d){%>
						<option value="<%=dct.getId() %>"> <%=dct.getName() %> (<%=dct.getSpecailization() %>)</option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td><button type="reset">Cancel</button></td>
				<td><button type="submit">Book</button></td>
			</tr>
		</table>
		</form>
	</div>
	<%}}%>
	<br>
	<a href="Patient"><button id="back">Back</button></a>
</body>
</html>