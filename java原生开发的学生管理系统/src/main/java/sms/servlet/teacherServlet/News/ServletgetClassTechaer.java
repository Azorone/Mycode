package sms.servlet.teacherServlet.News;

import com.google.gson.Gson;
import sms.pojo.Classber;
import sms.pojo.Student;
import sms.pojo.User;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletgetClassTechaer")
public class ServletgetClassTechaer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    WorkTeacher workTeacher = new WorkTeacher();
                    List<Classber> temp = workTeacher.getAllClass(Integer.valueOf(user.getId()));
                    int p ;
                    if (temp == null || temp.isEmpty())
                    {
                        System.out.println("没有加入教室");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(-1);
                        break;

                    }
                    else {
                    System.out.println("有加入教室！");
                    Gson gson = new Gson();
                    String json = gson.toJson(temp);
                    System.out.println(json);
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println(json);
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
