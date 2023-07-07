package dto;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Problem;
	LocalDateTime time;

	
	@ManyToOne
	Doctor doctor;
	
	@ManyToOne
	Patient p;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public LocalDateTime getDateTime() {
		return time;
	}

	public void setDateTime(LocalDateTime dateTime) {
		time = dateTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getP() {
		return p;
	}

	public void setP(Patient p) {
		this.p = p;
	}

	
}
