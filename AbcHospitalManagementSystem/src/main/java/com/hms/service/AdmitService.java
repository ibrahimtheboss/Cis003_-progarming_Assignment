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
public interface AdmitService  {
    
    public Response addAdmit(String json);

    public Response deleteAdmit(int id);
    
    public Response updateAdmit(String json);

    public String getAdmit(int id);
    
    public String getAdmit() ;
}
