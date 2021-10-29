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
public interface TransferService {
    public Response addTransfer(String json);

    public Response deleteTransfer(int id);
    
    public Response updateTransfer(String json);

    public String getTransfer(int id);
    
    public String getTransfer() ;
}
