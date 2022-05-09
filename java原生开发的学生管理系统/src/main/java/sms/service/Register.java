package sms.service;

import sms.pojo.Studentm;
import sms.pojo.Teacher;
import sms.pojo.Teachm;
import sms.pojo.User;
import sms.workdao.WorkUser;

import java.util.Map;

public class Register {

  public void getNews(Map<String,String> map , String kid){


     String pass  = map.get("pass");
     String  phone = map.get("phone");
       switch (kid){
           case "teacher":int i= createUser(pass,phone,8);createTeacherm(i,map);break;
           case "student":int j=createUser(pass,phone,4);createStudentm(j,map);break;
           case "manager":int k=createUser(pass,phone,12);createMangerm(k);break;
           default:System.out.println("参数错误");

       }
  }

 private int createUser(String pass,String phone,int per){
      System.out.println("1");
     User user = new User(null,phone,pass,per);
     WorkUser workUser = new WorkUser();
     int i = workUser.addUser(user);
     return i;
  }

 private void createTeacherm(int id,Map<String,String> map){
      if (map.isEmpty()){
          return;
      }
     Teachm teachm = new Teachm(String.valueOf(id),map.get("name"),map.get("phone"),map.get("mail"));
      teachm.toString();
      WorkUser workUser = new WorkUser();
      workUser.addTeacherm(teachm);

  }
 private void createStudentm(int id,Map<String,String> map){
      if (map.isEmpty())
      {
          return;
      }
     Studentm studentm = new Studentm(String.valueOf(id),map.get("name"),map.get("phone"),map.get("stuid"));
      studentm.toString();
      WorkUser workUser = new WorkUser();
      workUser.addStudent(studentm);
  }
 private void createMangerm(int id){

  }

}
