/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.models;

/**
 *
 * @author ابو ريان
 */
public class ErorreMesageModel {
    String listNumber,militaryid,reason;

    public ErorreMesageModel(String listNumber, String militaryid, String reason) {
        this.listNumber = listNumber;
        this.militaryid = militaryid;
        this.reason = reason;
    }

    public String getListNumber() {
        return listNumber;
    }

    public void setListNumber(String listNumber) {
        this.listNumber = listNumber;
    }

    public String getMilitaryid() {
        return militaryid;
    }

    public void setMilitaryid(String militaryid) {
        this.militaryid = militaryid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
