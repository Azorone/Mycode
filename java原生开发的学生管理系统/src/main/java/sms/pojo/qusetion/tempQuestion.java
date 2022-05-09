package sms.pojo.qusetion;

public class tempQuestion {
    private String qid;
    private String qname;

    public tempQuestion() {
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    @Override
    public String toString() {
        return "tempQuestion{" +
                "qid='" + qid + '\'' +
                ", qname='" + qname + '\'' +
                '}';
    }
}
