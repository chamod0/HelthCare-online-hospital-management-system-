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

import model.DoctorM;

@Path("Doctor")
public class Doctor {
	//Read all Doctor XML Format
	DoctorRepositry repo = new DoctorRepositry();
	@Path("/Dxml")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<DoctorM> getDoctors()
	 {
		System.out.println("Get Doctor..");
		return repo.getDoctors();
	 } 
	//Read a Doctor using ID
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DoctorM getDoctor(@PathParam("id")int id)
	 {
		
		return repo.getDoctor(id);
	 } 
	//Read all Doctor in HTML Table
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String getDoctorTable()
	 {
		
		System.out.println("Get Doctor Table..");
		return repo.getDoctorsTable();
	 }
	
	//creating a record for a doctor
	@POST
	@Path("/")
	
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public String createDoctor(DoctorM d1) {
		String output ="";
		System.out.println(d1);
		repo.create(d1);
		 output = "Inserted successfully";
		
		return output;
	}
	//Updating an available record using ID
	@PUT
	@Path("/")
	@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateDoctor(DoctorM d1) {
		String output ="";
		System.out.println(d1);
		if(repo.getDoctor(d1.getId()).getId()==0) {
			
			output = "Inavlide ID";
		
		}else {
		repo.update(d1);
		 output = "Updated successfully";
		}
			return output;
	}
	
	//Delete a recode
	@DELETE
	@Path("/{id}")
	public String deleteDoctor(@PathParam("id")int id) {
		
		String output = "";
		DoctorM a =repo.getDoctor(id);
		
		if(a.getId()!=0) { 
			
			repo.delete(id);
		System.out.println("Doctor delete");
		output = "Doctor Account deleted";
		}else {
			output = "Inavlide ID";
		}
		return output;
	}
	
	

}
