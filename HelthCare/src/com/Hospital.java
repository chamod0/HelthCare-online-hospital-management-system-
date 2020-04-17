package com;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.HospitalModel;

@Path("hospital")
public class Hospital {
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<HospitalModel> getAllHospital() {
		
		List<HospitalModel> hospitalList = new ArrayList<>();
		System.out.println("get eke");
		HospitalModel h1 = new HospitalModel();
		HospitalModel h2 = new HospitalModel();
		HospitalModel h3 = new HospitalModel();
		
		h1.setHos_id(10);
		h1.setHos_name("Nawaloke"); 
		h1.setHos_address("Colombo");
		h1.setHos_phone("0713734637");
		h1.setHos_email("prasad&gmail.com");
		
		h2.setHos_id(11);
		h2.setHos_name("Nawaloke2"); 
		h2.setHos_address("Colombo2");
		h2.setHos_phone("07137346372");
		h2.setHos_email("prasad&gmail2.com");
		
		h3.setHos_id(13);
		h3.setHos_name("Nawaloke3"); 
		h3.setHos_address("Colombo3");
		h3.setHos_phone("07137346373");
		h3.setHos_email("prasad&gmail3.com");
		
		hospitalList.add(h1);
		hospitalList.add(h2);
		hospitalList.add(h3);
		
		System.out.println(h1);
		
		return hospitalList;
		
	}

}
