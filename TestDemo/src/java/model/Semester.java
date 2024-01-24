/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HuyPC
 */
public class Semester {
    private int idSemester;
    private String Name;

    public Semester(int idSemester, String Name) {
        this.idSemester = idSemester;
        this.Name = Name;
    }

    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Semester{" + "idSemester=" + idSemester + ", Name=" + Name + '}';
    }
    
    public Semester(){}

}