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
@XmlRootElement (name="patient")
public class Patient {
    private int patient_id;
    private String patient_fname;
    private String patient_lname;
    private String patient_dob;
    private String patient_nic;
    private int patient_phone_no;
    private String patient_email;
    private String patient_address;
    private String patient_gender;

    public Patient(int patient_id, String patient_fname, String patient_lname, String patient_dob, String patient_nic, int patient_phone_no, String patient_email, String patient_address, String patient_gender) {
        this.patient_id = patient_id;
        this.patient_fname = patient_fname;
        this.patient_lname = patient_lname;
        this.patient_dob = patient_dob;
        this.patient_nic = patient_nic;
        this.patient_phone_no = patient_phone_no;
        this.patient_email = patient_email;
        this.patient_address = patient_address;
        this.patient_gender = patient_gender;
    }

    public Patient() {
        this.patient_id = 0;
        this.patient_fname = "";
        this.patient_lname = "";
        this.patient_dob = "";
        this.patient_nic = "";
        this.patient_phone_no = 0;
        this.patient_email = "";
        this.patient_address = "";
        this.patient_gender = "";
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_fname() {
        return patient_fname;
    }

    public void setPatient_fname(String patient_fname) {
        this.patient_fname = patient_fname;
    }

    public String getPatient_lname() {
        return patient_lname;
    }

    public void setPatient_lname(String patient_lname) {
        this.patient_lname = patient_lname;
    }

    public String getPatient_dob() {
        return patient_dob;
    }

    public void setPatient_dob(String patient_dob) {
        this.patient_dob = patient_dob;
    }

    public String getPatient_nic() {
        return patient_nic;
    }

    public void setPatient_nic(String patient_nic) {
        this.patient_nic = patient_nic;
    }

    public int getPatient_phone_no() {
        return patient_phone_no;
    }

    public void setPatient_phone_no(int patient_phone_no) {
        this.patient_phone_no = patient_phone_no;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getPatient_gender() {
        return patient_gender;
    }

    public void setPatient_gender(String patient_gender) {
        this.patient_gender = patient_gender;
    }
    
   @Override
    public String toString() {
        return patient_id+"::"+patient_fname+"::"+patient_lname+"::"+patient_dob+"::"+patient_nic+"::"
                +"::"+patient_phone_no+"::"+patient_email+"::"+patient_address+"::"+patient_gender ;
    }
}
