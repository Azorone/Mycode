package sms.pojo;

public class Studentm {
    private  String sid;
    private  String name;
    private  String phone;
    private  String stuid;

    public Studentm(String sid, String name, String phone, String stuid) {
        this.sid = sid;
        this.name = name;
        this.phone = phone;
        this.stuid = stuid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Studentm{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", stuid='" + stuid + '\'' +
                '}';
    }
}
