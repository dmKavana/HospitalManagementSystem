package Controller;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Staff;


@WebServlet("/staffsignup")
public class StaffSignup extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		long number=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("brith"));
		String gender=req.getParameter("Gender");
		
//		deprecate means 
//		int age=LocalDate.now().getYear()-dob.toLocalDate().getYear();
		Hospitaldao dao= new Hospitaldao();

		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
	if(dao.fetchStaff(number)==null && dao.fetchStaff(email)==null)
	{
		Staff s=new Staff();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(gender);
		s.setMobile(number);
		s.setDob(dob);
		s.setGender(gender);
		s.setAge(age);
		
		dao.save(s);
		
		resp.getWriter().print("<h1>Staff Account Created Successfully,Wait for Admin Approval</h1>");
		resp.getWriter().print("<h1>Your Staff ID is: "+s.getId()+"</h1>");
		req.getRequestDispatcher("LogIn.html").include(req, resp);
	}
	else 
	{
		resp.getWriter().print("<h1>Email and Mobile number already exist</h1>");
		req.getRequestDispatcher("LogIn.html").include(req, resp);

	}
	}
	
}
