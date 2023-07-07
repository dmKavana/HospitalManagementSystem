package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Appointment;
import dto.Doctor;
import dto.Patient;

@WebServlet("/bookappointment")
public class BookAppointment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("Pid"));
		int did=Integer.parseInt(req.getParameter("doctor"));
		String problem=req.getParameter("problem");
		Hospitaldao dao=new Hospitaldao();
		Doctor doctor=dao.fetchDoctor(did);
		Patient patient=dao.fetchPatient(pid);
		
		Appointment appointment=new Appointment();
		appointment.setDoctor(doctor);
		appointment.setP(patient);
		appointment.setProblem(problem);
		
		List<Appointment> list1=patient.getAppointment();
		if(list1==null)
		{
			list1=new ArrayList<>();
		}
		list1.add(appointment);
		patient.setAppointment(list1);
		
		List<Appointment> list2=doctor.getAppointment();
		if(list2==null)
		{
			list2=new ArrayList<>();
		}
		list2.add(appointment);
		doctor.setAppointment(list2);
		
		dao.saveAppointment(appointment);
		dao.updateDoctor(doctor);
		dao.updatePatient(patient);
		
		resp.getWriter().print("<h1>Appointment of "+patient.getName()+" is booked with "+doctor.getName()+" for "+problem+"</h1>");
		req.getRequestDispatcher("StaffHome.html").include(req, resp);
	}
}
