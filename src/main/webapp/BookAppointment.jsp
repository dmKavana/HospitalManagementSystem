<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	*{
		padding: 0;
		margin: 0;
	}

	body
	{
		overflow: hidden;
		background-image: url(./images/Patient.jpg);
		background-repeat: no-repeat;
		background-size: cover;
	}
	#sec
	{
		width: 400px;
		height: 200px;
		border: 5px groove black;
		position: relative;
		left: 800px;
		top: 200px;
	}

	button
	{
		width: 280px;
		height: 35px;
		font-size: 20px;
		font-weight: bold;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		margin-top:35px;
		margin-left: 60px;
	}

	#back
	{
		width:200px;
		font-family:'Arial Narrow',Arial, sans-serif;
		position: relative;
		left: 740px;
		top: 200px;
	}
</style>
</head>
<body>
	<%if(session.getAttribute("staff")==null) {
		response.getWriter().print("<h1>Session Expired,Please LogIn</h1>");
		request.getRequestDispatcher("LgoIn.html").include(request, response);
	}
	else
	{
		%>
		<div id="sec">
			<a href="Patient"><button>View All Patient</button></a><br><br>
			<a href="FetchById.html"><button>fetch Patient by ID</button></a>
		</div>
	<%} %>
	<br>
	<br>	
	<a href="StaffHome.html"><button id="back">Back</button></a>
</body>
</html>