/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.PatientUtils;
import com.hms.objects.Patient;
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
@Path("/patient-json")
public class PatientServiceImp implements PatientService{
    
    
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getPatient(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(PatientUtils.getPatient(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getPatient() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(PatientUtils.getPatient());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(String json) {
        Patient p = convertJsonToPatient(json);
        Response response = new Response();
        try {
            PatientUtils.addPatient(p);
            response.setMessage("Patient is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Patient is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(String json) {
        Patient p = convertJsonToPatient(json);
        Response response = new Response();
        try {
            PatientUtils.updatePatient(p);            
            response.setMessage("Patient is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Patient is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePatient(@PathParam("id")int id) {
        Response response = new Response();
        try {
            PatientUtils.deletePatient(id);
            response.setMessage("Patient is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Patient is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Patient convertJsonToPatient(String json) {
        return new Gson().fromJson(json, Patient.class);
    }
}
