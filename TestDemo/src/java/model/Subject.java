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
public class Subject {
    private int idSubject;
    private String SubjectName;
    private int TraingDepartmentId;

    public Subject(int idSubject, String SubjectName, int TraingDepartmentId) {
        this.idSubject = idSubject;
        this.SubjectName = SubjectName;
        this.TraingDepartmentId = TraingDepartmentId;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public int getTraingDepartmentId() {
        return TraingDepartmentId;
    }

    public void setTraingDepartmentId(int TraingDepartmentId) {
        this.TraingDepartmentId = TraingDepartmentId;
    }

    @Override
    public String toString() {
        return "Subject{" + "idSubject=" + idSubject + ", SubjectName=" + SubjectName + ", TraingDepartmentId=" + TraingDepartmentId + '}';
    }
   

    public Subject(){}

}