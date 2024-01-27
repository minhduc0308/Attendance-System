/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class Lecture {
    private BigInteger idLectures;
    private String email, lectureName;
    private int phoneNumber;
    private String address;
    private Date dateOfBirth;

    public Lecture() {
    }

    public Lecture(BigInteger idLectures, String email, String lectureName, int phoneNumber, String address, Date dateOfBirth) {
        this.idLectures = idLectures;
        this.email = email;
        this.lectureName = lectureName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public BigInteger getIdLectures() {
        return idLectures;
    }

    public void setIdLectures(BigInteger idLectures) {
        this.idLectures = idLectures;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Lecture{" + "idLectures=" + idLectures + ", email=" + email + ", lectureName=" + lectureName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth + '}';
    }

    
}
