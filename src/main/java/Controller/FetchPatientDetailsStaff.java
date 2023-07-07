package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Patient;

@WebServlet("/fetchallpatientStaff")
public class FetchPatientDetailsStaff extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Hospitaldao h=new Hospitaldao();
		List<Patient> lst=h.fetchAllPatient();
		
		if(req.getSession().getAttribute("staff")==null)
		{
			resp.getWriter().print("<h1 style='color:aqua'>seesion Expired<h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);

		}
		else
		{
			if(lst.isEmpty())
			{
				resp.getWriter().print("<h1>No Patient Data Found<h1>");
				req.getRequestDispatcher("StaffHome.html").include(req, resp);
					
			}
			else
			{
				resp.getWriter().print("<h1>Patient Details</h1>");
				req.setAttribute("lst", lst);
				req.getRequestDispatcher("ViewPatientDetails.jsp").forward(req, resp);
			}
		}
		
	}
}
