package Controller;

import java.io.IOException;

import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Appointment;

@WebServlet("/checkappointment")
public class CheckAppointments extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		Hospitaldao h = new Hospitaldao();

		Appointment appointment = h.fetchAppointment(id);
		appointment.setDateTime(LocalDateTime.now());
		h.updateAppointment(appointment);

		resp.getWriter().print("<h1>Successfully Updated</h1>");
		req.getRequestDispatcher("DoctorHome.html").include(req, resp);
	}
}
