/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.*;
/**
 *
 * @author admin
 */
//parent, training, class
public class Student {
    private int id;
    private String email;
    private int phoneNumber;
    private String address;
    private Date dob;

    public Student() {
    }

    public Student(int id, String email, int phoneNumber, String address, Date dob) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dob=" + dob + '}';
    }

    
    
    
}
