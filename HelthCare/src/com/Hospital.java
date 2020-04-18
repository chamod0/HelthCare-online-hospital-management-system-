package com;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.HospitalModel;


@Path("hospital")
public class Hospital {
	
	HospitalRepositry repo = new HospitalRepositry();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<HospitalModel> getHospitalModels()
	 {
		System.out.println("Get work & star list");
		return repo.getHospitalModels();
	 } 
	
	@GET
	@Path("hospital/{hos_id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public HospitalModel getHospitalModels(@PathParam("hos_id")int hos_id)
	 {
		System.out.println("Get with selected Id");
		return repo.getHospitalModel(hos_id);
	 } 
	
	@POST
	@Path("hospital")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public HospitalModel create_Hospital(HospitalModel h_create) {
		
		System.out.println("Set Path POST method");
		System.out.println(h_create);
		repo.create_Hospital(h_create);
		return h_create;
	}
	
	@PUT
	@Path("hospital")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public HospitalModel update_Hospital(HospitalModel h_update) {
		
		System.out.println("Put started");
		System.out.println(h_update);
		if(repo.getHospitalModel(h_update.getHos_id()).getHos_id()==0) {
			System.out.println("Inavlide ID");
		}
		repo.update_Hospital(h_update);
		return h_update;
	}
	
	
	@DELETE
	@Path("hospital/{hos_id}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public HospitalModel delete_Hospital(@PathParam("hos_id")int hos_id) {
		
		HospitalModel h = repo.getHospitalModel(hos_id);
		if (h.getHos_id()!=0) {
			repo.delete_Hospital(hos_id);
		}
		
		return h;
	
	}
	

}



//@Path("hospital")
//public class Hospital {
//	
//	@GET
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public List<HospitalModel> getAllHospital() {
//		
//		List<HospitalModel> hospitalList = new ArrayList<>();
//		System.out.println("get eke");
//		HospitalModel h1 = new HospitalModel();
//		HospitalModel h2 = new HospitalModel();
//		HospitalModel h3 = new HospitalModel();
//		
//		h1.setHos_id(10);
//		h1.setHos_name("Nawaloke"); 
//		h1.setHos_address("Colombo");
//		h1.setHos_phone("0713734637");
//		h1.setHos_email("prasad&gmail.com");
//		
//		h2.setHos_id(11);
//		h2.setHos_name("Nawaloke2"); 
//		h2.setHos_address("Colombo2");
//		h2.setHos_phone("07137346372");
//		h2.setHos_email("prasad&gmail2.com");
//		
//		h3.setHos_id(13);
//		h3.setHos_name("Nawaloke3"); 
//		h3.setHos_address("Colombo3");
//		h3.setHos_phone("07137346373");
//		h3.setHos_email("prasad&gmail3.com");
//		
//		hospitalList.add(h1);
//		hospitalList.add(h2);
//		hospitalList.add(h3);
//		
//		System.out.println(h1);
//		
//		return hospitalList;
//		
//	}