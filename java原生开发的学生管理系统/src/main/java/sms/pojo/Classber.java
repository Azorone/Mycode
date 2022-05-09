package sms.pojo;

public class Classber {
    private String cid;
    private String cname;
    private String cnumber;
    private String tid;
    private String cdescribe;
    private String ccode;

    public Classber(String cid, String cname, String cnumber, String tid, String cdescribe, String ccode) {
        this.cid = cid;
        this.cname = cname;
        this.cnumber = cnumber;
        this.tid = tid;
        this.cdescribe = cdescribe;
        this.ccode = ccode;
    }

    public Classber(String cname, String tid) {
        this.cname = cname;
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    @Override
    public String toString() {
        return "Classber{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", tid='" + tid + '\'' +
                ", cdescribe='" + cdescribe + '\'' +
                ", ccode='" + ccode + '\'' +
                '}';
    }
}
