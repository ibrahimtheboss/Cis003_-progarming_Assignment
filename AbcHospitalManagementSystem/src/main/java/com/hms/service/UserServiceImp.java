/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.DoctorUtils;
import com.hms.dao.UserUtils;
import com.hms.objects.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("/user-json")
public class UserServiceImp implements UserService {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getUser(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(UserUtils.getUser(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(UserUtils.getUser());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(String json) {
        User user = convertJsonToUser(json);
        Response response = new Response();
        try {
            UserUtils.addUser(user);
            response.setMessage("User is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("User is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(String json) {
        User user = convertJsonToUser(json);
        Response response = new Response();
        try {
            UserUtils.updateUser(user);            
            response.setMessage("User is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("User is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id")int id) {
        Response response = new Response();
        try {
            UserUtils.deleteUser(id);
            response.setMessage("User is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("User is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    User convertJsonToUser(String json) {
        return new Gson().fromJson(json, User.class);
    }
}
