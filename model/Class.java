
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.Session;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HuyPC
 */
public class Class {
    private int id;
    private String Name;
    private Date StartDate;
    private Date EndDate;
    private int TrainingDeapartmentId;
    private Subject subject;
    private ArrayList<Session> sessions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public Subject getSubject() {
        return subject;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }


}