package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Staff;

@WebServlet("/changestaffstatus")
public class StaffStatus extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		Hospitaldao h=new Hospitaldao();
		Staff s=h.fetchStaff(id);
		
		if(s.isStatus())
		{
			s.setStatus(false);
		}
		else
		{
			s.setStatus(true);
		}
		h.updateStaff(s);
		resp.getWriter().print("<h1> Staff Status Updated Successfully</h1>");
		req.setAttribute("list", h.fetchAllStaff());
		req.getRequestDispatcher("ApproveStaff.jsp").include(req, resp);
	}
}
