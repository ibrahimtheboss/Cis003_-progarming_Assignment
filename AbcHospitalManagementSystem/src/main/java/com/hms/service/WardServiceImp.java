/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.WardUtils;
import com.hms.objects.Ward;
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
@Path("/ward-json")
public class WardServiceImp implements WardService {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    @Override
    public String getWard(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(WardUtils.getWard(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getWard() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(WardUtils.getWard());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response addWard(String json) {
        Ward ward = convertJsonToWard(json);
        Response response = new Response();
        try {
            WardUtils.addWard(ward);
            response.setMessage("Ward is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Ward is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response updateWard(String json) {
        Ward ward = convertJsonToWard(json);
        Response response = new Response();
        try {
            WardUtils.updateWard(ward);            
            response.setMessage("Ward is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Ward is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response deleteWard(@PathParam("id")int id) {
        Response response = new Response();
        try {
            WardUtils.deleteWard(id);
            response.setMessage("Ward is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Ward is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Ward convertJsonToWard(String json) {
        return new Gson().fromJson(json, Ward.class);
    }
}
