package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
 @XmlAccessorType(XmlAccessType.FIELD) 
public class HospitalModel {

	
	
	public Integer hos_id;
	public String hos_name;
	public String hos_address;
	public String hos_phone;
	public String hos_email;
	
	
	
	public Integer getHos_id() {
		System.out.println("Get h_id");
		return hos_id;
	}
	public void setHos_id(Integer hos_id) {
		System.out.println("Get s_id");
		this.hos_id = hos_id;
	}
	public String getHos_name() {
		return hos_name;
	}
	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}
	public String getHos_address() {
		return hos_address;
	}
	public void setHos_address(String hos_address) {
		this.hos_address = hos_address;
	}
	public String getHos_phone() {
		return hos_phone;
	}
	public void setHos_phone(String hos_phone) {
		this.hos_phone = hos_phone;
	}
	public String getHos_email() {
		return hos_email;
	}
	public void setHos_email(String hos_email) {
		this.hos_email = hos_email;
	}
	@Override
	public String toString() {
		return "HospitalModel [hos_id=" + hos_id + ", hos_name=" + hos_name + ", hos_address=" + hos_address
				+ ", hos_phone=" + hos_phone + ", hos_email=" + hos_email + "]";
	}
	
	
	
}
