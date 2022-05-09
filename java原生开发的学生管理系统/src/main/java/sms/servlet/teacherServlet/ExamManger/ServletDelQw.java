package sms.servlet.teacherServlet.ExamManger;

import sms.pojo.User;
import sms.workdao.WorkQuestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDelQw")
public class ServletDelQw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是DelExam");
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
                    String qid = request.getParameter("qid");
                    System.out.println(qid);
                    WorkQuestion question = new WorkQuestion();

                    int p=1; question.delL(qid);
                    if (p>0)
                    {
                        System.out.println("以删除");
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println(1);
                        break;
                    }
                    else {
                        System.out.println("删除失败");
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
