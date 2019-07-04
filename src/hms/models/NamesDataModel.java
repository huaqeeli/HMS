package hms.models;


public class NamesDataModel {
    String militaryid,orderid,endatefrom,endateto;
    String fo_militaryid,rank,name;

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