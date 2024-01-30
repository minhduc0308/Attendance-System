
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HuyPC
 */
public class Subject {
    private int id;
    private String SubjectName;
    private int SemesterId;
        private ArrayList<Class> classes = new ArrayList<>();

    public Subject(int id, String SubjectName, int SemesterId ) {
        this.id = id;
        this.SubjectName = SubjectName;
        this.SemesterId = SemesterId;
    }
    
    
    public int getSemesterId() {
        return SemesterId;
    }

    public void setSemesterId(int SemesterId) {
        this.SemesterId = SemesterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public Subject(){}

}