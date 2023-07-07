package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectrole")
public class SelectRole extends HttpServlet
{	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		String s=req.getParameter("role");
		if(s.equals("staff"))
		{
			req.getRequestDispatcher("StaffSignup.html").forward(req, resp);
		}
		else 
		{
			req.getRequestDispatcher("DoctorSignup.html").forward(req, resp);
		}
	}

}
