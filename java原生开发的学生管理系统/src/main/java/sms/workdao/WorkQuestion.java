package sms.workdao;
import Util.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import sms.dao.ClstDao;
import sms.dao.QuestionDao;
import sms.pojo.Classber;
import sms.pojo.qusetion.*;
import java.lang.reflect.Field;
import java.util.*;
public class WorkQuestion{
  public Question questionFactor(String Type,Map<String,String> map)
   {
      if (Type==null)
      {
         return null;
      }
      if (Type.equalsIgnoreCase("ClassExam"))
      {
         return new ClassExam(map.get("cid"),map.get("eid"),map.get("ecid"));
      }
      else if (Type.equalsIgnoreCase("Eqtable"))
      {
         return new Eqtable(map.get("eid"),map.get("cid"),map.get("eqid"));
      }
      else if (Type.equalsIgnoreCase("Exam"))
      {
         return new Exam(map.get("eid"),map.get("tid"),map.get("ename"),map.get("etime"));
      }
      else if (Type.equalsIgnoreCase("Lunq"))
      {
         return new Lunq(map.get("wqtitle"),map.get("wqclass"),map.get("wqid"));
      }
      else if (Type.equalsIgnoreCase("seletq"))
      {
         return new seletq(map.get("qid"),map.get("qclass"),map.get("ansA"),map.get("ansB"),map.get("ansC"),map.get("ansD"),map.get("ans"),map.get("qdiff"),map.get("qtitle"));
      }
      return null;
   }
  public boolean addSeletq(seletq q){
      int i =0;
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapper = session.getMapper(QuestionDao.class);
     i=  mapper.addseletq(q);
      session.commit();
      session.close();
      return i>0;
   }
  public boolean addLunq(Lunq q){
      int i =0;
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapper = session.getMapper(QuestionDao.class);
      i=  mapper.addLunq(q);
      session.commit();
      session.close();
      return i>0;
   }
  //创建试卷
  public boolean creatExam(Exam exam)
   {
      int i =0;
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapper = session.getMapper(QuestionDao.class);
      i=  mapper.addExam(exam);
      session.commit();
      session.close();
      return i>0;
   }
   //给试卷添加题,eid,试卷id，试题的 id列表
  public boolean addEqtable(String eid, List<String> Qids)
   {
       Eqtable eqtable ;
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapper = session.getMapper(QuestionDao.class);
      int size = Qids.size();
      System.out.println( "题目数量： "+size);
      if (Qids ==null|| Qids.isEmpty())
      {
          System.out.println("没有题目。题目列表为空！");
      }
      else {
          for (int i=0;i<size;i++)
          {
              eqtable = new Eqtable(eid, Qids.get(i),null);
              mapper.addEqtable(eqtable);
              session.commit();
          }

          session.close();
          return true;
      }
           return false;
   }
   //发布作业
  public boolean addClassExam(ClassExam classExam)
   {

      int ecid = isExist(classExam);
     if (ecid!=0)
      {
    System.out.println("请勿重复发布");
   return false;
    }
     if (ecid==-1)
     {
    System.out.println("错误！");
    return false;
      }
      Setable setable = null;
      int i =0;
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapperQ = session.getMapper(QuestionDao.class);
      ClstDao mapperC    = session.getMapper(ClstDao.class);
      int cid =Integer.valueOf(classExam.getCid());
      i=  mapperQ.addClassExam(classExam);
      session.commit();
       int ecid1 = isExist(classExam);
       System.out.println( "这是教室试题编号："+ecid1);
      List<Integer> Sids = mapperC.getSid(cid);
      int size = Sids.size();
      System.out.println(" "+ size);
      for (int j=0;j<size;j++)
      {
         setable = new Setable(String.valueOf(Sids.get(j)),String.valueOf(ecid1),null);
         mapperQ.addsetable(setable);
      }
       session.commit();
       session.close();
      return i>0;
   }
 //判断是否以经在该教室发布了这个作业
 public int isExist(ClassExam classExam)
  {       if (classExam==null)
    {
      return -1;
    }
          ClassExam classExam1 = null;
          int cid = Integer.valueOf(classExam.getCid()) ;
          int eid = Integer.valueOf(classExam.getEid());
          Map<String,Object> map = new HashMap<>();
          System.out.println(cid+" "+eid);
          map.put("cid",cid);
          map.put("eid",eid);
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapperQ = session.getMapper(QuestionDao.class);
     classExam1 =    mapperQ.isExisetCE(map);
     System.out.println(classExam1);
     if (classExam1!=null)
     {
         return Integer.valueOf(classExam1.getEcid());
     }
    return 0;
  }
  //删除作业
    public int delectExam(String eid){
        int key = Integer.valueOf(eid);
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
        List<ClassExam> classExamList = mapper.getClassExamEid(key);
        if (classExamList==null || classExamList.isEmpty())
        {
            System.out.println("没有被发布");
        }
        else {
            int size = classExamList.size();
            System.out.println("被发布的教室数量："+size);
            for (int i=0;i<size;i++)
            {
                System.out.println(classExamList.get(i).getEcid());
                deleClassExam(classExamList.get(i).getEcid());
            }
        }
        mapper.delEQEid(key);
    int c=    mapper.delExam(key);
        session.commit();
        session.close();
        return c;
    }
    //删除发布的作业
    public int deleClassExam(String ecid){

       int ecid1 = Integer.valueOf(ecid);
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mappr = session.getMapper(QuestionDao.class);
     mappr.deleSetable(ecid1);
     mappr.delClassExam(ecid1);
     session.commit();
     session.close();
      return  0;
    }
    public int deleClassExamEid(String eid,String cid){

      ClassExam classExam = new ClassExam(cid,eid,null);
      int ecid = isExist(classExam);
      System.out.println(ecid);

      if (ecid>0)
      {
          deleClassExam(String.valueOf(ecid));
          return 1;
      }
      return 0;
    }


    //获取学生的作业列表
    public List<TestName> getStudentQ(String cid,String sid){

       int key= Integer.valueOf(cid);
       List<TestName> testNameList = new ArrayList<>(30);
       SqlSession session = mybatisUtil.getSqlSession();
       QuestionDao mapper = session.getMapper(QuestionDao.class);
       List<Exam> examList = mapper.getClassExamcid(key);
       if (examList == null)
       {
           return null;
       }
       if (examList.isEmpty())
       {
           return null;
       }
       int size = examList.size();
       TestName testName;
       Setable setable;
       Map<String,Object> map = new HashMap<>();
       map.put("sid",sid);
       map.put("cid",cid);
       for (int i=0;i<size;i++)
       {
        Exam exam =   examList.get(i);
        testName = new TestName();
        testName.setEid(exam.getEid());
        testName.setEname(exam.getEname());
        testName.setEtime(exam.getEtime());
        testName.setTid(exam.getTid());
        map.put("eid",exam.getEid());
        setable = mapper.getASetable(map);
        testName.setScore(setable.getScore());
        testName.setSeid(setable.getSeid());
        map.remove("eid");
        testNameList.add(testName);
       }

        if ( testNameList==null || testNameList.isEmpty())
        {
            return null;
        }
        return testNameList;
    }

    //获得一张试卷
    public Test getEidTest(String eid)
    {   int e= Integer.valueOf(eid);
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
        List<seletq> seletqList =   mapper.getSeletqs(e);
       // List<Lunq>  lunqList    = mapper.getLunqs(e);
        Exam exam  = mapper.getexam(e);
        Test test = new Test(exam.getEid(),exam.getTid(),exam.getEname(),exam.getEtime(),seletqList,null);
        return test;
    }
    //获得这个老师创建的所有作业
   public List<Exam> getCidExam(String  Tid)
    {   int tid= Integer.valueOf(Tid);
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
       List<Exam> temp = mapper.getTeacherExam(tid);
       if (temp == null || temp.isEmpty())
       {
           System.out.println("没有创建作业");
           return null;
       }
       return temp;
    }
    public List<seletq> getSeletq(int tid)
    {
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
         List<seletq> seletqList = mapper.getSeletqTid(tid);
        if (seletqList == null || seletqList.isEmpty()) {
            System.out.println("没有题");
            return null;
        }
        session.close();
        return seletqList;
    }
    public List<Lunq> getLunqQ(int tid)
    {
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
        List<Lunq> lunqList = mapper.getLunqTid(tid);
        if (lunqList == null || lunqList.isEmpty())
        { System.out.println("没有选择题");
            return null;
        }
        session.close();
        return lunqList;
    }
    //删除
    public void delaSel(String qid){
      int id = Integer.valueOf(qid);
      SqlSession session = mybatisUtil.getSqlSession();
      QuestionDao mapper = session.getMapper(QuestionDao.class);
              mapper.delSeletq(id);
              session.commit();
              session.close();
    }
    public void delL(String qid){
        int id = Integer.valueOf(qid);
        SqlSession session = mybatisUtil.getSqlSession();
        QuestionDao mapper = session.getMapper(QuestionDao.class);
        mapper.delLunq(id);
        session.commit();
        session.close();
    }

    //获得试卷的所有题
   public List<tempQuestion> getTempQuestionOK(String eid){
          List<tempQuestion> list = new ArrayList<>();
          tempQuestion temp ;
     Test test = getEidTest(eid);
     if (test!=null)
     {
         /*if (test.getLunqList()!=null)
         {
             List<Lunq> lunqs = test.getLunqList();
             if (!lunqs.isEmpty()){
                 for (Lunq lunq:lunqs)
                 {   temp = new tempQuestion();
                     temp.setQid(lunq.getWqid());
                     temp.setQname(lunq.getWqtitle());
                     list.add(temp);
                 }

             }

         }
         else {
             System.out.println("没有论述题");
         }*/
         if (test.getSeletqList()!=null)
         {
             List<seletq> seletqs = test.getSeletqList();
             if (!seletqs.isEmpty()){

                 for (seletq s:seletqs)
                 {
                     temp = new tempQuestion();
                     temp.setQname(s.getQtitle());
                     temp.setQid(s.getQid());
                     list.add(temp);
                 }

             }
         }


     }
     if (list.isEmpty())
     {
         return null;
     }

      return list;

   }
   //获取试卷没有的题
   public List<tempQuestion> getTempQuestionNo(String eid,String tid)
   {         Map<String,Object> map = new HashMap<>();
   map.put("eid",eid);
   map.put("tid",tid);
             SqlSession session = mybatisUtil.getSqlSession();
             QuestionDao mapper = session.getMapper(QuestionDao.class);
             List<seletq> seletqs  = mapper.getNoEidSq(map);
        //     List<Lunq> lunqs      = mapper.getNoEidLq(map);
             List<tempQuestion> questionList = new ArrayList<>();
             tempQuestion temp ;
          /*   if (lunqs!=null)
             {
                 if (!lunqs.isEmpty())
                 {
                     for (Lunq lunq:lunqs)
                     {   temp = new tempQuestion();
                         temp.setQname(lunq.getWqtitle());
                         temp.setQid(lunq.getWqid());
                         questionList.add(temp);
                     }
                 }
             }
             else {
                 System.out.println("没有论述题！");
             }*/
             if (seletqs!=null)
             {
                 if (!seletqs.isEmpty())
                 {
                     for (seletq s:seletqs)
                     {   temp = new tempQuestion();
                         temp.setQid(s.getQid());
                         temp.setQname(s.getQtitle());
                         questionList.add(temp);
                     }
                 }
             }
              else {
                  System.out.println("没有选择题！");
             }
             if (questionList.isEmpty())
             {
                 return null;
             }


              session.close();
             return questionList;
   }
    //获取试卷所在的教室
   public List<Classber> getOKClass(String eid)
   {
       SqlSession session = mybatisUtil.getSqlSession();
       QuestionDao questionDao = session.getMapper(QuestionDao.class);
       List<Classber> list = questionDao.getClassExameid(Integer.valueOf(eid));
       if (list == null || list.isEmpty())
       {
           return null;
       }
       session.close();

       return list;
   }
   //获取试卷不在的教室
   public List<Classber> getNOClass(String eid,String tid)
   {   Map<String,Object> map = new HashMap<>();
   map.put("eid",eid);
   map.put("tid",tid);
       SqlSession session = mybatisUtil.getSqlSession();
       QuestionDao questionDao = session.getMapper(QuestionDao.class);
       List<Classber> list = questionDao.getNoClass(map);
       if (list == null || list.isEmpty())
       {
           return null;
       }
       session.close();

       return list;
   }

   public void delEcamQuestion(String eid,String qid)
   {
       SqlSession session = mybatisUtil.getSqlSession();
       QuestionDao questionDao = session.getMapper(QuestionDao.class);
       Map<String,Object> map = new HashMap<>();
       map.put("eid",eid);
       map.put("qid",qid);
       questionDao.delExamQusetion(map);
       session.commit();
       session.close();
       return;

   }

   //添加学生的成绩
    public void addSetableScore(String seid,String score){
        Map<String,Object> map = new HashMap<>();
        map.put("seid",seid);
        map.put("score",score);
          SqlSession session = mybatisUtil.getSqlSession();
          QuestionDao mapper = session.getMapper(QuestionDao.class);
                   mapper.updateStudent(map);
                   session.commit();
                   session.close();
              return;

    }
}
