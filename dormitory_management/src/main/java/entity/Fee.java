package entity;


import java.io.Serializable;

public class Fee implements Serializable {

    private Integer dormitoryId;
    private Double fee;

    //记录和学生 宿舍都是多对一管理
    private Dormitory dormitory;


    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "Fee{" +
                ", dormitoryId=" + dormitoryId +
                ", fee=" + fee +
                ", dormitory=" + dormitory +
                '}';
    }
}
