package sms.workdao;

import Util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import sms.dao.ClassDao;
import sms.dao.ClstDao;
import sms.dao.StudentDao;
import sms.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkTeacher implements WorkT{
    @Override
    /**
    * 创建一个教室
    * */
    public boolean creaClas(Map<String,String> map) {
        if (map.isEmpty())
        {
            System.out.println("参数为空！");
            return false;
        }

        Classber   classber  =  new Classber(null, map.get("cname"),map.get("cnumber") ,map.get("tid"),map.get("cdescribe"),map.get("ccode"));
        SqlSession session =  mybatisUtil.getSqlSession();
        ClassDao   mapper  = session.getMapper(ClassDao.class);
        System.out.print( classber.toString());
        int i = mapper.addClass(classber);
        session.commit();
        session.close();
        return i>0;
    }

    @Override
    //查找一个教室
    public Classber findClass(int cid) {
        SqlSession session =  mybatisUtil.getSqlSession();
        ClassDao   mapper  = session.getMapper(ClassDao.class);
        Classber   classber = mapper.getClassber(cid);
        if (classber!=null)
        {   System.out.println(classber.toString());
            return classber;
        }
        session.close();
        return null;
    }

    @Override
    //更新一个教室
    public boolean updataClass(Classber classber) {
        SqlSession session =  mybatisUtil.getSqlSession();
        ClassDao   mapper  = session.getMapper(ClassDao.class);
        session.close();
        return false;
    }

    @Override
    //查看自己创建的所有教室
    public  List<Classber> getAllClass(int Tid) {
        SqlSession session =  mybatisUtil.getSqlSession();
        ClassDao   mapper  = session.getMapper(ClassDao.class);
        List<Classber> classberList = mapper.getClassbersT(Tid);
        session.close();
        return classberList;
    }

    @Override
    //查看这个教室的所有学生
    public List<Studentm> getStudents(String Cid) {
        WorkStudent workStudent = new WorkStudent();
        List<Studentm> studentmList = new ArrayList<>();
        int cid = Integer.valueOf(Cid);
        SqlSession session =  mybatisUtil.getSqlSession();
        ClstDao    mapperClst    = session.getMapper(ClstDao.class);
        List<Integer> ListSid = mapperClst.getSid(cid);
        int size = ListSid.size();
        System.out.println(size);
        for (int sid:ListSid) {
            System.out.print(" 学生id："+sid+" ");
            Studentm studentm = workStudent.getMyNews(sid);
            if (studentm==null)
            {
                System.out.println("该SID:"+sid+"对应的学生不存在于studenm表中，但存在于clst表中");
            }
            else {
                studentmList.add(studentm);
                System.out.println( studentm.toString());
            }
        }
        session.close();
        if (studentmList.isEmpty())
        {
            System.out.println("这个教室没有学生");
            return null;
        }
        else {
            return studentmList;
        }
    }
    @Override
    public Studentm getAStudent(int Sid) {
        WorkStudent workStudent =new WorkStudent();
        return workStudent.getMyNews(Sid);
    }

    @Override
    //移除一个学生出教室
    public boolean removeStudent(String Sid,String Cid) {
        SqlSession session =  mybatisUtil.getSqlSession();
        int sid = Integer.valueOf(Sid);
        int cid = Integer.valueOf(Cid);
        Clst clst  = new Clst(sid,cid);
        ClstDao  mapper = session.getMapper(ClstDao.class);
        int i=    mapper.delClast(clst) ;
        session.close();
        return i>0;
    }

    @Override
    //删除一个教室
    public boolean delectClass(String Cid) {
        SqlSession session = mybatisUtil.getSqlSession();
        ClassDao mapperClass = session.getMapper(ClassDao.class);
       int i = mapperClass.delClass(Integer.parseInt(Cid));
       if (i>0){
           System.out.println("教室被删除");
       }
        ClstDao mapperClast = session.getMapper(ClstDao.class);
        int p = mapperClast.dissolveClass(Integer.parseInt(Cid));
        System.out.println("删除的记录条数："+p);
        session.commit();
        session.close();
        return false;
    }
    public void dealNews(String newsid,String KEY){

        SqlSession session = mybatisUtil.getSqlSession();
        ClassDao mapper  = session.getMapper(ClassDao.class);
        if (KEY.equals("YES"))
        {    System.out.println("同意！");
            Joinnews joinnews = mapper.getJoinNews(Integer.valueOf(newsid));
            WorkStudent workStudent = new WorkStudent();
            if (joinnews==null)
            {
              System.out.println("没有该申请！");
              return;
            }
          int i=  workStudent.joinClass(joinnews.getStid(), joinnews.getCid());
            int p= mapper.delJoinNews(Integer.valueOf(newsid));
          System.out.println("处理中的添加记录条数："+i+"删除的记录条数："+p);

        }
        else if (KEY.equals("NO")){
            int i = mapper.delJoinNews(Integer.valueOf(newsid));
             System.out.println("受影响的记录条数："+i);
        }
        session.commit();
        session.close();
    }
    //获得加入教室申请
    public List<Student> getClassJoinNews(String Cid){
        SqlSession session = mybatisUtil.getSqlSession();
        ClassDao mapper    = session.getMapper(ClassDao.class);
          List<Joinnews> temp =      mapper.getClassAllNews(Integer.valueOf(Cid));
                 if(temp == null || temp.isEmpty())
                 {
                     System.out.println(Cid+ ":该教室没有加入申请！");
                     return null;
                 }
                 List<Student> studentList = new ArrayList<>(30);
                 int size = temp.size();
        Studentm studentm;
        Student student;
        WorkStudent workStudent = new WorkStudent();

                 for (int i=0;i<size;i++)
                 {
                     int sid = Integer.valueOf(temp.get(i).getStid());
                  studentm = workStudent.getMyNews( sid);
                  studentm.toString();
                  if (studentm!=null)
                  {   student = new Student();
                      student.setName(studentm.getName());
                      student.setNewsid(temp.get(i).getNewsid());
                      student.setPhone(studentm.getPhone());
                      student.setStuid(studentm.getStuid());
                      studentList.add(student);
                  }

                 }
                 if (studentList ==null || studentList.isEmpty())
                 {
                     System.out.println("为空！");
                     return null;
                 }
          return studentList;
    }
}
