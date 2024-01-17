/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
//classSession, student
public class Attendance {
    private int attendanceId; 
    private String status;

    public Attendance() {
    }

    public Attendance(int attendanceId, String status) {
        this.attendanceId = attendanceId;
        this.status = status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{" + "attendanceId=" + attendanceId + ", status=" + status + '}';
    }
    
    
}
