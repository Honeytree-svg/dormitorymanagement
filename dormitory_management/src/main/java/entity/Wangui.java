package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Wangui implements Serializable {

    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date wanguiTime;
    private Integer dormitoryId;
    private Integer studentId;

    //记录和学生 宿舍都是多对一管理
    private Student student;
    private Dormitory dormitory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWanguiTime() {
        return wanguiTime;
    }

    public void setWanguiTime(Date wanguiTime) {
        this.wanguiTime = wanguiTime;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "Wangui{" +
                "id=" + id +
                ", wanguiTime=" + wanguiTime +
                ", dormitoryId=" + dormitoryId +
                ", studentId=" + studentId +
                ", student=" + student +
                ", dormitory=" + dormitory +
                '}';
    }
}
