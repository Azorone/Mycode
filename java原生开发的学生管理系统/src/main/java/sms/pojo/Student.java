package sms.pojo;

public class Student {
    private  String name;
    private  String newsid;
    private  String phone;
    private String stuid;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", newsid='" + newsid + '\'' +
                ", phone='" + phone + '\'' +
                ", stuid='" + stuid + '\'' +
                '}';
    }
}
