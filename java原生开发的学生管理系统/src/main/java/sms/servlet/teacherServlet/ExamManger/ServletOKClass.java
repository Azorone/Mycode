package sms.servlet.teacherServlet.ExamManger;

import com.google.gson.Gson;
import sms.pojo.Classber;
import sms.pojo.User;
import sms.pojo.qusetion.tempQuestion;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletOKClass")
public class ServletOKClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("我是OKClass");
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
                    String eid = request.getParameter("eid");
                    WorkQuestion workQuestion = new WorkQuestion();
                    List<Classber> temp = workQuestion.getOKClass(eid);
                    if (temp == null || temp.isEmpty())
                    {
                        System.out.println("有被布置的教室");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(-1);
                        break;
                    }
                    else {
                        System.out.println("没有被布置的教室");
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
