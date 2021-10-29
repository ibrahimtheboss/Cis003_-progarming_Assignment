/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.AdmitUtils;
import com.hms.objects.Admit;
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
@Path("/admit-json")
public class AdmitServiceImp implements AdmitService {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    @Override
    public String getAdmit(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AdmitUtils.getAdmit(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getAdmit() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(AdmitUtils.getAdmit());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdmit(String json) {
        Admit admit = convertJsonToAdmit(json);
        Response response = new Response();
        try {
            AdmitUtils.addAdmit(admit);
            response.setMessage("Admit patient is added");
            response.setStatus(true);
            response.setCode("200");
        } catch(Exception e) {
            response.setMessage("Admit patient is not added");
            response.setStatus(false);
            response.setCode("400");
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response updateAdmit(String json) {
        Admit admit = convertJsonToAdmit(json);
        Response response = new Response();
        try {
            AdmitUtils.updateAdmit(admit);            
            response.setMessage("Admit patient is updated");
            response.setStatus(true);
            response.setCode("200");
        } catch(Exception e) {
            response.setMessage("Admit patient is not updated");
            response.setStatus(false);
            response.setCode("400");
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response deleteAdmit(@PathParam("id")int id) {
        Response response = new Response();
        try {
            AdmitUtils.deleteAdmit(id);
            response.setMessage("Admit patient is deleted");
            response.setStatus(true);
            response.setCode("200");
        } catch(Exception e) {
            response.setMessage("Admit patient is not deleted");
            response.setStatus(false);
            response.setCode("400");
        }
        return response;
    }
    
    Admit convertJsonToAdmit(String json) {
        return new Gson().fromJson(json, Admit.class);
    }
}
