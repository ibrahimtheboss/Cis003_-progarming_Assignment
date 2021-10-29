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
public interface PatientService {
     public Response addPatient(String json);

    public Response deletePatient(int id);
    
    public Response updatePatient(String json);

    public String getPatient(int id);
    
    public String getPatient() ;
}
