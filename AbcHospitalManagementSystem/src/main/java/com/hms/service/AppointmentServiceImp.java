/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.AppointmentUtils;
import com.hms.objects.Appointment;
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
@Path("/appointment-json")
public class AppointmentServiceImp implements AppointmentService {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    @Override
    public String getAppointment(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AppointmentUtils.getAppointment(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getAppointment() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AppointmentUtils.getAppointment());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response addAppointment(String json) {
        Appointment appointment = convertJsonToAppointment(json);
        Response response = new Response();
        try {
            AppointmentUtils.addAppointment(appointment);
            response.setMessage("Appointment is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Appointment is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response updateAppointment(String json) {
        Appointment appointment = convertJsonToAppointment(json);
        Response response = new Response();
        try {
            AppointmentUtils.updateAppointment(appointment);            
            response.setMessage("Appointment is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Appointment is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAppointment(@PathParam("id")int id) {
        Response response = new Response();
        try {
            AppointmentUtils.deleteAppointment(id);
            response.setMessage("Appointment is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Appointment is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Appointment convertJsonToAppointment(String json) {
        return new Gson().fromJson(json, Appointment.class);
    }
}
