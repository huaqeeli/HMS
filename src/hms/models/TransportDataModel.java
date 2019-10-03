package hms.models;


public class TransportDataModel {
    String militaryid,rank,name,newunit,transportid,transportdate,fromdate,leavingid,leavingdate,leavingfromdate;
    int sq ;

    public TransportDataModel(String militaryid, String rank, String name, String newunit, String transportid, String transportdate, String fromdate,int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.newunit = newunit;
        this.transportid = transportid;
        this.transportdate = transportdate;
        this.fromdate = fromdate;
        this.sq = sq;
    }

    public TransportDataModel(String militaryid, String rank, String name, String newunit, String transportid, String transportdate, String fromdate, String leavingid, String leavingdate, String leavingfromdate, int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.newunit = newunit;
        this.transportid = transportid;
        this.transportdate = transportdate;
        this.fromdate = fromdate;
        this.leavingid = leavingid;
        this.leavingdate = leavingdate;
        this.leavingfromdate = leavingfromdate;
        this.sq = sq;
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }
    
    public String getMilitaryid() {
        return militaryid;
    }

    public void setMilitaryid(String militaryid) {
        this.militaryid = militaryid;
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

    public String getNewunit() {
        return newunit;
    }

    public void setNewunit(String newunit) {
        this.newunit = newunit;
    }

    public String getTransportid() {
        return transportid;
    }

    public void setTransportid(String transportid) {
        this.transportid = transportid;
    }

    public String getTransportdate() {
        return transportdate;
    }

    public void setTransportdate(String transportdate) {
        this.transportdate = transportdate;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getLeavingid() {
        return leavingid;
    }

    public void setLeavingid(String leavingid) {
        this.leavingid = leavingid;
    }

    public String getLeavingdate() {
        return leavingdate;
    }

    public void setLeavingdate(String leavingdate) {
        this.leavingdate = leavingdate;
    }

    public String getLeavingfromdate() {
        return leavingfromdate;
    }

    public void setLeavingfromdate(String leavingfromdate) {
        this.leavingfromdate = leavingfromdate;
    }
    
    
}
