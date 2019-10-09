package hms.models;


public class TerminationDataModel {
    String militaryid,rank,name,reason,decreeid,decreeDate,fromDate,leavingDate;
    int sq;

    public TerminationDataModel(String militaryid, String rank, String name, String reason, String decreeid, String decreeDate, String fromDate, String leavingDate, int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.reason = reason;
        this.decreeid = decreeid;
        this.decreeDate = decreeDate;
        this.fromDate = fromDate;
        this.leavingDate = leavingDate;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDecreeid() {
        return decreeid;
    }

    public void setDecreeid(String decreeid) {
        this.decreeid = decreeid;
    }

    public String getDecreeDate() {
        return decreeDate;
    }

    public void setDecreeDate(String decreeDate) {
        this.decreeDate = decreeDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }
    
    
}
