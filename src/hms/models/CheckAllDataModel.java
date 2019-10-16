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
public class CheckAllDataModel {
    String militaryId,listNumber,enForm,enTo,fromDate,toDate,rank,name,balance;

    public CheckAllDataModel(String militaryId, String listNumber, String enForm, String enTo, String fromDate, String toDate,String balance) {
        this.militaryId = militaryId;
        this.listNumber = listNumber;
        this.enForm = enForm;
        this.enTo = enTo;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.balance = balance;
    }

    public CheckAllDataModel(String militaryId, String listNumber, String enForm, String enTo, String fromDate, String toDate) {
        this.militaryId = militaryId;
        this.listNumber = listNumber;
        this.enForm = enForm;
        this.enTo = enTo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

   
    

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public CheckAllDataModel( String listNumber , String militaryId) {
        this.listNumber = listNumber;
        this.militaryId = militaryId;
    }

    public CheckAllDataModel(String militaryId, String rank, String name) {
        this.militaryId = militaryId;
        this.rank = rank;
        this.name = name;
    }

    
    public String getMilitaryId() {
        return militaryId;
    }

    public void setMilitaryId(String militaryId) {
        this.militaryId = militaryId;
    }

    public String getListNumber() {
        return listNumber;
    }

    public void setListNumber(String listNumber) {
        this.listNumber = listNumber;
    }

    public String getEnForm() {
        return enForm;
    }

    public void setEnForm(String enForm) {
        this.enForm = enForm;
    }

    public String getEnTo() {
        return enTo;
    }

    public void setEnTo(String enTo) {
        this.enTo = enTo;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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
    
    
}
