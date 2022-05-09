package sms.workdao;

import sms.pojo.Classber;
import sms.pojo.Studentm;

import java.util.List;

public interface WorkS {
    //加入教室
    int joinClass(String Sid,String Cid);
    //退出教室
    int backClass(String Sid,String Cid);
    //查看个人信息
    Studentm getMyNews(int id);
    //查看学生自己加入的教室
    List<Classber> getMyClasses(int sid);
}
