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
@XmlRootElement (name="bill")
public class bill {
    private int bill_id;
    private int patient_id;
    private String datetime;
    private double medical_charge;
    private double appointment_charge;
    private double hospital_charge;
    private double discount;
    private double total;

    public bill(int bill_id, int patient_id, String datetime, double medical_charge, double appointment_charge, double hospital_charge, double discount, double total) {
        this.bill_id = bill_id;
        this.patient_id = patient_id;
        this.datetime = datetime;
        this.medical_charge = medical_charge;
        this.appointment_charge = appointment_charge;
        this.hospital_charge = hospital_charge;
        this.discount = discount;
        this.total = total;
    }

  

    public bill() {
        this.bill_id = 0;
        this.patient_id = 0;
        this.datetime = "";
        this.medical_charge = 0.00;
        this.appointment_charge = 0.00;
        this.hospital_charge = 0.00;
        this.discount = 0.00;
        this.total = 0.00;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getMedical_charge() {
        return medical_charge;
    }

    public void setMedical_charge(double medical_charge) {
        this.medical_charge = medical_charge;
    }

    public double getAppointment_charge() {
        return appointment_charge;
    }

    public void setAppointment_charge(double appointment_charge) {
        this.appointment_charge = appointment_charge;
    }

    public double getHospital_charge() {
        return hospital_charge;
    }

    public void setHospital_charge(double hospital_charge) {
        this.hospital_charge = hospital_charge;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
    @Override
    public String toString() {
        return bill_id+"::"+patient_id+"::"+datetime+"::"
           +"::"+medical_charge+"::"+appointment_charge+"::"+hospital_charge+"::"+discount+"::"+total;
    } 
}
