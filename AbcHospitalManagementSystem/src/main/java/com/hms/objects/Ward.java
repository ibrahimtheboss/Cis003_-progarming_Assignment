/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement (name="ward")
public class Ward {
    private int ward_id;
    private String ward_no;
    private String ward_type;
    private String ward_status;

    public Ward(int ward_id, String ward_no, String ward_type, String ward_status) {//constructor
        this.ward_id = ward_id;
        this.ward_no = ward_no;
        this.ward_type = ward_type;
        this.ward_status = ward_status;
    }

    public Ward() {// Default Constructor
        this.ward_id = 0;
        this.ward_no = "";
        this.ward_type = "";
        this.ward_status = "Available";// The Default value available 
    }

    public int getWard_id() { // Getter
        return ward_id;
    }

    public void setWard_id(int ward_id) { //Setter
        this.ward_id = ward_id;
    }

    public String getWard_no() {
        return ward_no;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

    public String getWard_type() {
        return ward_type;
    }

    public void setWard_type(String ward_type) {
        this.ward_type = ward_type;
    }
     public String getWard_status() {
        return ward_status;
    }

    public void setWard_status(String ward_status) {
        this.ward_status = ward_status;
    }
    
@Override
    public String toString() {
        return ward_id+"::"+ward_no+"::"+ward_type+"::"+ward_status;
    } 
}
