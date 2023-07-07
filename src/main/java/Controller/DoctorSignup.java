package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.loader.plan.exec.internal.FetchStats;

import dao.Hospitaldao;
import dto.Doctor;

@WebServlet("/doctorsignup")
public class DoctorSignup extends HttpServlet
{
		protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
		{
			String name=req.getParameter("dname");
			long number=Long.parseLong(req.getParameter("dmobile"));
			String email=req.getParameter("demail");
			String pwd=req.getParameter("dpassword");
			Date dob=Date.valueOf(req.getParameter("dob"));
			String qualification=req.getParameter("Qualification");
			String specailization=req.getParameter("specailization");
			String gender=req.getParameter("Gender");
			
			Hospitaldao h=new Hospitaldao();
			int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			
		if(h.fetchDoctor(number)==null && h.fetchDoctor(email)==null && h.fetchStaff(email)==null && h.fetchStaff(number)==null)
		{		
			Doctor d=new Doctor();
			d.setName(name);
			d.setMobile(number);
			d.setEmail(email);
			d.setPassword(pwd);
			d.setDob(dob);
			d.setAge(age);
			d.setQualification(qualification);
			d.setSpecailization(specailization);
			d.setGender(gender);
			
			h.saveD(d);
			
			resp.getWriter().print("<h1>Staff Account Created Successfully,Wait for Admin Approval</h1>");
			resp.getWriter().print("<h1>Your Staff ID is: "+d.getId()+"</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
			
		}
		else
		{
			resp.getWriter().print("<h1>Mobile Number or Email already exists</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
		}
	}
}
