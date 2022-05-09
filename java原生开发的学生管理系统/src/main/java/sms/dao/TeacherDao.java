package sms.dao;

import sms.pojo.Teacher;
import sms.pojo.Teachm;

import java.util.List;

public interface TeacherDao {
    //添加教师信息
    int addTeachm(Teachm teachm);
    //删除教师信息
    int delTeachm(int id);
    //查询信息
    Teachm getTeacher(int id);
    //查询所有的教师信息
    List<Teachm> getTeachers();


}
