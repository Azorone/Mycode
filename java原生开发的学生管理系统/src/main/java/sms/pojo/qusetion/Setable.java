package sms.pojo.qusetion;

public class Setable {
    private String sid;
    private String ecid;
    private String seid;
    private String score;
    public Setable() {
    }

    public Setable(String sid, String eid, String seid) {
        this.sid = sid;
        this.ecid = eid;
        this.seid = seid;
    }

    public Setable(String sid, String ecid, String seid, String scre) {
        this.sid = sid;
        this.ecid = ecid;
        this.seid = seid;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEcid() {
        return ecid;
    }

    public void setEcid(String ecid) {
        this.ecid = ecid;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Setable{" +
                "sid='" + sid + '\'' +
                ", ecid='" + ecid + '\'' +
                ", seid='" + seid + '\'' +
                ", scre='" + score + '\'' +
                '}';
    }
}
