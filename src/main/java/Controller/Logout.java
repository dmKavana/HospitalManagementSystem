package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getSession().invalidate();
//		resp.getWriter().print("<h1 Style='position:relative; top:100px'>LogOut Success</h1>");
		req.getRequestDispatcher("LogIn.html").include(req, resp);
	}
}
