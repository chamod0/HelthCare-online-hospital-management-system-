package com;

import java.util.ArrayList;
import java.util.List;

import model.DoctorM;

public class DoctorRepositry {
	
	List<DoctorM> doctor;
	public DoctorRepositry() {
		 
		doctor = new ArrayList<>();
		 
		DoctorM d1 = new DoctorM();
		
		d1.setId(001);
		d1.setName("Chamod");
		d1.setTel(07113234);
		d1.setSpecialization("hart");
		d1.setHosptal("kurunegala");
		
		DoctorM d2 = new DoctorM();
		
		d2.setId(002);
		d2.setName("dilshan");
		d2.setTel(071133455);
		d2.setSpecialization("brain");
		d2.setHosptal("colombo");
		
		doctor.add(d1);
		doctor.add(d2);
		
	}
	
	
	public List<DoctorM> getDoctors() {
		
		
		return doctor;
	}
	
	public DoctorM getDoctor(int id) {
		
		for (DoctorM a : doctor ) {
			
			if(a.getId() == id) {
				return a;
			}
			
		}
		return new DoctorM();
	}
	

	public void create(DoctorM d1) {
		// TODO Auto-generated method stub
		
		doctor.add(d1);
		
	}
	

}
