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
@XmlRootElement (name="statistics")
public class Statistics {
    private int total_user;
    private int total_doctor;
    private int total_patientreg;
    private int total_wards;
    private int total_wards_av;
    private int total_wards_tk;
    private int total_appoint;
    private int total_admit;
    private int total_discharge;
    private int total_curadmit;
    private int total_transfers;
    private int total_medicine;
    private int total_revenue;

    public Statistics(int total_user, int total_doctor, int total_patientreg, int total_wards, int total_wards_av, int total_wards_tk, int total_appoint, int total_admit, int total_discharge, int total_curadmit, int total_transfers, int total_medicine, int total_revenue) {
        this.total_user = total_user;
        this.total_doctor = total_doctor;
        this.total_patientreg = total_patientreg;
        this.total_wards = total_wards;
        this.total_wards_av = total_wards_av;
        this.total_wards_tk = total_wards_tk;
        this.total_appoint = total_appoint;
        this.total_admit = total_admit;
        this.total_discharge = total_discharge;
        this.total_curadmit = total_curadmit;
        this.total_transfers = total_transfers;
        this.total_medicine = total_medicine;
        this.total_revenue = total_revenue;
    }

    public Statistics() {
        this.total_user = 0;
        this.total_doctor = 0;
        this.total_patientreg = 0;
        this.total_wards = 0;
        this.total_wards_av = 0;
        this.total_wards_tk = 0;
        this.total_appoint = 0;
        this.total_admit = 0;
        this.total_discharge = 0;
        this.total_curadmit = 0;
        this.total_transfers = 0;
        this.total_medicine = 0;
        this.total_revenue = 0;
    }

    public int getTotal_user() {
        return total_user;
    }

    public void setTotal_user(int total_user) {
        this.total_user = total_user;
    }

    public int getTotal_doctor() {
        return total_doctor;
    }

    public void setTotal_doctor(int total_doctor) {
        this.total_doctor = total_doctor;
    }

    public int getTotal_patientreg() {
        return total_patientreg;
    }

    public void setTotal_patientreg(int total_patientreg) {
        this.total_patientreg = total_patientreg;
    }

    public int getTotal_wards() {
        return total_wards;
    }

    public void setTotal_wards(int total_wards) {
        this.total_wards = total_wards;
    }

    public int getTotal_wards_av() {
        return total_wards_av;
    }

    public void setTotal_wards_av(int total_wards_av) {
        this.total_wards_av = total_wards_av;
    }

    public int getTotal_wards_tk() {
        return total_wards_tk;
    }

    public void setTotal_wards_tk(int total_wards_tk) {
        this.total_wards_tk = total_wards_tk;
    }

    public int getTotal_appoint() {
        return total_appoint;
    }

    public void setTotal_appoint(int total_appoint) {
        this.total_appoint = total_appoint;
    }

    public int getTotal_admit() {
        return total_admit;
    }

    public void setTotal_admit(int total_admit) {
        this.total_admit = total_admit;
    }

    public int getTotal_discharge() {
        return total_discharge;
    }

    public void setTotal_discharge(int total_discharge) {
        this.total_discharge = total_discharge;
    }

    public int getTotal_curadmit() {
        return total_curadmit;
    }

    public void setTotal_curadmit(int total_curadmit) {
        this.total_curadmit = total_curadmit;
    }

    public int getTotal_transfers() {
        return total_transfers;
    }

    public void setTotal_transfers(int total_transfers) {
        this.total_transfers = total_transfers;
    }

    public int getTotal_medicine() {
        return total_medicine;
    }

    public void setTotal_medicine(int total_medicine) {
        this.total_medicine = total_medicine;
    }

    public int getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(int total_revenue) {
        this.total_revenue = total_revenue;
    }

    
      @Override
    public String toString(){
            return total_user+"::";
    }
    
}
