package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor;

@WebServlet("/changeDoctorstatus")
public class DoctorStatus extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		Hospitaldao h=new Hospitaldao();
		Doctor d=h.fetchDoctor(id);
		
		if(d.isStatus())
		{
			d.setStatus(false);
		}
		else
		{
			d.setStatus(true);
		}
		h.updateDoctor(d);
		resp.getWriter().print("<h1>Status updated Successfully</h1>");
		req.setAttribute("list", h.fetchAllDoctor());
		req.getRequestDispatcher("ApproveDoctor.jsp").include(req, resp);
	}

}
