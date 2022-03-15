package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Fix { //维修记录
    private Integer id;
    //注意不要写成 hh:mm:ss 不然会前后端匹配不到 直接错误
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fixTime;
    private Integer dormitoryId;
    private Integer fixPepoleId;//维修人员 这里是从维修管理员里面选择一个
    private Integer fixStatus; //维修状态 0 维修完毕  1 正在维修
    private String fixNote; //维修内容


    private Dormitory dormitory;
    private Admin admin;

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFixTime() {
        return fixTime;
    }

    public void setFixTime(Date fixTime) {
        this.fixTime = fixTime;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getFixPepoleId() {
        return fixPepoleId;
    }

    public void setFixPepoleId(Integer fixPepoleId) {
        this.fixPepoleId = fixPepoleId;
    }

    public Integer getFixStatus() {
        return fixStatus;
    }

    public void setFixStatus(Integer fixStatus) {
        this.fixStatus = fixStatus;
    }

    public String getFixNote() {
        return fixNote;
    }

    public void setFixNote(String fixNote) {
        this.fixNote = fixNote;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "id=" + id +
                ", fixTime=" + fixTime +
                ", dormitoryId=" + dormitoryId +
                ", fixPepoleId=" + fixPepoleId +
                ", fixStatus=" + fixStatus +
                ", fixNote='" + fixNote + '\'' +
                ", dormitory=" + dormitory +
                ", admin=" + admin +
                '}';
    }
}
