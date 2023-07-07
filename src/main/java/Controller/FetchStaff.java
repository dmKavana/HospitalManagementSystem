package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/fetchstaff")
public class FetchStaff extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException 
	{
		if(req.getSession().getAttribute("admin")!=null)
		{
		Hospitaldao h=new Hospitaldao();
		List<Staff> s=h.fetchAllStaff();
		
		if(s.isEmpty())
		{
			resp.getWriter().print("<h1>No staff has signed up yet<h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		}
		else
		{
			req.setAttribute("list", s);
			req.getRequestDispatcher("ApproveStaff.jsp").forward(req, resp);
		}
		}
		else
		{
			resp.getWriter().print("<h1>Session Expired</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
		}
		
	}
}
