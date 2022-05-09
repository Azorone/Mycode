package sms.pojo;

public class User {
        private  String id;
        private  String account;
        private  String pass;
        private  int    per;

    public User(String id, String account, String pass, int per) {
        this.id = id;
        this.account = account;
        this.pass = pass;
        this.per = per;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", pass='" + pass + '\'' +
                ", per=" + per +
                '}';
    }
}
