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
public class TrainingDataModel {
    String militaryid,rank,name,courseName,courseId,corseDate,corseSartDate,corseEndDate,leavingDate,backDate;
    int sq;

    public TrainingDataModel(String militaryid, String rank, String name, String courseName, String courseId, String corseDate, String corseSartDate, String corseEndDate, String leavingDate, String backDate, int sq) {
        this.militaryid = militaryid;
        this.rank = rank;
        this.name = name;
        this.courseName = courseName;
        this.courseId = courseId;
        this.corseDate = corseDate;
        this.corseSartDate = corseSartDate;
        this.corseEndDate = corseEndDate;
        this.leavingDate = leavingDate;
        this.backDate = backDate;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCorseDate() {
        return corseDate;
    }

    public void setCorseDate(String corseDate) {
        this.corseDate = corseDate;
    }

    public String getCorseSartDate() {
        return corseSartDate;
    }

    public void setCorseSartDate(String corseSartDate) {
        this.corseSartDate = corseSartDate;
    }

    public String getCorseEndDate() {
        return corseEndDate;
    }

    public void setCorseEndDate(String corseEndDate) {
        this.corseEndDate = corseEndDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }

   
    
    
}
