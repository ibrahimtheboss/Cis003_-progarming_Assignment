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
public interface DischargeService {
    public Response addDischarge(String json);

    public Response deleteDischarge(int id);
    
    public Response updateDischarge(String json);

    public String getDischarge(int id);
    
    public String getDischarge() ;
}
