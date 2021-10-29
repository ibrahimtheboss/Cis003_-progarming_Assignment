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
public interface DoctorService {
    public Response addDoctor(String json);

    public Response deleteDoctor(int id);
    
    public Response updateDoctor(String json);

    public String getDoctor(int id);
    
    public String getDoctor() ;
}
