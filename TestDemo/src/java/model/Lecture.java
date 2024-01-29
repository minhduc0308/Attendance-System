/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.sql.*;

/**
 *
 * @author HuyPC
 */
public class Lecture {
    private BigInteger  idLectures;
    private String Email, LectureName;
    private int PhoneNumber;
    private String Address;
    private Date DateOfBirth;

    public Lecture(BigInteger idLectures, String Email, String LectureName, int PhoneNumber, String Address, Date DateOfBirth) {
        this.idLectures = idLectures;
        this.Email = Email;
        this.LectureName = LectureName;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
    }

    public BigInteger getIdLectures() {
        return idLectures;
    }

    public void setIdLectures(BigInteger idLectures) {
        this.idLectures = idLectures;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLectureName() {
        return LectureName;
    }

    public void setLectureName(String LectureName) {
        this.LectureName = LectureName;
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
        return "Lecture{" + "idLectures=" + idLectures + ", Email=" + Email + ", LectureName=" + LectureName + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DateOfBirth=" + DateOfBirth + '}';
    }

   

    public Lecture(){}

}
