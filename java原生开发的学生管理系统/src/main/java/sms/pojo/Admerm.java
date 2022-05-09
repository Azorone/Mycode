package sms.pojo;

public class Admerm {
    private String id;
    private String phone;
    private String name;
    private String mail;

    public Admerm(String id, String phone, String name, String mail) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
