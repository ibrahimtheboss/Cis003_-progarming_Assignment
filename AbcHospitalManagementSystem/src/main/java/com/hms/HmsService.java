/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/hms-service")
public class HmsService {
    @GET
    @Path("/{message}")
    public Response getMessage(@PathParam("message")String msg){
        String message ="Hello World" +msg ;
        return Response.status(200).entity(message).build();
    }
    // Just for Testing Purposes !!1
}
