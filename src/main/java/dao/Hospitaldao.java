package dao;

import java.awt.PageAttributes;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Appointment;
import dto.Doctor;
import dto.Patient;
import dto.Staff;

public class Hospitaldao 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev2");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void save(Staff s)
	{
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public Staff fetchStaff(long mobile)
	{
		List<Staff> lst=em.createQuery("select m from Staff m where mobile=?1").setParameter(1, mobile).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}
	
	public Staff fetchStaff(String email)
	{
//		By using nativeQuery
//		List<Staff> l=em.createNativeQuery("select * from staff where email=?1",Staff.class).setParameter(1, email).getResultList();
		List<Staff> lst=em.createQuery("select e from Staff e where email=?1").setParameter(1, email).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}
	
	public void saveD(Doctor d)
	{
		et.begin();
		em.persist(d);
		et.commit();
	}
	
	public Doctor fetchDoctor(long mobile)
	{
		List<Doctor> lst=em.createQuery("select y from Doctor y where mobile=?1").setParameter(1, mobile).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}
	
	public Doctor fetchDoctor(String email)
	{

		List<Doctor> lst=em.createQuery("select x from Doctor x where email=?1").setParameter(1, email).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}
	
	public Patient fetchPatient(long mobile)
	{
		List<Patient> lst=em.createQuery("select m from Patient m where mobile=?1").setParameter(1, mobile).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}
	
	public Staff fetchStaff(int id)
	{
		return em.find(Staff.class, id);
	}
	
	public Doctor fetchDoctor(int id)
	{
		return em.find(Doctor.class, id);
	}
	
	public Patient fetchPatient(int id)
	{
		return em.find(Patient.class, id);
	}
	
	public void updateDoctor(Doctor d)
	{
		et.begin();
		em.merge(d);
		et.commit();
	}
	
	public void updateStaff(Staff s)
	{
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	public void updatePatient(Patient p)
	{
		et.begin();
		em.merge(p);
		et.commit();
	}
		
	public List<Doctor> fetchAllDoctor()
	{
		return em.createQuery("select x from Doctor x").getResultList();
	}
	
	public List<Staff> fetchAllStaff()
	{
		return em.createQuery("select y from Staff y").getResultList();
	}
		
	public List<Patient> fetchAllPatient()
	{
		return em.createQuery("select y from Patient y").getResultList();
	}
	
	public void savePatient(Patient p)
	{
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public List<Doctor> fetchAvailableDoctor()
	{
		return em.createQuery(" select x from Doctor x where available=true").getResultList();
	}
	
	public void saveAppointment(Appointment app)
	{
		et.begin();
		em.persist(app);
		et.commit();
	}
	
	public Appointment fetchAppointment(int id) {
		return em.find(Appointment.class, id);
	}
	
	public void updateAppointment(Appointment appointment) {
		et.begin();
		em.merge(appointment);
		et.commit();
	}
}
