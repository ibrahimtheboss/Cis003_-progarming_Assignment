/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public final class databaseconn {
    
    private static databaseconn instance;
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3306/icbt_batch22";
    static final String USER = "root";
    static final String PASS = "user";

    private databaseconn() throws SQLException { // making constructor private so that this class cannot be instantiated 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS); // getting connection
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }//passing the error message
    }
    
    public Connection getConnection() { 
        return connection;
    }
    public static databaseconn getInstance() throws SQLException {  //get the only object avalible 
        if (instance == null) {
            instance = new databaseconn();       // creating an object of databasecon
        } else if (instance.getConnection().isClosed()) {  
            instance = new databaseconn();      // creating an object of databasecon if the conection is closed 
        }

        return instance;
    }
}
