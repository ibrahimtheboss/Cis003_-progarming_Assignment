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
public interface BillService {
    public Response addBill(String json);

    public Response deleteBill(int id);
    
    public Response updateBill(String json);

    public String getBill(int id);
    
    public String getBill() ;
}
