package sms.pojo.qusetion;

import sms.workdao.Question;

public class ClassExam implements Question {
    private String cid;
    private String eid;
    private String ecid;

    public ClassExam(String cid, String eid,String ecid){
        this.cid = cid;
        this.eid = eid;
        this.ecid = ecid;
    }

    public String getCid(){
        return cid;
    }

    public void setCid(String cid){
        this.cid = cid;
    }

    public String getEid(){
        return eid;
    }

    public void setEid(String eid){
        this.eid = eid;
    }

    public String getEcid() {
        return ecid;
    }

    @Override
    public String toString() {
        return "ClassExam{" +
                "cid='" + cid + '\'' +
                ", eid='" + eid + '\'' +
                '}';
    }
}
