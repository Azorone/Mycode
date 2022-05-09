package sms.servlet;

import sms.service.Register;
import sms.workdao.WorkUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          boolean KEY  = false;
          System.out.println("这是注册！");
          String kid = request.getParameter("kid");
          Map<String,String>  map = new HashMap<>();
          System.out.println(kid);
          Register register  = new Register();
          Map<String,String[]> stringMap = request.getParameterMap();
          Set<String> setkey   = stringMap.keySet();
        for (String key:setkey)
        {
            String[] strings = stringMap.get(key);
             if (strings[0].equals(""))
             {  KEY = false;
                break;
             }
             else {
                 KEY = true;
                map.put(key,strings[0]);
                System.out.println(map.get(key));
             }
        }
        if (KEY){
            WorkUser workUser = new WorkUser();
           if (workUser.chickExist(map.get("phone")))
           {
               System.out.println("未被注册");
               register.getNews(map,map.get("kid"));
               PrintWriter out = response.getWriter();
               out.println("1");
           }
           else {

               System.out.println("以经被注册");
               PrintWriter out = response.getWriter();
               out.println("0");
           }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doPost(request,response);
    }
}
