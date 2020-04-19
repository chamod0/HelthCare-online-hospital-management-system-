package com;

import model.Appointment;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/appointment")
public class HealthCare {
	Appointment itemObj = new Appointment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return itemObj.readItems();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(@FormParam("app_Id") String itemCode,
									@FormParam("app_no") String app_no,
									@FormParam("app_type") String app_type,
	 								@FormParam("Doc_Id") String Doc_Id,
	 								@FormParam("Doc_name") String Doc_name,
	 								@FormParam("hospital_name") String hospital_name,
	 								@FormParam("des") String des)

	{
					String output = itemObj.insertAppointment(app_no,app_type,Doc_Id,Doc_name,hospital_name,des);
					return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData)
	{
		//Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
	 
		//Read the values from the JSON object
		String app_Id = itemObject.get("app_Id").getAsString();
		String app_no = itemObject.get("app_no").getAsString();
		String app_type = itemObject.get("app_type").getAsString();
		String Doc_Id = itemObject.get("Doc_Id").getAsString();
		String Doc_name = itemObject.get("Doc_name").getAsString();
		String hospital_name = itemObject.get("hospital_name").getAsString();
		String des = itemObject.get("des").getAsString();
	 
		String output = itemObj.updateAppointment(app_Id,app_no,app_type,Doc_Id,Doc_name,hospital_name,des);
	 
		return output;
	
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointment(String itemData)
	{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		String app_Id = doc.select("app_Id").text();
	 
		String output = itemObj.deleteAppointment(app_Id);
	 
		return output;
		
	}

}