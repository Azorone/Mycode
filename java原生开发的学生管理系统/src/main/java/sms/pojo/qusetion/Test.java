package sms.pojo.qusetion;

import sms.workdao.Question;

import java.util.List;

public class Test implements Question {
    private  String eid;
    private String tid;
    private String ename;
    private String etime;
    private List<seletq> seletqList;
    private List<Lunq> lunqList;


    public Test(String eid, String tid, String ename, String etime, List<seletq> seletqList, List<Lunq> lunqList) {
        this.eid = eid;
        this.tid = tid;
        this.ename = ename;
        this.etime = etime;
        this.seletqList = seletqList;
        this.lunqList = lunqList;
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

    public List<seletq> getSeletqList() {
        return seletqList;
    }

    public void setSeletqList(List<seletq> seletqList) {
        this.seletqList = seletqList;
    }

    public List<Lunq> getLunqList() {
        return lunqList;
    }

    public void setLunqList(List<Lunq> lunqList) {
        this.lunqList = lunqList;
    }
}
