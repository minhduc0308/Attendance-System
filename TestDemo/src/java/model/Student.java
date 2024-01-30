/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigInteger;
import java.sql.*;
/**
 *
 * @author admin
 */
//parent, training, class
public class Student {
    private BigInteger id;
    private String email;
    private int ClassId;
    private int PhoneNumber;
    private String Address;
    private Date DOB;
     private int TrainningDId;
      private int ParentId2;

    public Student(BigInteger id, String email, int ClassId, int PhoneNumber, String Address, Date DOB, int TrainningDId, int ParentId2) {
        this.id = id;
        this.email = email;
        this.ClassId = ClassId;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.DOB = DOB;
        this.TrainningDId = TrainningDId;
        this.ParentId2 = ParentId2;
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

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int ClassId) {
        this.ClassId = ClassId;
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

    public int getTrainningDId() {
        return TrainningDId;
    }

    public void setTrainningDId(int TrainningDId) {
        this.TrainningDId = TrainningDId;
    }

    public int getParentId2() {
        return ParentId2;
    }

    public void setParentId2(int ParentId2) {
        this.ParentId2 = ParentId2;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", email=" + email + ", ClassId=" + ClassId + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + ", TrainningDId=" + TrainningDId + ", ParentId2=" + ParentId2 + '}';
    }
    public Student() {
    }
}

   
