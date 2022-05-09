package sms.pojo.qusetion;

import sms.workdao.Question;

public class Lunq implements Question {
    private  String wqid;
    private   String wqtitle;
     private   String wqclass;

     private  String tid;
     public Lunq(String wqtitle, String wqclass, String wqid){
        this.wqtitle = wqtitle;
        this.wqclass = wqclass;
        this.wqid = wqid;
    }

    public Lunq(String wqtitle, String wqclass, String wqid, String tid) {
        this.wqtitle = wqtitle;
        this.wqclass = wqclass;
        this.wqid = wqid;
        this.tid = tid;
    }

    public String getWqtitle(){
        return wqtitle;
    }
     public void setWqtitle(String wqtitle){
        this.wqtitle = wqtitle;
    }
     public String getWqclass(){
        return wqclass;
    }
     public void setWqclass(String wqclass){
        this.wqclass = wqclass;
    }
     public String getWqid(){
        return wqid;
    }
     public void setWqid(String wqid){
        this.wqid = wqid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Lunq{" +
                "wqtitle='" + wqtitle + '\'' +
                ", wqclass='" + wqclass + '\'' +
                ", wqid='" + wqid + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}
