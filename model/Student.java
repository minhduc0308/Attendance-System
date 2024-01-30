/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
//parent, training, class
public class Student {
    private BigInteger id;
    private String email;
    private int PhoneNumber;
    private String Address;
    private Date DOB;
   private ArrayList<Class> classes = new ArrayList<>();

    public Student() {
    }

    public Student(BigInteger id, String email, int PhoneNumber, String Address, Date DOB) {
        this.id = id;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.DOB = DOB;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", email=" + email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + '}';
    }

    
    
}
