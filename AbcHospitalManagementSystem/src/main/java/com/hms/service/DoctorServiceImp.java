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
import com.hms.objects.doctor;
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
 @Path("/doctor-json")
public  class DoctorServiceImp implements DoctorService{

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getDoctor(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(DoctorUtils.getDoctor(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getDoctor() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(DoctorUtils.getDoctor());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(String json) {
        doctor d = convertJsonToDoctor(json);
        Response response = new Response();
        try {
            DoctorUtils.addDoctor(d);
            response.setMessage("Doctor is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Doctor is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(String json) {
        doctor d = convertJsonToDoctor(json);
        Response response = new Response();
        try {
            DoctorUtils.updateDoctor(d);            
            response.setMessage("Doctor is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Doctor is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDoctor(@PathParam("id")int id) {
        Response response = new Response();
        try {
            DoctorUtils.deleteDoctor(id);
            response.setMessage("Doctor is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Doctor is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    doctor convertJsonToDoctor(String json) {
        return new Gson().fromJson(json, doctor.class);
    }
}
