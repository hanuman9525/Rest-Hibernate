package com.scp.consume;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scp.bean.User;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsumeProductService {
	
	public static void main(String[] args) throws JSONException, JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.get("http://localhost:8080/RestApi/user");
		List<User> listOfUser=new ArrayList<>();
		JSONArray array=new JSONArray(response.asString());
		for (int i = 0; i < array.length(); i++) {
			JSONObject object=new JSONObject(array.get(i).toString());
			User user=new User();
			user.setUserId(object.getString("userId"));
			user.setUserName(object.getString("userName"));
			listOfUser.add(user);
			
		}
		System.out.println(listOfUser.toString());
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		
		Response respons=RestAssured.get("http://localhost:8080/RestApi/user/"+str);
		ObjectMapper mapper = new ObjectMapper();
		 
		User use = mapper.readValue(respons.asString(), User.class);
		System.out.println("Get the user object::"+use);
		User user=new User();
		user.setUserId("12004");
		user.setUserName("PQR123");
		
		
		Response resp= RestAssured.given().contentType("application/json").body(user).when().post("http://localhost:8080/RestApi/user");
		System.out.println(resp.asString());
		if(resp.getStatusCode()==200)
			System.out.println("okk..");
		else
			System.out.println("Fail..");
		
				
	}

}
