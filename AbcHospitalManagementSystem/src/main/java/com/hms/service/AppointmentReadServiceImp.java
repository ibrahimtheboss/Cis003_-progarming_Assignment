/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.dao.AppointmentReadUtils;
import com.hms.objects.AppointmentList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("/appointmentview-json")
public class AppointmentReadServiceImp {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getApointmnetList(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AppointmentReadUtils.getAppointmentList(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getApointmnetList() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AppointmentReadUtils.getAppointment());
    }
    AppointmentList convertJsonToApointmnetList(String json) {
        return new Gson().fromJson(json, AppointmentList.class);
    }
}
