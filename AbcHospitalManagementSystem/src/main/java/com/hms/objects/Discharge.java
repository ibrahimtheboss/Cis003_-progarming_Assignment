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
@XmlRootElement (name="discharge")
public class Discharge {
    private int discharge_id;
    private int admit_id;
    private String discharge_reason;
    private int ward_id;
    private String discharge_date;
    private String discharge_time;
    private String discharge_branch;

    public Discharge(int discharge_id, int admit_id, String discharge_reason, int ward_id, String discharge_date, String discharge_time, String discharge_branch) {
        this.discharge_id = discharge_id;
        this.admit_id = admit_id;
        this.discharge_reason = discharge_reason;
        this.ward_id = ward_id;
        this.discharge_date = discharge_date;
        this.discharge_time = discharge_time;
        this.discharge_branch = discharge_branch;
    }

    public Discharge() {
        this.discharge_id = 0;
        this.admit_id = 0;
        this.discharge_reason = "";
        this.ward_id = 0;
        this.discharge_date = "";
        this.discharge_time = "";
        this.discharge_branch = "";
    }

    public int getDischarge_id() {
        return discharge_id;
    }

    public void setDischarge_id(int discharge_id) {
        this.discharge_id = discharge_id;
    }

    public int getAdmit_id() {
        return admit_id;
    }

    public void setAdmit_id(int admit_id) {
        this.admit_id = admit_id;
    }

    public String getDischarge_reason() {
        return discharge_reason;
    }

    public void setDischarge_reason(String discharge_reason) {
        this.discharge_reason = discharge_reason;
    }

    public int getWard_id() {
        return ward_id;
    }

    public void setWard_id(int ward_id) {
        this.ward_id = ward_id;
    }

    public String getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(String discharge_date) {
        this.discharge_date = discharge_date;
    }

    public String getDischarge_time() {
        return discharge_time;
    }

    public void setDischarge_time(String discharge_time) {
        this.discharge_time = discharge_time;
    }

    public String getDischarge_branch() {
        return discharge_branch;
    }

    public void setDischarge_branch(String discharge_branch) {
        this.discharge_branch = discharge_branch;
    }
    
   @Override
    public String toString() {
        return discharge_id+"::"+admit_id+"::"+discharge_reason+"::"+ward_id+"::"+discharge_date+"::"
                +"::"+discharge_time+"::"+discharge_branch  ;
    } 
    
    
}
