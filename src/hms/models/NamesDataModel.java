package hms.models;

import javafx.scene.control.Button;


public class NamesDataModel {
    String militaryid,orderid,endatefrom,endateto;
    String fo_militaryid,rank,name,enfrom,ento,enfromdate,entodate;
    int sq;
   

    public NamesDataModel(String militaryid, String orderid, String endatefrom, String endateto) {
        this.militaryid = militaryid;
        this.orderid = orderid;
        this.endatefrom = endatefrom;
        this.endateto = endateto;
    }

    public NamesDataModel(String fo_militaryid, String rank, String name) {
        this.fo_militaryid = fo_militaryid;
        this.rank = rank;
        this.name = name;
    }

    public NamesDataModel(String fo_militaryid, String rank, String name, String enfrom, String ento, String enfromdate, String entodate,int sq) {
        this.fo_militaryid = fo_militaryid;
        this.rank = rank;
        this.name = name;
        this.enfrom = enfrom;
        this.ento = ento;
        this.enfromdate = enfromdate;
        this.entodate = entodate;
        this.sq = sq;
       
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }

    public String getEnfrom() {
        return enfrom;
    }

    public void setEnfrom(String enfrom) {
        this.enfrom = enfrom;
    }

    public String getEnto() {
        return ento;
    }

    public void setEnto(String ento) {
        this.ento = ento;
    }

    

    public String getEnfromdate() {
        return enfromdate;
    }

    public void setEnfromdate(String enfromdate) {
        this.enfromdate = enfromdate;
    }

    public String getEntodate() {
        return entodate;
    }

    public void setEntodate(String entodate) {
        this.entodate = entodate;
    }
    
    

    public String getFo_militaryid() {
        return fo_militaryid;
    }

    public void setFo_militaryid(String fo_militaryid) {
        this.fo_militaryid = fo_militaryid;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getMilitaryid() {
        return militaryid;
    }

    public void setMilitaryid(String militaryid) {
        this.militaryid = militaryid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getEndatefrom() {
        return endatefrom;
    }

    public void setEndatefrom(String endatefrom) {
        this.endatefrom = endatefrom;
    }

    public String getEndateto() {
        return endateto;
    }

    public void setEndateto(String endateto) {
        this.endateto = endateto;
    }
    
}
