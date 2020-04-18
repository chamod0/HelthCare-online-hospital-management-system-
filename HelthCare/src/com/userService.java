package com;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType; 
import model.Users;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 



@Path("/Users") 
public class userService {
	
	//Creating an object of User class
	Users users = new Users();
	
	
	//Read all Users
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
	public String readItems()
	 {
		return users.readUser();
	 }
	
	//creating a new record
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("userID") String userID,
	 @FormParam("fName") String fName,
	 @FormParam("lName") String lName,
	 @FormParam("email") String email,
	 @FormParam("nic") String nic,
	 @FormParam("phone") String phone,
	 @FormParam("password") String password,
	 @FormParam("confirmPass") String confirmPass){
		 	String output = users.insertUser(userID, fName, lName, nic, phone, password, confirmPass);
		
		 	return output;
	}
	
	//Updating an available record using ID
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String userData)
	{
		
		 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		
		 String userID = userObject.get("userID").getAsString();
		 String fName = userObject.get("fName").getAsString();
		 String lName = userObject.get("lName").getAsString();
		 String email = userObject.get("email").getAsString();
		 String nic = userObject.get("nic").getAsString();
		 String phone = userObject.get("phone").getAsString();
		 String password = userObject.get("password").getAsString();
		 String confirmPass = userObject.get("confirmPass").getAsString();
		 
		 String output = users.UpdateUser(userID, fName, lName, email, nic, phone, password, confirmPass);
		
		 return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String userData)
	{
	
		 Document document = Jsoup.parse(userData, "", Parser.xmlParser());
	
		//Read the value from the element <itemID>
		 String userID = document.select("userID").text();
		 String output = users.deleteUser(userID);
		
		 return output;
	}

	
	

}
