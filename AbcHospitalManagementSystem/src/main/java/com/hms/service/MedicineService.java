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
public interface MedicineService {
    public Response addMedicine(String json);

    public Response deleteMedicine(int id);
    
    public Response updateMedicine(String json);

    public String getMedicine(int id);
    
    public String getMedicine() ;
}
