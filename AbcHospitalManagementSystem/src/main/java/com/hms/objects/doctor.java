/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.objects;

import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *`
 * @author User
 */
@XmlRootElement (name="doctor")
public class doctor {
    
    private int doc_id;
    private String doc_firstname;
    private String doc_lastname;
    private String doc_dateofbirth;
    private String doc_nic_no;
    private String doc_sex;
    private int doc_phone_no;
    private String doc_address;
    private String specilization;
    private String doc_department;
    private String branch;

    public doctor(int doc_id, String doc_firstname, String doc_lastname, String doc_dateofbirth, String doc_nic_no, String doc_sex, int doc_phone_no, String doc_address, String specilization, String doc_department, String branch) {
        this.doc_id = doc_id;
        this.doc_firstname = doc_firstname;
        this.doc_lastname = doc_lastname;
        this.doc_dateofbirth = doc_dateofbirth;
        this.doc_nic_no = doc_nic_no;
        this.doc_sex = doc_sex;
        this.doc_phone_no = doc_phone_no;
        this.doc_address = doc_address;
        this.specilization = specilization;
        this.doc_department = doc_department;
        this.branch = branch;
    }

    public doctor() {
        this.doc_id = 0;
        this.doc_firstname = "";
        this.doc_lastname = "";
        this.doc_dateofbirth = "";
        this.doc_nic_no = "";
        this.doc_sex = "";
        this.doc_phone_no = 0;
        this.doc_address = "";
        this.specilization = "";
        this.doc_department = "";
        this.branch = "";
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getDoc_firstname() {
        return doc_firstname;
    }

    public void setDoc_firstname(String doc_firstname) {
        this.doc_firstname = doc_firstname;
    }

    public String getDoc_lastname() {
        return doc_lastname;
    }

    public void setDoc_lastname(String doc_lastname) {
        this.doc_lastname = doc_lastname;
    }

    public String getDoc_dateofbirth() {
        return doc_dateofbirth;
    }

    public void setDoc_dateofbirth(String doc_dateofbirth) {
        this.doc_dateofbirth = doc_dateofbirth;
    }

    public String getDoc_nic_no() {
        return doc_nic_no;
    }

    public void setDoc_nic_no(String doc_nic_no) {
        this.doc_nic_no = doc_nic_no;
    }

    public String getDoc_sex() {
        return doc_sex;
    }

    public void setDoc_sex(String doc_sex) {
        this.doc_sex = doc_sex;
    }

    public int getDoc_phone_no() {
        return doc_phone_no;
    }

    public void setDoc_phone_no(int doc_phone_no) {
        this.doc_phone_no = doc_phone_no;
    }

    public String getDoc_address() {
        return doc_address;
    }

    public void setDoc_address(String doc_address) {
        this.doc_address = doc_address;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public String getDoc_department() {
        return doc_department;
    }

    public void setDoc_department(String doc_department) {
        this.doc_department = doc_department;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return doc_id+"::"+doc_firstname+"::"+doc_lastname+"::"+doc_dateofbirth+"::"+doc_nic_no+"::"
                +"::"+doc_sex+"::"+doc_phone_no+"::"+doc_address+"::"+specilization+"::"
                +"::"+doc_department+"::"+branch;
    }
   

}
 