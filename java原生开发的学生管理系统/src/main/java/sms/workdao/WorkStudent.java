package sms.workdao;

import Util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import sms.dao.ClassDao;
import sms.dao.ClstDao;
import sms.dao.StudentDao;
import sms.pojo.Classber;
import sms.pojo.Clst;
import sms.pojo.Joinnews;
import sms.pojo.Studentm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkStudent implements WorkS{
    @Override
    public int joinClass(String Sid, String Cid) {
        Clst clst = new Clst(Integer.valueOf(Sid),Integer.valueOf(Cid));
        WorkTeacher workTeacher = new WorkTeacher();
       if (workTeacher.findClass(Integer.valueOf(Cid) )!=null) //教室是否存在
       {
           SqlSession session = mybatisUtil.getSqlSession();
           ClstDao mapper = session.getMapper(ClstDao.class);

           if (mapper.getClst(clst)!=null)                 //是否以经加入
           {
               System.out.println("以加入教室，请勿重复加入");
               session.close();
               return -1;
           }
           else {
                  int i= mapper.addclast(clst);
                  session.commit();
                  session.close();
                  return i;
           }
       }
       else {
           System.out.println("教室不存在！");

       }
        return 0;
    }

    @Override
    public int backClass(String Sid, String Cid) { //退出教室
        Clst clst = new Clst(Integer.valueOf(Sid),Integer.valueOf(Cid));
        SqlSession session = mybatisUtil.getSqlSession();
        ClstDao mapper = session.getMapper(ClstDao.class);
        int i= mapper.delClast(clst);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public Studentm getMyNews(int id) {
        SqlSession session = mybatisUtil.getSqlSession();
        StudentDao mapperStudent   = session.getMapper(StudentDao.class);
        Studentm studentm = mapperStudent.getStudent(id);
        if (studentm!=null)
        {     session.close();
              return studentm;
        }
        System.out.println("不存在该学生！");
        session.close();
        return null;
    }

    @Override
    public List<Classber> getMyClasses(int sid) {
        SqlSession session = mybatisUtil.getSqlSession();
        ClstDao mapperCS   = session.getMapper(ClstDao.class);
        WorkTeacher workTeacher = new WorkTeacher();
        List<Classber> classberList = new ArrayList<>();
        List<Integer> integerList = mapperCS.getCid(sid);
        int size = integerList.size();
        System.out.println(size);
        for (int cid:integerList) {
            Classber classber = workTeacher.findClass(cid);
            if (classber!=null)
            {
                classberList.add(classber);
            }
            else {
                System.out.println("教室为空");
            }
        }
        if (classberList.isEmpty())
        {
            System.out.println("没有加入教室");
            return null;
        }
        session.close();
         return classberList;

    }

    public int appJoinClass(String Sid,String Cid){
        int i = -1;
        Map<String,Object> map = new HashMap<>();
        map.put("stdi",Sid);
        map.put("cid",Cid);
        SqlSession session = mybatisUtil.getSqlSession();
        ClassDao mapper    = session.getMapper(ClassDao.class);
        StudentDao mappers = session.getMapper(StudentDao.class);

       Joinnews joinnews = mapper.isExistNews(map);
       if (joinnews==null)
       {
            Studentm studentm  = mappers.getStudent(Integer.valueOf(Sid));
            if (studentm!=null)
            {
                Joinnews joinnews1 = new Joinnews(Cid,Sid,studentm.getName(),null);
                i= mapper.addJoinNews(joinnews1);
                session.commit();
                System.out.println("添加成功");
            }
           else {
               System.out.println("错误，不存在该学生");
            }
       }
       else {
           System.out.println("申请存在，请勿重复申请");
       }
       session.close();
       return i;
    }
}
