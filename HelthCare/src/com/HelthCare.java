package com;

import model.HelthCareModel;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


@Path("/HelthCare")
public class HelthCare
{
	HelthCareModel HelthCareObj = new HelthCareModel();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
	public String readItems()
		{
			return "Hello";
		}
}