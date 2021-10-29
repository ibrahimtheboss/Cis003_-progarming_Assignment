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
public interface AppointmentService {
     public Response addAppointment(String json);

    public Response deleteAppointment(int id);
    
    public Response updateAppointment(String json);

    public String getAppointment(int id);
    
    public String getAppointment() ;
}
