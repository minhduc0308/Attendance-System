/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author thaim
 */
public class Session {

    private int id;
    private Class classes;
    private Room room;
    private TimeSlot slot;
    private Lecturer lecturer;
    private Date date;
    private boolean status;

    public Class getClasses() {
        return classes;
    }

    
    
    public Room getRoom() {
        return room;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Date getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
