/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hms.common.Response;
import com.hms.dao.BillUtils;
import com.hms.objects.bill;
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
@Path("/bill-json")
public class BillServiceImp implements BillService{
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/{id}")
    public String getBill(@PathParam("id")int id) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(BillUtils.getBill(id)); 
    } 
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getBill() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(BillUtils.getBill());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBill(String json) {
        bill bill = convertJsonToBill(json);
        Response response = new Response();
        try {
            BillUtils.addBill(bill);
            response.setMessage("Bill is added");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Bill is not added");
            response.setStatus(false); 
        }
        return response;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBill(String json) {
        bill bill = convertJsonToBill(json);
        Response response = new Response();
        try {
            BillUtils.updateBill(bill);            
            response.setMessage("Bill is updated");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Bill is not updated");
            response.setStatus(false); 
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBill(@PathParam("id")int id) {
        Response response = new Response();
        try {
            BillUtils.deleteBill(id);
            response.setMessage("Bill is deleted");
            response.setStatus(true);
        } catch(Exception e) {
            response.setMessage("Bill is not deleted");
            response.setStatus(false); 
        }
        return response;
    }
    
    bill convertJsonToBill(String json) {
        return new Gson().fromJson(json, bill.class);
    }
}
