package sms.pojo.qusetion;

import sms.workdao.Question;

public class Exam implements Question {
    private String eid;
    private String tid;
    private String ename;
    private String etime;

    public Exam() {
    }

    public Exam(String eid, String tid, String ename, String etime) {
        this.eid = eid;
        this.tid = tid;
        this.ename = ename;
        this.etime = etime;
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
}
