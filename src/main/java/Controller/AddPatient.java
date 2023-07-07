package Controller;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Hospitaldao;
import dto.Patient;


@WebServlet("/addpatient")
@MultipartConfig	//When Image is not supported that time we use @MultipartConfig

public class AddPatient extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		String name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("birth"));
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Part picture=req.getPart("picture");
	
		byte[] image=new byte[picture.getInputStream().available()];
		picture.getInputStream().read(image);
		
		Hospitaldao h=new Hospitaldao();
		Patient pa=h.fetchPatient(mobile);
		Patient p=new Patient();

		if(pa==null)
		{
			p.setName(name);
			p.setMobile(mobile);
			p.setDOB(dob);
			p.setAge(age);
			p.setPicture(image);
			h.savePatient(p);
				
			resp.getWriter().print("<h1>Added Patient</h1>");
			req.getRequestDispatcher("StaffHome.jsp").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1>Mobile Number is already existed</h1>");
			req.getRequestDispatcher("Appointment.html").include(req, resp);
		}
	}

}
