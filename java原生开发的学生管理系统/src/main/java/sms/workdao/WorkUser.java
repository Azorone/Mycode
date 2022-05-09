package sms.workdao;

import Util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import sms.dao.StudentDao;
import sms.dao.TeacherDao;
import sms.dao.UserDao;
import sms.pojo.Studentm;
import sms.pojo.Teachm;
import sms.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class WorkUser {

   public boolean chickExist(String account){
       SqlSession session = mybatisUtil.getSqlSession();
       UserDao mapper = session.getMapper(UserDao.class);
       User user = mapper.chickExist(account);
       if (user!=null)
       {
           return false;
       }
       return true;

   }
  public int addUser(User user){
       SqlSession session = mybatisUtil.getSqlSession();
       UserDao mapper = session.getMapper(UserDao.class);
       mapper.addUser(user);
       session.commit();
       Map<String,Object> map  = new HashMap<>();
       map.put("account",user.getAccount());
       map.put("pass",user.getPass());
       int id =  mapper.getUserId(map);
       session.close();
       return  id;
   }
   public int addTeacherm(Teachm teachm){
        SqlSession  Session = mybatisUtil.getSqlSession();
        TeacherDao mapper  =  Session.getMapper(TeacherDao.class);
        int i = mapper.addTeachm(teachm);
        Session.commit();
        Session.close();
        return i;
   }
   public int addStudent(Studentm studentm){
        SqlSession session = mybatisUtil.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        int i = mapper.addStudent(studentm);
        session.commit();
        session.close();
        return i;
   }
}
