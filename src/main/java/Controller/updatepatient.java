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

import dao.Hospitaldao;
import dto.Patient;

@WebServlet("/updatepatient")
public class updatepatient extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		Date dob=Date.valueOf(req.getParameter("dob"));
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		Hospitaldao h=new Hospitaldao();
		Patient p=h.fetchPatient(id);
		
		
			p.setName(name);
			p.setDOB(dob);
			p.setAge(age);
			
			h.updatePatient(p);
				
			resp.getWriter().print("<h1>Patient data updated successfully</h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
		
	}
}
