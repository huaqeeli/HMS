/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.models;

/**
 *
 * @author Administrator
 */
public class VacationDataModel {
    String militaryid,rank,name,vacationType,vacationId,vacationDate,vacationDuration,vacationPlace,vacationStartDate,vacationEndDate;
    int sq;

    public VacationDataModel(String militaryid, String rank, String name, String vacationType, String vacationId, String vacationDate, String vacationDuration, String vacationPlace, String vacationStartDate, String vacationEndDate, int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.vacationType = vacationType;
        this.vacationId = vacationId;
        this.vacationDate = vacationDate;
        this.vacationDuration = vacationDuration;
        this.vacationPlace = vacationPlace;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
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

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getVacationId() {
        return vacationId;
    }

    public void setVacationId(String vacationId) {
        this.vacationId = vacationId;
    }

    public String getVacationDate() {
        return vacationDate;
    }

    public void setVacationDate(String vacationDate) {
        this.vacationDate = vacationDate;
    }

    public String getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(String vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    public String getVacationPlace() {
        return vacationPlace;
    }

    public void setVacationPlace(String vacationPlace) {
        this.vacationPlace = vacationPlace;
    }

    public String getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(String vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public String getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(String vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }
    
    
}
