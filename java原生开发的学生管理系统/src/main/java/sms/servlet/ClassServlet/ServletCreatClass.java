package sms.servlet.ClassServlet;

import sms.pojo.User;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletCreatClass")
public class ServletCreatClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是创建教室的服务");
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies)
        {
            if (c.getName().equals("id"))
            {
                HttpSession session = request.getSession();
               User user =  (User)session.getAttribute(c.getValue());
               if (user!=null)
               {
                  if (user.getPer()>=4)
                  {
                          System.out.println("用户信息："+user.toString());

                      String cname =    request.getParameter("cname");
                      WorkTeacher workTeacher = new WorkTeacher();
                      Map<String,String> map = new HashMap<>();
                      map.put("tid",user.getId());
                      map.put("cname",cname);

                   boolean fl=  workTeacher.creaClas(map);
                   response.setCharacterEncoding("UTF-8");
                      PrintWriter out = response.getWriter();
                   if (fl){
                               out.println(1);
                   }else {
                              out.println(-1);
                   }
                      return;

                  }
                  else {
                      System.out.println("权限不够");
                      break;
                  }
               }
               else {
                   System.out.println("登录失效");
                   break;
               }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
