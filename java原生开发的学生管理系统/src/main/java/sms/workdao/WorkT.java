package sms.workdao;

import sms.pojo.Classber;
import sms.pojo.Studentm;

import java.util.List;
import java.util.Map;

//教师基础功能
public interface WorkT {
    boolean  creaClas(Map<String,String> map); //创建教室
   Classber  findClass(int cid);//查找教室
    boolean  updataClass(Classber classber);//更新教室信息
      List<Classber> getAllClass(int Tid);//获取所有教室
    List<Studentm> getStudents(String Cid);//获取所有学生
    Studentm getAStudent(int Sid); //查看一个学生信息
    boolean removeStudent(String Sid,String Cid); //移除学生
    boolean delectClass(String Cid);
}
