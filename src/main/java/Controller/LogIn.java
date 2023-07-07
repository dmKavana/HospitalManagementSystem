package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/log")
public class LogIn extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String pwd=req.getParameter("pwd");
		
		Hospitaldao h=new Hospitaldao();
		Staff s=h.fetchStaff(id);
		Doctor d=h.fetchDoctor(id);
		
		
		if(s==null && d==null && id!=999999)
		{
			resp.getWriter().print("<h1>Icorrect ID</h1>");
			req.getRequestDispatcher("LogIn.html").include(req, resp);
		}
		
		else
		{
			if(s!=null)
			{
				if(s.getPassword().equals(pwd))
				{
					if(s.isStatus())
					{
						req.getSession().setAttribute("staff",s);
						resp.getWriter().print("<h1 style='color:yellowgreen'>LogIn Successfully</h1>");
						req.getRequestDispatcher("StaffHome.html").include(req, resp);
					}
					else
					{
						resp.getWriter().print("<h1 style='color:yellowgreen'>Wait for Admin Approval</h1>");
						req.getRequestDispatcher("LogIn.html").include(req, resp);
					}
				}
				else
				{
					resp.getWriter().print("<h1>InValid Password or Id</h1>");
					req.getRequestDispatcher("LogIn.html").include(req, resp);
				}
			}
		
		
		if(d!=null)
		{
			if(d.getPassword().equals(pwd))
			{
				if(d.isStatus())
				{
					req.getSession().setAttribute("doctor",d);
					resp.getWriter().print("<h1 style='color:yellowgreen'>LogIn Successfully</h1>");
					req.getRequestDispatcher("DoctorHome.html").include(req, resp);
				}
				else
				{
					resp.getWriter().print("<h1 style='color:yellow'>Wait for Admin Approval</h1>");
					req.getRequestDispatcher("LogIn.html").include(req, resp);
				}
			}
			else
			{
				resp.getWriter().print("<h1>InValid Password or Id</h1>");
				req.getRequestDispatcher("LogIn.html").include(req, resp);

			}
		}
		
		
		if(id==999999)
		{
			if("999999".equals(pwd))
			{
				req.getSession().setAttribute("admin","admin");
				resp.getWriter().print("<h1 style='color:green'>LogIn Successfully</h1>");
				req.getRequestDispatcher("AdminHome.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1>InValid Password or Id</h1>");
				req.getRequestDispatcher("LogIn.html").include(req, resp);
			}
		}	
		}
	}
}
