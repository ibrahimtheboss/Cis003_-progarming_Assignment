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
@XmlRootElement (name="medicine")
public class Medicine {
    private int medicine_id;
    private String medicine_name;
    private String medicine_code;
    private double medicine_price;
    private String medicine_qty;

    public Medicine(int medicine_id, String medicine_name, String medicine_code, double medicine_price, String medicine_qty) {
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.medicine_code = medicine_code;
        this.medicine_price = medicine_price;
        this.medicine_qty = medicine_qty;
    }

    public Medicine() {
        
        this.medicine_id = 0;
        this.medicine_name = "";
        this.medicine_code = "";
        this.medicine_price = 0.00;
        this.medicine_qty = "";
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_code() {
        return medicine_code;
    }

    public void setMedicine_code(String medicine_code) {
        this.medicine_code = medicine_code;
    }

    public double getMedicine_price() {
        return medicine_price;
    }

    public void setMedicine_price(double medicine_price) {
        this.medicine_price = medicine_price;
    }

    public String getMedicine_qty() {
        return medicine_qty;
    }

    public void setMedicine_qty(String medicine_qty) {
        this.medicine_qty = medicine_qty;
    }

    @Override
    public String toString(){
            return medicine_id+"::"+medicine_name+"::"+medicine_code+"::"+medicine_price+"::"+medicine_qty;
    }
}
