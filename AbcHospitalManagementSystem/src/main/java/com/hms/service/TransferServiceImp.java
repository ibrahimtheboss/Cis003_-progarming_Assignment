/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.TransferUtils;
import com.hms.objects.Transfer;
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
@Path("/transfer-json")
public class TransferServiceImp implements TransferService{
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getTransfer(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(TransferUtils.getTransfer(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getTransfer() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(TransferUtils.getTransfer());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTransfer(String json) {
        Transfer transfer = convertJsonToTransfer(json);
        Response response = new Response();
        try {
            TransferUtils.addTransfer(transfer);
            response.setMessage("Transfer patient is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Transfer patient is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTransfer(String json) {
        Transfer transfer = convertJsonToTransfer(json);
        Response response = new Response();
        try {
            TransferUtils.updateTransfer(transfer);            
            response.setMessage("Transfer patient is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Transfer patient is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteTransfer(@PathParam("id")int id) {
        Response response = new Response();
        try {
            TransferUtils.deleteTransfer(id);
            response.setMessage("Transfer patient is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Transfer patient is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    Transfer convertJsonToTransfer(String json) {
        return new Gson().fromJson(json, Transfer.class);
    }
}
