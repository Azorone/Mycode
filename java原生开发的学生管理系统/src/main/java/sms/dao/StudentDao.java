package sms.dao;

import org.apache.ibatis.annotations.Mapper;
import sms.pojo.Student;
import sms.pojo.Studentm;

import java.util.List;

public interface StudentDao {
    //添加学生信息
    int addStudent(Studentm studentm);
    //删除学生信息
    int delStudent(int id);
    //查询一个学生
    Studentm getStudent(int id);
    //查询所有的学生
    List<Studentm> getStudents();

    List<Studentm> getClassStudent(int cid);

}
