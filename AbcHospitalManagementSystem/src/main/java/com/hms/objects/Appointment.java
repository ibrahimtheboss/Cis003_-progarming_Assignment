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
@XmlRootElement (name="appointment")
public class Appointment {
    private int appointment_id;
    private String appointment_name;
    private int appointment_age;
    private String appointment_gender;
    private int doctor_id;
    
    private String appointment_date;
    private String appointment_time;
    private int appointment_tel;
    private int patient_id;
    private double appointment_charge;
    private String appointment_no;
    private String appointment_branch;

    public Appointment(int appointment_id, String appointment_name, int appointment_age, String appointment_gender, int doctor_id, String appointment_date, String appointment_time, int appointment_tel, int patient_id, double appointment_charge, String appointment_no, String appointment_branch) {
        this.appointment_id = appointment_id;
        this.appointment_name = appointment_name;
        this.appointment_age = appointment_age;
        this.appointment_gender = appointment_gender;
        this.doctor_id = doctor_id;
        
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.appointment_tel = appointment_tel;
        this.patient_id = patient_id;
        this.appointment_charge = appointment_charge;
        this.appointment_no = appointment_no;
        this.appointment_branch = appointment_branch;
    }

    public Appointment() {
        this.appointment_id = 0;
        this.appointment_name = "";
        this.appointment_age = 0;
        this.appointment_gender = "";
        this.doctor_id = 0;
        
        this.appointment_date = "";
        this.appointment_time = "";
        this.appointment_tel = 0;
        this.patient_id = 0;
        this.appointment_charge = 0.0;
        this.appointment_no = "";
        this.appointment_branch = "";
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getAppointment_name() {
        return appointment_name;
    }

    public void setAppointment_name(String appointment_name) {
        this.appointment_name = appointment_name;
    }

    public int getAppointment_age() {
        return appointment_age;
    }

    public void setAppointment_age(int appointment_age) {
        this.appointment_age = appointment_age;
    }

    public String getAppointment_gender() {
        return appointment_gender;
    }

    public void setAppointment_gender(String appointment_gender) {
        this.appointment_gender = appointment_gender;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public int getAppointment_tel() {
        return appointment_tel;
    }

    public void setAppointment_tel(int appointment_tel) {
        this.appointment_tel = appointment_tel;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public double getAppointment_charge() {
        return appointment_charge;
    }

    public void setAppointment_charge(double appointment_charge) {
        this.appointment_charge = appointment_charge;
    }

    public String getAppointment_no() {
        return appointment_no;
    }

    public void setAppointment_no(String appointment_no) {
        this.appointment_no = appointment_no;
    }

    public String getAppointment_branch() {
        return appointment_branch;
    }

    public void setAppointment_branch(String appointment_branch) {
        this.appointment_branch = appointment_branch;
    }

    
    @Override
    public String toString() {
        return appointment_id+"::"+appointment_name+"::"+appointment_age+"::"+appointment_gender+"::"+doctor_id+"::"
                +"::"+appointment_date+"::"+appointment_time+"::"+appointment_tel+"::"+patient_id+"::"
                +"::"+appointment_charge+"::"+appointment_no+"::"+appointment_branch ;
    }
    
}
