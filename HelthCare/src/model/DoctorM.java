package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoctorM {
	private int id;
	private String name;
	private int Tel;
	private String Hosptal;
	private String Specialization;
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
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", Tel=" + Tel + ", Hosptal=" + Hosptal + ", Specialization="
				+ Specialization + "]";
	}
}
