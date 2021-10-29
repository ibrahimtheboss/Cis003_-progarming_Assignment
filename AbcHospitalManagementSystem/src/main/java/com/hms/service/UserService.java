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
public interface UserService {
     public Response addUser(String json);

    public Response deleteUser(int id);
    
    public Response updateUser(String json);

    public String getUser(int id);
    
    public String getUser() ;
}
