/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.*;

/**
 *
 * @author HuyPC
 */
public class Lecture {
    private int idLectures;
    private String Email;
    private int PhoneNumber;
    private String Address;
    private Date DateOfBirth;

    public Lecture(int idLectures, String Email, int PhoneNumber, String Address, Date DateOfBirth) {
        this.idLectures = idLectures;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
    }

    public int getIdLectures() {
        return idLectures;
    }

    public void setIdLectures(int idLectures) {
        this.idLectures = idLectures;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    @Override
    public String toString() {
        return "Lecture{" + "idLectures=" + idLectures + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DateOfBirth=" + DateOfBirth + '}';
    }
    
    public Lecture(){}
    
}
