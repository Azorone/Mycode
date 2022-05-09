package sms.servlet;

import com.google.gson.Gson;
import sms.pojo.Classber;
import sms.workdao.WorkStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "ServletgetClass")
public class ServletgetClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id ;
        Cookie[] cookie = request.getCookies();
        for (Cookie cookie1:cookie)
        {
            if (cookie1.getName().equals("id"))
            {
                id = Integer.valueOf(cookie1.getValue()) ;
                WorkStudent workStudent = new WorkStudent();
               List<Classber> classberList = workStudent.getMyClasses(id);

                if (classberList==null)
                {
                   PrintWriter out = response.getWriter();
                   System.out.println("没有加入教室！");
                   out.println("没有加入任何教室！");

                }
                else {
                    response.setCharacterEncoding("utf-8");
                    Gson gson =new Gson();
                    String json = gson.toJson(classberList);
                    System.out.println(json);
                    PrintWriter out = response.getWriter();

                    out.println(json);
                    break;
                }
            }
        }
        System.out.println("我是ServletgetClass");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
