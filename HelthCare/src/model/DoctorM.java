package model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class DoctorM {
	private int id;
	private String name;
	private int Tel;
	private String Hosptal;
	private String Specialization;
	private String Email;
	private String password;
	
	
	
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
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getHosptal() {
		return Hosptal;
	}
	public void setHosptal(String hosptal) {
		Hosptal = hosptal;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DoctorM [id=" + id + ", name=" + name + ", Tel=" + Tel + ", Hosptal=" + Hosptal + ", Specialization="
				+ Specialization + ", Email=" + Email + ", password=" + password + "]";
	}
	
}
