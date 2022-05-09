import Util.mybatisUtil;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sms.dao.StudentDao;
import sms.pojo.*;
import sms.pojo.qusetion.ClassExam;
import sms.pojo.qusetion.Lunq;
import sms.pojo.qusetion.TestName;
import sms.pojo.qusetion.seletq;
import sms.service.Login;
import sms.service.Register;
import sms.workdao.*;

import javax.swing.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TESR {
    @Test
   public void TesrLogin(){                           //yes
        Login login = new Login();
        login.chickUser("123","123");


    }
    @Test
    public void TestRegister(){   //yes

        Register register = new Register();
        Map<String,String> map = new HashMap<>();
        map.put("pass","1234561");
        map.put("phone","12312344");
        map.put("name","SA某人");
        map.put("stuid","2020211402");

        register.getNews(map,"student");


    }
    @Test
    public void chickExist(){         //yes

           WorkUser workUser = new WorkUser();
           workUser.chickExist("");


    }
    @Test
    public void addClass(){                      //yes
        WorkTeacher workTeacher = new WorkTeacher();
        Map<String,String> map  = new HashMap<>();
        map.put("cname","计算机科学与技术5班2");
        map.put("tid","16");

      boolean key =  workTeacher.creaClas(map);
        System.out.println(key);
    }
    @Test
 public void getMyclass(){
          WorkTeacher workTeacher = new WorkTeacher();
         List<Classber> list = workTeacher.getAllClass(16);
         Classber classber = workTeacher.findClass(4);
        Gson gson = new Gson();
        String JSON = gson.toJson(list);
        System.out.println(JSON);

    }
    @Test
    public void joinClass(){
        WorkStudent workStudent = new WorkStudent();
        workStudent.joinClass("16","4");
    }
    @Test
    public void demo(){
        StringBuffer P = new StringBuffer("/aljk.css");
        int o = P.lastIndexOf(".");


    }
    @Test
    public void TESTClass(){



        WorkTeacher workTeacher = new WorkTeacher();
        workTeacher.getAllClass(16);
     List<Student> list =  workTeacher.getClassJoinNews("6");

     for (Student joinnews:list)
     {
         System.out.print(joinnews.toString());
     }
     Gson gson = new Gson();
     String JSON = gson.toJson(list);
     System.out.println(JSON);
     workTeacher.dealNews("1","YES");

    }
    @Test
    public void T(){
        SqlSession session = mybatisUtil.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Studentm> studentmList = studentDao.getClassStudent(4);
        for (Studentm S:studentmList)
        {
            System.out.println(S.toString());
        }
    }
    @Test
    public void ecid(){
        ClassExam classExam = new ClassExam("4","1",null);
        WorkQuestion question = new WorkQuestion();
       int ecid =   question.isExist(classExam);
       System.out.println(ecid);
       question.addClassExam(classExam);
    }
    @Test
    public void getStudentQ(){
        WorkQuestion workQuestion = new WorkQuestion();
       List<TestName> testNameList = workQuestion.getStudentQ("4","15");
       Gson gson = new Gson();
       String JSON = gson.toJson(testNameList);
       System.out.println(JSON);

    }
    @Test
    public void getTest(){
        WorkQuestion workQuestion = new WorkQuestion();
      sms.pojo.qusetion.Test testNameList = workQuestion.getEidTest("1");
        Gson gson = new Gson();
        String JSON = gson.toJson(testNameList);
        System.out.println(JSON);
    }
    @Test
    public void appJoinClass(){
        WorkStudent workStudent = new WorkStudent();
        workStudent.appJoinClass("17","6");
    }
    @Test
    public void getExam()
    {
        WorkQuestion workQuestion = new WorkQuestion();
        Gson gson = new Gson();
        String json = gson.toJson(workQuestion.getCidExam("8"));
        System.out.println(json);
    }
    @Test
    public  void getStudent(){
        WorkTeacher workTeacher= new WorkTeacher();
        List<Studentm> list = workTeacher.getStudents("4");
        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
    }
    @Test
    public void delClass(){
        WorkTeacher workTeacher = new WorkTeacher();
        workTeacher.delectClass("9");
    }
    @Test
    public void date(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

    }
    @Test
    public void q(){
        WorkQuestion question = new WorkQuestion();

        List<seletq> list =   question.getSeletq(16);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    public void L(){

        WorkQuestion question = new WorkQuestion();
        List<Lunq> list   = question.getLunqQ(16);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);

    }
    @Test
    public void getok(){

        WorkQuestion question = new WorkQuestion();
        Gson gson = new Gson();
        System.out.println(gson.toJson(question.getTempQuestionOK("1")));
        System.out.println(gson.toJson(question.getTempQuestionNo("1","16")));
    }
@Test
    public void hsoo(){

        String S = "['1','2','3','4']";
        List p ;
        Gson gson = new Gson();
        p = gson.fromJson(S,List.class);
          System.out.println( p.get(1));
          double num = 0.4533 *100;

    }
}
