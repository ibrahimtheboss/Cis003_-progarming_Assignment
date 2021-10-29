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
@XmlRootElement (name="admittedlist")
public class AdmittedList{
    
    private int admit_id;
    private int patient_id;
    private String patient_name;
    private String admit_reason;
    private int ward_id;
    private String ward_no;
    private String admit_date;
    private String admit_time;
    private String admit_branch;

    public AdmittedList(int admit_id, int patient_id, String patient_name, String admit_reason, int ward_id, String ward_no, String admit_date, String admit_time, String admit_branch) {
        this.admit_id = admit_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.admit_reason = admit_reason;
        this.ward_id = ward_id;
        this.ward_no = ward_no;
        this.admit_date = admit_date;
        this.admit_time = admit_time;
        this.admit_branch = admit_branch;
    }

    public AdmittedList() {
        this.admit_id = 0;
        this.patient_id = 0;
        this.patient_name = "";
        this.admit_reason = "";
        this.ward_id = 0;
        this.ward_no = "";
        this.admit_date = "";
        this.admit_time = "";
        this.admit_branch = "";
    }

    public int getAdmit_id() {
        return admit_id;
    }

    public void setAdmit_id(int admit_id) {
        this.admit_id = admit_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getAdmit_reason() {
        return admit_reason;
    }

    public void setAdmit_reason(String admit_reason) {
        this.admit_reason = admit_reason;
    }

    public int getWard_id() {
        return ward_id;
    }

    public void setWard_id(int ward_id) {
        this.ward_id = ward_id;
    }

    public String getWard_no() {
        return ward_no;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

    public String getAdmit_date() {
        return admit_date;
    }

    public void setAdmit_date(String admit_date) {
        this.admit_date = admit_date;
    }

    public String getAdmit_time() {
        return admit_time;
    }

    public void setAdmit_time(String admit_time) {
        this.admit_time = admit_time;
    }

    public String getAdmit_branch() {
        return admit_branch;
    }

    public void setAdmit_branch(String admit_branch) {
        this.admit_branch = admit_branch;
    }

    
    
    @Override
    public String toString() {
        return admit_id+"::"+patient_id+"::"+patient_name+"::"+admit_reason+"::"+ward_id+"::"+ward_no+"::"+admit_date+"::"
                +"::"+admit_time+"::"+admit_branch  ;
    }
}
