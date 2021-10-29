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
@XmlRootElement (name="transfer")
public class Transfer {
    private int transfer_id;
    private int admit_id;
    private String transfer_reason;
    private String transfer_from;
    private String transfer_to;
    private String transfer_date;

    public Transfer(int transfer_id, int admit_id, String transfer_reason, String transfer_from, String transfer_to, String transfer_date) {
        this.transfer_id = transfer_id;
        this.admit_id = admit_id;
        this.transfer_reason = transfer_reason;
        this.transfer_from = transfer_from;
        this.transfer_to = transfer_to;
        this.transfer_date = transfer_date;
    }

    public Transfer() {
        this.transfer_id = 0;
        this.admit_id = 0;
        this.transfer_reason = "";
        this.transfer_from = "";
        this.transfer_to = "";
        this.transfer_date = "";
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getAdmit_id() {
        return admit_id;
    }

    public void setAdmit_id(int admit_id) {
        this.admit_id = admit_id;
    }

    public String getTransfer_reason() {
        return transfer_reason;
    }

    public void setTransfer_reason(String transfer_reason) {
        this.transfer_reason = transfer_reason;
    }

    public String getTransfer_from() {
        return transfer_from;
    }

    public void setTransfer_from(String transfer_from) {
        this.transfer_from = transfer_from;
    }

    public String getTransfer_to() {
        return transfer_to;
    }

    public void setTransfer_to(String transfer_to) {
        this.transfer_to = transfer_to;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
    }
    
    @Override
    public String toString() {
        return transfer_id+"::"+admit_id+"::"+transfer_reason+"::"+transfer_from+"::"+transfer_to+"::"
                +"::"+transfer_date  ;
    } 
    
}
