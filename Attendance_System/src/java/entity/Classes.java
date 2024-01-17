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
public class Classes {
    private int classId;
    private String className;
    private Date startDate;
    private Date endDate;

    public Classes() {
    }

    public Classes(int classId, String className, Date startDate, Date endDate) {
        this.classId = classId;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Classes{" + "classId=" + classId + ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    
    
}
