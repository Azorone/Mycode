package sms.pojo.qusetion;

import sms.workdao.Question;

public class Eqtable implements Question {
    private  String eid;
    private  String qid;
    private  String eqid;

    public Eqtable(String eid, String qid, String eqid) {
        this.eid = eid;
        this.qid = qid;
        this.eqid = eqid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }
}
