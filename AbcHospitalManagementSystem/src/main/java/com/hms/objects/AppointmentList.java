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
@XmlRootElement (name="appointmentlist")
public class AppointmentList {
    
     private int appointmentList_id;
    private String appointmentList_name;
    private int appointmentList_age;
    private String appointmentList_gender;
    private int doctor_id;
    private String doctor_fname;
    private String doctor_lname;
    private String appointmentList_date;
    private String appointmentList_time;
    private int appointmentList_tel;
    private int patient_id;
    private double appointmentList_charge;
    private String appointmentList_no;
    private String appointmentList_branch;

    public AppointmentList(int appointmentList_id, String appointmentList_name, int appointmentList_age, String appointmentList_gender, int doctor_id, String doctor_fname, String doctor_lname, String appointmentList_date, String appointmentList_time, int appointmentList_tel, int patient_id, double appointmentList_charge, String appointmentList_no, String appointmentList_branch) {
        this.appointmentList_id = appointmentList_id;
        this.appointmentList_name = appointmentList_name;
        this.appointmentList_age = appointmentList_age;
        this.appointmentList_gender = appointmentList_gender;
        this.doctor_id = doctor_id;
        this.doctor_fname = doctor_fname;
        this.doctor_lname = doctor_lname;
        this.appointmentList_date = appointmentList_date;
        this.appointmentList_time = appointmentList_time;
        this.appointmentList_tel = appointmentList_tel;
        this.patient_id = patient_id;
        this.appointmentList_charge = appointmentList_charge;
        this.appointmentList_no = appointmentList_no;
        this.appointmentList_branch = appointmentList_branch;
    }

    public AppointmentList() {
        this.appointmentList_id = 0;
        this.appointmentList_name = "";
        this.appointmentList_age = 0;
        this.appointmentList_gender = "";
        this.doctor_id = 0;
        this.doctor_fname = "";
        this.doctor_lname = "";
        this.appointmentList_date = "";
        this.appointmentList_time = "";
        this.appointmentList_tel = 0;
        this.patient_id = 0;
        this.appointmentList_charge = 0;
        this.appointmentList_no = "";
        this.appointmentList_branch = "";
    }

    public int getAppointmentList_id() {
        return appointmentList_id;
    }

    public void setAppointmentList_id(int appointmentList_id) {
        this.appointmentList_id = appointmentList_id;
    }

    public String getAppointmentList_name() {
        return appointmentList_name;
    }

    public void setAppointmentList_name(String appointmentList_name) {
        this.appointmentList_name = appointmentList_name;
    }

    public int getAppointmentList_age() {
        return appointmentList_age;
    }

    public void setAppointmentList_age(int appointmentList_age) {
        this.appointmentList_age = appointmentList_age;
    }

    public String getAppointmentList_gender() {
        return appointmentList_gender;
    }

    public void setAppointmentList_gender(String appointmentList_gender) {
        this.appointmentList_gender = appointmentList_gender;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_fname() {
        return doctor_fname;
    }

    public void setDoctor_fname(String doctor_fname) {
        this.doctor_fname = doctor_fname;
    }

    public String getDoctor_lname() {
        return doctor_lname;
    }

    public void setDoctor_lname(String doctor_lname) {
        this.doctor_lname = doctor_lname;
    }

    public String getAppointmentList_date() {
        return appointmentList_date;
    }

    public void setAppointmentList_date(String appointmentList_date) {
        this.appointmentList_date = appointmentList_date;
    }

    public String getAppointmentList_time() {
        return appointmentList_time;
    }

    public void setAppointmentList_time(String appointmentList_time) {
        this.appointmentList_time = appointmentList_time;
    }

    public int getAppointmentList_tel() {
        return appointmentList_tel;
    }

    public void setAppointmentList_tel(int appointmentList_tel) {
        this.appointmentList_tel = appointmentList_tel;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public double getAppointmentList_charge() {
        return appointmentList_charge;
    }

    public void setAppointmentList_charge(double appointmentList_charge) {
        this.appointmentList_charge = appointmentList_charge;
    }

    public String getAppointmentList_no() {
        return appointmentList_no;
    }

    public void setAppointmentList_no(String appointmentList_no) {
        this.appointmentList_no = appointmentList_no;
    }

    public String getAppointmentList_branch() {
        return appointmentList_branch;
    }

    public void setAppointmentList_branch(String appointmentList_branch) {
        this.appointmentList_branch = appointmentList_branch;
    }

   
    @Override
    public String toString() {
        return appointmentList_id+"::"+appointmentList_name+"::"+appointmentList_age+"::"+appointmentList_gender+"::"+doctor_id+"::"
                +"::"+appointmentList_date+"::"+appointmentList_time+"::"+appointmentList_tel+"::"+patient_id+"::"
                +"::"+appointmentList_charge+"::"+appointmentList_no+"::"+appointmentList_branch ;
    }
    
}
