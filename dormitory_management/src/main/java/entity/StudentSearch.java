package entity;

public class StudentSearch {
    private String username;
    private String sex;   //注意这里是查询的参数 最后写道sql语句里面 所以这里的类型都是String
    private String birthdayStart;
    private String birthdayEnd;
    //private String classId;
    private String dormitoryId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(String birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public String getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(String birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

//    public String getClassId() {
//        return classId;
//    }
//
//    public void setClassId(String classId) {
//        this.classId = classId;
//    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    @Override
    public String toString() {
        return "StudentSearch{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdayStart='" + birthdayStart + '\'' +
                ", birthdayEnd='" + birthdayEnd + '\'' +
                ", dormitoryId='" + dormitoryId + '\'' +
                '}';
    }
}
