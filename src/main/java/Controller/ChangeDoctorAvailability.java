package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor;

@WebServlet("/ChangeAvailability")
public class ChangeDoctorAvailability extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Doctor d=(Doctor)req.getSession().getAttribute("doctor");
		Hospitaldao h=new Hospitaldao();
		
		if(d==null)
		{
			resp.getWriter().print("<h1>Session Expired,Please LogIn</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
		}
		else
		{
			if(d.isAvailable())
			{
				d.setAvailable(false);
				h.updateDoctor(d);
				req.getSession().setAttribute("doctor", d);
				resp.getWriter().print("<h1>Changed to not Availabel</h1>");
				req.getRequestDispatcher("DoctorHome.html").include(req, resp);
				
			}
			else
			{
				d.setAvailable(true);
				h.updateDoctor(d);
				req.getSession().setAttribute("doctor", d);
				resp.getWriter().print("<h1>Changed to Availabel</h1>");
				req.getRequestDispatcher("DoctorHome.html").include(req, resp);

			}
		}
		
	}
}
