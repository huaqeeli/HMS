package hms.models;


public class CasesDataModel {
    String militaryid,rank,name,caseType,decreeId,decreeDate,caseFromDate,decreeType,caseState,startWorkDate;
    int sq;

    public CasesDataModel(String militaryid, String rank, String name, String caseType, String decreeId, String decreeDate, String caseFromDate, String decreeType, String caseState, String startWorkDate, int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.caseType = caseType;
        this.decreeId = decreeId;
        this.decreeDate = decreeDate;
        this.caseFromDate = caseFromDate;
        this.decreeType = decreeType;
        this.caseState = caseState;
        this.startWorkDate = startWorkDate;
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

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getDecreeId() {
        return decreeId;
    }

    public void setDecreeId(String decreeId) {
        this.decreeId = decreeId;
    }

    public String getDecreeDate() {
        return decreeDate;
    }

    public void setDecreeDate(String decreeDate) {
        this.decreeDate = decreeDate;
    }

    public String getCaseFromDate() {
        return caseFromDate;
    }

    public void setCaseFromDate(String caseFromDate) {
        this.caseFromDate = caseFromDate;
    }

    public String getDecreeType() {
        return decreeType;
    }

    public void setDecreeType(String decreeType) {
        this.decreeType = decreeType;
    }

    public String getCaseState() {
        return caseState;
    }

    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }

    public String getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(String startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }
    
    
}
