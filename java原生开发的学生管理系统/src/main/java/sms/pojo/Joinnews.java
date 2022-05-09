package sms.pojo;

public class Joinnews {
   private   String cid;
   private   String stid;
   private String name;
   private String newsid;
   public Joinnews(String cid, String stid, String name, String newsid) {
        this.cid = cid;
        this.stid = stid;
        this.name = name;
        this.newsid = newsid;
    }
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getStid() {
        return stid;
    }
    public void setStid(String stid) {
        this.stid = stid;
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

    @Override
    public String toString() {
        return "Joinnews{" +
                "cid='" + cid + '\'' +
                ", stid='" + stid + '\'' +
                ", name='" + name + '\'' +
                ", newsid='" + newsid + '\'' +
                '}';
    }
}
