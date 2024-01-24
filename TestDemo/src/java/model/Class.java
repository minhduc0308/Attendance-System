/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author HuyPC
 */
public class Class {
    private int idClass;
    private String Name;
    private Date StartDate;
    private Date EndDate;
    private int TrainingDeapartmentId;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getTrainingDeapartmentId() {
        return TrainingDeapartmentId;
    }

    public void setTrainingDeapartmentId(int TrainingDeapartmentId) {
        this.TrainingDeapartmentId = TrainingDeapartmentId;
    }

    @Override
    public String toString() {
        return "Class{" + "idClass=" + idClass + ", Name=" + Name + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", TrainingDeapartmentId=" + TrainingDeapartmentId + '}';
    }
   

    public Class(){}

    public Class(int idClass, String Name, Date StartDate, Date EndDate, int TrainingDeapartmentId) {
        this.idClass = idClass;
        this.Name = Name;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.TrainingDeapartmentId = TrainingDeapartmentId;
    }

}