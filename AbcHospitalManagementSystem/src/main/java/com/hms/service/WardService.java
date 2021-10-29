/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.common.Response;

/**
 *
 * @author User
 */
public interface WardService {
    public Response addWard(String json);

    public Response deleteWard(int id);
    
    public Response updateWard(String json);

    public String getWard(int id);
    
    public String getWard() ;
 
}
