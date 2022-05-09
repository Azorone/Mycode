package sms.servlet.StudentServlet;

import sms.pojo.User;
import sms.workdao.WorkStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletJoinClass")
public class ServletJoinClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  String cid =request.getParameter("cid");

                  if (cid!=null)
                  {
                      Cookie[] cookies = request.getCookies();
                      for (Cookie c:cookies)
                      {
                          if (c.getName().equals("id"))
                          {
                              String id = c.getValue();
                              HttpSession session = request.getSession();
                              User user =(User) session.getAttribute(id);
                              if (user!=null)
                              {    System.out.println("存在！");
                                  WorkStudent workStudent = new WorkStudent();
                                 int p = workStudent.appJoinClass(user.getId(),cid);
                                    if (p>0)
                                    {
                                        response.setCharacterEncoding("UTF-8");
                                        PrintWriter Out = response.getWriter();
                                        Out.println(1);
                                        System.out.println("添加成功");
                                        break;
                                    }
                                    else {
                                        response.setCharacterEncoding("UTF-8");
                                        PrintWriter Out = response.getWriter();
                                        Out.println(-1);
                                        break;
                                    }
                              }else {
                                  System.out.println("登录失效");
                                  break;
                              }
                          }
                      }
                  }
                  else {
                      System.out.println("错误！");
                  }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
