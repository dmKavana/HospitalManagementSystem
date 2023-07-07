package dto;

import javax.persistence.GeneratedValue;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(generator = "DoctorId")//In generator give the which name is given to in sequenceGenerator
	@SequenceGenerator(initialValue = 456001,allocationSize = 1,name="DoctorId",sequenceName = "DoctorId")
	//allocationSize is used for differe
	private int id;
	private String name;
	@Column(unique = true)
	private long mobile;
	@Column(unique = true)
	private String email;
	private String password;
	private Date dob;
	private int age;
	private String qualification;
	private String specailization;
	private String gender;
	private boolean status;
	private boolean available;
	
	@OneToMany
	List<Appointment> appointment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecailization() {
		return specailization;
	}

	public void setSpecailization(String specailization) {
		this.specailization = specailization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	
	
}
