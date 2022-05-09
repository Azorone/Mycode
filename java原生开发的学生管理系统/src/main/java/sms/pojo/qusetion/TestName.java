package sms.pojo.qusetion;

public class TestName {
    private String eid;
    private String tid;
    private String ename;
    private String etime;
    private String score;
    private String seid;

    public TestName(String eid, String tid, String ename, String etime, String score, String seid) {
        this.eid = eid;
        this.tid = tid;
        this.ename = ename;
        this.etime = etime;
        this.score = score;
        this.seid = seid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public TestName() {
    }

    @Override
    public String toString() {
        return "TestName{" +
                "eid='" + eid + '\'' +
                ", tid='" + tid + '\'' +
                ", ename='" + ename + '\'' +
                ", etime='" + etime + '\'' +
                ", score='" + score + '\'' +
                ", seid='" + seid + '\'' +
                '}';
    }
}
