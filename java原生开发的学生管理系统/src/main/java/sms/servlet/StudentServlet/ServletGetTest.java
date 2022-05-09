package sms.servlet.StudentServlet;

import com.google.gson.Gson;
import sms.pojo.Classber;
import sms.pojo.User;
import sms.pojo.qusetion.Test;
import sms.workdao.WorkQuestion;
import sms.workdao.WorkTeacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletGetTest")
public class ServletGetTest extends HttpServlet {
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
                String eid =request.getParameter("eid");
                    WorkQuestion workQuestion = new WorkQuestion();
                   Test temp= workQuestion.getEidTest(eid);
                    int p ;
                    if (temp == null)
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
