/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.DischargeUtils;
import com.hms.objects.Discharge;
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
@Path("/discharge-json")
public class DischargeServiceImp implements DischargeService{
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getDischarge(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(DischargeUtils.getDischarge(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getDischarge() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(DischargeUtils.getDischarge());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDischarge(String json) {
        Discharge discharge = convertJsonToDischarge(json);
        Response response = new Response();
        try {
            DischargeUtils.addDischarge(discharge);
            response.setMessage("Discharge patient is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Discharge patient is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDischarge(String json) {
        Discharge discharge = convertJsonToDischarge(json);
        Response response = new Response();
        try {
            DischargeUtils.updateDischarge(discharge);            
            response.setMessage("Discharge patient is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Discharge patient is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDischarge(@PathParam("id")int id) {
        Response response = new Response();
        try {
            DischargeUtils.deleteDischarge(id);
            response.setMessage("Discharge patient is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Discharge patient is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Discharge convertJsonToDischarge(String json) {
        return new Gson().fromJson(json, Discharge.class);
    }
}
