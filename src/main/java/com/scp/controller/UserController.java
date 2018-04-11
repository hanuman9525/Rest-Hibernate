package com.scp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scp.bean.User;
import com.scp.dao.UserDaoImpl;

@Path("/user")
public class UserController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUser() {
		
		return new UserDaoImpl().getAllUser();
	}
	
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") String userId)
	{
		if(userId!=null)
		{
			return new UserDaoImpl().getUser(userId);
		}
		else
		{
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User user)
	{
		if(user!=null)
		{
			return new UserDaoImpl().addUser(user);
		}
		else
		{
			return "Fail";
		}
	}
}
