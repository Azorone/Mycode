package sms.pojo.qusetion;

import sms.workdao.Question;

public class seletq implements Question {
  private  String qid;
   private String qtitle;
   private String qclass;
   private String ansA;
   private String ansB;
   private String ansC;
   private String ansD;
   private String ans;
   private String qdiff;

   private String tid;

    public seletq(String qid, String qclass, String ansA, String ansB, String ansC, String ansD, String ans, String qdiff, String qtitle, String tid) {
        this.qid = qid;
        this.qclass = qclass;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
        this.ans = ans;
        this.qdiff = qdiff;
        this.qtitle = qtitle;
        this.tid = tid;
    }
    public seletq(String qid, String qclass, String ansA, String ansB, String ansC, String ansD, String ans, String qdiff, String qtitle) {
        this.qid = qid;
        this.qclass = qclass;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
        this.ans = ans;
        this.qdiff = qdiff;
        this.qtitle = qtitle;
    }
    public String getQid(){
        return qid;
    }
    public void setQid(String qid){
        this.qid = qid;
    }
    public String getQclass() {
        return qclass;
    }
    public void setQclass(String qclass){
        this.qclass = qclass;
    }
    public String getAnsA(){
        return ansA;
    }
    public void setAnsA(String ansA){
        this.ansA = ansA;
    }
    public String getAnsB(){
        return ansB;
    }
    public void setAnsB(String ansB){
        this.ansB = ansB;
    }
    public String getAnsC(){
        return ansC;
    }
    public void setAnsC(String ansC){
        this.ansC = ansC;
    }
    public String getAnsD() {
        return ansD;
    }
    public void setAnsD(String ansD){
        this.ansD = ansD;
    }
    public String getAns(){
        return ans;
    }
    public void setAns(String ans){
        this.ans = ans;
    }
    public String getQdiff(){
        return qdiff;
    }
    public void setQdiff(String qdiff){
        this.qdiff = qdiff;
    }
    public String getQtitle(){
        return qtitle;
    }
    public void setQtitle(String qtitle){
        this.qtitle = qtitle;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "seletq{" +
                "qid='" + qid + '\'' +
                ", qclass='" + qclass + '\'' +
                ", ansA='" + ansA + '\'' +
                ", ansB='" + ansB + '\'' +
                ", ansC='" + ansC + '\'' +
                ", ansD='" + ansD + '\'' +
                ", ans='" + ans + '\'' +
                ", qdiff='" + qdiff + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}
