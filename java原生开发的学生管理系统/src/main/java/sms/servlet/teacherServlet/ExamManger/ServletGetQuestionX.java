package sms.servlet.teacherServlet.ExamManger;

import com.google.gson.Gson;
import sms.pojo.User;
import sms.pojo.qusetion.Exam;
import sms.pojo.qusetion.seletq;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletGetQuestionX")
public class ServletGetQuestionX extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我是这个GetQuestion");
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
                    WorkQuestion workQuestion = new WorkQuestion();
                    List<seletq> temp =  workQuestion.getSeletq(Integer.valueOf(user.getId()));
                    if (temp == null || temp.isEmpty())
                    {
                        System.out.println("没有选择题");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(-1);
                        break;

                    }
                    else {
                        System.out.println("有选择题！");
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
