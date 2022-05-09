package sms.pojo;

public class Teachm {
    private String tid;
    private String name;
    private String phone;
    private String mail;

    public Teachm(String tid, String name, String phone, String mail) {
        this.tid = tid;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
