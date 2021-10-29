/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.MedicineUtils;
import com.hms.objects.Medicine;
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
 * @author Medicine
 */
@Path("/medicine-json")
public class MedicineServiceImp implements MedicineService{
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    @Override
    public String getMedicine(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(MedicineUtils.getMedicine(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getMedicine() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(MedicineUtils.getMedicine());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response addMedicine(String json) {
        Medicine medicine = convertJsonToMedicine(json);
        Response response = new Response();
        try {
            MedicineUtils.addMedicine(medicine);
            response.setMessage("Medicine is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Medicine is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicine(String json) {
        Medicine medicine = convertJsonToMedicine(json);
        Response response = new Response();
        try {
            MedicineUtils.updateMedicine(medicine);            
            response.setMessage("Medicine is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Medicine is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedicine(@PathParam("id")int id) {
        Response response = new Response();
        try {
            MedicineUtils.deleteMedicine(id);
            response.setMessage("Medicine is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Medicine is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Medicine convertJsonToMedicine(String json) {
        return new Gson().fromJson(json, Medicine.class);
    }
}
