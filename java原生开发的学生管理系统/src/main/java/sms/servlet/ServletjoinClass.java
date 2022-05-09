package sms.servlet;

import sms.pojo.User;
import sms.workdao.WorkStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletjoinClass")
public class ServletjoinClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String id;
        User user = null;
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("id"))
            {
               id =  cookie.getValue();
               break;
            }
        }
        if (user!=null)
        {
          if (user.getPer()==4 || user.getPer()==8)
          {
              System.out.println(user.toString());
              System.out.println("是学生");
              String Cid    = request.getParameter("cid");
              String Stid   = user.getId();
              WorkStudent workStudent =new WorkStudent();
              workStudent.appJoinClass(Stid,Cid);

          }
          else if (user.getPer()==6)
          {
              System.out.println("老师访问，错误！");
          }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
