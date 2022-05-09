package sms.servlet.teacherServlet.ClassManger;

import com.google.gson.Gson;
import sms.pojo.User;
import sms.pojo.qusetion.Exam;
import sms.workdao.WorkQuestion;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletDelClass")
public class ServletDelClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我是这个DelClass");
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
                String CID = request.getParameter("cid");
                    WorkTeacher workTeacher = new WorkTeacher();

                   boolean p =  workTeacher.delectClass(CID);
                    if (p)
                    {
                        System.out.println("以删除");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(1);
                        break;
                    }
                    else {
                        System.out.println("没删除");
                        PrintWriter out = response.getWriter();
                        out.println(-1);
                        break;
                    }

                }else {
                    System.out.println("登录失效");
                    break;
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
