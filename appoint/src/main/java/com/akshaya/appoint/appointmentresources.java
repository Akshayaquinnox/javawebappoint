package com.akshaya.appoint;


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

@Path("/appoint")
public class appointmentresources {

	appointmentrepository repo= new appointmentrepository();
	@GET
	@Path("/details")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<appointment> getallappointment() throws  Exception {
		
		return repo.getallappointment();
		
	}
	
	@GET
	@Path("/details/{doctor}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<appointment> getallappointmentbyname(@PathParam("doctor") String doctor) throws  Exception {
		
		return repo.getallappointmentbyname(doctor);
		
	}
@POST
@Path("/insert")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public appointment addappointment( appointment a) throws Exception{
	 repo.addappointment(a);
	 return a;
}

@PUT
@Path("/update/{doctor}")
@Consumes(MediaType.APPLICATION_JSON)
public appointment updateappointment(@PathParam("doctor") String doctor, appointment a) throws Exception{
	
	 repo.updateappointment(a);
	
	
	 return a;
}
@DELETE
@Path("/delete/{doctor}")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public String deleteappointment(@PathParam("doctor") String doctor) throws Exception{
	//String doctor1=a.getDoctor();
	 repo.deleteappointment(doctor);
	 
	
	 return "details"+doctor+"deleted";
}
	
}
